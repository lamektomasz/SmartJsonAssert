package smartjsonassert.tools.statistic;

import com.google.common.collect.Streams;
import net.javacrumbs.jsonunit.core.internal.Node;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import smartjsonassert.tools.MatchingStrategy;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatisticMatchingStrategy implements MatchingStrategy {

    private static final JaroWinklerDistance distanceMeter = new JaroWinklerDistance();

    @Override
    public StatisticMatchingResult matchNodes(Node expected, Node actual, String description) {

        StatisticMatchingResult result = null;

        switch (expected.getNodeType()) {
            case OBJECT:
                result = new StatisticMatchingResult(expected, actual, 0, description);
                result.reduce(Streams.stream(expected.fields())
                        .map(keyValue -> matchNodes(keyValue.getValue(), actual.get(keyValue.getKey()),
                                description + "." + keyValue.getKey()))
                        .collect(Collectors.toList()));
                break;
            case ARRAY:
                result = new StatisticMatchingResult(expected, actual, 0, description);
                result.reduce(Streams.stream(expected.arrayElements()).map(node -> mapNodeToStatistic(
                        node, actual, description)).collect(Collectors.toList()));
                break;
            case STRING:
                result = new StatisticMatchingResult(expected, actual,
                        distanceMeter.apply(expected.toString(), actual.toString()),
                        expected.toString().equals(actual.toString()) ? "" : description);
                break;
            case NUMBER:
            case BOOLEAN:
                result = new StatisticMatchingResult(expected, actual,
                        expected.toString().equals(actual.toString()) ? 1 : 0,
                        expected.toString().equals(actual.toString()) ? "" : description);
                break;
            case NULL:
                result = new StatisticMatchingResult(expected, actual, 0, "");
        }
        return result;
    }

    private StatisticMatchingResult mapNodeToStatistic(Node expected, Node actual, String description) {
        AtomicInteger counter = new AtomicInteger(0);
        return Streams.stream(actual.arrayElements())
                .map(actualChild -> matchNodes(expected, actualChild,
                        description + ".[" + counter.getAndIncrement() + "]")).sorted(
                        Comparator.reverseOrder()).findFirst()
                .orElse(matchNodes(expected, actual, description));
    }
}

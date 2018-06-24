package smartjsonassert.tools.statistic;

import net.javacrumbs.jsonunit.core.internal.Node;
import org.apache.commons.lang3.StringUtils;
import smartjsonassert.tools.MatchingResult;

import java.util.LinkedList;
import java.util.List;

public class StatisticMatchingResult implements Comparable<StatisticMatchingResult>, MatchingResult {

    private Node expected;
    private Node actual;
    private double matchRatio;
    private String difference;
    private List<StatisticMatchingResult> results = new LinkedList<>();

    StatisticMatchingResult(Node expected, Node actual,
                            double matchRatio, String difference) {

        this.expected = expected;
        this.actual = actual;
        this.matchRatio = matchRatio;
        this.difference = difference;

        updateDifferenceIfNeeded();
    }

    private void updateDifferenceIfNeeded() {
        if (actual.isMissingNode() || actual.isNull()) {
            this.difference += " missed";
        } else if (matchRatio < 1d) {
            this.difference += " is " + actual.toString() + " should be " + expected.toString();
        }
    }

    void reduce(List<StatisticMatchingResult> result) {
        results.addAll(result);
        if (!(actual.isMissingNode() || actual.isNull())) {
            difference = result.stream().filter(matchResult -> matchResult.matchRatio < 1d)
                    .map(matchResult -> matchResult.difference)
                    .filter(StringUtils::isNotBlank)
                    .reduce("", (s, s2) -> s + "\n" + s2);
        }
        matchRatio = result.stream().mapToDouble(matchResult -> matchResult.matchRatio)
                .average().getAsDouble();
    }

    @Override
    public int compareTo(StatisticMatchingResult o) {
        return Double.compare(matchRatio, o.matchRatio);
    }

    @Override
    public String getFailDescription() {
        return difference;
    }

    @Override
    public boolean isAssertPassed() {
        return matchRatio == 1d;
    }
}

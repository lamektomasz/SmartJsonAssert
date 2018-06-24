package smartjsonassert.assertion;

import net.javacrumbs.jsonunit.core.internal.JsonUtils;
import net.javacrumbs.jsonunit.core.internal.Node;
import org.opentest4j.AssertionFailedError;
import smartjsonassert.tools.MatchingResult;
import smartjsonassert.tools.MatchingStrategy;
import smartjsonassert.tools.statistic.StatisticMatchingStrategy;

public class AssertJson {

    //    NodeResolverStrategy nodeResolverStrategy;
//    ReportingStrategy reportingStrategy;
    private MatchingStrategy matchingStrategy = new StatisticMatchingStrategy();

    public void assertJson(String message, String expected, String actual) {
        Node expectedJson = JsonUtils.convertToJson(expected, "");
        Node actualJson = JsonUtils.convertToJson(actual, "");

        MatchingResult result = matchingStrategy.matchNodes(expectedJson, actualJson, "");

        if (!result.isAssertPassed()) {
            throw new AssertionFailedError(result.getFailDescription());
        }
    }

}

package smartjsonassert.tools;

import net.javacrumbs.jsonunit.core.internal.Node;

public interface MatchingStrategy {
    MatchingResult matchNodes(Node expected, Node actual, String description);
}

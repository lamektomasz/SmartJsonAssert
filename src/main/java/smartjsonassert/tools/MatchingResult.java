package smartjsonassert.tools;

public interface MatchingResult {
    String getFailDescription();

    boolean isAssertPassed();
}

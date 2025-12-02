package use_case.showResults;

/**
 * Output boundary for showing results.
 */
public interface ShowResultsOutputBoundary {
    /**
     * Prepares the success view.
     * @param outputData the output data
     */
    void prepareSuccessView(ShowResultsOutputData outputData);

    void switchToOpenGameView();
}

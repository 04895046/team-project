package Battle_System.UseCase.Battle;

public interface Battle_OutputBoundary {
    /**
     * Prepares the Win view for the Battle Use Case.
     * @param outputData the output data
     */
    void prepareWinView(Battle_OutputData outputData);

    /**
     * Prepares the Loss view for the Battle Use Case.
     * @param outputData the output data
     */
    void prepareLossView(Battle_OutputData outputData);
}

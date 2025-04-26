package model;

/**
 * ScoreBoard class to track game scores between player and computer
 */
public class ScoreBoard {
    private int playerScore;
    private int computerScore;
    private int drawScore;

    /**
     * Default constructor initializing all scores to zero
     */
    public ScoreBoard() {
        this.playerScore = 0;
        this.computerScore = 0;
        this.drawScore = 0;
    }

    /**
     * Increment player score by one
     */
    public void incrementPlayerScore() {
        this.playerScore++;
    }

    /**
     * Increment computer score by one
     */
    public void incrementComputerScore() {
        this.computerScore++;
    }

    /**
     * Increment draw score by one
     */
    public void incrementDrawScore() {
        this.drawScore++;
    }

    /**
     * Get current player score
     * @return player score
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Get current computer score
     * @return computer score
     */
    public int getComputerScore() {
        return computerScore;
    }

    /**
     * Get current draw score
     * @return draw score
     */
    public int getDrawScore() {
        return drawScore;
    }

    /**
     * Reset all scores to zero
     */
    public void resetScores() {
        this.playerScore = 0;
        this.computerScore = 0;
        this.drawScore = 0;
    }
}

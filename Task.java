public class Task {
    String objective;
    int timeFrame;
    int numberOfBreaks;

    public Task(String objective, int timeFrame, int numberOfBreaks) {
        this.objective = objective;
        this.timeFrame = timeFrame;
        this.numberOfBreaks = numberOfBreaks;
    }

    public String getObjective() {
        return objective;
    }

    public int getTimeFrame() {
        return timeFrame;
    }

    public int getNumberOfBreaks() {
        return numberOfBreaks;
    }

}
//thinking having a list of strings that prints information through a for loop at end for users plans.
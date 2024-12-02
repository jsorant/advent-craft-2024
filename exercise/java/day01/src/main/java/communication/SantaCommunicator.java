package communication;

public class SantaCommunicator {
    private final Logger logger;

    public SantaCommunicator(Logger logger) {
        this.logger = logger;
    }

    public String composeMessage(Reindeer reindeer, NumberOfDaysBeforeChristmas numberOfDaysBeforeChristmas) {
        return "Dear " + reindeer.name().value() + ", please return from " + reindeer.currentLocation().value() +
                " in " + reindeer.daysBeforeReturn(numberOfDaysBeforeChristmas) + " day(s) to be ready and rest before Christmas.";
    }

    public boolean isOverdue(Reindeer reindeer, NumberOfDaysBeforeChristmas numberOfDaysBeforeChristmas) {
        if (reindeer.daysBeforeReturn(numberOfDaysBeforeChristmas) <= 0) {
            logger.log("Overdue for " + reindeer.name().value() + " located " + reindeer.currentLocation().value() + ".");
            return true;
        }
        return false;
    }
}
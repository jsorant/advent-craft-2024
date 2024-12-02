package communication;

public record Reindeer(ReindeerName name, CurrentLocation currentLocation,
                       NumbersOfDaysForComingBack numbersOfDaysForComingBack, NumberOfDaysToRest numberOfDaysToRest) {
    public int daysBeforeReturn(NumberOfDaysBeforeChristmas numberOfDaysBeforeChristmas) {
        return numberOfDaysBeforeChristmas.value() - numbersOfDaysForComingBack.value() - numberOfDaysToRest.value();
    }
}

package potvizsga4.railwaystation;

import java.util.ArrayList;
import java.util.List;

public class RailwayStation {
    public List<Train> trains = new ArrayList<>();
    public static final int MAX_TRAINS = 10;

    public List<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train train) {
        if (trains.size() < MAX_TRAINS) {
            trains.add(train);
        } else {
            throw new IllegalArgumentException("Too much trains!");
        }
    }

    public Train getLongestTrain() {
        checkEmptyStation();
        Train longest = trains.get(0);
        for (Train actual : trains) {
            if (actual.getTotalLength() > longest.getTotalLength()) {
                longest = actual;
            }
        }
        return longest;
    }

    public int getHowManyTrainsHaveName() {
        checkEmptyStation();
        int count = 0;
        for (Train actual : trains)  {
            if (actual.getName() != null && !actual.getName().isBlank()) {
                count++;
            }
        }
        return count;
    }

    public List<Train> getTrainsWithPassengersMoreThan(int number) {
        List<Train> result = new ArrayList<>();
        checkEmptyStation();
        for (Train actual : trains) {
            if (actual.calculateTravellingPeople() > number) {
                result.add(actual);
            }
        }
        return result;
    }

    private void checkEmptyStation() {
        if (trains.size() == 0) {
            throw new IllegalStateException("There are no trains in the station.");
        }
    }
}

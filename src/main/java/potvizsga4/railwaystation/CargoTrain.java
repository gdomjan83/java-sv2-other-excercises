package potvizsga4.railwaystation;

public class CargoTrain extends Train {

    public CargoTrain(int numberOfCars) {
        super(numberOfCars);
    }

    @Override
    public int calculateTravellingPeople() {
        if (getNumberOfWagons() < 10) {
            return 1;
        } else {
            return getNumberOfWagons() / 10;
        }
    }
}

package zarovizsga2.cleaning;

public class House implements Cleanable {
    private String address;
    private int area;
    public static final int CLEANING_COST = 80;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return area * CLEANING_COST;
    }

    @Override
    public String getAddress() {
        return address;
    }
}

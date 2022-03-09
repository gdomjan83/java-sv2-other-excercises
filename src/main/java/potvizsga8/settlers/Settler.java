package potvizsga8.settlers;

public class Settler {
    private long id;
    private String nameOfSettler;
    private int amountOfTobacco;
    private int expectedIncome;
    public static final int COST = 500;

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
    }

    public long getId() {
        return id;
    }

    public String getNameOfSettler() {
        return nameOfSettler;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public int getExpectedIncome() {
        return amountOfTobacco * COST;
    }


}

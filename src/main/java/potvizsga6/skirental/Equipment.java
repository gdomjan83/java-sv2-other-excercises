package potvizsga6.skirental;

public class Equipment {
    private int sizeOfBoot;
    private int sizeOfSkis;

    public Equipment(int sizeOfSkis, int sizeOfBoots) {
        this.sizeOfBoot = sizeOfBoots;
        this.sizeOfSkis = sizeOfSkis;
    }

    public int getSizeOfBoot() {
        return sizeOfBoot;
    }

    public int getSizeOfSkis() {
        return sizeOfSkis;
    }

    public boolean isChildSize() {
        if (sizeOfSkis == 0) {
            return sizeOfBoot <= 37;
        }
        if (sizeOfBoot == 0) {
            return sizeOfSkis <= 120;
        }
        return (sizeOfBoot <= 37 && sizeOfSkis <= 120);
    }

    public boolean hasRentedBoth() {
        return (sizeOfBoot > 0 && sizeOfSkis > 0);
    }
}

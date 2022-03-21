package kepesitovizsga2.forest;

public abstract class Tree {
    private int height;

    public Tree() {
    }

    public Tree(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract String status();

    public abstract void irrigate();
}

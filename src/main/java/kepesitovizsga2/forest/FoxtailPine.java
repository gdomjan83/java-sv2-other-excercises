package kepesitovizsga2.forest;

public class FoxtailPine extends Tree {
    private static final String TREE_NAME = "FoxtailPine";

    public FoxtailPine() {
    }

    public FoxtailPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        setHeight(getHeight() + 1);
    }

    @Override
    public String status() {
        return String.format("There is a %d tall %s in the forest.", getHeight(), TREE_NAME);
    }
}

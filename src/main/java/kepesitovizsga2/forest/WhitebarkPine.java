package kepesitovizsga2.forest;

public class WhitebarkPine extends Tree {
    private static final String TREE_NAME = "WhitebarkPine";

    public WhitebarkPine() {
    }

    public WhitebarkPine(int height) {
        super(height);
    }

    @Override
    public String status() {
        return String.format("There is a %d tall %s in the forest.", getHeight(), TREE_NAME);
    }

    @Override
    public void irrigate() {
        setHeight(getHeight() + 2);
    }
}

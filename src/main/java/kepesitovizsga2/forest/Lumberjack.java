package kepesitovizsga2.forest;

public class Lumberjack {

    public boolean canCut(Tree treeToCut) {
        if (treeToCut.getHeight() > 4) {
            return true;
        }
        return false;
    }
}

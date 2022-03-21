package kepesitovizsga2.forest;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees;

    public Forest(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Tree> getTrees() {
        return new ArrayList<>(trees);
    }

    public void rain() {
        trees.forEach(Tree::irrigate);
    }

    public void cutTrees(Lumberjack lumberjack) {
        trees.removeIf(lumberjack::canCut);
    }

    public boolean isEmpty() {
        return trees.size() == 0;
    }

    public List<String> getStatus() {
        return trees.stream()
                .map(Tree::status)
                .toList();
    }
}

package org.samples;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Cell> neighbors = new ArrayList<>();
    private List<Cell> coparents = new ArrayList<>();

    public void addNeighbor(Cell neighbor) {
        neighbors.add(neighbor);
        coparents.add(neighbor);
    }

    public boolean amIDoomed() {
        return !(neighbors.size() == 2 || neighbors.size() == 3);
    }

    public boolean amIAParent() {
        return coparents.size() == 2;
    }

    public void addCoparent(Cell coparent) {
        coparents.add(coparent);
    }
}

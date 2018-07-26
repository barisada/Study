package books.ctci.graph;

import java.util.Objects;

public class Vertex {
    private int val;

    public Vertex(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {

        return Objects.hash(val);
    }
}

package books.effective_java.ch4.item15;

import java.util.Objects;

public final class ImmutableClassExample {
    private int x;
    private int y;

    private ImmutableClassExample(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static ImmutableClassExample valueOf(int x, int y){
        return new ImmutableClassExample(x, y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public ImmutableClassExample add(ImmutableClassExample other){
        return new ImmutableClassExample(this.x + other.getX(), this.y + other.getY());
    }

    public ImmutableClassExample subtract(ImmutableClassExample other){
        return new ImmutableClassExample(this.x - other.getX(), this.y - other.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableClassExample)) return false;
        ImmutableClassExample that = (ImmutableClassExample) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "ImmutableClassExample{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

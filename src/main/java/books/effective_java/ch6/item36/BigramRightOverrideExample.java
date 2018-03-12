package books.effective_java.ch6.item36;

import java.util.Objects;

public class BigramRightOverrideExample {
    private final char first;
    private final char second;

    public BigramRightOverrideExample(char first, char second){
        this.first = first;
        this.second = second;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigramRightOverrideExample)) return false;
        BigramRightOverrideExample that = (BigramRightOverrideExample) o;
        return first == that.first &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

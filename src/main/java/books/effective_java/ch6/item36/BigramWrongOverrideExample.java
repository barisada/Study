package books.effective_java.ch6.item36;

public class BigramWrongOverrideExample {
    private final char first;
    private final char second;

    public BigramWrongOverrideExample(char first, char second){
        this.first = first;
        this.second = second;
    }

    public boolean equals(BigramWrongOverrideExample b){
        return b.first == first && b.second == second;
    }

    public int hashCode(){
        return 31* first + second;
    }
}

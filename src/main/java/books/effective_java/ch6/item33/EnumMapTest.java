package books.effective_java.ch6.item33;

public class EnumMapTest {
    public static void main(String[] args) {
        PhaseEnumMapExample[] array = PhaseEnumMapExample.values();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i == j) continue;
                PhaseEnumMapExample.Transition t = PhaseEnumMapExample.from(array[i], array[j]);
                System.out.println(t + " = (" + array[i] + ", " + array[j] + ")");
            }
        }
    }
}

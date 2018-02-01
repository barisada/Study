package books.effective_java.ch2.item2;

public class BuilderTest {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.BuilderImpl(240, 8)
                .calories(180).sodium(35).carbonhydrate(27).fat(1).build();
        System.out.println(nutritionFacts.toString());
    }
}

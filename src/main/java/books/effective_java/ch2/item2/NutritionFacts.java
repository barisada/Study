package books.effective_java.ch2.item2;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbonhydrate;

    private NutritionFacts(BuilderImpl builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbonhydrate = builder.carbonhydrate;
    }

    public static class BuilderImpl implements Builder<NutritionFacts>{
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbonhydrate = 0;

        public BuilderImpl(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public BuilderImpl calories(int calories){
            this.calories = calories;
            return this;
        }

        public BuilderImpl fat(int fat){
            this.fat = fat;
            return this;
        }

        public BuilderImpl sodium(int sodium){
            this.sodium = sodium;
            return this;
        }

        public BuilderImpl carbonhydrate(int carbonhydrate){
            this.carbonhydrate = carbonhydrate;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbonhydrate=" + carbonhydrate +
                '}';
    }
}

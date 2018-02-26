package books.effective_java.ch5.item27;

public class GenericSingletonFactoryExample {
    interface UnaryFucntion<T>{
        T apply(T arg);
    }

    private static UnaryFucntion<Object> IDENTITY_FUNCTION = arg -> arg;

    @SuppressWarnings("unchecked")
    public static <T> UnaryFucntion<T> identityFunction(){
        return (UnaryFucntion<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strs = {"jute", "hemp", "nylon"};
        UnaryFucntion<String> sameStr = identityFunction();
        for(String s : strs){
            System.out.println(sameStr.apply(s));
        }

        Number[] nums = {1,2.0, 3L};
        UnaryFucntion<Number> sameNum = identityFunction();
        for(Number n : nums){
            System.out.println(sameNum.apply(n));
        }
    }
}

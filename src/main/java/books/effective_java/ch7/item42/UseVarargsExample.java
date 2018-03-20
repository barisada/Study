package books.effective_java.ch7.item42;

public class UseVarargsExample {

    public static int minBadVarargs(int...args){
        if(args.length == 0){
            throw new IllegalArgumentException("no args");
        }

        int min = args[0];
        for(int i = 1; i < args.length; i++){
            if(min > args[i]) min = args[i];
        }

        return min;
    }

    public static int minGoodVarags(int firstArg, int... remainArgs){
        int min = firstArg;
        for(int arg : remainArgs){
            if(min > arg) min = arg;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(minGoodVarags(98237, array));

    }
}

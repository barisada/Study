package books.effective_java.ch5.item26;

public class StackWithGenericTest {

    public static void main(String[] args) {
        args = new String[]{"a", "b", "c", "d"};
        StackWithGenericExample<String> stack = new StackWithGenericExample<>();
        for(String arg : args){
            stack.push(arg);
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }

    }
}

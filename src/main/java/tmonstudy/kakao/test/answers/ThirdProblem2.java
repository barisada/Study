package tmonstudy.kakao.test.answers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-07-04.
 */
@SuppressWarnings("Duplicates")
public class ThirdProblem2 {
    private static Integer[] answer;
    static{
        answer = new Integer[26];
        for(int i =0; i < 26;i ++){
            answer[i] = 0;
        }
    }

    public static void main(String...args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        JwStack<String> stack = new JwStack<>();
        for(String token : input.split("")){
            stack.push(token);
        }
        while(!stack.isEmpty()){
            int consecutiveNum = 0;
            if(stack.peek().equals(")")){
                stack.pop();    //pop ")"
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("(")){
                    sb.append(stack.pop());
                }
                stack.pop();    //pop "("
                consecutiveNum = Integer.valueOf(sb.toString());
            }
            if(stack.peek().equals("#")){
                stack.pop();    //pop "#"
                String second = stack.pop();
                String first = stack.pop();
                markOnArray(Integer.valueOf(first + second), consecutiveNum);
            } else {
                markOnArray(Integer.valueOf(stack.pop()), consecutiveNum);
            }
        }
        System.out.println(Arrays.stream(answer).map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void markOnArray(int pos, int consecutiveNum) {
        if(consecutiveNum == 0){
            answer[pos - 1]++;
        } else{
            answer[pos - 1] += consecutiveNum;
        }
    }

    static class JwStack<E>{
        private List<E> list;

        public JwStack(){
            list = new ArrayList<>();
        }

        public JwStack(Collection<E> collection){
            list.addAll(collection);
        }

        public boolean push(E item){
            return list.add(item);
        }

        public E pop(){
            return list.remove(list.size()-1);
        }

        public E peek(){
            return list.get(list.size()-1);
        }

        public boolean isEmpty(){
            return list.isEmpty();
        }

        public boolean contains(Object o){
            return list.contains(o);
        }

        public String toString(){
            return list.toString();
        }
    }
}



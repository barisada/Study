package tmonstudy.kakao.test.answers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-07-03.
 */
@SuppressWarnings("Duplicates")
public class ThirdProblem {
    private static Integer[] answer;
    private static List<String> stopword;
    static{
        answer = new Integer[26];
        for(int i =0; i < 26;i ++){
            answer[i] = 0;
        }
        stopword = new ArrayList<>();
        stopword.add("#");
        stopword.add("(");
    }

    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        String[] array = input.split("");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < array.length; i++){
            if(stopword.contains(array[i])) {
                if(i + 1 < array.length && (array[i] + array[i+1]).equals("#(")){
                    while(queue.size() != 2){
                        markOnArray(queue);
                    }
                    queue.add(queue.poll() + queue.poll());
                    String consecutiveNum = "";
                    i += 2;     //skip "#("
                    for(;!array[i].equals(")"); i++){
                        consecutiveNum += array[i];
                    }
                    markOnArray(queue, Integer.valueOf(consecutiveNum));

                } else if (array[i].equals("#")){
                    while(queue.size() != 2){
                        markOnArray(queue);
                    }
                    queue.add(queue.poll() + queue.poll());
                    markOnArray(queue);
                } else {
                    while(queue.size() !=1){
                        markOnArray(queue);
                    }
                    String consecutiveNum = "";
                    i++;     //skip "("
                    for(;!array[i].equals(")"); i++){
                        consecutiveNum += array[i];
                    }
                    markOnArray(queue, Integer.valueOf(consecutiveNum));
                }
            } else {
                queue.add(array[i]);
            }
        }

        while(!queue.isEmpty()){
            markOnArray(queue);
        }


        System.out.println(Arrays.stream(answer).map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static void markOnArray(Queue<String> queue) {
        int pos = Integer.valueOf(queue.poll()) - 1;
        answer[pos]++;
    }

    private static void markOnArray(Queue<String> queue, int consecutiveNum) {
        int pos = Integer.valueOf(queue.poll()) - 1;
        answer[pos] += consecutiveNum;
    }
}

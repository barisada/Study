package internet_lecture.alg_pknu_ac_kr.lecture._02_recursion;

/**
 * 멱집합은 구하는 방법은
 * {a,b,c,d,e,f}의 모든 부분집합은
 * a를 포함하지 않은 집함 {b,c,d,e,f}을 나열하고
 * {b,c,d,e,f}에 {a}를 추가한 집합들을 나열한다.
 *         {b,c,d,e,f}에 {a}를 추가한 집합을 나열하려면
 *         {c,d,e,f}의 모든 집합들에 {a}를 추가한 집합을 나열하고
 *         {c,d,e,f}의 모든 집합에 {a,b}를 추가한 집합을 나열한다.
 *              {c,d,e,f}에 {a,b}를 추가한 집합을 나열하려면
 *              {d,e,f}의 모든 집합들에 {a}를 추가한 집합을 나열하고,
 *              {d,e,f}의 모든 집합에 {a,c}를 추가한다.
 *              ....반복
 *
 */
public class Recursion_07_Powerset {
    static boolean[] include;         //모든 집합에 추가해야하는 원소를 표시하는 역할
    public static void main(String[] args) {
        int[] data = {1,2,3};
        include = new boolean[data.length];
        powerSet(data, 0);
    }

    private static void powerSet(int[] data, int level) {
        if(data.length == level){
            for(int i = 0; i < data.length; i++){
                if(include[i]){
                    System.out.print(data[i] + "  ");
                }
            }
            System.out.println();
            return;
        }

        include[level] = false;
        powerSet(data, level + 1);
        include[level] = true;
        powerSet(data, level + 1);
    }
}

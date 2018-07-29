package internet_lecture.alg_pknu_ac_kr.lecture._01_recursion;

import java.util.Arrays;

/**
 * Designing Recursion
 * 순환 알고리즘의 설계
 */
public class Recursion_03 {
    public static void main(String[] args) {
        int[] data = {99,100,2,3,1,6,7,9,0,11,22,32,25,44,66,8,12,13,200,15};
        int begin = 0;
        int end = data.length -1;
        int target1  = 32;

        System.out.println("암시적 순차검색 >>> " + Arrays.toString(data) + "에서 " +  target1 + "을 찾는다 : "
                + implicitSequentialSearch(data, end, target1));

        int target2 = 8;
        System.out.println("명시적 순차검색 >>> " + Arrays.toString(data) + "에서 " +  target2 + "을 찾는다 : "
                + explicitSequentialSearch(data, begin, end, target2));

        System.out.println("명시적 순차검색 뒤에서부터 >>> " + Arrays.toString(data) + "에서 " +  target2 + "을 찾는다 : "
                + explicitSequentialSearchAlternative(data, begin, end, target2));

        System.out.println("명시적 순차검색 중간부터 >>> " + Arrays.toString(data) + "에서 " +  target2 + "을 찾는다 : "
                + explicitSequentialSearchAlternative2(data, begin, end, target2));

        System.out.println("최대값 찾기 >>> " + Arrays.toString(data) + "에서 최대값을 찾는다 : "
                + findMax(data, begin, end));

        System.out.println("최대값 찾기 반반 나눠서 찾기>>> " + Arrays.toString(data) + "에서 최대값을 찾는다 : "
                + findMaxAlternative(data, begin, end));

        Arrays.sort(data);
        int target3 = 99;
        System.out.println("이진검색 >>> " + Arrays.toString(data) + " 에서 "  + target3 + " 을 찾는다 : "
                + binarySearch(data, begin, end, target3));
    }

    /**
     * data size = n 일때
     * data[0]부터 data[n-1]까지 사이에서 target을 검색한다.
     * 없으면 -1을 리턴한다.
     * @param data
     * @param end
     * @param target
     * @return
     */
    private static String implicitSequentialSearch(int[] data, int end, int target) {
        for(int i = 0; i <= end; i++){
            if(data[i] == target)
                return "Found at data[" + i + "]";
        }
        return "Not Found";
    }

    /**
     * 명시적 순차 검색
     * data size = n 일때
     * data[0]부터 data[n-1]까지 사이에서 target을 검색한다.
     * 없으면 -1을 리턴한다.
     * @param data
     * @param begin
     * @param end
     * @param target
     * @return
     */
    private static String explicitSequentialSearch(int[] data, int begin, int end, int target) {
        if(begin > end){
            return "Not Found";
        } else if(data[end] == target){
            return "Found at data[" + end + "]";
        } else {
            return explicitSequentialSearch(data, begin, end - 1, target);
        }
    }

    /**
     * 뒤에서 부터 검색
     * @param data
     * @param begin
     * @param end
     * @param target
     * @return
     */
    private static String explicitSequentialSearchAlternative(int[] data, int begin, int end, int target) {
        if(begin > end){
            return "Not Found";
        } else if(data[begin] == target){
            return "Found at data[" + begin + "]";
        } else {
            return explicitSequentialSearch(data, begin + 1, end, target);
        }
    }

    /**
     * 중간 먼저 검색
     * 없으면 0 ~ 중간 검색
     * 없으면 중간 ~ 마지막 검색
     * 한번씩 다볼때까지 검색
     * @param data
     * @param begin
     * @param end
     * @param target
     * @return
     */
    private static String explicitSequentialSearchAlternative2(int[] data, int begin, int end, int target) {
        if(begin > end){
            return "Not Found";
        } else {
            int mid = (begin + end) / 2;
            if(data[mid] == target){
                return "Found at data[" + mid + "]";
            } else {
                String result = explicitSequentialSearchAlternative2(data, begin, mid - 1, target);
                if(result.equals("Not Found")){
                    return explicitSequentialSearch(data, mid + 1, end, target);
                } else {
                    return result;
                }
            }
        }
    }

    /**
     * data[begin]에서 data[end] 사이의 최대값을 찾는다.
     * 예) n > end 일떄
     * data[n] 과 data[n + 1] ~ data[end]사이의 최대값을 비교해서
     * 둘중에 큰값을 리턴하면된다.
     *
     * data에는 1개 이상의 데이터가 있다고 가정.
     * @param data
     * @param begin
     * @param end
     * @return
     */
    private static int findMax(int[] data, int begin, int end) {
        if(begin == end){
            return data[begin];
        } else {
            return Math.max(data[begin], findMax(data, begin + 1, end));
        }
    }

    private static int findMaxAlternative(int[] data, int begin, int end) {
        if(begin == end){
            return data[begin];
        } else {
            int mid = (begin + end) / 2;
            return Math.max(findMax(data, begin, mid), findMax(data, mid + 1, end));
        }
    }

    /**
     * data[begin]와 data[end] 사이에서 target을 찾는다.
     * @param data
     * @param begin
     * @param end
     * @param target
     * @return
     */
    private static String binarySearch(int[] data, int begin, int end, int target){
        if(begin > end){
            return "Not Found";
        } else {
            int mid = (begin + end) / 2;
            if(data[mid] == target){
                return "Found at data[" + mid + "]";
            } else if(data[mid] < target){
                return binarySearch(data, mid + 1, end, target);
            } else {
                return binarySearch(data, begin, mid - 1, target);
            }
        }
    }
}

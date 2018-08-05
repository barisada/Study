/**
 */
public class Test {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,12,15,34,64,73,75,83,87,123,124,359,5745};

		int target = 0;
		boolean hasTarget = binarySearch(arr, target);
		System.out.println(hasTarget);
	}

	private static boolean binarySearch(int[] arr, int target) {
		return doSearch(arr, target, 0, arr.length);
	}


	private static boolean doSearch(int[] arr, int target, int left, int right) {
		if(left >= right){
			return target == arr[left];
		}

		int mid = (left + right) / 2;
		if(target > arr[mid]){
			return doSearch(arr, target, mid + 1, right);
		} else if(target < arr[mid]) {
			return doSearch(arr, target, left, mid -1);
		} else {
			return true;
		}
	}

}

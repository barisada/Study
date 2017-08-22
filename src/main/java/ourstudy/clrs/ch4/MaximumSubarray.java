package ourstudy.clrs.ch4;

/**
 * Created by jwlee1 on 2017. 8. 6..
 */
@SuppressWarnings("Duplicates")
public class MaximumSubarray {

	/**
	 * precondition : array.length >= 1
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public Indices findMaxSubArrayIndices(int[] array, int left, int right){
		if(left == right){
			return new Indices(left, right);
		} else {
			int mid= (left + right) / 2;
			Indices leftMax = findMaxSubArrayIndices(array, left, mid);
			Indices rightMax = findMaxSubArrayIndices(array, mid + 1, right);
			Indices crossMax = findCrossMaxSubArrayIndices(array, left, mid, right);

			return getMaxIndices(array, leftMax, rightMax, crossMax);
		}
	}


	private Indices findCrossMaxSubArrayIndices(int[] array, int left, int mid, int right) {
		int leftMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid;
		for(int i = mid; i >= left; i--){
			sum = sum + array[i];
			if(sum > leftMaxSum){
				leftMaxSum = sum;
				maxLeft = i;
			}
		}
		Indices maxL = new Indices(maxLeft, mid);

		int rightMaxSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = mid + 1;
		for(int i = mid+1; i <=right; i++){
			sum = sum + array[i];
			if(sum > rightMaxSum){
				rightMaxSum = sum;
				maxRight = i;
			}
		}
		Indices maxR = new Indices(mid+1, maxRight);
		Indices maxBoth = maxL.add(maxR);

		return maxBoth;

	}

	private Indices getMaxIndices(int[] array, Indices maxL, Indices maxR, Indices maxBoth) {
		if(maxL.sum(array) >= maxR.sum(array) && maxL.sum(array) >= maxBoth.sum(array)){
			return maxL;
		} else if(maxR.sum(array) >= maxL.sum(array) && maxR.sum(array) >= maxBoth.sum(array)){
			return maxR;
		} else {
			return maxBoth;
		}
	}
}

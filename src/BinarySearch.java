
public class BinarySearch {

	public static void main(String[] args) {
		new BinarySearch().searchInsert(new int[] { 1, 3 }, 4);
	}

	public void searchInsert(int[] nums, int target) {
		System.out.println(binarySearch(nums, 0, nums.length - 1, target));
	}

	int binarySearch(int[] nums, int l, int r, int tar) {
		if (r >= l) {

		int mid = l + (r - l) / 2;
			
			if (nums[mid] == tar) {
				return mid;
			} else if (tar > nums[mid]) {
				return binarySearch(nums, mid + 1, r, tar);
			} else if (tar < nums[mid]) {
				return binarySearch(nums, l, mid - 1, tar);
			}

		}

		return -1;
	}

}

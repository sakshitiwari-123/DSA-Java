class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        int[] right = new int[n];

        // Step 1: Build suffix minimum array
        right[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

        // Step 2: Traverse with prefix maximum
        int leftMax = 0;

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);

            if (leftMax - right[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
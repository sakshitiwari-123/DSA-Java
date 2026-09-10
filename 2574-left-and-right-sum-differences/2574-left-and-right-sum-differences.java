class Solution {
          
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ls = new int[n];
        int[] rs = new int[n];

        ls[0] = 0;
        int s = 0;

        for (int i = 0; i < n - 1; i++) {
            s += nums[i];
            ls[i + 1] = s;
        }

        rs[n - 1] = 0;
        s = 0;
        for (int i = n - 1; i > 0; i--) {
            s += nums[i];
            rs[i - 1] = s;
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
            ans[i] = Math.abs(ls[i] - rs[i]);

        return ans;
    }
}
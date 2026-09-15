
class Solution {

    private String s;
    private int k;
    private Integer[] dp;

    public int maxPalindromes(String s, int k) {
        this.s = s;
        this.k = k;
        dp = new Integer[s.length() + 1];

        return solve(0);
    }

    private int solve(int i) {

        if (i >= s.length())
            return 0;

        if (dp[i] != null)
            return dp[i];

        // Option 1: Skip current character
        int ans = solve(i + 1);

        // Option 2: Take palindrome of length k
        if (i + k <= s.length() && isPalindrome(i, i + k - 1)) {
            ans = Math.max(ans, 1 + solve(i + k));
        }

        // Option 3: Take palindrome of length k+1
        if (i + k + 1 <= s.length() && isPalindrome(i, i + k)) {
            ans = Math.max(ans, 1 + solve(i + k + 1));
        }

        return dp[i] = ans;
    }

    private boolean isPalindrome(int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
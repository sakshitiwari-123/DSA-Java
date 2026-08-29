class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int maxLen = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (Center = i)
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len1 = right - left - 1;

            // Case 2: Even length palindrome (Center = i, i + 1)
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 = right - left - 1;

            // Dono me se maximum length leni hai
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
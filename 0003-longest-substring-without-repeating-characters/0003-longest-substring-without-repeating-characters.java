class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        
        // Array ko -1 se initialize karte hain
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Agar character repeat ho raha hai current window mein
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }

            lastIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
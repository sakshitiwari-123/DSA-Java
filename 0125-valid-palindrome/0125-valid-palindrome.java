class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        String str = "";

        // Only letters and numbers rakho
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                str = str + ch;
            }
        }

        // Reverse banao
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        // Compare
        return str.equals(rev);
    }
}
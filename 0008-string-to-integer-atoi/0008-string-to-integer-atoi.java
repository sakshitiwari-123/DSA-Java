class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0;
        int n = s.length();

        // 1. Shuruat ke whitespaces skip karo
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Agar poori string me sirf spaces the
        if (index == n) return 0;

        // 2. Sign check karo ('+' ya '-')
        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        // 3. Digits read karo aur overflow handling karo
        long result = 0; // Overflow check karne ke liye long use kiya
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;

            // 4. 32-bit range overflow check
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (result * sign);
    }
}

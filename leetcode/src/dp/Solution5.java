package dp;

/**
 * XTransfer
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        String res = "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                int j = i + k;
                if (j - i <= 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

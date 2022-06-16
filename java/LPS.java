public class LPS {
    private static Solution SOLUTION = new Solution();

    public static void main(String[] args) {
        test("obbad", "bb");
        test("babad", "bab");
        test("badad", "ada");
        test("dabad", "dabad");
        test("b", "b");
        test("bb", "bb");
        test("aaaa", "aaaa");
    }

    private static void test(String s, String expected) {
        final String result = SOLUTION.longestPalindrome(s);
        if (!expected.equals(result)) {
            throw new IllegalStateException(String.format("Test failed. Expected: '%s', But got '%s'", expected, result));
        }
    }

}

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        int start = 0;
        int end = 0;
        int lps = 1;
        for (int i = 0; i < len; i++) {
            int oddLength = 0;
            int oddStart = i;
            int oddEnd = i;
            while (oddStart >= 0 && oddEnd < s.length() && s.charAt(oddStart) == s.charAt(oddEnd)) {
                oddLength = oddEnd - oddStart + 1;
                oddStart--;
                oddEnd++;
            }

            int evenLength = 0;
            int evenStart = i;
            int evenEnd = i + 1;
            while (evenStart >= 0 && evenEnd < s.length() && s.charAt(evenStart) == s.charAt(evenEnd)) {
                evenLength = evenEnd - evenStart + 1;
                evenStart--;
                evenEnd++;
            }

            if (oddLength > lps && oddLength > evenLength) {
                start = i - (oddLength / 2);
                end = i + (oddLength / 2);
                lps = oddLength;
            } else if (evenLength > lps && evenLength > oddLength) {
                start = i - (evenLength / 2) + 1;
                end = i + (evenLength / 2);
                lps = evenLength;
            }

        }
        return s.substring(start, end + 1);
    }

    public String longestPalindromeN3(String s) {
        int l = s.length();
        if (l == 1) {
            return s;
        }

        int lps = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < l; i++) {
            for (int j = l - 1; j >= 0; j--) {
                int subL = l - i - (l - j) + 1;
                if (i <= j && isPalindrome(s, i, j) && subL > lps) {
                    lps = subL;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(String s, int start, int finish) {

        int i = start;
        int j = finish;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}

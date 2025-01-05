import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class exercise0401 {
    public static int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();
        for (Character c: s.toCharArray()) {
            letters.add(c);
        }

        int ans = 0;
        for (Character letter : letters) {
            int i = -1;
            int j = 0;

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }

                    j = k;
                }
            }

            Set<Character> between = new HashSet<>();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }

            ans += between.size();
        }

        return ans;
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] prefix = new int[n+1];
        int start, end, direction;

        for(int i=0;i<shifts.length;i++){
            start=shifts[i][0];
            end=shifts[i][1];
            direction=shifts[i][2];

            int val = (direction == 1) ? 1 : -1;
            prefix[start] += val;
            prefix[end + 1] -= val;
        }

        int shiftAmount = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            shiftAmount += prefix[i];
            int newChar = ((result[i] - 'a') + shiftAmount) % 26;
            if (newChar < 0) newChar += 26;  // Ajuste para valores negativos
            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }
}

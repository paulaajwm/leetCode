import java.util.*;
import java.util.List;

public class Medium {
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

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] count = new int[n + 1][100];
        int q = queries.length;
        int ans[] = new int[q];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < 100; ++j)
                count[i + 1][j] = count[i][j];

            ++count[i + 1][nums[i] - 1];
        }

        for(int i = 0; i < q; ++i) {
            int low = queries[i][0];
            int high = queries[i][1] + 1;
            List<Integer> present = new ArrayList<>();
            int min = 100;

            for(int j = 0; j < 100; ++j)
                if(count[high][j] - count[low][j] != 0)
                    present.add(j);

            for(int j = 1; j < present.size(); ++j)
                min = Math.min(min, present.get(j) - present.get(j - 1));

            if(present.size() == 1)
                min = -1;

            ans[i] = min;
        }

        return ans;
    }

    public static ArrayList<String> stringMatching(String[] words) {
        HashSet<String> solution = new HashSet<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i!=j){
                    int n = words[i].length(), m = words[j].length();
                    String txt = words[i], pat = words[j];

                    int[] lps = new int[m];

                    constructor(pat,lps);

                    int p1 = 0;
                    int p2 = 0;

                    while(p1<n){
                        if(txt.charAt(p1)==pat.charAt(p2)){
                            p1++;
                            p2++;

                            if(p2==m){
                                solution.add(pat);
                                p2=lps[p2-1];
                            }
                        }else{
                            if(p2!=0){
                                p2=lps[p2-1];
                            }else{
                                p1++;
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(solution);
    }

    private static void constructor (String pat, int[] lps){
        int len=0;
        lps[0]=0;

        int i=1;
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }

    public static ArrayList<String> stringMatchingAux(String[] words) {
        HashSet<String> solution = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    solution.add(words[j]);
                }
            }
        }

        return new ArrayList<>(solution);
    }

    public static ArrayList<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> sol = new ArrayList<>();
        int[] maxFreq = new int[26];

        // Calculate the maximum required frequency for each letter from words2
        for (String word : words2) {
            int[] currentFreq = new int[26];
            for (char c : word.toCharArray()) {
                currentFreq[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                maxFreq[j] = Math.max(maxFreq[j], currentFreq[j]);
            }
        }

        // Check each word in words1
        for (String word : words1) {
            int[] currentFreq = new int[26];
            for (char c : word.toCharArray()) {
                currentFreq[c - 'a']++;
            }

            // Check if currentFreq satisfies maxFreq
            if (isSubset(currentFreq, maxFreq)) {
                sol.add(word);
            }
        }

        return sol;
    }

    private static boolean isSubset(int[] currentFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (currentFreq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public static int minimumLength(String s) {
        int[] freq = new int[26];
        int length = s.length();
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i = 0; i<freq.length; i++){
            if(freq[i]>=3){
                while(freq[i]>2){
                    freq[i] -= 2;
                    length -= 2;
                }
            }
        }
        return length;
    }

    public static String largestNumber(int[] nums) {
        String sol = "";
        int maxNum;
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        while(!list.isEmpty()){
            maxNum = candidate(list);
            sol = sol + maxNum;
            list.remove(Integer.valueOf(maxNum));
        }
        return sol;
    }

    private static int candidate(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int length = String.valueOf(i).length();
            ArrayList<Integer> result = new ArrayList<>();
            ArrayList<Integer> maxResult = new ArrayList<>();
            int number = nums.get(i), maxNumber = max;

            for (int j = length - 1; j >= 0; j--) {
                result.add(number % 10);
                number /= 10;
            }

            for (int k = length - 1; k >= 0; k--) {
                maxResult.add(maxNumber % 10);
                maxNumber /= 10;
            }

            int n = 0;
            while (n < result.size() && n < maxResult.size()) {
                if (result.get(n) > maxResult.get(n)) {
                    max = i;
                    break;
                } else {
                    n++;
                }
            }
        }
        return max;
    }

    public static int[] wiggleSort(int[] nums) {
        int[] numsNew = new int[nums.length];
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            numsNew[i] = nums[i];
        }

        int i=0;
        int j=nums.length-1;

        while(i<nums.length){
            if(i%2!=0){
                nums[i]=numsNew[j];
                j--;
            }
            i++;
        }

        int t=nums.length-1;
        int k=0;
        while(t>=0){
            if(t%2==0){
                nums[t]=numsNew[k];
                k++;
            }
            t--;
        }

        return nums;

    }

}

import java.util.HashSet;
import java.util.Set;

public class exercise0201 {
    public static int maxScore(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int sumOne=0, sumZero=0, maxScore=0;
        int oneRight;
        int score;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                sumOne++;
            }
            prefix[i]=sumOne;
        }

        for(int i=0; i<n-1; i++){
            if(s.charAt(i)=='0'){
                sumZero++;
            }
            oneRight=sumOne-prefix[i];
            score=oneRight+sumZero;
            maxScore=Math.max(score,maxScore);
        }

        return maxScore;
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        Set<String> vowelSet = new HashSet<>();
        vowelSet.add("a");
        vowelSet.add("e");
        vowelSet.add("i");
        vowelSet.add("o");
        vowelSet.add("u");
        int[] prefix = new int[words.length];
        for(int i=0; i<words.length; i++){
            String word = words[i];
            char first=word.charAt(0);
            char last=word.charAt(word.length()-1);

            if(vowelSet.contains(String.valueOf(first))&&vowelSet.contains(String.valueOf(last))){
                prefix[i]=1;
            }

            if(i>0){
                prefix[i]+=prefix[i-1];
            }
        }

        for(int i=0; i<queries.length; i++){
            int li = queries[i][0];
            int ri = queries[i][1];

            ans[i]=prefix[ri]-(li>0?prefix[li-1]:0);
        }

        return ans;
    }
}

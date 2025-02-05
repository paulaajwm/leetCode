import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Easy {
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

    public static boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        HashSet<Integer> diff = new HashSet<Integer>();

        if(n==1) return false;

        for (int i=0; i<n; i++){
            diff.add(deck[i]);
        }

        int size = diff.size();
        int[] count = new int[size];


        for (int i : diff){
            int c = 0;
            for (int j = 0; j<n; j++){
                if(deck[j]==i){
                    c++;
                    count[size-1]=c;
                }
            }
            size--;
        }

        for(int i=0; i<count.length; i++){
            if(i>0 && count[i-1]!=count[i]){
                return false;
            }
        }
        return true;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int cont=0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        if(s1.equals(s2)) return true;
        else{
            for(char c : s1.toCharArray()){
                freq1[c-'a']++;
            }
            for(char c : s2.toCharArray()){
                freq2[c-'a']++;
            }
            if(Arrays.equals(freq1,freq2)){
                for(int i=0; i<s1.length(); i++){
                    if(s1.charAt(i)!=s2.charAt(i)) cont++;
                }
                if(cont<=2) return true;
            }
        }

        return false;
    }
}

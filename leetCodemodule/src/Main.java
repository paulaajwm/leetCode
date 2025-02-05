import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

       /* //1
        int e1 = exercise0201.maxScore("011101");
        System.out.println(e1);

        //2
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] e2 = exercise0201.vowelStrings(words, queries);
        for (int num : e2) {
            System.out.println(num);
        }

        //3
        int[] nums ={2,3,1,0};
        int e3 = exercises0301.waysToSplitArray(nums);
        System.out.println(e3);

        //4
        int e4 = exercise0401.countPalindromicSubsequence("aabca");
        System.out.println(e4);

        String s="abc";
        int[][] m = {{0,1,0},{1,2,1},{0,2,1}};
        String e5 =exercise0401.shiftingLetters(s,m);
        System.out.println(e5);

        String[] words = {"leetcoder","leetcode","od","hamlet","am"};
        ArrayList<String> e6= Medium.stringMatchingAux(words);
        System.out.println(e6);

        int[] deck = {1,1};
        boolean e7 = Easy.hasGroupsSizeX(deck);
        System.out.println(e7);

        String[] words1={"amazon","apple","facebook","google","leetcode"};
        String[] words2={"e","o"};
        ArrayList<String> words=Medium.wordSubsets(words1,words2);
        System.out.println(words);

        String s = "abaacbcbb";
        int e8 = Medium.minimumLength(s);
        System.out.println(e8);

        int[] nums = {10,2};
        String e9 = Medium.largestNumber(nums);
        System.out.println(e9);*/

        int[] nums ={1,5,1,1,6,4};
        int[] e10 = Medium.wiggleSort(nums);
        System.out.println(Arrays.toString(e10));
    }
}
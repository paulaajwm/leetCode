public class Main {
    public static void main(String[] args) {

        int i = exercise0201.maxScore("011101");
        System.out.println(i);

        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] x = exercise0201.vowelStrings(words, queries);
        for (int num : x) {
            System.out.println(num);
        }

    }
}
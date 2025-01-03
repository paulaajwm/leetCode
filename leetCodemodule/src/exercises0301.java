public class exercises0301 {
    public static int waysToSplitArray(int[] nums) {
        int solution=0;
        long sumLeft=0, sumRight=0, totalSum=0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        for (int i = 0; i < nums.length-1; i++) {
            sumLeft += nums[i];
            sumRight = totalSum - sumLeft;
            if (sumLeft >= sumRight) {
                solution++;
            }
        }
        return solution;
    }
}

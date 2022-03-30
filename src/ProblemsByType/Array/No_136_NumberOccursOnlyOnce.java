package ProblemsByType.Array;


public class No_136_NumberOccursOnlyOnce
{
    // Òì»òÔËËã a ^ a = 0; b ^ 0 = b
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int item : nums)
            res ^= item;
        return res;
    }

}

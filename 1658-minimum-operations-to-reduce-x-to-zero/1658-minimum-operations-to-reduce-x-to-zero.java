class Solution {

    private int maxSubArraySum(int[] nums, int sum) {
        int n = nums.length;

        int len = -1;
        int i = 0, j = 0;
        int currSum = 0;

        while(j < n) {
            currSum += nums[j];

            while(currSum > sum) {
                currSum -= nums[i];
                i++;
            }

            if(currSum == sum) {
                len = Math.max(len, j - i + 1);
            }

            j++;
        }

        return len;
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(x > sum) {
            return -1;
        }

        int len = maxSubArraySum(nums, sum - x);    
        if(len == -1) {
            return -1;
        }

        return nums.length - len;
    }
}
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] prefix = new int[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefix[i];
            int right = (prefix[n] - prefix[i + 1]) - nums[i] * (n - i - 1);
            result[i] = left + right;
        }

        return result;
    }
}
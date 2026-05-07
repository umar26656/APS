import java.util.*;

class Solution {
    private int[] indexes;
    private int[] counts;
    private int[] tempIndexes;
    private int[] nums;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        this.nums = nums;
        indexes = new int[n];
        counts = new int[n];
        tempIndexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempIndexes[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[tempIndexes[j]] < nums[tempIndexes[i]]) {
                indexes[k++] = tempIndexes[j++];
                rightCount++;
            } else {
                counts[tempIndexes[i]] += rightCount;
                indexes[k++] = tempIndexes[i++];
            }
        }

        while (i <= mid) {
            counts[tempIndexes[i]] += rightCount;
            indexes[k++] = tempIndexes[i++];
        }

        while (j <= right) {
            indexes[k++] = tempIndexes[j++];
        }
    }
}
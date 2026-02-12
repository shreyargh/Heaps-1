// TC: O(n log(n-k))
// SC: O(n-k)

// 1: We use a maxheap to store elements in the descending order
// 2: We maintain a size of n-k elements, whenever we have crossed the size limit, we remove the last element and update the minimum element seen so far
// 3: Once we have iterated through the array, we hold the kth largest element in our maxElement variable
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Maxheap
        int size = n - k;
        int maxNums = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
            if (pq.size() > size) {
                maxNums = Math.min(maxNums, pq.poll());
            }
        }
        return maxNums;
    }
}
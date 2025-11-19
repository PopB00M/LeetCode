import java.util.PriorityQueue;

public class Test {
    public static int FindKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    public static void quickSort(int[] nums,int left,int right){
        if(left < right){
            int pivot = Partition(nums,left,right);
            quickSort(nums,left,pivot - 1);
            quickSort(nums,pivot + 1,right);
        }
    }

    public static int Partition(int[] nums,int left,int right){
        int pivot = nums[left];
        while(left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static int findKthLargest2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(FindKthLargest(nums,2));
        System.out.println(findKthLargest2(nums,2));

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        quickSort(nums2,0,nums2.length-1);
        for(int i:nums2){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(FindKthLargest(nums2,4));
        System.out.println(findKthLargest2(nums2,4));
    }


}

import java.util.Arrays;

/**
 * 实现懒汉单例模式
 */

public class SingleTon {


    private static volatile SingleTon instance = null;
    private SingleTon() {}



    public static SingleTon getInstance() {
        if(instance == null) {
            synchronized (SingleTon.class) {
                if(instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }


    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        int left = 0,right = 1;
        while(right < nums.length){
            int curLen = 1;
            if(nums[right] == nums[left] + 1){
                curLen++;
                result = Math.max(result,curLen);
            }else{
                curLen=1;
            }
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
}

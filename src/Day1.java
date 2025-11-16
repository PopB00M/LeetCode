public class Day1 {


    /**
     * LeetCode_209 长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0;right < n;right++){
            sum += nums[right];                            // 进窗口
            while(sum >= target){                          // 判断
                result = Math.min(result,right-left+1);    // 更新结果
                sum -= nums[left];
                left++;                                    // 让 left 出窗口
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }


    /**
     * LeetCode_3 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];   // 用数组模拟一个hash
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < n; right++) {
            hash[chars[right]]++;                  // 入窗口
            while(hash[chars[left]] > 1){          // 重复了，需要从窗口内删除，重复移动到left，直到[left,right]中无重复字符
                hash[chars[left]]--;               // 比如abbacd，当right指向最后一个a时，left需要从0下标移到2次，[left,right] 变成 [ba];
                left++;                            // 所以这里是 while，而不是 if
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

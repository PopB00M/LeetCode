public class Day2 {
    /**
     * LeetCode 142 环形链表2
     * 思路：第一次快慢指针找到相遇位置后，快指针步伐调成1步，慢指针从head从头开始走，就会在若干步后再次相遇，这次的相遇就是入环点
     */

//    public ListNode detectCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode meet = null;
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow==fast){
//                meet = fast;
//                break;
//            }
//        }
//        // 不存在环
//        if(meet == null){
//            return null;
//        }
//        slow = head;
//        fast = meet;
//        while(slow != fast){
//            slow = slow.next;
//            fast = fast.next;
//            if(slow == fast){
//                meet = fast;
//                break;
//            }
//        }
//        return meet;
//    }
}

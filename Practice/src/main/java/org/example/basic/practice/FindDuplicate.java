package org.example.basic.practice;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate(nums));
    }

    static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}

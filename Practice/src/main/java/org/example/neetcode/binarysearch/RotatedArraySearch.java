package org.example.neetcode.binarysearch;

public class RotatedArraySearch {

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(search(nums, 1   ));
    }
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                if(nums[l] <= target && nums[mid] > target)
                    r = mid - 1;
                else l = mid + 1;
            } else {
                if(nums[r] >= target && nums[mid] < target)
                    l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}

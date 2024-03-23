package org.example;

public class NumArray {

    int[] numArray;

    public NumArray(int[] nums) {
        this.numArray = nums;
    }

    public void update(int index, int val) {
        this.numArray[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        while (left < right){
            sum += numArray[left] + numArray[right];
            left++;
            right--;
        }
        return left == right ? sum + numArray[left] : sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,-8};
        NumArray obj = new NumArray(nums);
        obj.update(0,3);
        obj.sumRange(1,1);
        obj.sumRange(0,1);
    }
}


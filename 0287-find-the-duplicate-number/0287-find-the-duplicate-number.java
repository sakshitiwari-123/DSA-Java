class Solution {
    public int findDuplicate(int[] nums) {
        //Approach - Using Hare and Tortoise/Floyd Cycle Detectn Approach TC - O(n), SC - O(1)
        int slow = nums[nums[0]];
        int fast = nums[slow];
        
        //Detecting cycle by moving slow by 1 elt and fast by 2 elt
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        //Finding the start of cycle/duplicate elt by moving slow and fast by 1 node/elt
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
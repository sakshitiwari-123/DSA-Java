class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0]= find(nums,target,true);
        if(result[0]==-1){
            return result;
        }
        result[1]=find(nums,target,false);
        return result;
    }
    private int find(int[] nums,int target,boolean isFirst){
        int start =0;
        int end = nums.length-1;
        int bound=-1;
        while(start<=end){
            int mid=start+((end-start)/2);
            if(target==nums[mid]){
                bound = mid; //potential first
                if(isFirst){
                    end=mid-1; //explore left for first
                }
                else{
                    start=mid+1; // explore right for end
                }
            }
            else if(target>nums[mid]){
                start = mid+1;
            }
            else {
                end= mid-1;
            }
        }return bound;
    }   
}
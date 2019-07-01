class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length -1;
        //int mid = (start + end ) / 2 + start;
        while(start != end){
            int mid = (start + end ) /2 + start;
            if(nums[mid] == target) return true;
            if (nums[start] == nums[mid]) ++start;//这是为了去除掉重复元素的影响
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else start = mid;
            }else{
                if(nums[mid] < target && target < nums[end]){
                    start = mid +1;
                }else end = mid;                
            }
        }
        return false;
        
    }
}
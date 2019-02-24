/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let len = nums.length;
    let i = 0,j = 0;
    while(j < len){
        console.log(i,j)
        if(nums[j] != 0){
            let temp = nums[j];
            nums[j] = 0;
            nums[i] = temp;
            i++;
        }
        j++;
    }
    console.log(nums)
};
moveZeroes([0,1,0,3,12])
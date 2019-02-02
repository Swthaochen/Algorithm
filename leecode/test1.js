/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}

var twoSum = function(nums, target) {
    nums.sort(mySort);
    //console.log(nums);
    let length = nums.length;
    for(let i = 0;i < length;i++){
        let a = nums[i]
        let find = target - a
        let lo = 0,hi = length - 1
        while(lo < hi){
            let mid = parseInt((lo + hi) / 2)
            if(a[mid] < find)
                hi = mid - 1
            else if(a[mid] > find)
                lo = mid + 1
            else
                return [i,mid]
        }
    }
};

var mySort = (a,b)=>{
    //从小到大顺序排序
    return a - b;
}

console.log(twoSum([3,2,4],6))
 */


 /**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target){
    var obj = {}
    let i = 0;
    nums.forEach(v=>{
        obj[v]=i
        i++
    })
    arr = []
    for(let i = 0;i < nums.length;i++)
    {
        v = nums[i]
        if(obj[target - v] != undefined && obj[target - v] != i){  
            arr[0] = i
            arr[1] = obj[target - v]
            return arr
        }
    }
}
console.log(twoSum([3,2,4],6))
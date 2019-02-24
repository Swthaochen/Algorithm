// 回文数的问题
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    var str = x.toString();
    let i = 0;
    while(i <= str.length - 1){
        if(str[i] != str[str.length - 1 - i])
            return false;
        i++;
    }
    return true;
};

console.log(isPalindrome(0))
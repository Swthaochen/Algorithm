/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var i = 0,j = 1,len = 0,max = 1;
    let k = s.length;
    if(k == 0)
        return k;
    var set = new Set();
    set.add(s[0]);
    len++;
    while(j < k){
        // 如果当前字符在集合中
        if(set.has(s[j])){
            max = len > max ? len : max;
            if(s[i] != s[j]){
                set.delete(s[i])
                len--;
            }else{
                i++;
                j++;
                continue;
            }
            while(s[++i] != s[j] ){
                set.delete(s[i])
                len--;
            }
            i++;
            j++;
        }else{
            set.add(s[j++]);
            len++;
        }
    }
    max = len > max ? len : max;
    return max;
};

console.log(lengthOfLongestSubstring("pwwkew"))
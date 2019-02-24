/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    if(root == null)
        return 0;
    return sumNodes(root,0)
};

var sumNodes = (root, sum)=>{
    sum = sum * 10 + root.val;
    if(root.left == null && root.right == null){
        return sum;
    }
    var left = root.left == null ? 0 : sumNodes(root.left, sum);
    var right = root.right == null ? 0 : sumNodes(root.right, sum);
    return left + right;
}

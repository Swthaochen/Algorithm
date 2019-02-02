// arr = [1,2,3]
// console.log(...arr)

// var aa = (a1,a2,a3)=>{
//     console.log(a1 + a2 + a3)
// }
// aa(...arr)

// function test(a,b,c){
//     console.log(test.length)
// }
// test(1,2,3) 

// function curry(fn){ 
//     return function curried(){
//         let context = this
//         var agrs = [].slice.call(arguments)
//         return agrs.length >= fn.length ?
//             fn.apply(context,agrs) : 
//             function() {
//                 var rest = [].slice.call(arguments)
//                 return curried.apply(context,agrs.concat(rest))
//             }  
//     }
// }
// var people = {
//     name:'xiaoming',
//     setPeople:function(sex,height,age){
//         return [this.name + ':' , age , sex , height].join(' ')
//     }
// }
// people.mytest = curry(people.setPeople)
// console.log(people.mytest('man')(170,20))

// function add(a,b,c,d)
// {
//     return a + b + c + d;
// }
// var curry_call = curry(add)
// console.log(curry_call(1)(2,3)(4))


// 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
 
function ListNode(val) {
    this.val = val;
    this.next = null;
}
var addTwoNumbers = function(l1, l2) {
    p = l1;
    q = l2;
    var l3 = new ListNode(0);
    var t = l3;
    var k = l3;
    var temp = 0
    while(l1 != null && l2 != null){
        t = t.next;
        t = new ListNode(0);
        k.next = t;
        k = k.next;
        if(l1.val + l2.val + temp >= 10){
            t.val = (l1.val + l2.val + temp) % 10;
            temp = 1
        }else{
            t.val = (l1.val + l2.val + temp);
            temp = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        console.log(t)
    }
    while(l1 != null){
        t = t.next;
        t = new ListNode(0);
        k.next = t;
        k = k.next;
        if(l1.val + temp >= 10){
            t.val = (l1.val + temp) % 10;
            temp = 1;
        }else{
            t.val = (l1.val + temp);
            temp = 0;
        }
        l1 = l1.next
    }
    while(l2 != null){
        t = t.next;
        t = new ListNode(0);
        k.next = t;
        k = k.next;
        if(l2.val + temp >= 10){
            t.val = (l2.val + temp) % 10;
            temp = 1;
        }else{
            t.val = (l2.val + temp);
            temp = 0;
        }
        l2 = l2.next;
    }
    if(temp != 0){
        t = t.next;
        t = new ListNode(1);
        k.next = t;
        k = k.next;
    }
    if(l3.next != null)
        return l3.next;
    else
        return l3;
};

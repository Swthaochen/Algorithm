#include <iostream>
#include <vector>

using namespace std;
vector<int> a;  //存放原数组的向量
vector<int> tree;   // 构建得到线段树
vector<int> setv;   // 更新的lazy数组
int _min = 10000,v;   //全局最小值,更新的值
int ul,ur,ql,qr;    //定义更新的区间和搜索的区间

void pushdown(int o,int l,int r){
    int lc = o*2,rc = o*2+1;
    if(setv[o] >= 0){
        setv[lc] = setv[rc] = setv[o];
        setv[o] = -1;
    }
}

void maintain(int o,int l,int r){
    int lc = o*2,lr = o*2+1;
    if(l < r){
        tree[o] = min(tree[lc],tree[lr]);
    }
    // 进入这个if执行语句有两种情况,也就是节点的setv还没有往下push的情况
    // 第一种是被修改的区间包含了整个节点的区间
    // 第二种是区间长度为1的情况（实际上和第一种情况是一样的）
    if(setv[o] >= 0)
        tree[o] = v;
}

// 对树进行更新操作
// 如果当前节点区域就在更新区域中，我们就直接更新setv的值
// 否则我们先向下推进setv，然后递归进行update操作，然后进行maintain操作
void update(int o,int l,int r){
    if(ul <= l && ur >= r){
        setv[o] = v;
    }else{
        pushdown(o,l,r);
        int mid = (l + r) / 2;
        if(ul <= mid) update(o*2,l,mid);
        else maintain(o*2,l,mid);
        if(ur > mid) update(o*2+1,mid+1,r);
        else maintain(o*2+1,mid+1,r);
    }
    maintain(o,l,r);
}
// 查询的时候分几类情况
// 首先如果这个节点有setv的值，说明该节点端的所有值都要改成v，因此最小值也就是v
// 查询的区间没有setv，就是之前讨论的普通的查找模型
void query(int o,int l,int r){
    if(setv[o] >= 0){
        _min = min(_min,setv[o]);
    }else if(ql <= l && qr >= r){
        _min = min(_min,tree[o]);
    }else{
        int mid = (l + r) / 2;
        if(ql <= mid) query(o*2,l,mid);
        if(qr > mid) query(o*2+1,mid+1,r);
    }
}

int main()
{
    int n;
    cin >> n;
    a.push_back(0);
    for(int i = 0;i < n;i++){
        int k;
        cin >> k;
        a.push_back(k);
    }
    int m = 0;
    while((1 << m) < n) m++;
    for(int i = 0;i < (1 << m) + 1;i++){
        tree.push_back(0);
        setv.push_back(0);
    }
    for(int i = 0;i < n;i++){
        v = a[i+1];
        ul = ur = i + 1;
        update(1,1,n);
    }
    ql = 1;
    qr = n;
    query(1,1,n);
    cout << _min;
    return 0;
}

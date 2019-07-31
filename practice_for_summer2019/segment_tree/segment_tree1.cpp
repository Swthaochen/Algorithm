#include <iostream>
#include <vector>

using namespace std;
vector<int> a;
vector<int> tree;
int ql,qr;
int w,v;    //�޸�a[w] = v;

int init_tree(int count,int l,int r){
    if(l == r){
        tree[count] = a[l];
        return a[l];
    }
    int m = (l + r) / 2;
    int left = init_tree(count*2,l,m);
    int right = init_tree(count*2+1,m+1,r);
    tree[count] = min(left,right);
    return tree[count];
}

int query(int o,int l,int r){
    int m = (l + r) / 2,ans;
    if(ql <= l && qr >= r)  return tree[o];
    if(ql <= m) ans = query(o*2,l,m);
    if(qr > m) ans = min(ans,query(o*2+1,m+1,r));
    return ans;
}

// �Զ������޸ģ������ж����䳤���Ƿ����1�����ھ�ֱ���޸�
// �����ھ���Ҫ��w��mid���бȽ��ж����ĸ������ϣ�Ȼ����¶�Ӧ������������������ڵ��ֵ
void update(int o,int l,int r){
    if(l == r)  tree[o] = v;
    else{
        int mid = (l + r) / 2;
        if(w <= mid) update(o*2,l,mid);
        else update(o*2+1,mid+1,r);
        tree[o] = min(tree[o*2],tree[o*2+1]);
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
    }
    init_tree(1,1,n);
    cin >> ql >> qr;
    cout << query(1,1,n) << endl;
    cin >> w >> v;
    update(1,1,n);
    cout << query(1,1,n) << endl;
    return 0;
}

#include <iostream>
#include <vector>

using namespace std;
vector<int> a;
vector<int> tree;
vector<int> add;

// �����ѯ����������һ��add��ʾ����֮ǰ�ĸ��ڵ��ۼ�ֵ
void query(int o,int l,int r,int add){
    if(ql <= l && qr >= r){
        _min = min(_min,tree[o] + add);
    }else{
        int mid = (l + r) / 2;
        if(ql <= mid) query(o*2,l,m,add+add[o]);
        if(qr > mid) query(o*2+1,m+1,r,add+add[o]);
    }
}

// ά����ǰ�ڵ�ֵ�ĺ���
void maintain(int o,int l,int r){
    int lc = o * 2,rc = o*2+1;
    tree[o] = 0;
    if(r > l){
        tree[o] = min(tree[lc],tree[rc]);
    }
    tree[o] = tree[o] + add[o];
}

// ����������Ҫ�ж���Ҫ���µ������Ƿ񸲸��������ڵ������
// ����Ǿ�ֱ���޸ģ�������ǾͰ��ն�Ӧ����������޸Ĳ���
void update(int o,int l,int r){
    // ������²�����������������
    if(lc <= l && lr >= r){
        add[o] += v;
    }
    // û�и�����������
    else{
        int m = (l + r) / 2;
        if(w <= mid) update(o*2,l,mid);
        else update(o*2+1,mid+1,r);
    }
    maintain(o,l,r);
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
        add.push_back(0);
    }
    init_tree(1,1,n);
    cin >> ql >> qr;
    cout << query(1,1,n) << endl;
    cin >> w >> v;
    update(1,1,n);
    cout << query(1,1,n) << endl;
    return 0;
}

#include <iostream>
#include <vector>

using namespace std;
vector<int> a;  //���ԭ���������
vector<int> tree;   // �����õ��߶���
vector<int> setv;   // ���µ�lazy����
int _min = 10000,v;   //ȫ����Сֵ,���µ�ֵ
int ul,ur,ql,qr;    //������µ����������������

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
    // �������ifִ��������������,Ҳ���ǽڵ��setv��û������push�����
    // ��һ���Ǳ��޸ĵ���������������ڵ������
    // �ڶ��������䳤��Ϊ1�������ʵ���Ϻ͵�һ�������һ���ģ�
    if(setv[o] >= 0)
        tree[o] = v;
}

// �������и��²���
// �����ǰ�ڵ�������ڸ��������У����Ǿ�ֱ�Ӹ���setv��ֵ
// ���������������ƽ�setv��Ȼ��ݹ����update������Ȼ�����maintain����
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
// ��ѯ��ʱ��ּ������
// �����������ڵ���setv��ֵ��˵���ýڵ�˵�����ֵ��Ҫ�ĳ�v�������СֵҲ����v
// ��ѯ������û��setv������֮ǰ���۵���ͨ�Ĳ���ģ��
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

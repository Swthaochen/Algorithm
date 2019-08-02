#include <type_traits>//
// Created by lenovo on 2019/8/2.
//
#include "suffix_string1.h"

using namespace std;
string s;
vector<string> sv;  // 存放后缀数组的数组
vector<int> link;   // 存放排名的数组，代表的是第i个后缀的排在第几名，相当于rank数组
int l;

void sortString(){
    int i = 2;
    while(i/2 < l){
        vector< pair<pair<int,int>,int> > a;  //定义存放名次对的二元组
        int j;
        for(j = 0;j + i/2 < l;j++) {
            pair<int, int> p(link[j], link[j + i / 2]);
            pair<pair<int, int>, int> q(p, j);
            a.push_back(q);
        }
        for(;j < l;j++){
            pair<int, int> p(link[j], 0);
            pair<pair<int, int>, int> q(p, j);
            a.push_back(q);
        }
        sort(a.begin(),a.end());
        int local = 0;
        for(j = 0;j < l;j++){
            if(j != 0 && a[j].first == a[j-1].first){
                link[a[j].second] = local;
            }else{
                link[a[j].second] = ++local;
            }
        }
        i = i * 2;
    }
}

void test1_main(){
    cin >> s;
    l = s.length();
    for (int i = 0; i < l; ++i) {
        sv.push_back(s.substr(i,l-i));
        link.push_back(s[i]-'a'+1);
    }
    sortString();
//    int _link[l];
//    for(int i = 0;i < l;i++){
//        _link[link[i]-1] = i;
//    }
}

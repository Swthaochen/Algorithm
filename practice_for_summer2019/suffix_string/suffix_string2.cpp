//
// Created by shihaochen on 2019/8/2.
//
#include "suffix_string1.h"
#include "suffix_string2.h"

using namespace std;
extern string s;
extern vector<string> sv;  // 存放后缀数组的数组
extern vector<int> link;   // 存放排名的数组，代表的是第i个后缀的排在第几名，相当于rank数组
extern int l;

void test2_main(){
    test1_main();
    int k = 0;
    vector<int> sa(l,0);  //存放的是第i-1名对应的索引值
    vector<int> height(l,0);
    for(int i = 0;i < l;i++){
        sa[link[i]-1] = i;
    }
    for (int i = 0; i < l; ++i) {
        if(link[i] == 1)
            continue;
        else{
            if(k) k--;
            int j = sa[link[i]-2];
            while(s[j+k] != '\0' && s[i+k] == s[j+k]) k++;
            height[link[i]-1] = k;
        }
    }
    for(int i = 1;i < l;i++){
        cout << height[i] << endl;
    }
}
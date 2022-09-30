~~~C++
#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <stack>
#include <algorithm>
using namespace std;

struct fruit{
    int price;
    string a;
};

struct cmp{
    bool operator () (fruit f1, fruit f2){
        if(f1.price == f2.price) return f1.a > f2.a;
        return f1.price > f2.price;
    }
};

int n;
priority_queue<fruit, vector<fruit>, cmp> q;
int main(){
    cin >> n;
    for(int i = 0;i < n;i++){
        int a;
        string b;
        cin >> a >> b;
        fruit ll;
        ll.price = a;
        ll.a = b;
        q.push(ll);
    }
    for(int i = 0;i < n;i++){
        fruit t = q.top();
        q.pop();
        cout << t.price << " " << t.a << endl;
    }
    return 0;
}

~~~

在C++里面，cmp的排序方式和sort函数是相反的

### C++常用字符串函数：

char* strcpy(char* str1, char* str2);

功能：把str2指向的字符串拷贝到str1中去

返回：返回的是str1的指针

 char *strncpy(char *dest, const char *src，int count) 

功能：将字符串src的count个字符拷贝到dest中去

返回：指向dest的指针



char* strcat(char * str1,char * str2);

函数功能：把字符串str2接到str1后面，str1最后的'\0'被取消

函数返回：str1

char *strncat(char *dest, const char *src, size_t maxlen) 

将字符串src中前maxlen个字符连接到dest中



int strcmp(char * str1,char * str2); 

比较两个字符串str1,str2

返回：str1<str2,返回负数;str1=str2,返回 0;str1>str2,返回正数



int strncmp(char *str1,char *str2,int count) 



char* strchr(char* str,char ch); 

 找出str指向的字符串中第一次出现字符ch的位置 

返回指向该位置的指针,如找不到,则返回空指针 



char *strrchr(const char *s, int c) 

得到字符串s中最后一个含有c字符的位置指针

位置指针





函数原型:  char* strstr(char* str1,char* str2); 

函数功能:  找出str2字符串在str1字符串中第一次出现的位置(不包括str2的串结束符) 

函数返回:  返回该位置的指针,如找不到,返回空指针 



char *strupr(char *s) 

 将字符串s中的字符变为大写 



char *strlwr(char *s) 

将字符串中的字符变为小写字符 

指向s的指针 



头文件为#include <algorithm>

transform(s.begin(), s.end(), s.begin(), ::toupper);    

transform(s.begin(), s.end(), s.begin(), ::tolower);



C++截取字符串

s.substr(pos, n)    截取s中从pos开始（包括0）的n个字符的字串，n可省略

s.replace(pos, n, s1)   用s1替换s中从pos开始的n个字符的字串



s.find(s1, n)  查找s中第一次出现s1的位置，并返回

// 如果没有找到，就会返回npos,使用s.npos进行判断

s.rfind(s1)  查找s中最后一次出现s1的位置，并返回



```
sscanf( dtm, "%s %s %d  %d", weekday, month, &day, &year );
```



###stringstream用法

1.int转string

~~~C++
#include<iostream>
#include<sstream>
#include<string>
using namespace std;
int main()
{
    int i=23412;
    string str1("hhhhhh");
    stringstream stream;
    stream<<i;//把i的值给stream
    stream>>str1;//把stream的值给str1
    cout<<str1<<endl;
    return 0;
}
~~~

2.字符数组和string互相转化

~~~C++
#include<iostream>
#include<sstream>
#include<string>
using namespace std;
int main()
{
    char a[100]="hhhhhhhhh";
    double k=3.1423;
    stringstream stream;
    stream<<k;
    stream>>a;
    cout<<a<<endl;
    return 0;
}
~~~

3.字符串转数字

~~~C++
#include<iostream>  
#include <sstream>   
#include <string>
using namespace std; 
int main()
{
    //字符转数字
    string str1 = "2018219";
    string str2 = "2018.219";//浮点数转换后的有效数为6位
    int num1 = 0;
    double num2 = 0.0;
    stringstream s;
    //转换为int类型
    s << str1;
    s >> num1;
    //转换为double类型
    s.clear();
    s << str2;
    s >> num2;
    cout << num1 << "\n" << num2 << endl;
    return 0;
}
~~~

4.进行字符串的切割

~~~C++
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

int main(){
    string s = "123/456/789";
    stringstream ss(s);
    string temp;
    vector<string> vv;
    while(getline(ss, temp, '/')){
        cout << temp << endl;
        vv.push_back(temp);
    }
    int a;
    stringstream ee;
    for(int i = 0;i < vv.size();i++){
        ee.clear();
        ee << vv[i];
        ee >> a;
        cout << a << endl;
    }
    return 0;
}
~~~

pair的优先队列

~~~C++
#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> P;

struct cmp
{
    bool operator()(const P p1, const P p2)
    {
        return p1.second > p2.second; //second的小值优先
    }
};

int main(void)
{
    priority_queue<P, vector<P>, cmp> que;
    que.push(P(10,20));
    que.push(P(15,30));
    que.push(P(20,1));
    P p;
    while(!que.empty())
    {
        p=que.top();
        que.pop();
        cout<<p.first<<" "<<p.second<<endl;
    }
}
~~~



math.h中常用的函数

ceil(x)   x向上取整

floor(x)   x向下取整

round(x)  x的四舍五入

fmax(x,y)  取最大

fmin(x, y)  取最小



格式化的输入输出

1.整形输出一定宽度并补0

~~~C++
#include <iostream>
using namespace std;

int main(void)
{
    int d = 2;
    int n = 3;
    printf("%0*d",n, d);
    return 0;
}
~~~

~~~C++
#include <iostream>
using namespace std;

int main(void)
{
    int d = 2;
    printf("%03d",d);
    return 0;
}

~~~

2.输出十六进制数

~~~C++
# include <stdio.h>
int main(void)
{
    int i = 47;
    printf("%x\n", i);   
    printf("%X\n", i);   
    printf("%#x\n", i);   
    printf("%#X\n", i);   
    return 0;
}
//结果是
2f
2F
0x2f
0X2F
~~~

可以控制输出左对齐或右对齐, 即在"%"和字母之间加入一个"-" 号可    说明输出为左对齐, 否则为右对齐。

可以在"%"和字母之间加小写字母l, 表示输出的是长型数。   
例如:  %ld  表示输出long整数   
%lf  表示输出double浮点数   



~~~C++
#include <iostream>
#include <set>
#include <vector>
#define MAXN 50001
using namespace std;

int n, k;
int book[MAXN];
struct node{
    int val;
    int num;
    bool operator < (const node a) const{
        if(num != a.num) return num > a.num;
        else return val < a.val;
    }
};

int main()
{
    cin >> n >> k;
    int a;
    set<node> ss;
    fill(book, book+MAXN, 0);
    for(int i = 0;i < n;i++){
        cin >> a;
        if(i != 0){
            cout << a << ":";
            int j = 0;
            for(set<node>::iterator it = ss.begin(); it != ss.end();it++){
                if(j < k) cout << " " << it->val;
                else break;
                j++;
            }
            if(i+1 != n) cout << endl;
        }
        node nn;
        nn.val = a;
        nn.num = book[a];
        if(ss.find(nn) != ss.end()){
            ss.erase(ss.find(nn));
        }
        if(book[a] != 0){
            nn.num = book[a] + 1;
        }else{
            nn.num = 1;
        }
        book[a]++;
        ss.insert(nn);
    }
    return 0;
}

~~~

test2

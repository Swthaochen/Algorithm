public class Percolation {
    //代表某行某列某个点是否被open
    boolean[][] gird;
    //整个系统是否渗透
    boolean isPer = false;
    //二维数组的维数
    int size;
    //一维数组代表连通分量
    int union[];
    //height代表的是这个树的高度
    int height[];
    //代表一个点是否为full状态
    boolean[] isFull;
    //渗透系统的构造器
    public Percolation(int N){
        size = N;
        union = new int[N * N];
        gird = new boolean[N][N];
        height = new int[N * N];
        isFull = new boolean[N * N];

        //for循环对图的进行初始化
        for (int i = 0;i < N;i++) {
            for (int j = 0;j < N;j++){
                //所有的点都是block状态
                gird[i][j] = false;
                union[i * N + j] = i * N + j;
                height[i * N + j] = 1;
                isFull[i * N + j] = false;
            }
        }
    }

    // 将附近的节点连通起来，这个函数是相对于第一行的点而言的，
    // 优先改变其他节点的ID
    // 传入的参数分别是两个子树的位置
    private void unionNode(int first,int second){
        int root1 = find(first);
        int root2 = find(second);
        //第一棵树的高度大于第二棵树的高度
        if (height[root1] > height[root2]){
            union[root2] = union[root1];
            if(isFull[root1]){
                isFull[root2] = true;
            }
            if (isFull[root2]){
                isFull[root1] = true;
            }
        } else {
            //第一棵树的高度小于等于第二棵树的高度
            union[root1] = union[root2];
            if (isFull[root2]){
                isFull[root1] = true;
            }
            if (isFull[root1]){
                isFull[root2] = true;
            }
        }
    }
    //递归寻找根节点
    private int find(int id){
        int num = id;
        while (union[num] != num){
            num = union[num];
        }
        return num;
    }

    //open site if it is not already
    public void open(int i,int j){
        gird[i][j] = true;
        //对图的连通性进行动态分配
        //当被open的是第一行的点的时候
        if (i == 0){
            //将这个点设置为贯通的点
            isFull[i*size+j] = true;
            //左边的点是open的
            if (j > 0 && gird[i][j-1])
            {
                unionNode(i*size+j-1,i*size+j);
            }
            //右边的点是open的
            if (j < size-1 && gird[i][j+1])
            {
                unionNode(i*size+j+1,i*size+j );
            }
            //下面的点是open的
            if (gird[i+1][j]){
                unionNode(i*size+j,(i+1)*size+j);
            }
        } else if (i == size-1){
            //若被open的点是最后一行的时候
            //上边的点是open的
            if (gird[i-1][j]){
                if (union[i*size+j] != union[(i-1)*size+j])
                    unionNode(i*size+j,(i-1)*size+j);
            }
            if (j > 0 && gird[i][j-1]){
                if (union[i*size+j-1] != union[i*size+j])
                    unionNode(i*size+j-1,i*size+j);
            }
            if (j < size-1 && gird[i][j+1]){
                if (union[i*size+j+1] != union[i*size+j])
                    unionNode(i*size+j+1,i*size+j);
            }
        } else {
            //上面的点是open的
            if (gird[i-1][j])
            {
                if (union[(i-1)*size+j] != union[i*size+j])
                    unionNode((i-1)*size+j,i*size+j);
            }
            //左边的点是open的
            if (j > 0 && gird[i][j-1]){
                if (union[i*size+j] != union[i*size+j-1])
                {
                    unionNode(i*size+j-1,i*size+j);
                }
            }
            //右边的点是open的
            if (j < size-1 && gird[i][j+1]){
                if (union[i*size+j] != union[i*size+j+1])
                {
                    unionNode(i*size+j,i*size+j+1);
                }
            }
            if (gird[i+1][j]){
                if (union[i*size+j] != union[(i+1)*size+j])
                {
                    unionNode((i+1)*size+j,i*size+j);
                }
            }
        }
    }
    //查找某个点是否为open
    public boolean isOpen(int i,int j){
        return gird[i][j];
    }

    //有没有和上面连通
    public boolean isFull(int i,int j){
        int a = find(i*size+j);
        return isFull[a];
    }

    public boolean percolates(){
        return isPer;
    }
}

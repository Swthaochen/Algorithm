public class Percolation {
    //代表某行某列某个点是否被open
    boolean[][] gird;
    //整个系统是否渗透
    boolean isPer = false;
    //二维数组的维数
    int size;
    //一维数组代表连通分量
    int union[];
    //渗透系统的构造器
    public Percolation(int N){
        size = N;
        union = new int[N * N];
        gird = new boolean[N][N];
        //for循环对图的进行初始化
        for (int i = 0;i < N;i++) {
            for (int j = 0;j < N;j++){
                //所有的点都是block状态
                gird[i][j] = false;
                union[i * N + j] = i * N + j;
            }
        }
    }

    //将附近的节点连通起来，这个函数是相对于第一行的点而言的，
    // 优先改变其他节点的ID
    //传入的参数分别代表要改变值的id和变更的id
    private void unionNode(int num,int id){
        for (int i = 0;i < size * size;i++){
            if(union[i] == num){
                union[i] = id;
                if (i >= (size-1)*size && i < size*size){
                    if (union[i] >= 0 && union[i] < size){
                        isPer = true;
                    }
                }
            }
        }
    }

    //open site if it is not already
    public void open(int i,int j){
        gird[i][j] = true;
        //对图的连通性进行动态分配
        //当被open的是第一行的点的时候
        if (i == 0){
            //左边的点是open的
            if (j > 0 && gird[i][j-1])
            {
                unionNode(union[i*size+j-1],union[i*size+j]);
            }
            //右边的点是open的
            if (j < size-1 && gird[i][j+1])
            {
                unionNode(union[i*size+j+1],union[i*size+j] );
            }
            //下面的点是open的
            if (gird[i+1][j]){
                unionNode(union[(i+1)*size+j],union[i*size+j]);
            }
        } else if (i == size-1){
            //若被open的点是最后一行的时候
            //上边的点是open的
            if (gird[i-1][j]){

                union[i*size+j] = union[(i-1)*size+j];
                if (union[i*size+j] >= 0 && union[i*size+j] < size)
                    isPer = true;
            }
            if (j > 0 && gird[i][j-1]){
                if (union[i*size+j-1] >= 0 && union[i*size+j-1] < size)
                    unionNode(union[i*size+j],union[i*size+j-1]);
                else
                    unionNode(union[i*size+j-1],union[i*size+j]);
            }
            if (j < size-1 && gird[i][j+1]){
                if (union[i*size+j+1] >= 0 && union[i*size+j+1] < size)
                    unionNode(union[i*size+j],union[i*size+j+1]);
                else
                    unionNode(union[i*size+j+1],union[i*size+j]);
            }
        } else {
            //上面的点是open的
            if (gird[i-1][j]){
                union[i*size+j] = union[(i-1)*size+j];
            }
            //左边的点是open的
            if (j > 0 && gird[i][j-1]){
                if (union[i*size+j] != union[i*size+j-1]){
                    //如果左边的点和最顶上的点是连通的
                    if (union[i*size+j-1] >= 0 && union[i*size+j-1] < size)
                        unionNode(union[i*size+j],union[i*size+j-1]);
                    else
                        unionNode(union[i*size+j-1],union[i*size+j]);
                }
            }
            //右边的点是open的
            if (j < size-1 && gird[i][j+1]){
                if (union[i*size+j] != union[i*size+j+1])
                {
                    if (union[i*size+j+1] >= 0 && union[i*size+j+1] < size)
                        unionNode(union[i*size+j],union[i*size+j+1]);
                    else
                        unionNode(union[i*size+j+1],union[i*size+j]);
                }
            }
            if (gird[i+1][j]){
                if (union[i*size+j] != union[(i+1)*size+j])
                {
                    if (union[(i+1)*size+j] >= 0 && union[(i+1)*size+j] < size)
                        unionNode(union[i*size+j],union[(i+1)*size+j]);
                    else
                        unionNode(union[(i+1)*size+j],union[i*size+j]);
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
        if (union[i*size+j] >= 0 && union[i*size+j] < size){
            return true;
        } else {
            return false;
        }
    }

    public boolean percolates(){
        return isPer;
    }
}

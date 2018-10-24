
public class PercolationStats {
    double theMean;
    int size;
    double theSts;
    int[] result;
    public PercolationStats(int N, int T){
        this.size = N;
        result = new int[T];
        for (int k = 0;k < T;k++){
            Percolation p = new Percolation(size);
            int flag = 0;
            while (!p.percolates()){
                int i = (int)(0+Math.random()*(size));
                int j = (int)(0+Math.random()*(size));
                if (!p.isOpen(i,j)){
                    p.open(i,j);
                    flag++;
                    for (int m = 0;m < size;m++){
                        if (p.isFull(size-1,m)){
                            p.isPer = true;
                            break;
                        }
                    }
                }
            }
            result[k] = flag;
        }
    }
    public double mean(){
        double sum = 0;
        int len = this.result.length;
        for (int i = 0;i < len;i++){
            sum = sum + this.result[i];
        }
        this.theMean = sum / (len * this.size * this.size);
        return this.theMean;
    }
    public double stddev(){
        double sum = 0;
        int len = this.result.length;
        for (int i = 0;i < len;i++){
            double re = (double)result[i] / (this.size * this.size) - this.theMean;
            sum = sum + Math.pow(re,2);
        }
        this.theSts = sum / (len - 1);
        return Math.sqrt(this.theSts);
    }
    public double confidenceLo(){
        return this.theMean - 1.96 * Math.sqrt(this.theSts / this.result.length);
    }
    public double confidenceHi(){
        return this.theMean + 1.96 * Math.sqrt(this.theSts / this.result.length);
    }
}

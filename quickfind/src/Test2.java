public class Test2 {
    public static void main(String[] args) {
        int N = 100;
        int T = 400;
        long startTime=System.currentTimeMillis();
        PercolationStats pe = new PercolationStats(N,T);
        long endTime=System.currentTimeMillis();
        System.out.println("Example values after creating PercolationStats(" + N + "," + T +")");
        System.out.println("mean()：\t\t\t\t\t" + pe.mean() + "\nstddev()：\t\t\t\t\t" + pe.stddev());
        System.out.println("confidenceLow()：\t\t\t" + pe.confidenceLo());
        System.out.println("confidenceHigh()：\t\t\t" + pe.confidenceHi());
        System.out.println("Running time:\t\t\t\t" + (endTime-startTime) / 1000.00 + "s");
    }
}


public class test {
    public static void main(String[] args) {
        int size = 100;
        Percolation p = new Percolation(size);
        int flag = 0;
        while (!p.percolates()){
            int i = (int)(0+Math.random()*(size));
            int j = (int)(0+Math.random()*(size));

//            Scanner input = new Scanner(System.in);
//            int i = input.nextInt();
//            int j = input.nextInt();
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
        System.out.println(flag);
    }
}

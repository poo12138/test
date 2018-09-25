package JavaTest;
import java.lang.*;

public class Statistics {
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        int singlecount = 0;
        int p = n;
        int num = 0;
        if (k == 0) {
            return n / 10 + 1;
        } else if (n == 0) {
            return 0;
        } else {
            while(p != 0) {
                if (p % 10 > k) {
                    singlecount = (int)((double)(p / 10 + 1) * Math.pow(10.0D, (double)num));
                }

                if (p % 10 == k) {
                    singlecount = (int)((double)(p / 10) * Math.pow(10.0D, (double)num) + (double)n % Math.pow(10.0D, (double)num) + 1.0D);
                }

                if (p % 10 < k) {
                    singlecount = (int)((double)(p / 10) * Math.pow(10.0D, (double)num));
                }

                count += singlecount;
                p /= 10;
                ++num;
            }

            return count;
        }
    }
    public static void main(String[] args) {
    Statistics sta=new Statistics();
    int a=sta.digitCounts(1,12);
    System.out.print(a);
    }
}


package com;

import java.util.Scanner;

public class ReverseInt {


    public int reverseInteger(int number) {
        // write your code here
        int result=0;
        int b=number/100;
        int s=number/10%10;
        int g=number%10;
        result=g*100+s*10+b;
        return result;
    }
    public void show() {
        Scanner in = new Scanner(System.in);



            System.out.print("请输入100～1000之间的数字\n");
            int a = in.nextInt();
            if (a < 100 || a > 1000) {
                System.out.print("Wrong Number");
            }
            else {
                ReverseInt rint = new ReverseInt();
                int re = rint.reverseInteger(a);
                System.out.print("Result :" + re);

            }

    }
    public static void main(String[] args) {
        ReverseInt in = new ReverseInt();
        Scanner an = new Scanner(System.in);
        String s = an.next();
        while (s.equals("y"))
            in.show();
    }


}

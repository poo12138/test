package com;

//public class Ceshi {
//
//    public static void main(String args[]){
//
//        String i="12s1";
//        try {
//            int c=Integer.parseInt(i);
//            System.out.print(c);
//        }catch(NumberFormatException e){
//            e.printStackTrace();
//            System.out.print("wrong\n");
//        }
//        String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";
//
//        // 出现次数
//        int num = 0;
//
//        // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
//        for (int j=0;j<s.length();j+=4)
//        {
//            // 获取每个字符，判断是否是字符a
//            if (s.charAt(j)=='a') {
//                // 累加统计次数
//                num++;
//            }
//        }
//        System.out.println("字符a出现的次数：" + num);
//    }
//}

public class Ceshi<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = 0; i < N && !hasSorted; i++) {
            hasSorted = true;
            for (int j = 0; j < N - i - 1; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args){
        String t[]={"121sas","wqwqw","2asas"};
        System.out.println(t.length);
        Ceshi cs=new Ceshi();
        cs.sort(t);
        for (String q:t) {
            System.out.println(q);

        }
    }
}

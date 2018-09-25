package com;
import java.util.*;
public class SortTest<T extends Comparable<T>>extends Sort<T> {
    /**
     * 选择排序
     * @param nums
     */
    public void shellsort(T[] nums){
        int N=nums.length;
        int h=1;
        while(h<N/3) {
            h = 3 * h + 1;
        }
        while(h>=1){
            for(int i=N;i<N;i++){
                for(int j=i;j>=h&&less(nums[j],nums[j-h]);j-=h) {
                    swap(nums, j, j - h);
                }
            }
            h=h/3;
        }
    }
    @Override
//    public void sort(T[] nums) {
//        int N=nums.length;
//        for(int i=0;i<N;i++){
//            int min=i;
//            for(int j=i+1;j<N;j++) {
//                if (less(nums[j], nums[min]))
//                    min = j;
//            }
//            swap(nums,i,min);
//        }
//
//    }
//    public void sort(T[] nums){
//        /**
//         * 冒泡排序
//         * @param nums
//         */
//        int N=nums.length;
//        for(int i=0;i<N-1;i++){
//            for(int j=0;j<N-1-i;j++){
//                if(less(nums[j+1],nums[j]))
//                    swap(nums,j,j+1);
//            }
//        }
//    }
//    public void sort(T[] nums){
//
//        /**
//         * 插入排序
//         */
//        int N=nums.length;
//        for(int i=1;i<N;i++){
//            for(int j=i;j>0&&less(nums[j],nums[j-1]);j--)
//                swap(nums,j,j-1);
//        }
//    }

//
       public void sort(T[] nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);

    }
    public void sort(T[] nums,int lo,int hi){
       if(lo>=hi)
           return ;
       int j=partition(nums,lo,hi);
       sort(nums,lo,j-1);
       sort(nums,j+1,hi);

    }
    private int partition(T[] nums, int l, int h) {
        int i=l;
        int j=h+1;
        T v=nums[i];
        while(true){
            while(less(nums[++i],v)&&i!=h);
            while(less(v,nums[--j])&&j!=i);
            if(i>=j){
                break;
            }
            swap(nums,i,j);

        }
        swap(nums,j,l);
        return j;

    }
    public void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public static void main(String[] args){
        String nums[]={"6","3","8","2","9","1"};
        SortTest st=new SortTest();
        st.shellsort(nums);
        //st.sort(nums,0,5);
        for (String i:nums) {
            System.out.println(i);

        }
    }

}


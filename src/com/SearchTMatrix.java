package com;

public class SearchTMatrix {
    /**
     *  @Author poo
     *  @param  matrix,target
     *  @return  返回target出现的次数
     */

    public static int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null||matrix.length==0||(matrix.length==1&&matrix[0].length==0))
            return -1;

        int klen=matrix.length;
        int clen=matrix[0].length;
        int n=0;
        int count=0;
        while(matrix[n][0]<=target){


            n++;
            if(n==klen)
                break;
        }
        for(int i=0;i<clen;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == target) {
                    count++;
                }
            }
        }

        System.out.print(count);
        return count;
    }
    public int searchMatrix2(int[][] matrix, int target) {
        // write your code here
        //从右上角开始搜索，因为从左到右递增，从上到下递增，从右上角
        //开始搜索的话效率高，target值大于矩阵点row++,target值小于
        //矩阵点，column--，target值等于矩阵点，count++,row++,column--
        int count=0;
        if(matrix.length==0)
            return 0;
        int row=matrix.length;
        int column=matrix[0].length;
        int i=0;
        int j=column-1;

        while(i<=row-1&&j>=0){

            if(target>matrix[i][j])
                i++;
            else
            if(target<matrix[i][j])
                j--;
            else
            if(target==matrix[i][j]){
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
    public static void main(String args[]){
        int[][] a={{1,2,3,4},
                {2,3,4,7},
                {3,4,5,6},
                {4,5,6,7} ,
                {6,7,8,9}};
        int[][] b={};
        searchMatrix(b,9);
    }
}

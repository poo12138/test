package JavaTest;

public class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int columns = 0;
        if (len == 0) {
            columns = 0;
        } else {
            columns = matrix[0].length;
        }
        int row = 0;
        int colum = columns-1;
        if (matrix != null && len > 0 && columns > 0)
            while (row <= len && colum >=0) {
                if (matrix[row][colum] == target) {
                    return true;
                } else if (matrix[row][colum] < target)
                    row++;
                else
                    colum--;
            }
            return false;
        }
    public static void main(String[] args) {
        Matrix sta=new Matrix();
       int a[][]={{1, 3, 5, 7},
               {10, 11, 16, 20},
               {23, 30, 34, 50}};
       if(sta.searchMatrix(a,9))
           System.out.print(1);
       else
           System.out.print("null");

    }
}

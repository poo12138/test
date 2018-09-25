package offer;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Leetcode {
    public List<Integer> Permutation(int n,int k) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> rec=new ArrayList<>();
        int[] num=new int[n];

        Boolean[] bool=new Boolean[n];
        for(int i=0;i<n;i++){
            num[i]=i+1;
            bool[i]=false;
        }


        get(num,list,rec,0,bool);
     return list.get(k-1);
    }
    public void get(int[] n,List<List<Integer>> list,List<Integer> rec,int index,Boolean[] bool){
        if(index==n.length){
            list.add(new ArrayList<>(rec));
            return;
        }

        for(int i=0;i<n.length;i++){
            if(!bool[i]){
                rec.add(n[i]);
                bool[i]=true;
                get(n,list,rec,index+1,bool);
                bool[i]=false;
                rec.remove(rec.size()-1);
            }
        }



    }
public List<List<Integer>> fourSum1(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list=new ArrayList<>();
    int N=nums.length;
    Boolean[] arr=new Boolean[N];
    for(int i=0;i<nums.length;i++){
        arr[i]=false;
    }
    List<Integer> list_=new ArrayList<>();
    fourSum(list,nums,target,arr,0,0,list_);
    return list;
}

    public void fourSum(List<List<Integer>> list,int[] nums, int target,Boolean[] arr,int sum,int index,List<Integer> list_){
        if(list_.size()==4 && sum==target){

            if(!list.contains(list_))
                list.add(new ArrayList<>(list_));
            return;
        }
        if(index>=4){
            return;
        }


        for(int i=index;i<nums.length;i++){

            if(!arr[i]){
                sum=nums[i]+sum;
                arr[i]=true;
                list_.add(nums[i]);
                fourSum(list,nums,target,arr,sum,index+1,list_);
                arr[i]=false;
                sum=sum-nums[i];
                list_.remove(list_.size()-1);
                while(i < nums.length-1 && nums[i] == nums[i+1]){
                     i++;
                }
            }
        }
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if (nums == null || nums.length < 3)
            return list;

        int N=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<N;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<N;j++){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left=j+1;
                int right=N-1;
                while(left<right){
                  int sum=  nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[left]);
                        res.add(nums[right]);
                        list.add(new ArrayList<>(res));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;

                    }
                    else if(sum>target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }



            }
        }
        return list;
    }
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];

        //因式分解需要的基数
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                factorial[i] = 1;
                continue;
            }
            factorial[i] = factorial[i - 1] * (i);
        }
        //1,1,2,6,24
        //1*0+1*1+2*2+6*3+24*4=119
        //而我们实际需要的数是：1、2、3、4、5，但他们的组合序列就相当于0、1、2、3、4的组合，只是各自加1而已。
        //二者的不同还在于，0-4的k的表是范围是从0-119，而我们的k是从1-120，所以变换关系是k-1。


        StringBuilder res = new StringBuilder();
        boolean[] used = new boolean[n];
        int i = n - 1;
        while (i >= 0) {
            int digit = (k - 1) / factorial[i];//变换关系k-1
            res.append(findKth(used, digit));//先取最高位的值
            k -= digit * factorial[i--];
        }

        return res.toString();
    }
    //再次强调下，数组是用的地址，而我们传递的对象就是普通的参数
    public int findKth(boolean[] used, int digit) {
        int res = -1;
        while (digit >= 0) {
            if (!used[++res]) { //从小到大的去取值，同时进行标记
                digit--;
            }
        }
        used[res] = true;
        return res + 1;//从0-4，变为1-5

    }

//    public int rotateRight(ListNode head, int k) {
//        int count=0;
//        ListNode temp=new ListNode(-1);
//        temp.next=head;
//        while(temp.next!=null){
//            temp=temp.next;
//            count++;
//        }
//        ListNode temps=new ListNode(-1);
//        temps.next=head;
//        temps=temps.next;
////       for(int i=0;i<count;i++){
////            temps=temps.next;
////       }
//        ListNode ref;
//       while(count-1>1){
//           temps=temps.next;
//           ref=temps.next;
//           count--;
//       }
//       temps.next=null;
//       ref.next=head;
//        return count;
//    }
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k <= 0)
        return head;
    // 新建一个结点，利于操作
    ListNode tmpHead = new ListNode(0);
    tmpHead.next = head;
    // 使用快慢指针，计算倒数节点数目
    ListNode fast = tmpHead;
    ListNode slow = tmpHead;
    int len = 0;
    // 计算链表长度
    while (slow.next != null) {
        len++;
        slow = slow.next;

    }
    slow = tmpHead;
    // 关键，记录k 的有效长度，输入会有k大于链表长度值
    k = (len + (k % len)) % len;
    // 不需要翻转
    if (k == 0)
        return tmpHead.next;
    // 快指针先走k步
    while (--k >= 0)
        fast = fast.next;
    // 一起走
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    // 重新链接链表，注意置空
    tmpHead.next = slow.next;
    fast.next = head;
    slow.next = null;
    return tmpHead.next;

}
    public int uniquePaths(int m, int n) {
        int [][] nums=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)
                nums[0][0]=1;
               else if(i==0&&j>0){
                    nums[i][j]=nums[i][j-1];
                }
                else if(j==0&&i>0){
                    nums[i][j]=nums[i-1][j];
                }else{
                    nums[i][j]=nums[i-1][j]+nums[i][j-1];
                }
            }
        }
        return nums[n-1][m-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
                else if (i == 0 && j == 0)
                    obstacleGrid[0][0] = 1;
                else if (i == 0 && j > 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
    public int minPathSum(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0&&j==0){
                    continue;
                }
                else if (i == 0 && j > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] += Math.min(obstacleGrid[i - 1][j] , obstacleGrid[i][j - 1]);
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }

    public int[] plusOne(int[] digits) {
        int N=digits.length;
        digits[N-1]=digits[N-1]+1;

            for(int i=N-1;i>0;i--){
                if(digits[i]==10){
                    digits[i]=digits[i]%10;
                    digits[i-1]=digits[i-1]+1;
                }

            }
        if(digits[0]==10){
            int[] arr=new int[N+1];

            arr[0]=1;
            for(int j=1;j<arr.length;j++){
                arr[j]=0;
                return arr;
            }
        }

        return digits;
    }
    public String addBinary(String a, String b) {
        int na=a.length();
        int nb=b.length();
        StringBuilder sb=new StringBuilder();
        int num1=0,num2=0;
        int count=0;
        while(na-1>=0||nb-1>=0){


            if(na>0){
                 num1=a.charAt(na-1)-'0';
            }else{
                num1=0;
            }
            if(nb>0){
                 num2=b.charAt(nb-1)-'0';
            }
            else{
                num2=0;
            }
            int num=num1+num2+count;
            if(num>=2){
                sb.append(num%2);
               count=num/2;
            }
            else{
                sb.append(num%2);
                count=0;
            }
            na--;
            nb--;
        }
        if(count==1){
            sb.append(count);
        }
        return sb.reverse().toString();
    }
    public int mySqrt(int x) {
        int i=0, j=x;
        while (i<=j) {
            int m = (i+j)/2;
            long m2 = (long)m*m;
            if (m2==(long)x) return m;
            if (m2>x) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i-1;
    }
    public String simplifyPath(String path) {
        String[] str=path.split("/");
        if(str.length==0){
            return "/";
        }
        if (str[str.length - 1] .equals("..") ) {
            return "/";
        }
        if(str[str.length-1].charAt(0)=='.'){
            return "/";
        }

       return "/"+str[str.length-1];
    }
    public void setZeroes(int[][] matrix) {
        boolean[] bool=new boolean[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            boolean row=false;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row=true;
                    bool[j]=true;
                }
            }
            if(row){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(bool[i]){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int lr=col-1;
        int ud=0;

        while(lr>=0&&ud<row){
            if(matrix[ud][lr]==target){
                return true;
            }
            else if(matrix[ud][lr]>target){
                lr--;
            }else {
                ud++;
            }

        }
        return false;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<>();

        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;

        }
        combine(list,res,nums,k,0);
        return list;
    }

    public void combine(List<List<Integer>> list,List<Integer> res,int[] n,int k,int index){
        if(res.size()==k){
            if(!list.contains(res))
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i=index;i<n.length;i++){
            res.add(n[i]);

            combine(list,res,n,k,i+1);
            res.remove(res.size()-1);

        }


    }
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, n, k, 1);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k, int m) {
        if(temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=m; i<=n; i++) {
            temp.add(i);
            dfs(res, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        subsets(list,res,nums,0);
        return list;

    }
    public void subsets(List<List<Integer>> list,List<Integer> res,int[] nums,int index){
        list.add(new ArrayList<>(res));
        if(res.size()==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            res.add(nums[i]);
            subsets(list,res,nums,i+1);
            res.remove(res.size()-1);
        }

    }
    public boolean exist(char[][] board, String word) {
        boolean[][] market=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean value=existed(board,word,i,j,0,market);
                    if(value){
                        return value;
                    }
                }
            }
        }
        return false;
    }
    public boolean existed(char[][]board,String word,int row,int col,int count,boolean[][] market){
        if(count == word.length())
            return true;

        if(row >= board.length || row < 0 ||  col >= board[0].length || col < 0
                         || word.charAt(count) != board[row][col] || market[row][col])
                     return false;


             market[row][col]=true;
                 if(existed(board, word,  row - 1, col,count + 1, market) || // go top
                     existed(board, word,  row, col + 1,count + 1, market) || // go right
                         existed(board, word,  row + 1, col,count + 1, market) || // go bottom:
                         existed(board, word,  row, col - 1, count + 1,market))   // go left:
                 {
                         return true;
                     }
                market[row][col]=false;
                 return false;

    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int N=nums.length;
        int count=1;
        int temp=nums[0];
        int i=1;
        int length=N;
        while(i<length){
            if(temp==nums[i]){
                count++;
                if(count>2){
                    int j=i+1;
                    if(j>=length){
                        return i;}
                    while(j<length){
                        if(nums[j]!=nums[i]){
                            length=length-(j-i);
                            leftmove(nums,i,j);
                            count=1;
                            i=i-1;
                            break;
                        }
                        else if(j==length-1){
                            return i;
                        }
                        else j++;
                    }

                }
                i++;
            }else{
                temp=nums[i];
                count=1;
                i++;
            }

        }
        return length;
    }
    public void leftmove(int[] nums,int i,int j){
        int N=nums.length;
        while(j<N){
            nums[i++]=nums[j++];

        }

    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode list=new ListNode(-1);
        ListNode listNode=list;


        while(head != null && head.next != null) {
            if (head.val == head.next.val) {
                while(head.next!=null&& head.val==head.next.val){
                   head=head.next;
                }
                head=head.next;
            }else{
                listNode.next=head;
                listNode=listNode.next;
                head=head.next;
            }
        }
        listNode.next=head;
        return list.next;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode list=new ListNode(-1);
        ListNode listNode=list;


        while(head != null && head.next != null) {
            if (head.val == head.next.val) {
                while(head.next!=null&& head.val==head.next.val){
                    head=head.next;
                }

            }else{
                listNode.next=head;
                listNode=listNode.next;
                head=head.next;
            }
        }
        listNode.next=head;
        return list.next;

    }
    //wrong
    public int largestRectangleArea(int[] heights) {
        int area=heights[0];
        int temp=0;
        int i=1;
        int count=1;
        int mark=0;
        int low=heights[0];
        while(i<heights.length){

          int nlow=Math.min(heights[i],low);
           count++;
           temp=nlow*count;
           if(mark==i-1) {
               if (area >= temp && area > heights[i]) {
                   count--;
                   i++;
               } else if (area > temp && area < heights[i]) {
                   low = heights[i++];
                   mark=i;
                   count = 1;
               } else {
                       area = temp;
                       low = nlow;
                       i++;
                       mark = i;

               }

           }else{
               if(area<heights[i]){
                   area=heights[i];
                   mark=i++;
               }else{
                   i++;
               }
           }
        }
        return area;
    }
    public int largestRectangleArea1(int[] heights) {
        int len=heights.length;
        Stack<Integer> stack=new Stack();
        int maxarea=0;
       for(int i=0;i<=len;i++){
           int h=(i==len ? 0:heights[i]);
           if(stack.isEmpty()||h>=heights[stack.peek()]) {
               stack.push(i);
           }else{
            int top=stack.pop();
            maxarea=Math.max(maxarea,heights[top]*(stack.isEmpty()? i: i-stack.peek()-1));
            i--;
           }
       }
       return maxarea;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode node=new ListNode(-1);
        ListNode listNode=node;

        ListNode list=new ListNode(-1);
        ListNode listNode1=list;
        while(head!=null&&head.next!=null){

            if(head.val==x){

                listNode1.next=head;
                listNode1= listNode1.next;
                head=head.next;


                while(head!=null){

                    if(head.val<x){
                        ListNode temp=new ListNode(-1);
                        temp.next=head;
                        temp=temp.next;
                        head=head.next;

                        temp.next=null;
                        listNode.next=temp;
                        listNode=listNode.next;
                    }else{
                        listNode1.next=head;
                        listNode1= listNode1.next;
                        head=head.next;
                    }
                }
                listNode1.next=head;
            }else{
                listNode.next=head;
                listNode=listNode.next;
                head=head.next;
            }
        }
        listNode.next=list.next;
        return node.next;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0;
        int j=0;
        int z=0;
        while(i<m+n&&j<n){
            if(nums1[i]<nums2[j]&&z<m){
                i++;
                z++;
            }else if(z==m &&j<n){
                nums1[i]=nums2[j];
                i++;
                j++;

            }else{
                leftmove(nums1,i);
                nums1[i]=nums2[j];
                j++;
                i++;
            }

        }
    }
    public void leftmove(int[] nums,int key){
        for(int i=nums.length-1;i>key;i-- ){
            nums[i]=nums[i-1];
        }
    }
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }

    }
    public static void main(String[] args){
        Leetcode leetcode=new Leetcode();
        int[] nums={6,1,5,6,2,3,0,0,0};
        int[] nums1={1,2,3,0,0,0,0};
        int[] nums2={2,5,6};
        leetcode.merge(nums1,3,nums2,3);
      //leetcode.leftmove(nums,3);
      for(int i:nums1){
          System.out.println(i);
      }

        //System.out.println(leetcode.largestRectangleArea1(nums));
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(2);
        ListNode listNode5=new ListNode(1);
        ListNode listNode6=new ListNode(2);
       // ListNode listNode7=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        //listNode6.next=listNode7;
        leetcode.partition(listNode1,3);
        //System.out.println(leetcode.deleteDuplicates(listNode1));
//      int[] nums = {-1,0,1,2,-1,-4};
//
//
//          System.out.println(leetcode.getPermutation(3,3));
//        ListNode l1=new ListNode(1);
//        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(4);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=null;
//
//        System.out.println( leetcode.rotateRight(l1,2));




        //List<List<Integer>> lists=leetcode.Permutation(3,3);
//        for(List<Integer> list:lists){
////            System.out.println(list);
////        }
        System.out.println(leetcode.Permutation(3,3));
    }
}

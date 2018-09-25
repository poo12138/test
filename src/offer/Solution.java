package offer;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static boolean duplicate(int[] nums,int[] duplication){
        if (nums == null || nums.length <= 0)
            return false;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[j++] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        for (int x:duplication) {
            System.out.println(x);

        }
        return false;

    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static boolean Find(int target, int[][] matrix) {
        if(matrix==null||matrix[0].length==0||matrix.length==0)
            return false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int r=0,c=cols-1;
        while(r<rows&&c>=0){
            if(target==matrix[r][c])
                return true;
            else if(target>matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
//    public  int[] twoSum(int[] nums, int target) {
//
//
//        int i=0;
//        int j=nums.length-1;
//        while(i<j){
//            if(nums[i]+nums[j]==target){
//
//             int[] a={i+1,j+1};
//                return a;
//
//            }
//            else if(nums[i]+nums[j]<target)
//                i++;
//            else
//                j--;
//        }
//
//        return null;
//    }
    public int[] twoSum(int[] nums, int target) {
        List list =new ArrayList<Integer>();
        int result[] = new int[2];
        for (int i = 0 ;i<nums.length;i ++){
            if (list.contains(target-nums[i]))
            {
                result[0]=list.indexOf(target-nums[i]);
                result[1]=i;
                break;
            }
            else
            {
                list.add(nums[i]);
            }
        }

        return result;
    }
    public int myAtoi(String str) {


        str = str.trim();
        if (str.isEmpty())
            return 0;

        int sign = 1;
        int i = 0;
        int result = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;


        while (i < str.length() && str.charAt(i) >='0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) -'0'> 7))
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + (str.charAt(i++)-'0');

        }
        return sign * result;
    }
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int N=s.length();
        for(int i=0;i<N;i++){
            int len1 = isPalindrome(s, i, i);
            int len2 = isPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len==N)
                return true;

        }
        return false;
    }
    public int isPalindrome(String s,int left,int right){
        int l=left;
        int r=right;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return  r-l-1;
    }
    public List<List<Integer>> threeSum(int[] nums) {

        int N=nums.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<N;i++){

            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int temp=nums[i];
            int target=0-temp;
            int left=i+1,right=N-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    list.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // 去掉重复的左点
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    right--;
                    left++;
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else{
                    left++;
                }

            }
            }


        return list;
    }


    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int N=nums.length;
        int sum =0;
        int dis=Integer.MAX_VALUE;
        for(int i=0;i<N-1;i++){
            int left=i+1,right=N-1;
            while(left<right){
                int temp=Math.abs(nums[i]+nums[left]+nums[right]-target);

                if(temp<dis){
                    dis=temp;
                    sum=nums[i]+nums[left]+nums[right];
                }else if(nums[i]+nums[left]+nums[right]>target){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<target){
                    left++;
                }else{
                    return nums[i]+nums[left]+nums[right];
                }

            }
        }
        return sum;
    }

//    public void letterCombinations(String digits) {
//        HashMap<Character,String> hashMap=new HashMap();
//        hashMap.put('2',"abc");
//        hashMap.put('3',"def");
//        hashMap.put('4',"ghi");
//        hashMap.put('5',"jkl");
//        hashMap.put('6',"mno");
//        hashMap.put('7',"pqrs");
//        hashMap.put('8',"tuv");
//        hashMap.put('9',"wxyz");
//        StringBuilder sb=new StringBuilder();
//        List<String> list=new ArrayList<>();
//        for (char ch:digits.toCharArray()) {
//             list.add(hashMap.get(ch));
//        }
//        System.out.println(list);
//        //list=pailie(sb);
//        //return list;
//
//    }
    public List<String> letterCombinations(String digits){
        List<String> list=new ArrayList<>();
        if(digits.isEmpty()){
            return list;
        }
        HashMap<Character,String> hashMap=new HashMap();
        hashMap.put('0'," ");
        hashMap.put('1',"");
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");



        letterCombinations(digits,0,"",hashMap,list);
        return list;

    }

    /**
     * 电话号码对应低下的字母，返回排列
     * s中保存的此时digits【0。。。index-1】翻译得到的一个字母字符串
     * 寻找和digits匹配的字母，获得digits【0。。。index】翻译得到的解
     * @param digits
     * @param index
     * @param s
     * @return
     */
    public void letterCombinations(String digits, int index,String s,Map<Character,String> hashmap,List<String> list){
        if(index==digits.length()){
            list.add(s);
            return;
        }
        char ch= digits.charAt(index);
        assert (ch>='0'&& ch<='9'&& ch!='1');
        String letters=hashmap.get(ch);
        for(int i=0;i<letters.length();i++){

            letterCombinations(digits,index+1,s + letters.charAt(i),hashmap,list);

        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int N=nums.length;
        Boolean[] arr=new Boolean[N];
        for(int i=0;i<nums.length;i++){
            arr[i]=false;
        }
        List<Integer> list_=new ArrayList<>();
        fourSum(list,nums,target,arr,0,1,list_);
        return list;
    }

    public void fourSum(List<List<Integer>> list,int[] nums, int target,Boolean[] arr,int sum,int index,List<Integer> list_){
        if(list_.size()==4 && sum==target){
            list.add(new ArrayList<>(list_));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!arr[i]){
            sum=nums[i]+sum;
            arr[i]=true;
            list_.add(nums[i]);
            fourSum(list,nums,target,arr,sum,index+1,list_);
            arr[i]=false;
            sum=0;
            list_.clear();
            }
        }
    }

    public boolean isValid(String s) {
        int N=s.length();
        if(N==0||N%2==1||s==null){
            return false;
        }
        char start=s.charAt(0);
        char end=s.charAt(N-1);
        if(start == '}' || start == ')' || start == ']')
        {
            return false;
        }
        if(end == '{' || end == '(' || end == '[')
        {
            return false;
        }

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<N;i++){
            char ch=s.charAt(i);

            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }
            else if(ch == '}' || ch == ')' || ch == ']'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char peek=stack.peek();
                    if(isMatch(peek,ch)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }

            }
        }
        if(stack.isEmpty())
        {
            return true;
        }

        return false;

    }
    public boolean isMatch(char c1, char c2)
    {
        return (c1 == '{' && c2 == '}' || c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']')? true: false;
    }






public ArrayList<String> Permutation(String str)
{
    if (str == null)
        return null;
    ArrayList<String> list = new ArrayList<String>();
    char[] pStr = str.toCharArray();

    Permutation(pStr, 0, list);
    Collections.sort(list);
    return list;
}

    static void Permutation(char[] str, int i, ArrayList<String> list)
    {
        // 如果为空
        if (str == null)
            return;
        // 如果i指向了最后一个字符
        if (i == str.length - 1)
        {
            if (list.contains(String.valueOf(str)))
                return;
            list.add(String.valueOf(str));
        } else
        {
            // i指向当前我们做排列操作的字符串的第一个字符
            for (int j = i; j < str.length; j++)
            {
                // 把做排列操作的字符串的第一个字符和后面的所有字符交换
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                // 交换后对i后面的字符串递归做排列操作
                Permutation(str, i + 1, list);
                // 每一轮结束后换回来进行下一轮排列操作
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }

    }
    public static void testArray() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));
    }


//    public int search(int[] nums, int target) {
//        int N=nums.length;
//        for(int i=0;i<N;i++){
//            if(nums[i]==target)
//                return i;
//        }
//        return -1;
//    }
    public int search(int[] nums, int target) {
        int N=nums.length;
        int left=0,right=N-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[left]==target){return left;}
            if(nums[right]==target){return right;}
            if(nums[mid]==target){return mid;}
            if(nums[left]<nums[mid]){
                if(nums[left]<target && target<nums[mid]){right--;}
                else{left++;}

            }
            if(nums[mid]<nums[right]){
                if(nums[right]>target && nums[mid]<target){left++;}
                else{right--;}
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] res={-1,-1};
        while(left<nums.length && right>=0){
            if(nums[left]==target&&nums[right]==target){
                res[0]=left;
                res[1]=right;
                return res;
            }else if(nums[left]<target){
                left++;

            }
            else if((nums[right]!=target)){
                right--;
            }
        }
    return res;

    }
    public int searchInsert(int[] nums, int target) {
        int N=nums.length;
//        for(int i=0;i<N;i++){
//            if(nums[i]==target){
//                return i;
//            }
//        }
//        return 0;
        int left=0,right=N-1;
        int mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(nums[left]==target){return left;}
            if(nums[right]==target){return right;}
            if(nums[mid]==target){return mid;}
            if(nums[mid]<target){
                left++;
            }
            if(nums[mid]>target){
                right--;
            }
        }
        if(target<=nums[0]){
            return 0;
        }
        if(target>nums[N-1]){
            return N;
        }
        else{
         return mid+1;
        }
    }
    //依次检查每行，每列，每个子九宫格是否出现重复元素，如果出现返回false，否则返回true.
    public boolean isValidSudoku(char[][] board) {
    for(int i=0;i<9;i++){
        HashSet<Character> row=new HashSet<>();
        HashSet<Character> column=new HashSet<>();
        HashSet<Character> cube=new HashSet<>();
        for(int j=0;j<9;j++){
           // 检查第i行，在横坐标位置
            if (board[i][j] != '.' && !row.add(board[i][j]))
                return false;
            // 检查第i列，在纵坐标位置
            if (board[j][i] != '.' && !column.add(board[j][i]))
                return false;
            // 行号+偏移量
            int RowIndex = 3 * (i / 3) + j / 3;
            // 列号+偏移量
            int ColIndex = 3 * (i % 3) + j % 3;
            //每个小九宫格，总共9个
            if (board[RowIndex][ColIndex] != '.'
                    && !cube.add(board[RowIndex][ColIndex]))
                return false;
        }



    }
    return true;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(list,candidates,target,res,0);
        return list;
    }
    public void combinationSum(List<List<Integer>> list,int[] candidates, int target,List<Integer> res,int index){
        if(0==target){
            list.add(new ArrayList<>(res));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){

            res.add(candidates[i]);
            combinationSum(list,candidates,target-candidates[i],res,i);
            res.remove(res.size() - 1);
        }

    }
//public List<List<Integer>> combinationSum(int[] candidates, int target) {
//    List<List<Integer>> list=new ArrayList<>();
//    List<Integer> res=new ArrayList<>();
//    Arrays.sort(candidates);
//    combinationSum(list,candidates,target,res,0);
//    return list;
//}
//    public void combinationSum(List<List<Integer>> list,int[] candidates, int target,List<Integer> res,int index){
//        if(target==0){
//            list.add(new ArrayList<>(res));
//            return;
//        }
//
//
//        for(int i=index;i<candidates.length;i++){
//            if(candidates[i]>target)
//                break;
//
//            res.add(candidates[i]);
//            combinationSum(list,candidates,target-candidates[i],res,i+1);
//            res.remove(res.size() - 1);
//            while(i < candidates.length-1 && candidates[i] == candidates[i+1]){
//                i++;
//            }
//        }
//
//    }
//    public String multiply(String num1, String num2) {
//        int x=change(num1);
//        int y=change(num2);
//
//        return ""+x*y;
//
//    }
//    public int change(String nums){
//        int N=nums.length();
//        int num=0;
//        for(int i=N-1;i>=0;i--){
//            double dou=(double)N-i-1;
//            num=num+(nums.charAt(i)-'0')*(int)Math.pow(10,dou);
//        }
//
//        return num;
//    }
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] arr=new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                arr[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>9){
                arr[i+1]+=arr[i]/10;
                arr[i]=arr[i]%10;

            }
        }
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }
        while (sb.charAt(0) == '0' && sb.length()>1)  sb.deleteCharAt(0);
        return sb.toString();


    }

    public List<List<Integer>> permute(int[] s){
        List<Integer> ref=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        Boolean[] arr=new Boolean[s.length];

        for(int i=0;i<s.length;i++){
            arr[i]=false;
        }
        permute(list,ref,s,0,arr);
        return list;
    }
    public void permute(List<List<Integer>> list,List<Integer> ref,int[] s,int index,Boolean[] booleans){
        if(index==s.length){
            if(!list.contains(ref))
            list.add(new ArrayList<>(ref));
            return;
        }
//        for(int i=0;i<s.length;i++){
//            if(!booleans[i]) {
//                ref.add(s[i]);
//                booleans[i]=true;
//                permute(list, ref, s, index + 1, booleans);
//                ref.remove(ref.size() - 1);
//                booleans[i]=false;
//            }
//        }
        for(int i=0;i<s.length;i++){
            if(!booleans[i]) {
                ref.add(s[i]);
                booleans[i]=true;
                permute(list, ref, s, index + 1, booleans);
                ref.remove(ref.size() - 1);
                booleans[i]=false;
            }
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List> map=new HashMap<>();
        for(String str:strs){
            char[] ch= str.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);

        }
        return new ArrayList(map.values());
    }



//    public double myPow(double x, int n) {
//        if(n<0){
//            x=1/x;
//        }
//        if(n==0&&x!=0){
//            return 1.0;
//        }
//        double sum=x;
//        n=Math.abs(n);
//        for(int i=0;i<n-1;i++){
//            sum=sum*x;
//        }
//        return sum;
//    }
    public double myPow(double x, int n) {
        if(n==0&&x!=0){
            return 1.0;
        }

        if(n<0){
            n=Math.abs(n);
            return power(1/x,n);
        }else{
            return power(x,n);
        }

    }
    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double v=power(x,n/2);
        if(n%2==0)
            return v*v;

        else
            return v*v*x;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return list;
        int rownumber=matrix.length;
        int columnnumber=matrix[0].length;
        int left=0,top=0;
        int down=columnnumber-1,right=rownumber-1;
        while(list.size()<rownumber*columnnumber){
            for(int i=left;i<=down;i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(list.size()<rownumber*columnnumber) {
                for (int j = top; j <=right; j++) {
                    list.add(matrix[j][down]);
                }
                down--;
            }
            if(list.size()<rownumber*columnnumber) {
            for(int i=down;i>=left;i--){
                list.add(matrix[right][i]);
            }
            right--;}
            if(list.size()<rownumber*columnnumber) {
                for (int j = right; j >= top; j--) {
                    list.add(matrix[j][left]);
                }
                left++;
            }
        }
        return list;

    }


    public boolean canJump(int[] nums) {

        List<Integer> listnum = Arrays.stream( nums ).boxed().collect(Collectors.toList());
        if(!listnum.contains(0))
            return true;

        List<Integer> list=new ArrayList<>();
        int first=nums[0];
        for(int i=0;i<=first;i++){
            list.add(i);
        }

        for(int i=1;i<nums.length;i++) {
            if(list.contains(i)) {
                int num = nums[i];

                int lang=num+i;
                if(lang==nums.length){
                    return true;
                }
                for (int j = i; j <=lang; j++) {
                    if (!list.contains(j))
                        list.add(j);
                }
            }
        }
        if(list.contains(nums.length-1))
            return true;
        else
            return false;


    }
    public boolean c1anJump(int[] nums) {

        int max=0;
        for(int i=0;i<nums.length;i++){
          max=Math.max(max,nums[i]+i);
          if(max<=i&&i!=nums.length-1)
              return false;
        }
        return true;
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> newlist=new ArrayList<>();

        int N=intervals.size();

        Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval a, Interval b) {
                                 return a.start - b.start;
                            }});;
        Interval temp=intervals.get(0);
        if(intervals.size() == 1) {
        newlist.add(temp);
         return newlist;
         }

        for(int i=1;i<N;i++){
            Interval in1=intervals.get(i);

            if(temp.end>=in1.start){
                temp.end=Math.max(in1.end,temp.end);
            }else{
                newlist.add(temp);
                temp=intervals.get(i);
            }
        }
        newlist.add(temp);
        return newlist;
    }
    public int lengthOfLastWord(String s) {
        if(s.isEmpty()){
            return 0;
        }
        String[] str=s.split(" ");

       if(str.length!=0){
        if(str.length>=1){
        return str[str.length-1].length();
        }
        else
            return str[0].length();
       }else
           return 0;
    }
    public int[][] generateMatrix1(int n) {
         int[][] matrix=new int[n][n];
        int rownumber=n;
        int columnnumber=n;
        int left=0,top=0;
        int down=columnnumber-1,right=rownumber-1;
        int count=1;
        while(count<=n*n){
            for(int i=left;i<=down;i++){
                matrix[top][i]=count;
                count++;
            }
            top++;
            if(count<=n*n) {
                for (int j = top; j <=right; j++) {
                  matrix[j][down]=count;
                    count++;
                }
                down--;
            }
            if(count<=n*n) {
                for(int i=down;i>=left;i--){
                    matrix[right][i]=count;
                    count++;
                }
                right--;}
            if(count<=n*n) {
                for (int j = right; j >= top; j--) {
                    matrix[j][left]=count;
                    count++;
                }
                left++;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        Solution s = new Solution();


        int[][] num=s.generateMatrix1(3);
        for(int[] i:num){
            System.out.println(i);
        }

//    String s1=" ";
//        System.out.println(s.lengthOfLastWord(s1));
//    String[]  s2=s1.split(" ");
//        //System.out.println(s2[s2.length-1]);
//    for(String s3:s2) {
//        System.out.println(s3);
//    }

//
//        Interval interval1=new Interval(1,3);
//        Interval interval2=new Interval(2,6);
//        Interval interval3=new Interval(8,10);
//        Interval interval4=new Interval(15,18);
//
//       List<Interval> list=new ArrayList<>();
//       list.add(interval1);
//       list.add(interval2);
//       list.add(interval3);
//        list.add(interval4);
//       s.merge(list);

//       int[] ss={1,2,3};
//        System.out.println(s.permute(ss));
//        int xa=1/2;
//
//        double x=2.0;
//        System.out.println(s.myPow(x,2));
//        int[][] m= {
//                {1, 2, 3 ,1},
//                {4, 5, 6 ,2},
//                {7, 8, 9 ,3}
//        };
//        System.out.println(s.spiralOrder(m));

//        int[] num={1,3,5,6};
//        int[] nums={5,7,7,8,8,10};
//        System.out.println(s.searchInsert(num,2));
//        for(int i:s.searchRange(nums,5)){
//            System.out.println(i);
//        }
//        int[] candidates ={2,3,6,7};
//        List<List<Integer>> list=s.combinationSum(candidates,7);
//        for(List<Integer> res:list){
//            System.out.println(res);
//        }
//        System.out.println(s.multiply("6913259244",
//                "71103343"));

////        int[] nums = {2,2,1,6,6,5,0};
////        int[] q = {0};
////        int matrix[][]= {{1, 4, 7, 11, 15},
////                {2, 5, 8, 12, 19},
////                {3, 6, 9, 16, 22},
////                {10, 13, 14, 17, 24},
////                {18, 21, 23, 26, 30}
////        };
////        if(  Find(122,matrix))
////            System.out.println("1");
////       if( duplicate(nums, q))
////           System.out.print("true");
//
//        if(s.isPalindrome(121)){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
//
//       int[] num={3,2,4};
////        List list = new ArrayList();
////        list.add(0);
////        list.add(1);
////        list.add(2);
////        Integer[] ary = (Integer[])list.toArray(new Integer[3]);
//
//       int[] b=s.twoSum(num,6);
//           for(int i:b){
//               System.out.println(i);
//
//       }
//        String str="21313";
//           int res=s.myAtoi(str);
//           System.out.println(res);
//
//           int[] nums={0,1,2};
//           System.out.println(s.threeSumClosest(nums,0));
//
//            String str1="237";
//           s.letterCombinations(str1);
//    }
//        String str = "23";
//       List<String> list=s.letterCombinations(str);
//
//
//       System.out.println(list);
//        //System.out.print(list.size());


//
//        String str= "";
//       System.out.println( s.isValid(str));
    }

}

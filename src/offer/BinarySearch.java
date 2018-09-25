package offer;


import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BinarySearch {

            public static int search(int[] nums, int target) {

                ExecutorService executorService = Executors.newCachedThreadPool();
                int l = 0, h = nums.length - 1;

                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if (target == nums[m])
                        return m;
                    else if (target > nums[m])
                        l = m + 1;
                    else
                        h = m - 1;
                }
                return -1;
            }
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }

        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }
    public static void copyFile(String src, String dist) throws IOException {

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024];

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while (in.read(buffer, 0, buffer.length) != -1) {
            out.write(buffer);
        }

        in.close();
        out.close();
    }
    public static void readFileContent(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        mergeTwoLists(l1,l2,listNode);
//        return listNode.next;
//
//    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){

            return l2;
        }
        else if(l2==null){
           return l1;
        }
        ListNode listNode=new ListNode(-1);
        if(l1.val>l2.val){
            listNode=l2;
            listNode.next=mergeTwoLists(l1,l2.next);
        }else{
            listNode=l1;
            listNode.next=mergeTwoLists(l1.next,l2);;
            }

        return listNode;
    }

    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int N=nums.length;
        int i=1;
        int count=1;
        int temp=nums[0];
        while(i<N){
            if(temp==nums[i]){
                i++;
            }else{
                temp=nums[i];
                nums[count++]=nums[i++];
            }
        }
        return count;
    }
    public int removeElement(int[] nums, int val){
        if(nums.length==0)
            return 0;
       int count=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=val) {
           nums[count]=nums[i];
           count++;
           }
       }
        return count;
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int N = haystack.length();
        int l = needle.length();
        for (int i = 0; i <= N - l; i++) {
            int j;
            for ( j = 0; j < l; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == l)
                return i ;
        }
        return -1;
    }
    public static void main(String[] args) {
//                File die=new File("/Users/wangwei/Downloads");
//                new BinarySearch().listAllFiles(die);
//                die.exists();
//            String src="/Users/wangwei/Downloads/1s.pages";
//            String dist="/Users/wangwei/Downloads/q.pages";
//       try{
//           new BinarySearch().copyFile(src,dist);
//       }
//       catch (IOException e){
//           e.printStackTrace();
//       }
//        String str1 = "中文";
//       try{
//        byte[] bytes = str1.getBytes("UTF-8");
//           System.out.println(str1);
//        String str2 = new String(bytes, "UTF-16");
//        System.out.println(str2);}
//        catch (UnsupportedEncodingException e){e.printStackTrace();}
//        BinarySearch bin=new BinarySearch();
//        String path="/Users/wangwei/Documents/test/src/offer/q.txt";
//        try{
//        bin.readFileContent(path);}
//        catch(IOException e){
//            e.printStackTrace();
//        }
        BinarySearch binarySearch=new BinarySearch();
//        int[] nums={2,2,1,3,2,4,5};
//        int n=binarySearch.removeElement(nums,2);
//        for(int i=0;i<n;i++){
//            System.out.println(nums[i]);
//        }

       String haystack = "asddwef";
       String needle = "wef";
        System.out.println(binarySearch.strStr(haystack,needle));
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        ListNode l7 = new ListNode(7);
//        l1.next = l2;
//        l2.next = l6;
//
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l7;
//        ListNode x=binarySearch.mergeTwoLists(l1,l3);
        int[] n={2,3,4,1};
        Arrays.sort(n);
        for(int i=0;i<n.length;i++){
        System.out.println(n[i]);}
    }
}

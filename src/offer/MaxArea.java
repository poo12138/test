package offer;

import java.util.HashMap;

public class MaxArea {
    public  int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int maxarea=0;
        while(l<r){
            int high=Math.min(height[l],height[r]);
            int lang=r-l;
            int area_=high*lang;
            maxarea=Math.max(maxarea,area_);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxarea;
    }
    public static int romanToInt(String s) {
        //char[] ch=s.toCharArray();
        HashMap<Character,Integer> hash=new HashMap<>();
        hash.put('I',1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        int ref=0;
        int value=0;
        int temp=0;
        int N=s.length();
        for(int i=N-1;i>=0;i--){
            char key=s.charAt(i);
            value=hash.get(key);
            if(value>=temp){
                ref+=value;
                temp=value;
            }else{
                ref-=value;
                temp=value;
            }
        }
        return ref;
    }
//    public String longestCommonPrefix(String[] strs) {
//
//    }
    public static void main(String[] args){
        int[] higth={1,8,6,2,5,4,8,3,7};
        int x=new MaxArea().maxArea(higth);
        System.out.println(x);
        String s="LVIII";
        int xs=romanToInt(s);
        System.out.println(xs);
    }
}

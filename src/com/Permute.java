package com;

import java.util.*;

public class Permute {

    public List<List<Integer>> permuteun(int nums[]){
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums==null){
            return null;
        }
        if(nums.length==0){
            list.add(new ArrayList<Integer>());
        }
        List<Integer> def=new ArrayList<Integer>();
        dfs(list,def,nums);


        return list;

    }
    public void dfs(List<List<Integer>> list,List<Integer> def,int nums[]) {
        int n = nums.length;

        if (def.size() == n) {
            list.add(new ArrayList<>(def));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (def.contains(nums[i]))
                continue;
            def.add(nums[i]);
            dfs(list, def, nums);
            def.remove(def.size() - 1);

        }
    }
    public static void main(String[] args){

        int[] nums={1,2,3};
        Permute pn=new Permute();
        List<List<Integer>> list=pn.permuteun(nums);
        for(List<Integer> i:list){
            System.out.println(i);
        }

    }
}

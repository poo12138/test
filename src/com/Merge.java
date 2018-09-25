package com;

import java.util.ArrayList;
import java.util.List;

public class Merge {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> list=new ArrayList<>();
        int n=intervals.size();
        if (intervals .size()== 0){
            list.add(newInterval);
        }
        if(newInterval==null){
            return intervals;
        }
        if(newInterval.start>intervals.get(n-1).end){
            intervals.add(newInterval);
        }
        Interval temp=null;
        for(int i=0;i<n;i++){
            Interval ref=intervals.get(i);
            if(ref.end<newInterval.start){
                list.add(ref);
            }
            if(newInterval.end<ref.start){
                list.add(newInterval);
                temp=ref;
            }

        }



        return intervals;
    }
}

package com.f;

import java.util.*;

public class GiveChange{
    public static void main(String[] argc)
    {
        int amount=6;
        int[] coins=new int[]{1,2,5};
        List<Integer> result=new ArrayList<>();
        List<List<Integer>> allresult=new ArrayList<>();

        backTrack(0,coins,0,amount,result,allresult);
        for(List<Integer> K:allresult)
            System.out.println(K);
    }
    static void backTrack(int iterator,int[] coins,int sum,int amount,List<Integer> result,List<List<Integer>> allresult)
    {
        if(sum==amount)
        {
            allresult.add(new ArrayList<>(result));
            return;//ֱ��return������ȥ��result���һλ,return֮����ȥ�����
        }
        if(sum>amount)
        {
            return;
        }
        for(int i=iterator;i<coins.length;i++)
        {
            result.add(coins[i]);
            sum+=coins[i];
            backTrack(iterator,coins,sum,amount,result,allresult);
            sum-=coins[i];
            result.remove(result.size()-1);
            iterator++;
        }
    }
}
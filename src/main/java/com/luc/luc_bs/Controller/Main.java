package com.luc.luc_bs.Controller;

import java.util.*;

/**
 * @ Author : dell on 2018/3/22.
 * Date :  Created in  20:57.   2018/3/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum =0;
        List<Integer> list_n =new ArrayList<>();
        for(int i = 0; i < n; i++){
            list_n.add(sc.nextInt());
        }
        List<Integer> list_m =new ArrayList<>();
        for(int i = 0; i < m; i++){
            list_m.add(sc.nextInt());
        }
        System.out.println(total(list_n,list_m,sum));

    }

    public static int total (List<Integer> list_n ,List<Integer> list_m, int sum  ){
        float agv_n  =avge(list_n);
        float agv_m  =avge(list_m);
        if (agv_n < agv_m )
        {

            for (int i = (int)agv_n+1;i<agv_m;i++)
            {
                if (list_m.contains(i)&&!list_n.contains(i)){
                    list_m.remove((Object)i);
                    list_n.add(i);
                    sum++;
                    sum=total(list_n,list_m,sum);
                }
            }

        } else if (agv_n>agv_m ){
            for (int i = (int)agv_m+1;i<agv_n;i++)
            {
                if (list_n.contains(i)&&!list_m.contains(i)){
                    list_n.remove(i);
                    list_m.add(i);
                    sum++;
                    total(list_n,list_m,sum);
                }
            }
        }
       return sum;
    }

    public static float avge(List<Integer> list_n ) {
            int sum=0;
            for (int i =0 ; i< list_n.size();i ++)
                sum+=list_n.get(i);
            return sum*1.0f/list_n.size();
    }
}
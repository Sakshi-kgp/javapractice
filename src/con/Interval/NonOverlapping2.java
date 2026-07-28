package con.Interval;

/*
Given a 2d array arr[][] of time intervals,
 where each interval is of the form [start, end].
 The task is to determine all intervals from the given array
  that do not overlap with any other interval in the set.
  If no such interval exists, return an empty list.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NonOverlapping2 {
    public static List<List<Integer>> helper(int [][]interval){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(interval,(a,b)->Integer.compare(a[0],b[0]));
       for(int i=1;i<interval.length;i++){

           int prevend=interval[i-1][1];
           int currstart=interval[i][0];

           if(currstart>=prevend){
               List<Integer>l=new ArrayList<>();
               l.add(prevend);
               l.add(currstart);
               list.add(new ArrayList<>(l));
           }
       }
       return list;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of interval");
        int n=sc.nextInt();
        int [][]arr=new int[n][2];
        System.out.println("enter interval");
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }

       List<List<Integer>> list = helper(arr);
        for(List<Integer> l:list){
            System.out.println(Arrays.toString(l.toArray()));
        }

    }
}

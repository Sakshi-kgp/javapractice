package con.quespractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {
    public static int [][] insert(int [][]intervals,int []newInterval){
        boolean is=false;
        int [][]interval=new int[intervals.length+1][2];
        int k=0;
        for(int i=0;i<intervals.length;i++){
            if(!is && newInterval[0]<intervals[i][0]){
                interval[k][0]=newInterval[0];
                interval[k][1]=newInterval[1];
                is=true;
                k++;
            }

                interval[k][0]=intervals[i][0];
                interval[k][1]=intervals[i][1];
                k++;


        }
        if(!is){
            interval[k][0]=newInterval[0];
            interval[k][1]=newInterval[1];
        }
        System.out.println("interval");
        for(int i=0;i<interval.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(interval[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("interval");
        List<int []> ans=new ArrayList<>();
        ans.add(new int[]{interval[0][0],interval[0][1]});
        for(int i=1;i<interval.length;i++){
            int []past=ans.get(ans.size()-1);
            int []curr=interval[i];
            if(curr[0]<=past[1]){
                past[0]=Math.min(past[0],curr[0]);
                past[1]=Math.max(past[1],curr[1]);
                ans.set(ans.size()-1,past);
            }
            else{
                ans.add(new int[]{curr[0],curr[1]});
            }

        }

        int result[][]=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            result[i][0]=ans.get(i)[0];
            result[i][1]=ans.get(i)[1];
        }
        return result;


    }
    static void main() {
        int [][]intervals={{1,3},{4,5},{6,7},{8,10}};
        int []newInterval={5,6};
int [][]res=insert(intervals,newInterval);
for(int i=0;i<res.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
}
    }
}

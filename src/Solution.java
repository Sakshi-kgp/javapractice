import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main() {
        List<Jobsequencing > j=new ArrayList<>() ;
        j.add(new Jobsequencing(1,20,4) );
        j.add(new Jobsequencing(2,60,5) );
        j.add(new Jobsequencing(3,70,6) );
        j.add(new Jobsequencing(4,65,6) );
        j.add(new Jobsequencing(5,25,4) );
        j.add(new Jobsequencing(6,80,2) );
        j.add(new Jobsequencing(7,10,2) );
        j.add(new Jobsequencing(8,22,2) );

        int maxDeadline=0;
        for(int i=0;i<j.size();i++){
            if(j.get(i).getDeadline()>maxDeadline){
                maxDeadline=j.get(i).getDeadline();
            }
        }




        int []arr=new int[maxDeadline+1];
        Arrays.fill(arr,-1);
        j.sort((o1, o2)->{
            if(o2.getProfit()>o1.getProfit())return 1;
            else if(o2.getProfit()<o1.getProfit())return -1;
            else return 0;
        });
        int totalProfit=0;
        int c=0;
       for(int i=0;i<j.size() ;i++){
           int ind=j.get(i).deadline;
           if(arr[ind]==-1){
               arr[ind]=j.get(i).id;
               totalProfit=totalProfit+j.get(i).profit;
               c++;
           }
           else{
               for(int k=ind-1;k>0;k--){
                   if(arr[k]==-1){
                       arr[k]=j.get(i).id;
                       totalProfit=totalProfit+j.get(i).profit;
                       c++;
                       break;
                   }
               }
           }
       }

System.out.println(totalProfit);
       System.out.println(c);

    }
}

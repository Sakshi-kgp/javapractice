import java.util.ArrayList;
import java.util.List;

public class Subseq {
public static void subseq(int []arr, int i, List<Integer> al, List<List<Integer>> list,int no0,int no1,int max){
    if(i==arr.length){
        if(no0==no1){
            list.add(new ArrayList<>(al));
   max=Math.max(max,no1);
            return ;
        }
        return;
    }
    al.add(arr[i]);
    if(arr[i]==0)
      subseq(arr,i+1,al,list,no0+1,no1,max);
    else
        subseq(arr,i+1,al,list,no0,no1+1,max);

    al.remove(al.size()-1);
    subseq(arr,i+1,al,list,no0,no1,max);
}







   public static void main(String[] args) {
         int []arr={1,0,0,1,0,0,0,1};
         List<Integer> al=new ArrayList<>();
         List<List<Integer>> list=new ArrayList<>();
         int max=0;
         subseq(arr,0,al,list,0,0,max);
         System.out.println(list);
         System.out.println(max);
    }
}

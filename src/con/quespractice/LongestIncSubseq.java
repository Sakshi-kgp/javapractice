package con.quespractice;

import java.util.ArrayList;
import java.util.List;

//finding length of longest increasing subsequence
public class LongestIncSubseq {
    public static void main(String[] args) {
        int []arr={1,4,5,4,2,8};
        int ans=helper(arr);
        System.out.println(ans);

    }
    public static int helper(int[] arr){
        List<Integer> list=new ArrayList<>();
        list.add(arr[0]);
        int length=0;
        for(int i=1;i<arr.length;i++){
            if(list.get(list.size()-1)<arr[i])list.add(arr[i]);
            else{
                int index=binary(arr[i],list);
                list.set(index,arr[i]);
            }
        }
        System.out.println(list);
        return  list.size();
    }
    public static int binary(int target,List<Integer> list){
        int ans=0;
        int s=0;
        int e=list.size()-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(list.get(mid)>=target){
                ans=mid;
                e=mid-1;
            }
            else {
                s=mid+1;
            }
        }
        return ans;
    }
}

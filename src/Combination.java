import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

*/
class Combination {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,new ArrayList<Integer>());
        return ans;
    }
    public static void helper(int ind,int []arr,int target,List<List<Integer>> ans,List<Integer>l){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
            l.add(arr[i]);
            helper(i+1,arr,target-arr[i],ans,l);
            l.remove(l.size()-1);
        }

    }
    public static void main(String[] args) {
        int []candidates=new int[]{1,2,3,4,5,6,7,8,9,10};
        int target=9;
        List<List<Integer>> ans=combinationSum2(candidates,target);
        System.out.println(ans);

    }

}




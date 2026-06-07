package con.quespractice;

import java.util.Scanner;

public class Sum {
     static int sum(String s,int idx,int tight,int [][][]dp,int sum){
        if(idx==s.length())return sum;
        if(dp[idx][tight][sum]!=-1){
            return dp[idx][tight][sum];
        }
        int lb=0;
        int ub=tight==1?s.charAt(idx)-'0':9;
        int ans=0;
        for(int dig=lb;dig<=ub;dig++){
            ans+=sum(s,idx+1,tight==1 && (dig==ub)?1:0,dp,sum+dig);
        }
        return dp[idx][tight][sum]=ans;


    }
    static int SumOf_digit(int a,int b){
        String as=String.valueOf(a-1);
        String bs=String.valueOf(b);
        int [][][]dp=new int[20][2][162];
        for(int i=0;i<20;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<162;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int sum1=sum(as,0,1,dp,0);
        for(int i=0;i<20;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<162;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int sum2=sum(bs,0,1,dp,0);
        return sum2-sum1;
    }
   public   static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first number");
        int a=sc.nextInt();
        System.out.println("enter second number");
        int b=sc.nextInt();

System.out.println(SumOf_digit( a, b)) ;

    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Pattern {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        ArrayList<String>ans=res(n,"");
        System.out.println(ans);
    }
    public static ArrayList<String> res(int n,String pro){
        if(pro.length()==n){
            ArrayList<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        ArrayList<String> list1 = new ArrayList<>();
        int index=pro.length();
        if(index==0){
           list1.addAll( res(n,pro+"0"));
             list1.addAll(res(n,pro+"1"));
        }
        else{
            if(pro.charAt(index-1)=='1'){
                list1.addAll( res(n,pro+"0"));

            }
            if(pro.charAt(index-1)=='0'){
                list1.addAll( res(n,pro+"0"));
                list1.addAll( res(n,pro+"1"));
            }
        }
return list1;
    }
}

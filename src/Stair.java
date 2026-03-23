public class Stair {
public static int count(int n,int c){
    if(c==n)return 1;
    if(c>n)return 0;
    int k1=count(n,c+1);
    int k2=count(n,c+2);
    return k1+k2;
}
    static void main(String[] args) {
        int n=4;
        System.out.println(count(n,0));
    }
}

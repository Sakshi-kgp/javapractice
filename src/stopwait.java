import java.util.Scanner;

public class stopwait {
   static void sender(int i){
        System.out.println(i+"package send by sender");
    }
    static void reciever(int i){
        System.out.println(i+"package received by receiver");
    }

    public static void main(String[] args) {
       int n=5;
       for(int i=1;i<=n;i++){
           sender(i);
           reciever(i);
           System.out.println("Ack recieved");
       }






    }
}

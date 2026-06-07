package con.quespractice;

import java.util.HashSet;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LengthOfLoop {
    public static void main(String []args){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next= head.next.next;
        System.out.println(lengthOfLoop(head));


    }
    public static int lengthOfLoop(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                  Node temp=slow;
                int ans=1;
              while(temp.next!=slow){
                  temp=temp.next;
                  ans++;

              }
             return ans;


                }
            }
            return 0;
        }

    }


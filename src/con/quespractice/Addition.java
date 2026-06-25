package con.quespractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}


public class Addition {
    public static ListNode createLinkedList(int[] arr){
        ListNode head=new ListNode(arr[0]);
        ListNode temp=head;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i]);
            temp=temp.next;


        }
        return head;
    }
    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            temp.next=prev;
            prev=temp;
            temp=curr;
        }
        return prev;
    }
    public static ListNode addOneToLnkedList(ListNode head) {
        if (head == null ) {
            return head;
        }
        ListNode temp = reverse(head);
        int c = 1;
        ListNode curr = temp;
        ListNode prev=null;
        while (curr != null) {
            if (c == 1) {
                int x = curr.val + c;
                if (x > 9) {
                    curr.val = x % 10;
                    x = x / 10;
                    c = x % 10;

                } else {
                    curr.val = x;
                    c = 0;
                }
                prev=curr;
                curr = curr.next;
            } else {
                prev=curr;
                curr = curr.next;
                break;

            }



        }
        curr=prev;
        if (c == 1) curr.next = new ListNode(1);
        return reverse(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of element in linkedlist");
        int n = sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        ListNode head=createLinkedList(a);
       ListNode node=addOneToLnkedList(head);
       while(node!=null){
           System.out.print(node.val+" ");
           node=node.next;
       }

    }


}
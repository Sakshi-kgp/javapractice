package con.SegmentTree;

import java.util.Scanner;


public class RangeSumqueries {
    public static void buildTree(int i,int l,int r,int []arr,int []segmentTree){
        if(l==r){
            segmentTree[i]=arr[l];
            return;
        }


        int mid=l+(r-l)/2;
        buildTree(2*i+1,l,mid,arr,segmentTree);
        buildTree(2*i+2,mid+1,r,arr,segmentTree);
        segmentTree[i]=segmentTree[2*i+1]+segmentTree[2*i+2];

    }
    public static void update(int i,int l,int r,int val,int idx,int []segmentTree){
        if(l==r){
            segmentTree[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid){
            update(2*i+1,l,mid,val,idx,segmentTree);
        }
        else {
            update(2*i+2,mid+1,r,val,idx,segmentTree);
        }
        segmentTree[i]=segmentTree[2*i+1]+segmentTree[2*i+2];

    }
    public static int query(int i,int l,int r,int[]segmentTree,int s,int e){
        if(r<s ||l>e){
            return 0;
        }
        else if(l>=s && r<=e){
            return segmentTree[i];
        }
        else{
            int mid=l+(r-l)/2;
           return  query(2*i+1,l,mid,segmentTree,s,e)+ query(2*i+2,mid+1,r,segmentTree,s,e);
        }


    }
    static void main(String []args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=in.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int[] segmentTree=new int[2*n];
        buildTree(0,0,n-1,arr,segmentTree);
        System.out.println("segment tree:");
        for(int i=0;i<segmentTree.length;i++){
            System.out.print(segmentTree[i]+" ");
        }
        System.out.println("Enter range [start,end] to find sum");
        int start=in.nextInt();
        int end=in.nextInt();
        int ans=query(0,0,n-1,segmentTree,start,end);
        System.out.println(ans);






    }
}

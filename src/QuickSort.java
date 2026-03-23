import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static int partition(int []arr,int low,int high){
        int i=low-1;
        int j=high+1;
        int pivot=arr[low];
        while(i<=j){
            do{
                i++;
            }while(i<high && arr[i]<=pivot);
            do{
                j--;
            }while(j>low && arr[j]>pivot);
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
//            if(i>j)break;
        }

        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;

    }
    public static void quickSort(int []arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi);
            quickSort(arr,pi+1,high);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n :");
        int n = sc.nextInt();
        int []arr=new int[n];
        System.out.println("Enter the values :");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,n-1);
        System.out.println("Sorted array :"+ Arrays.toString(arr));




    }
}

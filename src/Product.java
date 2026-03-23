public class Product {
public boolean isProduct(int []arr,int k){
    int p=1;

    for(int i=0;i<arr.length;i++){
        if(arr[i]==0){
            p=1;
        }
        p=p*arr[i];
        if(p==k){
            return true;
        }

    }
    return false;
}

   public static void main(String[] args) {
        int []arr={2,0,4,5};
        int n=arr.length;
        int k=20;
        System.out.println(new Product().isProduct(arr,k));
    }
}

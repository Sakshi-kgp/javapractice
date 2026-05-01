import java.util.ArrayList;
import java.util.Scanner;

public class HamiltonCycle {
    static void hamiltonianlpath(ArrayList<ArrayList<Integer>> graph,int []visited,String path,int v,int src,int osrc){
         if(v==graph.size()){
             System.out.print(path);
             boolean flag=false;
             for(int item:graph.get(src)){
                 if(item==osrc){
                     flag=true;
                     break;
                 }
             }
             if(flag){
                 System.out.println("*");
             }
             else{
                 System.out.println(".");
             }

             return;
         }

for(int item:graph.get(src)){
    if(visited[item]==0){
        visited[item]=1;
        hamiltonianlpath(graph,visited,path+item,v+1,item,osrc);
        visited[item]=0;
    }

}





    }
    static ArrayList<ArrayList<Integer>> createGraph(int v,int [][]edges){
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int []e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
return graph;
    }

   public  static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of vertex");
        int v=sc.nextInt();
        System.out.println("Enter no of edges");
        int e=sc.nextInt();

        int [][]edges=new int[e][2];
        for(int i=0;i<e;i++){
            for(int j=0;j<2;j++){
                edges[i][j]=sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> adj=createGraph(v,edges);
        int []visited=new int[v];
        visited[0]=1;
       hamiltonianlpath(adj,visited,"0",1,0,0);
       //System.out.println(adj.get(0));
    }
}


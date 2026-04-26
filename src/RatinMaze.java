import java.util.ArrayList;
import java.util.Scanner;

public class RatinMaze {
    static void main(String[] args) {
        int n=4;
        int [][]maze={{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        ArrayList<String> ans=path(n,maze);
        System.out.println(ans);



    }
    public static ArrayList<String> path(int n,int[][]maze){
        boolean [][]matrix=new boolean[n][n];
        ArrayList<String> path=new ArrayList<>();
       if(maze[0][0]==1) helper(n,matrix,path,0,0,"",maze);
       return path;

    }
    public static void helper(int n,boolean [][]matrix,ArrayList<String> path,int i,int j,String s,int[][]maze){
        if(i==n-1 && j==n-1){
            path.add(s);
            return;
        }
        if(matrix[i][j])return;
        matrix[i][j]=true;
        if(i>0) {
            if (maze[i - 1][j] == 1) {
                helper(n, matrix, path, i - 1, j, s + "u", maze);
            }
        }
            if(i<n-1){
                if(maze[i+1][j]==1){
                    helper(n,matrix,path,i+1,j,s+"D",maze);
                }
            }
        if(j>0){
            if(maze[i][j-1]==1){
            helper(n,matrix,path,i,j-1,s+"L",maze);}
        }


            if(j<n-1){
                if(maze[i][j+1]==1){
                    helper(n,matrix,path,i,j+1,s+"R",maze);
                }
            }
            matrix[i][j]=false;


    }




}

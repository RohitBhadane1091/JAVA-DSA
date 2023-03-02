public class BackTrack {
    public static void fillArray(int[]arr,int i,int element){
        if (i== arr.length){
            print(arr);
            return;
        }
        arr[i]=element;

        fillArray(arr,i+1,element+1);
        arr[i]=arr[i]-2;


    }
    public static void print(int []arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void printSubsets(String s,int i,String ns){
        if (i==s.length()){
           if(ns.length()==0){
               System.out.println("null");
           }
           else{
               System.out.println(ns);
           }
            return;
        }
        printSubsets(s,i+1,ns+s.charAt(i));
        printSubsets(s,i+1,ns);
    }
    public static void printArray(int[]arr,int i) {
        int []temp=new int[arr.length];

    }
    public static void permutation(String s,String newS){
        if (s.length()==0){
            System.out.println(newS);
            return;
        }
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            String s2=s.substring(0,i)+s.substring(i+1);
            permutation(s2,newS+c);

        }
    }
    public static void print2D(char[][]arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean solveAMaze(int [][]maze,int i ,int j,int[][]path){
        int n=maze.length;
        if (i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1){
            return false;
        }
        path[i][j]=1;
        if (i==n-1 && j==n-1){
            printPath(maze,path);
            return true;

        }
        if (solveAMaze(maze,i-1,j,path)){
            return true;
        }
        if (solveAMaze(maze,i,j+1,path)){
            return true;
        }
        if (solveAMaze(maze,i+1,j,path)){
            return true;
        }
        if (solveAMaze(maze,i,j-1,path)){
            return true;
        }
        return false;
    }
    public static boolean isRatInMaze(int [][]maze){
        int n= maze.length;
        int [][] path=new int[n][n];
        return solveAMaze(maze,0,0,path);
   }
    public static void printPath(int[][]maze,int[][]path){
        for (int i = 0; i < path.length ; i++) {
            for (int j = 0; j < path.length ; j++) {
                path[i][j]=path[i][j]&maze[i][j];
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void allPaths(int[][]maze, int i, int j, int[][]path){
        int n= maze.length;
        if (i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || path[i][j]==1){
            return;
        }
        path[i][j]=1;
        if (i==n-1 && j==n-1){
            printPath(maze,path);
            path[i][j]=0;
            return;
        }
        allPaths(maze,i-1,j,path);
        allPaths(maze,i,j+1,path);
        allPaths(maze,i+1,j,path);
        allPaths(maze,i,j-1,path);
        path[i][j]=0;

    }
    public static void ratInMaze(int [][]maze){
        int n=maze.length;
        int path[][]=new int[n][n];
        allPaths(maze,0,0,path);
    }
    public static void printBoard(int [][]arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void queenArrangement(int i,int j,int n,int[][]board){
        if (i<0 || j<0 || i>=n || j>=n)
        if (i==n){
            printBoard(board);
            board[i][j]=0;
            return;
        }

    }
    public static void placeQueens(int n,int i){

        int [][]board=new int[n][n];
        /*check whether the next queen place is safe and move to next place
         or else back track
        * */
        queenArrangement(0,0,n,board);
    }


    public static void main(String[] args) {

       /*N queen Problem*/
//        int n=2;
//        char[][]board=new char[2][2];
//
//        for (int i = 0; i <n; i++) {
//            for (int j = 0; j <n; j++) {
//                board[i][j]='_';
//            }
//        }
//        print2D(board);
//
//        nQueensOnBoard(board,0);
//      int [][] maze={{1,1,0},{1,1,0},{1,1,1}};
////        boolean pathPossible= isRatInMaze(maze);
////        System.out.println(pathPossible);
//        ratInMaze(maze);
        int n=4;
        int [][]chess=new int[4][4];

//



    }
}

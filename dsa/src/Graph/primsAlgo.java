package Graph;

public class primsAlgo {
    int V;
    int key[];
    int parent[];
    primsAlgo(int v){
        this.V=v;
        key=new int[v];
        parent=new int[v];
    }

    void createMST(int arr[],int p){
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min && arr[i]!=0){
                key[p]=arr[i];
                parent[p]=i;
                min=arr[i];
            }}
           // System.out.println(key[]+" "+parent[]);

    }
    void m2(int arr[][]){
        for (int i = 0; i < V; i++) {
            createMST(arr[i],i);
        }
    }

    void printMST(){
        boolean visited[]=new boolean[V];
        System.out.println("edge\tweight");
        for (int i = 0; visited[i]==false&& i < V ; i++) {
            System.out.println((i ) + "-" + parent[i] + "\t" + key[i]);
            visited[i]=true;
        }
    }

    public static void main(String[] args) {
        primsAlgo obj=new primsAlgo(5);
        int graph[][] = new int[][]
//                {{0, 0, 3, 0, 0},
//                {0, 0, 10, 4, 0},
//                {3, 10, 0, 2, 6},
//                {0, 4, 2, 0, 1},
//                {0, 0, 6, 1, 0},
//        };
                { { 0, 2, 0, 6, 0 },
                  { 2, 0, 3, 8, 5 },
                  { 0, 3, 0, 0, 7 },
                  { 6, 8, 0, 0, 9 },
                  { 0, 5, 7, 9, 0 } };

        obj.m2(graph);
        obj.printMST();
    }



}

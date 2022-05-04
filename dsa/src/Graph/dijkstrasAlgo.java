package Graph;

public class dijkstrasAlgo {
    int V;
    int dist[];
    boolean visited[];
    dijkstrasAlgo(int v){
        this.V = v;
        this.dist=new int[v];
        this.visited=new boolean[v];
        for (int i = 0; i < v; i++) {
        dist[i]=Integer.MAX_VALUE;
        visited[i]=false;
        }
    }
    int chooseMin(int dist[],boolean visited[]){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for (int i = 0; i < V; i++) {
            if(dist[i]<=min&&visited[i]!=true){
                min=dist[i];
                min_index=i;
            }
        }
        System.out.println(min);
        return min_index;
    }

    void algo(int graph[][],int src)
    {
        dist[src]=0;
        for (int j = 0; j < V-1; j++) {
            int u = chooseMin(dist, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist);
    }
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
}

    public static void main(String[] args) {
        dijkstrasAlgo obj=new dijkstrasAlgo(9);
        int graph[][] = new int[][]
                { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        obj.algo(graph,0);
    }}

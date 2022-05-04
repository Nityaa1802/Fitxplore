package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    int vertices;
    LinkedList<Integer> l[];
    boolean visited[];
    DFS(int vertices)
    {
         this.vertices=vertices;
         l=new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
        {

            l[i]=new LinkedList<Integer>();
        }
        visited=new boolean[vertices];
    }

    void insertEdge(int u,int v){
        l[u].add(v);
    }

    void dfs(int vertice){
        visited[vertice]=true;
        System.out.println(vertice);
        Iterator<Integer> it=l[vertice].listIterator();
       while (it.hasNext()){
           int n=it.next();
           if(!visited[n]){
               visited[n]=true;
             dfs(n);
           }
       }
    }

    public static void main(String[] args) {
        DFS graph=new DFS(8);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);
        graph.dfs(0);
    }
}

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
     static void bfs(ArrayList<ArrayList<Integer>> arr,int s)
     {
      boolean visited[]=new boolean[arr.size()];         //a boolean visited array to find which vertices we have visited
      LinkedList<Integer> ll=new LinkedList<Integer>(); //a linked list for queue implementation
      visited[s]=true;                                   //
      ll.add(s);
      while (!ll.isEmpty()){
          for (int i = 0; i <arr.get(ll.getFirst()).size(); i++) {
              if(!visited[arr.get(ll.getFirst()).get(i)])
              {
                  ll.addLast(arr.get(ll.getFirst()).get(i));
            visited[arr.get(ll.getFirst()).get(i)]=true;
          }
          }
          System.out.println(ll.remove());
      }

  }

    public static void main(String[] args) {

        representation obj=new representation();

        ArrayList<ArrayList<Integer>> arr
                = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i <5; i++) {
            arr.add(new ArrayList<Integer>());
        }
        obj.addEdge(arr,1,2);
        obj.addEdge(arr,2,3);
        obj.addEdge(arr,1,4);
        obj.addEdge(arr,2,4);
        obj.addEdge(arr,4,0);
        obj.addEdge(arr,3,0);

        bfs(arr,0);

    }

}

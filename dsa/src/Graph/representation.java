package Graph;

import java.util.ArrayList;

public class representation {


    void addEdge( ArrayList<ArrayList<Integer>> arr, int u, int v){
       arr.get(u).add(v);
       arr.get(v).add(u);

    }

    void printEdge(ArrayList<ArrayList<Integer>> arr){
         for(int i=0;i<arr.size();i++)
         {
             System.out.print(i);
             for (int j = 0; j <arr.get(i).size(); j++) {
                 System.out.print("->"+arr.get(i).get(j));
             }
             System.out.println();
         }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr
                = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i <5; i++) {
            arr.add(new ArrayList<Integer>());
        }
        representation obj=new representation();
        obj.addEdge(arr,1,2);
        obj.addEdge(arr,2,3);
        obj.addEdge(arr,1,4);
        obj.addEdge(arr,2,4);
        obj.addEdge(arr,4,0);
        obj.addEdge(arr,3,0);
        obj.printEdge(arr);
    }
}

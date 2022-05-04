package Sort;

import java.util.Queue;

public class QuickSort {

    int swap(int arr[],int beg,int end ){
        int pivot=arr[end];
        int i=beg-1;
        for (int j = beg; j <=end-1; j++) {
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }
     void sorting(int arr[],int beg,int end){
      if(beg<end){
          int pi=swap(arr,beg,end);
          swap(arr,beg,pi-1);
          swap(arr,pi+1,end);
      }
    }


    void printArray(int arr[]){
        //  System.out.println("sorted array is");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QuickSort obj=new QuickSort();
        int arr[]={8,5,4,2,1,6,3,7};
        int n=arr.length;
        obj.printArray(arr);
        obj.sorting(arr,0,n-1);
        obj.printArray(arr);
    }
}

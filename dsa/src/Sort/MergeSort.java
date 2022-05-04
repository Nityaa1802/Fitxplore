package Sort;

public class MergeSort {
    void divide( int arr[],int end,int beg){
        int mid=(beg+end)/2;
        divide(arr,beg,mid);
        divide(arr,mid+1,end);
        conquer(arr,beg,end,mid);
    }
    void conquer(int arr[],int beg,int end,int mid){

    }
}

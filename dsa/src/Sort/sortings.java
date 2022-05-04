package Sort;

public class sortings {
    int arr[]={8,5,4,2,6,3,7,1};
    int len;
    sortings(int length ){
        this.len=length;
    }

    void bubbleSort(int arr[],int length){
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }


    void insertionSort(int arr[],int len){
        for (int i = 1; i < len; i++)
        {   //int i=2;
            int j=i-1;
            int temp=arr[i];
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }

    void printArray(int arr[]){
      //  System.out.println("sorted array is");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    void selectionSort(int arr[],int len){
        for (int i = 0; i < len; i++) {
            int min=arr[i];
            int min_index=i;
            for (int j = i+1; j < len; j++) {
                if(arr[j]<min)
                {  min=arr[j];
                min_index=j;}
            }
            arr[min_index]=arr[i];
            arr[i]=min;
        }
    }

    public static void main(String[] args) {
        sortings obj=new sortings(8);
        obj.printArray(obj.arr);
        obj.selectionSort(obj.arr, obj.len);
        obj.printArray(obj.arr);
    }
}

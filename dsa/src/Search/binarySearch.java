package Search;

public class binarySearch {


    static int search(int value,int arr[],int p){
        if(arr[p]==value)
            return p;
        else if(value<arr[p])
            return search(value,arr,p/2);
        else
            return search(value,arr,(p*3/2));
    }
    public static void main(String[] args) {
         int arr[]={1,12,22,36,45,54,68,76,85,94};
        int location=search(85,arr,arr.length/2);
        if(location==-1)
            System.out.println("value not found");
        else
            System.out.println("value found at " + location + " location");

    }
}

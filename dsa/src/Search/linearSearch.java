package Search;

public class linearSearch {
   static int arr[]={75,96,101,44,84,21,1,0,4,6};


    static int search(int value){
        int pos=-1;
        for (int i = 0; i < arr.length; i++) {
            if (value==arr[i])
                pos=i+1;
        }
      return pos;
    }

    public static void main(String[] args) {
        int location=search(84);
        if(location==-1)
        System.out.println("value not found");
        else
            System.out.println("value found at " + location + " location");

    }
}

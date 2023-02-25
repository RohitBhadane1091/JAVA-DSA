public class Sorting {
    public static void bubbleSort(int []arr){
        int n=arr.length;
        for (int i = 0; i <n-1; i++) {
            for (int j = 1; j <n-i; j++) {
                if (arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("Bubble sort using for loop");

    }
    public static void selectionSort(int []arr){
        int n=arr.length;
        for (int i = 0; i < n-2; i++) {
            int min=i;
            for (int j = i+1; j <n-1 ; j++) {
                if (arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        System.out.println("Selection sort using for loop");
    }
    public static void printArray(int []arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void merge(int[]arr,int s,int mid,int e){
        int []temp=new int[e-s+1];
        int i=s;//iterator for left
        int j=mid+1;//iterator for right
        int k=0;//iterator for temp
        while (i<=mid && j<=e){
            if (arr[i]<arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }
        while (i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while (j<=e){
            temp[k++]=arr[j++];
        }
        for (k=0, i=s;k<temp.length; i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void mergeSort(int[]arr,int s,int e){
        /* we have applied divide and conquer below
        *  1.divide the array unto the smallest index
        *  2.sort the smallest individuals
        *  3.merge the array */
        if (s>=e){
            return;
        }

        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);

    }
    public static int partition(int []arr,int s,int e){
        int pivot=arr[e];
        int i=s-1;//pointing in array at index -1
        for (int j =s; j <e; j++) {
            if (arr[j]<pivot){
                i++;//points to 0
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[e]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void quickSort(int[]arr,int s,int e){
        if (s>=e){
            return;
        }
        int pi=partition(arr,s,e);
        quickSort(arr,s,pi-1);
        quickSort(arr,pi+1,e);

    }
    public static void main(String[] args) {
      

    }
}

public class J20_Recurssion {
    public static int fact(int n){
        if (n-1==0){
            return 1 ;
        }
        int ans=n*fact(n-1);
        return ans;

    }
    public static void nth(int n){
        if (n == 0) {
            System.out.println(0);
            return;
        }
        System.out.print(n+" ");
        nth(n-1);

    }
    public static void nth2(int n){
        if (n == 0) {

            return;
        }

        nth2(n-1);
        System.out.print(n+" ");

    }
    public static int sum(int n){
        if (n==0){
            return 0 ;
        }
        int ans=n+sum(n-1);
        return ans;

    }
    public static int NthFibonacci(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int ans=NthFibonacci(n-1)+NthFibonacci(n-2);
        return ans;
    }
    public static boolean isSorted(int arr[],int i){
        if (i==arr.length-1){
            return true;
        }

        if(arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr,i+1);


    }
    public static int firstOcc(int arr[],int key,int i){
        if (i==arr.length-1){
            System.out.println("Key is Not found");
            return -1;
        }
        if(key==arr[i]){
            System.out.print("Key is found at index ");
            return i;
        }
        return firstOcc(arr,key,i+1);


    }
    public static int lastOcc(int arr[],int key,int i){
        if (i==0){
            System.out.println("Key is Not found");
            return -1;
        }
        if(key==arr[i]){
            System.out.print("Key is found at index ");
            return i;
        }
        return lastOcc(arr,key,i-1);


    }
    public static int power(int n,int count,int pow){
        if(count == pow){
            return 1;
        }
        count++;
        int ans=n*power(n,count,pow);
        return ans;
    }
    public static int power2(int n,int pow){
        if (pow==0){
            return 1;
        }
        return n* power2(n,pow-1);
    }
    public static int power3(int n,int pow){
        if (pow==0){
            return 1;
        }
        else if(pow%2==0){
            pow=pow/2;
            int ans=power3(n,pow);
            return (int) Math.pow(ans,2);
        }
        else{
            pow=pow/2;
            int ans=power3(n,pow);
            return n*(int) Math.pow(ans,2);
        }
    }
    public static int tile(int n){// all possible ways to fill the board with 2*n
        if (n==0 || n==1){
            return 1;
        }

        return tile(n-1)+tile(n-2);
    }
    public static void removeDuplicate(String str,int i,StringBuilder newStr,boolean []map){
        if (i==str.length()){
            System.out.println(newStr);
            return;
        }
        char current=str.charAt(i);
        if (map[current - 'a']){
            removeDuplicate(str,i+1,newStr,map);
        }
        else{
            map[current-'a']=true;
            newStr.append(current);
            removeDuplicate(str,i+1,newStr,map);
        }
    }
    public static int pairing(int n){//n= number of friends which are single or paired
        if (n==1||n==2){
            return n;
        }

        return pairing(n-1)+(n-1)*pairing(n-2);
    }
    public static void binary (String s,int i){
        if (i+1==s.length()){
            System.out.println(s);
            return;
        }
        if (s.charAt(i)=='1' && s.charAt(i+1)=='1'){
            System.out.println("Cannot be displayed because it has ");
        }
        else{
            binary(s,i+1);
        }

    }
    public static void allBinary(int n,int lastIndex,StringBuilder s){
        /* size--> size of the string in which you want display all the strings
           s--> string in which we have to store the temporary string
           lastIndex--> it is prior position where we have to check whether is 1 or 0
        */
        if (n==0){
            System.out.println(s);
            return;
        }
        if(lastIndex==0){
            allBinary(n-1,0,s.append("0"));
            allBinary(n-1,1,s.append("1"));
        }
        else {
            allBinary(n-1,0,s.append("0"));
        }
    }
    public static void sayDigit(String n,int i){
        if (i==n.length()){
            return;
        }
        char ans =n.charAt(i);
        switch (ans){
            case '0':
                System.out.print("zero ");
                break;
            case '1':
                System.out.print("one ");
                break;
            case '2':
                System.out.print("two ");
                break;
            case '3':
                System.out.print("three ");
                break;
            case '4':
                System.out.print("four");
                break;
            case '5':
                System.out.print("five  ");
                break;
            case '6':
                System.out.println("six ");
                break;
            case '7':
                System.out.print("seven ");
                break;
            case '8':
                System.out.print("Eight ");
                break;
            case '9':
                System.out.print("nine");
                break;
            default:
                System.out.print("It is not the Number");
                break;
        }
        sayDigit(n,i+1);
        System.out.println();
    }
    public static void binarySearch(int []arr,int key,int first ,int last,int count){

        if (first>last){
            System.out.println("key is not found");
            count++;
            System.out.println(count);
            return;
        }
        int mid=(first+last)/2;
        if (arr[mid]==key){
            System.out.println("Key is found at "+mid+" index");
            count++;
            System.out.println(count);
            return;
        }
        else if(arr[mid]<key){
            first=mid+1;
            count++;
            binarySearch(arr,key,first,last,count);


        }
        else {
            last=mid-1;
            count++;
            binarySearch(arr,key,first,last,count);
        }
    }

    
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        binarySearch(arr,16,0,arr.length-1,0);

    }
}

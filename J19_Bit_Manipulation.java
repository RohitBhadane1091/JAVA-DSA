public class J19_Bit_Manipulation {
    public static void odd_even(int n){
        if ((n&1)==0){
            System.out.println("It is Even Number");
        }
        else{
            System.out.println("It is Odd Number");
        }
    }
    public static void getIthBit(int n,int bit){
        int ans=(1<<bit);// let ith bit be 3
        // then 100
        if ((n&ans)==1){
            //let number be 1111
            // 1111 &0100 return
            System.out.println(bit+" Bit of "+n+" is 1");
        }
        else {
            System.out.println(bit+" Bit of "+n+" is 1");
        }
    }
    public static void setIthBit(int n,int bit){
        int ans=1<<bit;
        System.out.println(n|bit);

    }
    public static void clearIthBit(int n,int bit){
        int ans=~(1<<bit);
        System.out.println(n&ans);
    }
    public static void updateBit(int n,int bit,int newBit){

    }
    public static void main(String[] args) {


    }
}

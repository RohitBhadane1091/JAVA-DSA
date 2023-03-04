public class LL2 {
    public static class Node1{
        int data;
        Node1 next;//--> this is a reference variable which points the next object
        // or simply an object

        // inserting data value while creating a node
        // for that first we have to insert a function, constructor of the Node
        public Node1(int data){
            this.data= data;
            this.next=null;
        }
    }
    public static Node1 head;
    public static Node1 tail;
    public static int size=0;
    public void addFirst(int data){
        /*There are  basically three properties
        * 1. to create a node
        * 2. to check whether head is pointing someone or nothing
        *   a.then store n node in head and tail
        * 3. if head is pointing
        *   a. store head in n.next   --> basically it is storing the address of node to which new node is getting connected
        *   b. now change the head
        *
        *
        *   NOTE--> create new node,store address in new node ,change head and now head is new node*/
        Node1 n=new Node1(data);
        size++;
        if (head==null){
            head=tail=n;
            return;
        }
        n.next=head;
        head=n;
    }
    public void addLast(int data){
        Node1 n=new Node1(data);
        size++;
        if (head==null){
            head=tail=n;
            return;
        }
        tail.next= n;
        tail=n;
    }
    public void addMid(int data,int i){
        if (i==0){
            addFirst(data);
        }

        Node1 temp=head;
        int x=0;
        Node1 n=new Node1(data);
        size++;

        if (head==null){
            head=tail=n;
            return;
        }

        while (x<i-1){
            temp=temp.next;
            x++;
        }
        n.next=temp.next;
        temp.next=n;
    }
    public void removeFirst(){
        Node1 temp=head;
        head=temp.next;
        size--;
    }
    public void removeLast(){

        Node1 pre=head;
        for (int i = 0; i <size-2 ; i++) {
            pre=pre.next;
        }
        pre.next=null;
        tail=pre;
        size--;
    }
    public void findKey(int key){
        int i=0;
        Node1 temp=head;
        while (i<size){
            if (key==temp.data){
                System.out.println("Key is found at index "+i);
                return;
            }
            temp=temp.next;
            i++;
        }
        System.out.println("Key not found");
    }
    public void findKeyRecursive(int key,int i,Node1 temp){
        if (i>=size|| temp==null){
            System.out.println("Key not found");
            return;
        }
        if (key==temp.data){
            System.out.println("Key found at index "+i);
            return;
        }
        findKeyRecursive(key,i+1,temp.next);
    }
    public void reverseLL(){
        Node1 current=head;
        Node1 previous=null;
        Node1 after;
        tail=head;
        while (current!=null){
            after=current.next;
            current.next=previous;
            previous=current;
            current=after;
        }
        head=previous;
    }
    /*TO find middle node there is very famous technique to find it
    * i.e is called as slow-fast
    * we have to create two nodes 1 is fast and other is slow
    * assign both to head
    * then jump both of them
    * slow by 1 position
    * fast by two position
    * in odd case fast.next points to null then stop
    * in even case fast itself is now null then stop*/
    public Node1 findMid(Node1 head){
        Node1 fast=head;
        Node1 slow=head;
        while(fast.next!=null && fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean isPalindrome(Node1 head){
        if (head==null || head.next==null){
            return true;
        }
        Node1 midNode=findMid(head);
        Node1 current =midNode;
        Node1 previous =null;
        Node1 after;
        while (current!=null){
            after=current.next;
            previous.next=current;
            current.next=previous;
            previous=current;
            current=after;
        }
        // after reversing half  linked list
        Node1 rightHead=previous;
        Node1 temp1=head;
        Node1 temp2=rightHead;
        while (temp1!=midNode || temp2!=null){
            if (temp1.data!=temp2.data){
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;

    }
    public void removeNthFroEnd(int n){
        int size1=0;
        Node1 temp1=head;
        while (temp1!=null){
            temp1=temp1.next;
            size1++;
        }
        int i=1;
        Node1 temp2=head;
        int x=size1-n;
        while (i<x){
            temp2=temp2.next;
            i++;
        }
        temp2.next=temp2.next.next;
        return;
    }
    public void printLL(Node1 head){
        Node1 temp=head;
        if (temp==null){
            System.out.println("LL is Empty");
            return;
        }
       while(temp!=null){
           System.out.print(temp.data+" ");
           temp=temp.next;
       }
        System.out.println();

    }


    public static void main(String[] args) {
        LL2 l=new LL2();
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(3);
        l.addFirst(4);
        l.printLL(head);
        System.out.println(l.isPalindrome(head));




    }
}

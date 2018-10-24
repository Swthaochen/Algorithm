public class lianbiao {
    public static int PI = 3;
    public static void main(String args[])
    {
        Node head,p;
        head = new Node();
        p = head;
        for(int i = 0;i < 5;i++)
        {
            Node n = new Node(i);
            p.setNext(n);
            p = p.getNext();
        }
        p = head.getNext();
        while(p != null)
        {
            System.out.println(p.getData());
            p = p.getNext();
        }
    }
}

class Node{
    private int data;
    private Node next;
    public Node()
    {
        this.next = null;
    }
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public void setNext(Node p)
    {
        this.next = p;
    }
    public Node getNext()
    {
        return this.next;
    }
    public int getData()
    {
        return this.data;
    }
}
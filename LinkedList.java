public class LinkedList 
{
	public static void main(String[] args) 
	{
	    LinkedList ll = new LinkedList();
	    ll.addFront(7);
	    ll.addFront(2);
	    ll.addEnd(34);
	    ll.addFront(90);
	    ll.addEnd(24);
	    ll.display();
	}
	
	private Node head;
    private int count;

    public LinkedList()
    {
        this.head = null;
        this.count = 0;
    }

    public void addFront(int value)
    {
        Node n = new Node(value);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            n.setNextNode(head);
            head = n;
        }
        count++;
    }
    
    public void addEnd(int value) 
    {
    	Node current = this.head;
    	Node node = new Node(value);
    	while(current.getNextNode() != null) 
    	{
    		current = current.getNextNode();
    	}
    	current.setNextNode(node);
        count++;
    }

    public void display()
    {
        String answer = "Contents: ";
        Node currNode = head;
        for(int i = 0; i < this.count; i++)
        {
            answer = answer + currNode.getPayload() + " -> ";
            currNode = currNode.getNextNode();
        }
        System.out.println(answer);
    }
}//class
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
	    ll.addFront(27);
	    ll.display();
	    ll.removeAtIndex(3);
	    ll.removeEnd();
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
        this.count++;
    }
    
    public int removeFront()
    {
        Node currNode = this.head;
        this.head = this.head.getNextNode();
        currNode.setNextNode(null);
        this.count--;
        return currNode.getPayload();
    }

    public int removeAtIndex(int location) 
    {
    	Node current = this.head;
    	Node newPointer = current.getNextNode();
    	
    	if(location == 0) 
    	{
    		return this.removeFront();
    	}
    	else 
    	{
    		if(location == this.count - 2) 
    		{
    			return this.removeEnd();
    		}
    	}
    	
    	for(int i = 0; i < location - 1; i++) 
    	{
    		current = current.getNextNode();
    	}
    	newPointer = current.getNextNode();
    	current.setNextNode(newPointer.getNextNode());
    	newPointer.setNextNode(null);
    	this.count--;
    	return newPointer.getPayload();
    }
    
    public int removeEnd() 
    {
    	Node current = this.head;
    	Node newPointer = current.getNextNode();
    	
    	if(this.count == 1) 
    	{
    		return removeFront();
    	}
    	else 
    	{
    		for(int i = 0; i < this.count - 2; i++) 
        	{
        		current = current.getNextNode();
        	}
        	current.setNextNode(null);
        	this.count--;
        	return newPointer.getPayload();
    	}
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
package myPackage1;

public class LinkedListCreation {
	
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data=data;
			this.next=next;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	
	public void addValue(int data)
	{
		Node newnode=new Node(data);
		if(head==null)
		{
			head=newnode;
			tail=newnode;
		}
		else
		{
			tail.next=newnode;
			tail=newnode;
		}	
	}
	
	public void display()
	{
		Node current=head;
		
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Values of list are: ");
		while(current!=null)
		{
			System.out.println(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		LinkedListCreation list=new LinkedListCreation();
		
		list.addValue(56);
		list.addValue(30);
		list.addValue(70);
		list.display();
	}

}

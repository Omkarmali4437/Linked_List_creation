package myPackage1;

public class LinkedListCreation<T> {
	
	class Node<T> 
	{
		T data;
		Node next;
		
		public Node(T data)
		{
			this.data=data;
			this.next=next;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	
	public void addValue(T data)
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
	
	public void insertatFirst(T data)
	{
		Node newnode1=new Node(data);
		if(head==null)
		{
			head=newnode1;
			tail=newnode1;
		}
		else
		{
			Node node1=head;
			head=newnode1;
			head.next=node1;
		}
	}
	
	public void insertatLast(T data)
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
	
	public <T> Node insertatMid(T data, int position)
	{
		Node newnode2=new Node(data);
		newnode2.data=data;
		Node current=head;
		Node oldNode=null;
		int count=0;
		
		while(count<position)
		{
			oldNode=current;
			current=current.next;
			count++;
		}
		newnode2.next=current;
		while(oldNode != null)
		{
			oldNode.next=newnode2;
			return head;		
		}
		return newnode2;
	}
	
	public void popFirst()
	{
		if(head == null)
		{
			System.out.println("List empty");
			return;
		}
		else
		{
			if(head != tail)
			{
				head=head.next;
			}
			else
			{
				head=tail=null;
			}
		}
	}
	
	public void popLast()
	{
		if (head == null)
		{
			System.out.println("List is Empty");
			return;
		}
		else 
		{
			if (head != tail) 
			{
				Node<T> current = head;
				while(current.next != tail)
				{
					current = current.next;
				}
				tail = current;
				tail.next = null;
			}
			else
			{
				head = tail = null;
			}
		}
	}
	
	public void searchNode(T data)
	{
		Node ptr=head;
		int i=0;
		boolean flag=false;
		if(ptr == null)
		{
			System.out.println("List empty");
			return;
		}
		else
		{
			while(ptr != null)
			{
				if(ptr.data==data)
				{
					flag=true;
					break;
				}
				else
				{
					flag=false;
				}
				i++;
				ptr=ptr.next;
			}
			if(flag)
			{
				System.out.println(data+" node found at: "+i+"\n");
			}
			else
			{
				System.out.println(data+" node not present in list");
			}
		}
	}
	
	public void insertAfterNode(Node previous,T data)
	{
		if(previous == null)
		{
			System.out.println("Previous node cannot be empty");
			return;
		}
		
		Node newnode3=new Node(data);
		newnode3.next=previous.next;
		previous.next=newnode3;	
	}
	
	public void  deleteafteraGivennode(T key)
	{
		Node temp=head;
		Node previous=null;
		
		if(temp != head && temp.data==key)
		{
			head=temp.next;
			return;
		}
		while(temp != null && temp.data != key)
		{
			previous=temp;
			temp=temp.next;
		}
		if(temp == null)
		{
			return;
		}
		previous.next=temp.next;
			
	}
		
	public void display()
	{
		Node current=head;
		int size=0;
		
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		else 
		{
			System.out.println("Values of list are: ");
			while(current!=null)
			{
				System.out.println(current.data+" ");
				size++;
				current=current.next;
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) 
	{
		LinkedListCreation list=new LinkedListCreation();
		
		list.addValue(56);
		list.addValue(70);
		list.insertatMid(30,1);
		list.display();
		System.out.println("After insterting element after 30:");
		list.insertAfterNode(list.head.next,40);
		list.display();
		System.out.println("After deleting element 40:");
		list.deleteafteraGivennode(40);
		list.display();
	}

}

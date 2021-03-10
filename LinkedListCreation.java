package myPackage1;

import java.util.Scanner;

public class LinkedListCreation<T extends Comparable<T>> {
	
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
	
	public <T> void sortList()
	{
		Node current=head;
		Node index=null;
		T temp;
		
		if(head == null)
		{
			return;
		}
		else
		{
			while(current != null)
			{
				index=current.next;
				while(index != null)
				{
					if(((Comparable<T>) current.data).compareTo((T) index.data)>0)
					{
						temp=(T) current.data;
						current.data=index.data;
						index.data=temp;
					}
					index=index.next;
				}
				current=current.next;
			}
		}
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
			System.out.println("List size is: "+size);
		}
	}
	
	public void choice()
	{
		LinkedListCreation list=new LinkedListCreation();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.Simple list, 2.Insert at first, 3.Insert at last,\n 4.Insert at  middle"
				+ ", 5.Delete first, 6.Delete last, 7.Search,\n 8.Insert after given value"
				+ ", 9.Delete given value, 10.Sorting");
		int choose=sc.nextInt();
		switch(choose)
		{
			case 1:
				list.addValue(56);
				list.addValue(30);
				list.addValue(70);
				list.display();
				break;
				
			case 2:
				list.insertatFirst(70);
				list.insertatFirst(30);
				list.insertatFirst(56);
				list.display();
				break;
			case 3:
				list.insertatLast(56);
				list.insertatLast(30);
				list.insertatLast(70);
				list.display();
				break;
			case 4:
				list.addValue(56);
				list.addValue(70);
				list.insertatMid(30,1);
				list.display();
				break;
			case 5:
				list.addValue(56);
				list.addValue(70);
				list.insertatMid(30,1);
				list.display();
				System.out.println("After deleting first element");
				list.popFirst();
				list.display();
				break;
			case 6:
				list.addValue(56);
				list.addValue(70);
				list.insertatMid(30,1);
				list.display();
				System.out.println("After deleting last element");
				list.popLast();
				list.display();
				break;
			case 7:
				list.addValue(56);
				list.addValue(30);
				list.addValue(70);
				list.searchNode(30);
				break;
			case 8:
				list.addValue(56);
				list.addValue(70);
				list.insertatMid(30,1);
				list.display();
				System.out.println("After insterting element after 30:");
				list.insertAfterNode(list.head.next,40);
				list.display();
				break;
			case 9:
				list.addValue(56);
				list.addValue(30);
				list.addValue(70);
				list.addValue(40);
				list.display();
				list.deleteafteraGivennode(40);
				list.display();
			case 10:
				list.addValue(56);
				list.addValue(30);
				list.addValue(40);
				list.addValue(70);
				list.display();
				
				System.out.println();
				list.sortList();
				list.display();
				break;
		}

	}
	
	public static void main(String[] args) 
	{
		LinkedListCreation obj=new LinkedListCreation();
		obj.choice();
	}

}

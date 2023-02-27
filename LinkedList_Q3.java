//Q3-> Palindrome List detection

public class LinkedList_Q3 {
	
	node head;
	private int size;
LinkedList_Q3(){
	size= 0;
}
  class node{
	  int data;
	  node next;
	
	  node(int data){
		  this.data=data;
		  this.next=null;
		  size++;
	  }
  }
	
  public node getMiddle(node head) {
	  // use turtle rabbit approach 
	  //  turtle moves 1 step while rabbit 2 steps when rabbit jumps to null at that time turtle is on middle 
	  node turtle= head;
	  node rabbit = head;
	  
	  while(rabbit.next != null && rabbit.next.next != null) {
		  rabbit = rabbit.next.next;
		  turtle = turtle.next;
	  }
	  
	  return turtle;
  }
  
  public node reverse(node head) {
	  
	  node prev = null;
	  node curr = head;
	  
	  while(curr!=null) {
		  node temp = curr.next;
		  curr.next = prev;
		  prev =curr;
		  curr = temp;
	  }
	  
	  return prev;
  }
  
  public boolean isPalindrome(node head) {
	  if(head==null||head.next==null) {
		  return true;
	  }
	  
	  node firstHalfEnd = getMiddle(head);
	  node secondHalfStart= reverse(firstHalfEnd.next);
	  node firstHalfStart = head;
	  
	  while(secondHalfStart!=null) {
		  if(secondHalfStart.data != firstHalfStart.data)
			  return false;
		  
		  secondHalfStart = secondHalfStart.next;
		  firstHalfStart = firstHalfStart.next;
	  }
	  
	  return true;
  }
  
//add data
 public void add(int data) {
	  node newNode = new node(data);
	  
	  if(head==null) {
		  head = newNode;
		  return;
	  }
	  
	  node lastNode= head;
	  while(lastNode.next != null) {
		  lastNode = lastNode.next;
	  }
	    lastNode.next = newNode;
 }
 
 // print list method
 
 public void printList() {
     node currNode = head;
     while(currNode != null) {
  	   System.out.print(currNode.data+"->");
  	   currNode = currNode.next;
     }
       System.out.println("NULL");
}	  
  
      public static void main(String[]args) {
    	LinkedList_Q3 list = new LinkedList_Q3(); 
    	  list.add(2);
    	  list.add(3);
    	  list.add(3);
    	  list.add(3);
    	  list.add(2);
    	  
    	   if(list.isPalindrome(list.head))
    		   System.out.println("Palindromic list");
    	   
    	   else 
    		   System.out.println("Not Palindromic");
      }
}

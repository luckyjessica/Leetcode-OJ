package easy;
class Node{
	public int val;
	// premin uses to store the current min value
	// when this node serves as the head of the stack
	
	public int premin;
	public Node next;
	//constructor
	public Node(int x){
		this.val = x;
	}
}
class MinStack {	
	Node head;
	int size;
	
	public void push(int x) {
		Node n = new Node(x);
		//if the stack is empty
		//new node become head
		//value of new node become the min
		if(size==0){
			n.next = null;
			n.premin = x;
			head = n;
		}
		//when the value of new node is smaller than the current min
		//it means when the new node is the head of stack, the min is its value;
		//else when the new node is the head of stack, the min is same as the min before it is added
		else{
			if(x < head.premin) n.premin = x;
			else n.premin = head.premin;
			n.next = head;
			head = n;
		}
		size++;
	}
	public void pop() {
		if(size==0) System.err.println("Empty Stack!");
		else{
			head = head.next;
			size--;
		}	
	}
	
	public int top() {
		if(size == 0) return Integer.MAX_VALUE;
		else return head.val;
	}
	
	public int getMin() {
		if(size == 0) return Integer.MAX_VALUE;
		else return head.premin;
	}
}

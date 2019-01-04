

public class SinglyList<String>extends Object {
	public Node<String>head;
	public SinglyList() {
		this.head = new Node<String>();
	}
	public SinglyList(String[] values) {
		this();
		Node<String>rear = this.head;
		for(int i=0;i<values.length;i++) {
			rear.next=new Node<String>(values[i],null);
			rear = rear.next;
		}
	}
	public boolean isEmpty() {
		return this.head.next==null;
	}
	public String get(int i) {
		Node<String>p=this.head.next;
		for(int j =0;p!=null&&j<i;j++)
			p=p.next;
		return(i>=0&&p!=null)?p.data:null;
	}

	public Node<String>insert(int i ,String x){
		if(x==null)
			throw new NullPointerException("x==null");
		Node<String>front=this.head;
		for(int j = 0;front.next!=null&&j<i;j++)
			front=front.next;
		front.next=new Node<String>(x,front.next);
		return front.next;
	}
	public Node<String>insert(String x){
		return insert(Integer.MAX_VALUE,x);
	}
	public String remove(int i) {
		Node<String>front=this.head;
		for(int j=0;front.next!=null&&j<i;j++)
			front=front.next;
		if(i>=0&&front!=null) {
			String old = front.next.data;
			front.next=front.next.next;
			return old;
		}
		return null;
	}
	public void clear() {
		this.head.next=null;
	}
}

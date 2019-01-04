
public class Node<String> {
	public String data;
	public Node<String>next;
	public Node(String data,Node<String>next) {
		this.data= data;
		this.next=next;
	}
	public Node() {
		this(null,null);
	}
	public  java.lang.String toString() {
		return this.data.toString();
	}
}

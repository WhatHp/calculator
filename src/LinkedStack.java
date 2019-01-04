
public final class LinkedStack<Integer> {
	private SinglyList<Integer>list;
	public LinkedStack() {
		this.list=new SinglyList<Integer>();
	}
	public boolean isEmpty() {
		return this.list.isEmpty();
		
	}
	public void push(Integer x) {
		this.list.insert(0,x);
	}
	public Integer peek() {
		return this.list.get(0);
	}
	public Integer pop() {
		
		return this.list.remove(0);
	}
	
}

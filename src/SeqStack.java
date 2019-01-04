
public final class SeqStack<String>  {
	private SeqList<String>list;
	public SeqStack(int length) {
		this.list = new SeqList<String>(length);	
		}
	public SeqStack() {
		this(64);
		
	}
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	public void push(String x) {
		this.list.insert(x);
	}
	public String peek() {
		return this.list.get(list.size()-1);
	}
	public String pop() {
		return list.remove(list.size()-1);
	}
}

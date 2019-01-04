
public class SeqList<String> extends Object {
	protected Object[] element;
	protected int n;
	public SeqList(int length) {
		this.element= new Object[length];
		this.n= 0;
	}
	public SeqList() {
		this(64);
	}
	public SeqList(String[] values) {
		this(values.length);
		for(int i =0;i<values.length;i++)
			this.element[i] = values[i];
		this.n= element.length; 
	}
	 public boolean isEmpty() {
		 return this.n ==0;
	 }
	 public int size() {
		 return this.n;
	 }
	 public String get(int i) {//返回第i个元素，传递对象引用
		 if(i>=0&&i<this.n)
			 return(String)this.element[i];
		 return null;
	 }
	
	public int insert(int i,String x) {//插入
		if(x==null)
			throw new NullPointerException("x==null");
		if(i<0)i=0;
		if(i>this.n)i=this.n;
		Object[] source=this.element;
		if(this.n==element.length) {
			this.element=new Object[source.length*2];
			for(int j = 0;j<i;j++)
				this.element[j]=source[j];
		}
		for(int j = this.n-1;j>=i;j--)
			this.element[j+1]=source[j];
		this.element[i] =x;
		this.n++;
		return i;
		
	}
	public int insert(String x) {
		return this.insert(this.n,x);
	}
	public String remove(int i) {
		if(this.n>0&&i>=0&&i<this.n) {
			String old = (String)this.element[i];
			for(int j = i;j<this.n-1;j++)
				this.element[j]=this.element[j+1];
			this.element[this.n-1]=null;
			this.n--;
			return old;
		}
		return null;
	}
	public void clear() {
		this.n=0;
	}
	
}

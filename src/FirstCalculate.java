import java.util.Scanner;

public class FirstCalculate {
	public static void main(String args[]) {
		double a,b,c,d;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入想要计算的两个数字");
		a = scanner.nextDouble();
		b =scanner.nextDouble();
		System.out.println("如果想计算加法输入1"+"\n"+"减法输入2"+"\n"+"乘法输入3"+"\n"+"除法输入4");
		c=scanner.nextDouble();
		if(c==1) {
			d=a+b;
		}
		else if(c==2) {
			d=a-b;
		}
		else if(c==3) {
			d = a*b;
		}
		else 
			d = a/b;
		System.out.println("结果是："+d);
	}
	
}

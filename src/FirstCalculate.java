import java.util.Scanner;

public class FirstCalculate {
	public static void main(String args[]) {
		double a,b,c,d;
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ�������������");
		a = scanner.nextDouble();
		b =scanner.nextDouble();
		System.out.println("��������ӷ�����1"+"\n"+"��������2"+"\n"+"�˷�����3"+"\n"+"��������4");
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
		System.out.println("����ǣ�"+d);
	}
	
}

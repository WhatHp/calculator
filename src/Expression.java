import java.util.Scanner;
import java.util.Stack;

public class Expression {
		public static StringBuffer toPostfix(String infix) {  //���ؽ�infix��׺���ʽת���ǵĺ�׺���ʽ
			SeqStack<String>stack = new SeqStack<String>(infix.length());//�����ջ
			StringBuffer postfix = new StringBuffer(infix.length()*2);//��׺���ʽ�ַ���
			int i = 0;
			while (i<infix.length()) {
				char ch = infix.charAt(i);
				switch(ch) {
				case'+':case'-':
					while(!stack.isEmpty()&&!stack.peek().equals("("))//��ջ��������Ƚ�
						postfix.append(stack.pop());//��ջ�������ӵ���׺���ʽ
					stack.push(ch+"");//��ǰ�������ջ
					i++;
					break;
				case'*':case'/':
					while(!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/")))
						postfix.append(stack.pop());//ջ�����ȼ��ߵ��������ջ
					stack.push(ch+"");
					i++;
					break;
				case'(':
					stack.push(ch+"");
					i++;
					break;
				case')':
					String out = stack.pop();
					while (out!=null&&!out.equals("(")) {
						postfix.append(out);
						out = stack.pop();
					}
					i++;
					break;
				default:
					while(i<infix.length()&&ch>='0'&&ch<='9') {
						postfix.append(ch);
						i++;
						if(i<infix.length())
							ch = infix.charAt(i);
					}
					postfix.append(" ");
					
				}
			}
			while(!stack.isEmpty())//�����������ջ
				postfix.append(stack.pop());
			return postfix;
		}
		/*�����׺���ʽ��ֵ
		 * ���������׺���ʽ���ַ�
		 * ת��������
		 */
		public static int toValue(StringBuffer postfix) {
			LinkedStack<Integer>stack = new LinkedStack<Integer>();
			int value = 0;
			for(int i =0;i<postfix.length();i++) {
				char ch = postfix.charAt(i);
				if(ch>='0'&&ch<='9') {
					value = 0;
					while(ch!=' ') {
						value = value*10+ch-'0';
						ch = postfix.charAt(++i);
					}
					stack.push(value);
				}
				else
					if(ch!=' ') {
						int  y= stack.pop(),x = stack.pop();
						switch(ch) {
						case'+':value = x+y;break;
						case'-':value = x-y;break;
						case'*':value = x*y;break;
						case'/':value = x/y;break;
						}
						
						stack.push(value);
						
					}
			}
			return stack.pop();
		}
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			String infix = scanner.next();
			StringBuffer postfix = toPostfix(infix);
			System.out.println("value="+toValue(postfix));
		}
}

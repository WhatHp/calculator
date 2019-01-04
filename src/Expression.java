import java.util.Scanner;
import java.util.Stack;

public class Expression {
		public static StringBuffer toPostfix(String infix) {  //返回将infix中缀表达式转换城的后缀表达式
			SeqStack<String>stack = new SeqStack<String>(infix.length());//运算符栈
			StringBuffer postfix = new StringBuffer(infix.length()*2);//后缀表达式字符串
			int i = 0;
			while (i<infix.length()) {
				char ch = infix.charAt(i);
				switch(ch) {
				case'+':case'-':
					while(!stack.isEmpty()&&!stack.peek().equals("("))//与栈顶运算符比较
						postfix.append(stack.pop());//出栈运算符添加到后缀表达式
					stack.push(ch+"");//当前运算符出栈
					i++;
					break;
				case'*':case'/':
					while(!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/")))
						postfix.append(stack.pop());//栈顶优先级高的运算符出栈
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
			while(!stack.isEmpty())//所有运算符出栈
				postfix.append(stack.pop());
			return postfix;
		}
		/*计算后缀表达式的值
		 * 逐个检索后缀表达式的字符
		 * 转换成整形
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

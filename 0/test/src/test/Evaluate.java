package test;
import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Evaluate
{
	public static void main (String[] args)
	{
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while(!StdIn.isEmpty())
		{	//读取字符如果是运算符则压入栈
			String s = StdIn.readString();
			if      (s.equals("("))		 	  	   ;
			else if (s.equals("+"))		ops.push(s);
			else if (s.equals("-"))		ops.push(s);
			else if (s.equals("*"))		ops.push(s);
			else if (s.equals("/"))		ops.push(s);
			else if (s.equals("sqrt"))  ops.push(s);
			else if (s.equals(")"))
			{	//如果支付为")"弹出运算符和操作数计算结果并压入栈
				String op = ops.pop();
				double v = vals.pop();
				if		(op.equals("+"))	v = vals.pop() + v;
				else if (op.equals("-"))	v = vals.pop() - v;
				else if (op.equals("*"))	v = vals.pop() * v;
				else if (op.equals("/"))	v = vals.pop() / v;
				else if (op.equals("sqrt"))	v = Math.sqrt(v);
				vals.push(v);
			}	//如果字符既非运算符也不是括号将他作为double值压入栈
			else vals.push(Double.parseDouble(s.trim()));
		}
		StdOut.println(vals.pop());
	}
}

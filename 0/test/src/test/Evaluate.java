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
		{	//��ȡ�ַ�������������ѹ��ջ
			String s = StdIn.readString();
			if      (s.equals("("))		 	  	   ;
			else if (s.equals("+"))		ops.push(s);
			else if (s.equals("-"))		ops.push(s);
			else if (s.equals("*"))		ops.push(s);
			else if (s.equals("/"))		ops.push(s);
			else if (s.equals("sqrt"))  ops.push(s);
			else if (s.equals(")"))
			{	//���֧��Ϊ")"����������Ͳ�������������ѹ��ջ
				String op = ops.pop();
				double v = vals.pop();
				if		(op.equals("+"))	v = vals.pop() + v;
				else if (op.equals("-"))	v = vals.pop() - v;
				else if (op.equals("*"))	v = vals.pop() * v;
				else if (op.equals("/"))	v = vals.pop() / v;
				else if (op.equals("sqrt"))	v = Math.sqrt(v);
				vals.push(v);
			}	//����ַ��ȷ������Ҳ�������Ž�����Ϊdoubleֵѹ��ջ
			else vals.push(Double.parseDouble(s.trim()));
		}
		StdOut.println(vals.pop());
	}
}

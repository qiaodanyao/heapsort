package test;
public class Merge 
{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];
		sort(a,0,a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo) return;
		int mid =lo + (hi-lo)/2;
		sort(a,lo,mid);		//将左边排序
		sort(a,mid+1,hi);	//将右边排序
		merge(a,lo,mid,hi);	//并归结果
	}
	
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{	//将a【lo...mid】和a[mid+1...hi]并归
		int i = lo, j = mid+1;
		for(int k = lo; k<= hi; k++)
			aux[k] = a[k];
		for(int k =lo; k<= hi; k++)
			if 		(i > mid)	a[k] =aux[j++];
			else if (j > hi)	a[k] = aux[i++];
			else if (Selection.less(aux[j],aux[i]))	a[k] = aux[j++];
			else				a[k] = aux[i++];
		
		
	}
}


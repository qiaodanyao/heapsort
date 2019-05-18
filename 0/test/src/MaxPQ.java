
//基于完全二叉堆的优先队列
public class MaxPQ <Key extends Comparable<Key>>//抽象数据类型Key继承Comparable的Key
{
	private Key[] pq;//定义一个Key类型的数组（基于堆的完全二叉树）
	private int N = 0 ;//储存于pq[1..N]中，pq[0]没有使用
	
	public MaxPQ(int maxN)
	{	//创建一个泛型的数组在Java中是不允许的，这里使用类型转换
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}
	
	public void insert(Key v)
	{
		pq[++N] = v;//使得插入的值在完全二叉堆的最后一个叶节点
		swim(N);//上浮使得新插入的堆有序化
	}
	
	public Key delMax()
	{
		Key max = pq[1];//从根节点得到最大元素
		exch(1,N--);	//将其和最后一个节点交换
		pq[N+1] = null;	//防止对象游离
		sink(1);		//下浮使得堆恢复有序性
		return max;
	}

	private void swim(int k) 
	{	//k>1上浮上界（首节点），less(k/2,k)比较父节点是否比子节点小。如果小则交换，同时修改k的值
		while(k < 1 && less(k/2,k))
		{
			exch(k/2,k);
			k = k/2;
		}
		
	}
	
	private void sink(int k)
	{
		while (2*k <= N)//判断下沉下界（最大为倒数第二层）
		{
			int j = 2*k;
			if(j < N && less(j,j+1))	j++;//判断子节点孰大
			if(!less(k,j))	break;		//判断父节点是否比子节点大，如果小则继续循环，大则跳出循环
			exch(k,j);			//交换父节点与较大的子节点（通过j++实现），使其下沉
			k = j;		
			
		}
	}
	
	private void exch(int k, int j) 
	{
		Key t = pq[k]; pq[k] = pq[j]; pq[j] = t;
		
	}

	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
}

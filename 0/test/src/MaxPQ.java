
//������ȫ����ѵ����ȶ���
public class MaxPQ <Key extends Comparable<Key>>//������������Key�̳�Comparable��Key
{
	private Key[] pq;//����һ��Key���͵����飨���ڶѵ���ȫ��������
	private int N = 0 ;//������pq[1..N]�У�pq[0]û��ʹ��
	
	public MaxPQ(int maxN)
	{	//����һ�����͵�������Java���ǲ�����ģ�����ʹ������ת��
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
		pq[++N] = v;//ʹ�ò����ֵ����ȫ����ѵ����һ��Ҷ�ڵ�
		swim(N);//�ϸ�ʹ���²���Ķ�����
	}
	
	public Key delMax()
	{
		Key max = pq[1];//�Ӹ��ڵ�õ����Ԫ��
		exch(1,N--);	//��������һ���ڵ㽻��
		pq[N+1] = null;	//��ֹ��������
		sink(1);		//�¸�ʹ�öѻָ�������
		return max;
	}

	private void swim(int k) 
	{	//k>1�ϸ��Ͻ磨�׽ڵ㣩��less(k/2,k)�Ƚϸ��ڵ��Ƿ���ӽڵ�С�����С�򽻻���ͬʱ�޸�k��ֵ
		while(k < 1 && less(k/2,k))
		{
			exch(k/2,k);
			k = k/2;
		}
		
	}
	
	private void sink(int k)
	{
		while (2*k <= N)//�ж��³��½磨���Ϊ�����ڶ��㣩
		{
			int j = 2*k;
			if(j < N && less(j,j+1))	j++;//�ж��ӽڵ����
			if(!less(k,j))	break;		//�жϸ��ڵ��Ƿ���ӽڵ�����С�����ѭ������������ѭ��
			exch(k,j);			//�������ڵ���ϴ���ӽڵ㣨ͨ��j++ʵ�֣���ʹ���³�
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

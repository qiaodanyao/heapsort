
public class TreeNode {
	//�ڵ��ֵ
	int value;
	//����
	TreeNode leftNode;
	//�Һ���
	TreeNode rightNode;
	
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	//��������
	public  void setleftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//�����Һ���
	public  void setrightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	//ǰ�����
	public void frontShow() {
		//�ȱ�����ǰ�ڵ������
		System.out.println(value);
		//��ڵ�
		if(leftNode != null) {
			leftNode.frontShow();
		}
		//�ҽڵ�
		if(rightNode != null) {
			rightNode.frontShow();
		}
	}

	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		if(this.value == i) {
			return this;
		}else {
			if(leftNode != null) {
				target = leftNode.frontSearch(i);
			}
			if(target != null) {
				return target;
			}
			if(rightNode != null) {
				target = rightNode.frontSearch(i);
			}
		}
		return target;
	}
	//ɾ��һ������
	public void delete(int i) {
		TreeNode parent = this;
		//�ж������
		if((parent.leftNode.value == i) && (parent.leftNode!=null))
		{
			parent.leftNode = null;
			return;
		}
		//�ж��Ҷ���
		if((parent.rightNode.value == i )&& (parent.rightNode!=null)) 
		{
			parent.rightNode = null;
			return;
		}
		//�ݹ��鲢ɾ�������
		parent = leftNode;
		if(parent != null) 
		{
			parent.delete(i);
		}
		//�ݹ��鲢ɾ���Ҷ���
		parent = rightNode;
		if(parent != null)
		{
			parent.delete(i);
		}
		
	}
}


public class TreeNode {
	//节点的值
	int value;
	//左孩子
	TreeNode leftNode;
	//右孩子
	TreeNode rightNode;
	
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	//设置左孩子
	public  void setleftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//设置右孩子
	public  void setrightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	//前序遍历
	public void frontShow() {
		//先遍历当前节点的内容
		System.out.println(value);
		//左节点
		if(leftNode != null) {
			leftNode.frontShow();
		}
		//右节点
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
	//删除一颗子树
	public void delete(int i) {
		TreeNode parent = this;
		//判断左儿子
		if((parent.leftNode.value == i) && (parent.leftNode!=null))
		{
			parent.leftNode = null;
			return;
		}
		//判断右儿子
		if((parent.rightNode.value == i )&& (parent.rightNode!=null)) 
		{
			parent.rightNode = null;
			return;
		}
		//递归检查并删除左儿子
		parent = leftNode;
		if(parent != null) 
		{
			parent.delete(i);
		}
		//递归检查并删除右儿子
		parent = rightNode;
		if(parent != null)
		{
			parent.delete(i);
		}
		
	}
}

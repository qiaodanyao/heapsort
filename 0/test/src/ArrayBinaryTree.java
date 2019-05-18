
public class ArrayBinaryTree {
	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
	public void frontShow(){
		frontShow(0);
	}
	
	//前序遍历
	public void frontShow(int index) {
		if(data == null||data.length == 0) {
			return;
		}
		//先遍历当前节点的内容
		System.out.println(data[index]);
		//递归遍历左子节点
		if(2*index+1 <data.length) {
			frontShow(2*index+1);
		}
		//递归遍历左子节点
		if(2*index+2 <data.length) {
			frontShow(2*index+2);
		}
		
	}

}

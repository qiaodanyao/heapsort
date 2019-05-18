
public class TestBinaryTree {

	public static void main(String[] args) {
		//������һ����
		BinaryTree binTree = new BinaryTree();
		//����һ�����ڵ�
		TreeNode root = new TreeNode(1);
		//�Ѹ��ڵ㸳����
		binTree.setRoot(root);
		//���������ӽڵ�
		TreeNode rootL = new TreeNode(2);
		TreeNode rootR = new TreeNode(3);
		//�Ѵ������ӽڵ�����Ϊ���ڵ���ӽڵ�
		root.setleftNode(rootL);
		root.setrightNode(rootR);
		//Ϊ�ڶ������ڵ㴴�������ӽڵ�
		rootL.setleftNode(new TreeNode(4));
		rootL.setrightNode(new TreeNode(5));
		//Ϊ�ڶ�����ҽڵ㴴�������ӽڵ�
		rootR.setleftNode(new TreeNode(6));
		rootR.setrightNode(new TreeNode(7));
		//ǰ�������
		binTree.frontShow();
		System.out.println("==========================");
		//ǰ�����
		TreeNode result = binTree.frontSearch(5);
		System.out.println(result);
		System.out.println("==========================");
		//ɾ������
		binTree.delete(2);
		binTree.frontShow();
		
	}

}

/**
 * 
 */
package book.karumanchi.ds.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author subratt
 *This is simple node for a Binary Tree.
 *Class contains all ADT methods of Tree data structure.
 *
 */
public class BinaryTreeNode {

	/**
	 * @param args
	 */
	private int data;
	private BinaryTreeNode left,right;
	private static int nodeCount=0;
	

	public BinaryTreeNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	
	
	public int getData() {
		return data;
	}



	public void setData(int data) {
		this.data = data;
	}



	public BinaryTreeNode getLeft() {
		return left;
	}



	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}



	public BinaryTreeNode getRight() {
		return right;
	}



	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public static String getInorderTraversal (BinaryTreeNode root, List<Integer> inorderTraversal){
		if(root == null){
			return null;
		}
		if(inorderTraversal==null){
			inorderTraversal= new ArrayList<Integer>();
		}

		getInorderTraversal(root.getLeft(), inorderTraversal);	
		inorderTraversal.add(root.getData());	
		getInorderTraversal(root.getRight(), inorderTraversal);	
		
		return inorderTraversal.toString();
		
	}
	
	public static int getNodeCount(BinaryTreeNode root) {
		if(root !=null){
			nodeCount++;
		}
		else{
			return 0;
		}
		BinaryTreeNode.getNodeCount(root.left);
		BinaryTreeNode.getNodeCount(root.right);
		return nodeCount;
		
	}
	/*
	 * Recursive method to find height of tree
	 */
	public static int getHeight(BinaryTreeNode root){
		int height=0;
		if(root ==null){
			return 0;
		}
		int leftSubTreeHeight=getHeight(root.getLeft());
		int rightSubTreeHeight=getHeight(root.getRight());
		if(leftSubTreeHeight>=rightSubTreeHeight){
			height=height+leftSubTreeHeight+1;
		}else{
			height=height+rightSubTreeHeight+1;
		}
		return height;
	}
	
	public static int getMaximum (BinaryTreeNode root) {
		if(root ==null) {
			return 0;
		}
		int maxFromLeftTree=getMaximum (root.left);
		int maxFromRightTree = getMaximum(root.right);
		int maxValue= maxFromLeftTree>maxFromRightTree?maxFromLeftTree:maxFromRightTree;
		if(maxValue<root.getData()){
			maxValue=root.getData();
		}
		return maxValue;
	}
	
	public static String getLevelOrderTraversal(BinaryTreeNode root){
		if(root == null){
			return null;
		}
		 List<Integer> levelorderTraversal= new ArrayList<Integer>();
		 Queue levelOrderQueue= new LinkedList<BinaryTreeNode>();
		
		levelOrderQueue.offer(root);
		while(!levelOrderQueue.isEmpty()){
			BinaryTreeNode node= (BinaryTreeNode) levelOrderQueue.poll();
			levelorderTraversal.add(node.getData());
			if(node.getLeft() !=null)
			levelOrderQueue.offer(node.getLeft());
			if(node.getRight() !=null)
			levelOrderQueue.offer(node.getRight());
		}
		
		return levelorderTraversal.toString();
	}
	
	public static void deleteTree (BinaryTreeNode root) {
		if(root ==null){
			return;
		}
		
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root.setLeft(null);
		root.setRight(null);
		root=null;
		
	}
	
	public static void getTopView(BinaryTreeNode root) {
		if(root ==null){
			return;
		}
		BinaryTreeNode head=root;
		Stack leftdata=new Stack();
		if(head.getLeft() !=null){
			while(root !=null){
				leftdata.push(root.data);
				root=root.getLeft();
			}
		}
		while(!leftdata.isEmpty()){
			System.out.print(leftdata.pop());
		}
		if(head.getRight() !=null){
			head=head.getRight();
			while(head !=null){
				System.out.print(head.getData());
				head=head.getRight();
			}
		}
	}
	
	
	
	/*
	 * Main Methods for all Binary Tree methods
	 */
	public static void main(String[] args) {
		System.out.println("Binary Tree implimentation");
		BinaryTreeNode root= new BinaryTreeNode(25);
		BinaryTreeNode child11= new BinaryTreeNode(2);
		BinaryTreeNode child12= new BinaryTreeNode(33);
		BinaryTreeNode child111= new BinaryTreeNode(4);
		BinaryTreeNode child1112= new BinaryTreeNode(55);
		BinaryTreeNode child121= new BinaryTreeNode(10);
		BinaryTreeNode child1212= new BinaryTreeNode(45);
		root.setLeft(child11);
		root.setRight(child12);
		child11.setLeft(child111);
		child111.setRight(child1112);
		child12.setLeft(child121);
		child121.setLeft(child1212);
		/*System.out.println(getNodeCount(root));
		System.out.println("Inorder Traversal for tree is" +getInorderTraversal(root,null));
		System.out.println("Level Order Traversal for tree is"+getLevelOrderTraversal(root));
		System.out.println("Height of the tree :" + getHeight(root));
		System.out.println("Maximum of the tree :" + getMaximum(root));
		System.out.println("Delete Tree:" );
		deleteTree(root);*/
		//getTopView(root);
		/*boolean siblings = checkSiblings(root,child121,child1112);
		if (siblings == true)
				System.out.print("Nodes are siblings");
		else
			System.out.print("Nodes are not siblings");*/
		//singleChild(root);
		/*int level = getLevel(root , child111 ,1);
		System.out.print("Node is at level " + level); */
		/*boolean cousins = checkCousins(root,child111,child121);
		if (cousins == true)
				System.out.print("Nodes are cousins");
		else
			System.out.print("Nodes are not cousins");*/
		//printNodesAtLevel(root , 1 , 5);
		//System.out.print(countNodesAtLevel(root , 1 ,4));
		//System.out.print(getWidth(root));
	}

}

/**
 * 
 */
package book.karumanchi.ds.Tree.Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import book.karumanchi.ds.Tree.BinaryTreeNode;

/**
 * @author subratt
 *
 */
public class LevelOrderTraversalReverse extends BinaryTreeNode{

	
	static int  maxlevel = 0;
	public LevelOrderTraversalReverse(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	/*
	 * The simplest and most efficient method to get LevelOrderTraversal in reverse order is by using Stack and Queue
	 */
	public static void getLevelOrderTraversalReverse(BinaryTreeNode root){
		Stack<Integer> reverseOrder= new Stack<Integer>();
		Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<BinaryTreeNode>();
		if(root ==null){
			return;
		}
		levelOrderQueue.offer(root);
		while(!levelOrderQueue.isEmpty()){
			BinaryTreeNode node=levelOrderQueue.poll();

			if(node.getRight() != null){
				levelOrderQueue.offer(node.getRight());
				//reverseOrder.push(node.getRight().getData());
			}
			if(node.getLeft() != null){
				levelOrderQueue.offer(node.getLeft());
				//reverseOrder.push(node.getLeft().getData());
			}
			reverseOrder.push(node.getData());
			
		}
		
		while(!reverseOrder.isEmpty()){
			System.out.print(reverseOrder.pop() + "->");
		}
	}
	
	/*
	 * The simplest and most efficient method to get Reverse LevelOrderTraversal using recursion
	 */
	
	public static void getLevelOrderTraversalReverseRecursive(BinaryTreeNode root){
		int height = getHeight(root);
		for(int i=height;i >= 1;i--)
		{
			printGivenLevel(root , i);
		}
	}
	
	public static void printGivenLevel(BinaryTreeNode root, int level){
		  if(root == null)
			  return;
          if(level == 1)
          System.out.print(root.getData() + "->");
          else
          {
        	  printGivenLevel(root.getLeft() , level-1);
        	  printGivenLevel(root.getRight() , level-1);
          }
          
	}
	
	/*
	 * The simplest and most efficient method to get LevelOrderTraversal using recursion
	 */
	
	public static void getLevelOrderTraversalRecursive(BinaryTreeNode root){
		int height = getHeight(root);
		for(int i=1;i <= height;i++)
		{
			printGivenLevelOrder(root , i);
		}
	}
	
	public static void printGivenLevelOrder(BinaryTreeNode root, int level){
		  if(root == null)
			  return;
          if(level == 1)
          System.out.print(root.getData() + "->");
          else
          {
        	  
        	  printGivenLevelOrder(root.getLeft() , level-1);
        	  printGivenLevelOrder(root.getRight() , level-1);
          }
          
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode root= new BinaryTreeNode(1);
		BinaryTreeNode child11= new BinaryTreeNode(2);
		BinaryTreeNode child12= new BinaryTreeNode(3);
		BinaryTreeNode child111= new BinaryTreeNode(4);
		BinaryTreeNode child1112= new BinaryTreeNode(5);
		BinaryTreeNode child1111= new BinaryTreeNode (6);
		BinaryTreeNode child1113= new BinaryTreeNode (7);
		BinaryTreeNode child1114= new BinaryTreeNode (8);
		BinaryTreeNode child1124= new BinaryTreeNode (9);
		root.setLeft(child11);
		root.setRight(child12);
		child11.setLeft(child111);
		child12.setLeft(child1111);
		child12.setRight(child1113);
		child11.setRight(child1112);
		child1113.setRight(child1114);
		child1112.setLeft(child1124);
		//getLevelOrderTraversalReverse(root);
		//getLevelOrderTraversalReverseRecursive(root);
		// getLevelOrderTraversalRecursive(root);
		//printLeftView(root);
		
	}

}

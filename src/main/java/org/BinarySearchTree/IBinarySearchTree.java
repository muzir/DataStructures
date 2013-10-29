package org.BinarySearchTree;

import org.BinarySearchTree.BinarySearchTree.TreeNode;


public interface IBinarySearchTree {
	public void addNode(Integer param);
	public String searchNode(TreeNode node, Integer param);
	public String traversePreOrder(TreeNode node);
	public String traverseInOrder(TreeNode node);
	public String traversePostOrder(TreeNode node);
}

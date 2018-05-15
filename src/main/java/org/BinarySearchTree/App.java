package org.BinarySearchTree;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();

		binarySearchTree.addNode(10);
		binarySearchTree.addNode(11);
		binarySearchTree.addNode(14);
		binarySearchTree.addNode(9);
		System.out
				.println("Test traversePreOrder with No Paramater Constructor");
		System.out.println(binarySearchTree.traversePreOrder(binarySearchTree
				.get_root()));

		binarySearchTree.set_strSequential("");
		System.out
				.println("Test traverseInOrder with No Paramater Constructor");
		System.out.println(binarySearchTree.traverseInOrder(binarySearchTree
				.get_root()));

		binarySearchTree.set_strSequential("");
		System.out
				.println("Test traversePostOrder with No Paramater Constructor");
		System.out.println(binarySearchTree.traversePostOrder(binarySearchTree
				.get_root()));

		System.out.println("Test Search Tree method");
		System.out.println(binarySearchTree.searchNode(
				binarySearchTree.get_root(), 14));
		binarySearchTree.set_depth(0);
		System.out.println(binarySearchTree.searchNode(
				binarySearchTree.get_root(), 10));
		binarySearchTree.set_depth(0);
		System.out.println(binarySearchTree.searchNode(
				binarySearchTree.get_root(), 11));
		binarySearchTree.set_depth(0);
		System.out.println(binarySearchTree.searchNode(
				binarySearchTree.get_root(), 8));

		/*
		 * System.out.println("Test traversePreOrder with Paramater Constructor")
		 * ; BinarySearchTree bSTParam = new BinarySearchTree(
		 * binarySearchTree.get_root(), binarySearchTree.get_size());
		 * System.out.println(bSTParam.traversePreOrder(bSTParam.get_root()));
		 * 
		 * System.out.println("Test traversePreOrder with Copy Constructor");
		 * BinarySearchTree bSTCopy = new BinarySearchTree(binarySearchTree);
		 * System.out.println(bSTCopy.traversePreOrder(bSTCopy.get_root()));
		 */
		/*
		 * Dog myDog = new Dog("Rover"); myDog.foo(myDog);
		 * System.out.println("Dod name" + myDog.get_name());
		 */



	}
}

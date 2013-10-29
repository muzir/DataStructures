package org.BinarySearchTree;

/**
 * Created to understand binary search tree traversal algorithm
 * 
 * @author muzir
 * 
 */
public class BinarySearchTree implements IBinarySearchTree {

	/**
	 * Constructor with no parameter
	 */
	public BinarySearchTree() {
		_root = new TreeNode();
		_size = 0;
		_strSequential = "";
		_depth = 0;
	}

	/**
	 * Constructor with parameter
	 * 
	 * @param root
	 * @param size
	 */
	public BinarySearchTree(TreeNode root, int size) {
		_root = new TreeNode();
		_root.set_nodeValue(root.get_nodeValue());
		_root.set_leftNode(root.get_leftNode());
		_root.set_rightNode(root.get_rightNode());
		_size = size;
		_strSequential = "";
		_depth = 0;
	}

	/**
	 * Copy constructor
	 * 
	 * @param copy
	 */
	public BinarySearchTree(BinarySearchTree copy) {
		_root = new TreeNode();
		_root.set_nodeValue(copy.get_root().get_nodeValue());
		_root.set_leftNode(copy.get_root().get_leftNode());
		_root.set_rightNode(copy.get_root().get_rightNode());
		_size = copy.get_size();
		_strSequential = copy.get_strSequential();
		_depth = copy.get_depth();
	}

	/* Class methods */
	/**
	 * Add node to BinarySearchTree
	 * 
	 * @param node
	 * @param param
	 */
	public void addNode(Integer param) {
		if (_size == 0) {
			_root = new TreeNode(param);
		} else {
			if (_root.get_nodeValue() >= param) {
				_root.putLeft(param);
			} else {
				_root.putRight(param);
			}
		}
		_size = _size + 1;
	}// end of addNode method

	/**
	 * Return the first TreeNode whose value equals to param value
	 * 
	 * @return
	 */
	public String searchNode(TreeNode node, Integer param) {
		if (node == null) {
			return "Param value " + param + " is not found.";
		} else if (node.get_nodeValue() == param) {
			return "Param value:" + node.get_nodeValue() + " deep: " + _depth;
		} else {
			_depth = _depth + 1;
			if (node.get_nodeValue() >= param) {
				return searchNode(node.get_leftNode(), param);
			} else {
				return searchNode(node.get_rightNode(), param);
			}
		}
	}// end of searchNode method

	/*
	 * Traverse tree depth-first
	 */
	/* Traverse preOrder */
	public String traversePreOrder(TreeNode node) {
		// First root null check
		if (node == null) {
			return "Tree is empty";
		}
		// Put root value first
		_strSequential = _strSequential + "  " + node.get_nodeValue();
		// Then visit the left subtree
		if (node._leftNode != null) {
			traversePreOrder(node.get_leftNode());
		}
		// Then visit the right subtree
		if (node.get_rightNode() != null) {
			traversePreOrder(node.get_rightNode());
		}
		return _strSequential;
	}// end of traversePreOrder method

	/* Traverse inOrder */
	public String traverseInOrder(TreeNode node) {
		// First root null check
		if (node == null) {
			return "Tree is empty";
		}

		if (node.get_leftNode() != null) {
			traverseInOrder(node.get_leftNode());
		}
		_strSequential = _strSequential + "  " + node.get_nodeValue();
		if (node.get_rightNode() != null) {
			traverseInOrder(node.get_rightNode());
		}
		return _strSequential;
	}

	/* Traverse postOrder */
	public String traversePostOrder(TreeNode node) {

		// First root null check
		if (node == null) {
			return "Tree is empty";
		}
		if (node.get_leftNode() != null) {
			traversePostOrder(node.get_leftNode());
		}
		if (node.get_rightNode() != null) {
			traversePostOrder(node.get_rightNode());
		}
		_strSequential = _strSequential + "  " + node.get_nodeValue();
		return _strSequential;
	}

	/* End of class methods */

	/* TreeNode inner class */
	class TreeNode {
		TreeNode() {
			_nodeValue = 0;
			_leftNode = null;
			_rightNode = null;
		}

		TreeNode(Integer param) {
			_nodeValue = param;
			_leftNode = null;
			_rightNode = null;
		}

		public void putLeft(Integer param) {
			if (_leftNode == null) {
				this._leftNode = new TreeNode(param);
			} else {
				if (_leftNode.get_nodeValue() >= param) {
					_leftNode.putLeft(param);
				} else {
					_rightNode.putRight(param);
				}
			}
		}

		public void putRight(Integer param) {
			if (_rightNode == null) {
				this._rightNode = new TreeNode(param);
			} else {
				if (_rightNode.get_nodeValue() < param) {
					_rightNode.putRight(param);
				} else {
					_leftNode.putLeft(param);
				}
			}
		}

		public Integer get_nodeValue() {
			return _nodeValue;
		}

		public void set_nodeValue(Integer _nodeValue) {
			this._nodeValue = _nodeValue;
		}

		public TreeNode get_leftNode() {
			return _leftNode;
		}

		public void set_leftNode(TreeNode _leftNode) {
			this._leftNode = _leftNode;
		}

		public TreeNode get_rightNode() {
			return _rightNode;
		}

		public void set_rightNode(TreeNode _rightNode) {
			this._rightNode = _rightNode;
		}

		/* Class variables */
		private Integer _nodeValue;
		private TreeNode _leftNode;
		private TreeNode _rightNode;
	}// end of inner class TreeNode

	public TreeNode get_root() {
		return _root;
	}

	public void set_root(TreeNode _root) {
		this._root = _root;
	}

	public int get_size() {
		return _size;
	}

	public void set_size(int _size) {
		this._size = _size;
	}

	public String get_strSequential() {
		return _strSequential;
	}

	public void set_strSequential(String _strSequential) {
		this._strSequential = _strSequential;
	}

	public int get_depth() {
		return _depth;
	}

	public void set_depth(int _depth) {
		this._depth = _depth;
	}

	/* BinarySearchTree Class variables */
	private TreeNode _root;
	private int _size;
	private String _strSequential = "";
	private int _depth;
}// end of class BinarySearchTree

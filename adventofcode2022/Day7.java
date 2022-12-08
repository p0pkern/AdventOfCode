package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day7 {

	public static Tree runCommand(Tree tree, String target) {
		if (target.equals("/")) {
			tree.moveToTopDirectory();
		} else if (target.equals("..")) {
			tree.moveUp();
		} else if (target.equals("ls")) {
			// tree.listChildren();
		} else {
			tree.moveDown(target);
		}
		
		return tree;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Tree directory = new Tree(new Node(0, "/", true));

		try (BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))) {
			String line = inFile.readLine();

			while (line != null) {
				String[] commands = line.split(" ");
				if (commands[0].equals("$")) {
					directory = runCommand(directory, commands[1]);
				} else if (commands[0].equals("dir")) {
					Node newNode = new Node(0, commands[1], true);
					newNode.setParent(directory.getTargetNode());
					directory.appendFile(newNode);
				} else {
					Node newNode = new Node(Integer.parseInt(commands[0]), commands[1], false);
					newNode.setParent(directory.getTargetNode());
					directory.appendFile(newNode);
				}

				line = inFile.readLine();
			}
			directory.listChildren();
			//System.out.println(directory.solvePartOne());
		}

	}

}

class Node {
	private String name;
	private int size;
	private Node parent;
	private List<Node> children;
	private boolean isDirectory;

	Node(int size, String name, boolean isDirectory) {
		this.size = size;
		this.name = name;
		this.isDirectory = isDirectory;
		this.children = new ArrayList<>();
	}

	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public void addChild(Node n) {
		getChildren().add(n);
	}

	@Override
	public String toString() {
		String dir = isDirectory ? "(Dir)" : "(File)";
		String totalSize = getSize() > 0 ? "Size: " + getSize() : "";
		return dir + " " + getName() + " " + totalSize;
	}

}

class Tree {
	private Node root;
	private Node targetNode;

	Tree(Node root) {
		this.root = root;
		this.targetNode = root;
	}

	public Node getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void moveUp() {
		if (getTargetNode() == getRoot())
			return;
		else if (getTargetNode().getParent() == getRoot())
			setTargetNode(getRoot());
		else if (getTargetNode().getParent() == null)
			setTargetNode(getRoot());
		else
			setTargetNode(getTargetNode().getParent());
	}

	public void moveDown(String target) {
		for (Node c : getTargetNode().getChildren()) {
			if (c.getName().equals(target)) {
				setTargetNode(c);
			}
		}
	}

	public void moveToTopDirectory() {
		setTargetNode(getRoot());
	}

	public void listChildren() {
		if (getTargetNode() == null)
			return;
		else
			listChildren(getTargetNode());
	}

	public void listChildren(Node n) {
		if (n == null)
			return;
		System.out.println(n);
		for (Node c : n.getChildren()) {
			if (c.isDirectory()) {
				System.out.println("\t");
				listChildren(c);
			} else
				System.out.println("\t" + c);
		}
	}

	public void appendFile(Node n) {
		getTargetNode().addChild(n);
	}
	
	public int solvePartOne() {
		int total = 0;
		System.out.println(getRoot().getChildren());
		for(Node c: getRoot().getChildren()) {
			if(c.isDirectory()) {
				int subtotal = 0;
				for(Node child: c.getChildren()) {
					subtotal += child.getSize();
				}
				
				total += subtotal;
			}
		}
		
		return total;
	}
	
	

}
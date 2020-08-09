package chapter2.data_structure.tree;

public class FindNextNode {
	public LinkTreeNode middleFindNext(LinkTreeNode treeNode) {
		LinkTreeNode next = null;
		
		if (treeNode.right != null) {
			next = treeNode.right;
			
			while (next.left != null) {
				next = next.left;
			} 
			
			return next;
		}
		
		if (treeNode.parent == null) {
			return null;
		}
		
		next = treeNode;
		
		while (next.parent != null && next.parent.left != next) {
			next = next.parent;
		}
		
		next = next.parent;
		return next;
	}
	
	public static void main(String[] args) {
		LinkTreeNode a = new LinkTreeNode('a');
		LinkTreeNode b = new LinkTreeNode('b');
		a.left = b;
		b.parent = a;
		LinkTreeNode c = new LinkTreeNode('c');
		a.right = c;
		c.parent = a;
		LinkTreeNode d = new LinkTreeNode('d');
		b.left = d;
		d.parent = b;
		LinkTreeNode e = new LinkTreeNode('e');
		b.right = e;
		e.parent = b;
		LinkTreeNode f = new LinkTreeNode('f');
		c.left = f;
		f.parent = c;
		LinkTreeNode g = new LinkTreeNode('g');
		c.right = g;
		g.parent = c;
		LinkTreeNode h = new LinkTreeNode('h');
		e.left = h;
		h.parent = e;
		LinkTreeNode i = new LinkTreeNode('i');
		e.right = i;
		i.parent = e;
		
		LinkTreeNode next = new FindNextNode().middleFindNext(f);
		
		if (next != null) {
			System.out.println(next.data);
		} else {
			System.out.println("null");
		}
		
	}
}

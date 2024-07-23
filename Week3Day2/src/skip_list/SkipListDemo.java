package skip_list;

// Skip List: a data structure that allows for fast search within an ordered sequence of
// elements.  It consists consists of multiple layers of Linked Lists, each higher layer
// acting as an express lane for the elements below.

public class SkipListDemo {

	public static void main(String[] args) {
		SkipList skipList = new SkipList();
		skipList.insert(3);
		skipList.insert(6);
		skipList.insert(7);
		skipList.insert(9);
		skipList.insert(12);
		skipList.insert(19);
		skipList.insert(17);
		skipList.insert(26);
		skipList.insert(21);
		skipList.insert(25);
		
		skipList.display();	
		
		System.out.println("Does it contain 19?: " + skipList.search(19));
		System.out.println("Does it contain 15?: " + skipList.search(15));
	}

}

class SkipListNode {
	private int value;
	SkipListNode[] forward;
	
	public SkipListNode(int value, int level) {
		this.value = value;
		this.forward = new SkipListNode[level + 1];
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}

class SkipList {
	private static final double P = 0.5;
	private static final int MAX_LEVEL = 16;
	private int level;
	private SkipListNode head;
	
	
	public SkipList() {
		this.level = 0;
		this.head = new SkipListNode(-1, MAX_LEVEL);
	}
	
	private int randomLevel() {
		int lvl = 0;
		while(Math.random() < P && lvl < MAX_LEVEL) {
			lvl++;
		}
		return lvl;
	}
	
	// O(log(n))
	public void insert(int value) {
		SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
		SkipListNode x = head;
		for (int i = level; i >= 0; i--) {
			while(x.forward[i] != null && x.forward[i].getValue() < value) {
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];
		if (x == null || x.getValue() != value) {
			int lvl = randomLevel();
			if (lvl > level) {
				for (int i = level + 1; i <= lvl; i++) {
					update[i] = head;
				}
				level = lvl;
			}
			x = new SkipListNode(value, lvl);
			for (int i = 0; i <= lvl; i++) {
				x.forward[i] = update[i].forward[i];
				update[i].forward[i] = x;
			}
		}
	}
	
	public boolean search(int value) {
		SkipListNode x = head;
		for (int i = level; i >= 0; i--) {
			while (x.forward[i] != null && x.forward[i].getValue() < value) {
				x = x.forward[i];
			}
		}
		x = x.forward[0];
		return x != null && x.getValue() == value;
	}
	
	public void display() {
		for (int i = level; i >= 0; i--) {
			SkipListNode node = head.forward[i];
			System.out.print("Level " + i + ": ");
			while (node != null) {
				System.out.print(node.getValue() + " ");
				node = node.forward[i];
			}
			System.out.println();
		}
	}
}












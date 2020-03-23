package team.tygy.SG.snake;
/**
 * 
 * @ClassName: SnakeNode
 * @Description: TODO �����ߵĽڵ�
 * @author ��˼��
 * @date 2020��3��19��-����11:10:32
 * @version 1.0
 *
 */
public class SnakeNode {
	
	private int x;									//�ڵ��x����
	private int y;									//�ڵ��y����
	private int size;								//�ڵ�Ĵ�С
	private int dir;								//�ڵ�ķ���
	private SnakeNode pre;							//�ڵ��ǰ��
	private SnakeNode next;							//�ڵ�ĺ��
	
	
	/**
	 * 
	 * @Title: SnakeNode
	 * @Description: TODO ��ʼ��
	 * @param:  @param x
	 * @param:  @param y
	 * @param:  @param dir
	 * @throws
	 */
	public SnakeNode(int x,int y,int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public SnakeNode getPre() {
		return pre;
	}

	public void setPre(SnakeNode pre) {
		this.pre = pre;
	}

	public SnakeNode getNext() {
		return next;
	}
	public void setNext(SnakeNode next) {
		this.next = next;
	}
}

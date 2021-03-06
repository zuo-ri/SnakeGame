package com.tygy.snake;
/**
 * 
 * @ClassName: SnakeNode
 * @Description: TODO 定义蛇的节点
 * @author 陈思祥
 * @date 2020年3月19日-下午11:10:32
 * @version 1.0
 *
 */
public class SnakeNode {
	
	private int x;									//节点的x坐标
	private int y;									//节点的y坐标
	private int size;								//节点的大小
	private int dir;								//节点的方向
	private SnakeNode pre;							//节点的前驱
	private SnakeNode next;							//节点的后继
	
	
	/**
	 * 
	 * @Title: SnakeNode
	 * @Description: TODO 初始化
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

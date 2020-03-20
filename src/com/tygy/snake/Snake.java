package com.tygy.snake;

import static com.tygy.util.ConstantUtil.DOWN;
import static com.tygy.util.ConstantUtil.LEFT;
import static com.tygy.util.ConstantUtil.RIGHT;
import static com.tygy.util.ConstantUtil.SNAKE_CELL_SIZE;
import static com.tygy.util.ConstantUtil.SNAKE_GRID_H;
import static com.tygy.util.ConstantUtil.SNAKE_GRID_W;
import static com.tygy.util.ConstantUtil.UP;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
/**
 * 
 * @ClassName: Snake
 * @Description: TODO 定义蛇的属性和方法
 * @author 陈思祥
 * @date 2020年3月19日-下午11:11:35
 * @version 1.0
 *
 */
public class Snake {

	private LinkedList<SnakeNode> body = new LinkedList<SnakeNode>();			//存储蛇的链表结构
	private boolean life;														//是否活着
	private boolean pause;														//是否暂停游戏
	private int foodCount;														//吃掉食物的数量
	private SnakeNode oldTail;													//旧的尾巴（在吃掉食物的时候使用）
	private Color headColor;													//头的颜色
	private Color bodyColor;													//身体的颜色
	private int sleepTime;														//控制蛇的速度
	
	
	/**
	 * 
	 * @Title: Snake
	 * @Description: TODO  在构造方法中初始化
	 * @param:  
	 * @throws
	 */
	public Snake() {
		init();
	}
	
	
	/**
	 * 
	 * @Title: init 
	 * @Description: TODO 初始化
	 * @param  
	 * @return void
	 * @throws
	 */
	private void init() {
		int x = SNAKE_GRID_W>>1;												//相当于SNAKE_GRID_W/2
		int y = SNAKE_GRID_H>>1;												//相当于SNAKE_GRID_H/2
		for (int i = 0; i < 3; i++) {
			body.addLast(new SnakeNode(x, y, RIGHT));
			x--;
		}
		foodCount = 0;
		life = true;
		pause = false;
		if(sleepTime==0) {
			sleepTime = 300;
		}
	}
	
	
	/**
	 * 
	 * @Title: clear 
	 * @Description: TODO 清空蛇的节点的方法（用来开始一次新的游戏）
	 * @param  
	 * @return void
	 * @throws
	 */
	public void clear() {
		body.clear();
	}
	
	
	/**
	 * 
	 * @Title: die 
	 * @Description: TODO 蛇死掉的方法
	 * @param  
	 * @return void
	 * @throws
	 */
	public void die() {
		life = false;
	}
	
	
	/**
	 * 
	 * @Title: getHead 
	 * @Description: TODO 获取代表蛇头的节点
	 * @param  @return
	 * @return SnakeNode
	 * @throws
	 */
	public SnakeNode getHead() {
		return body.getFirst();
	}
	
	
	/**
	 * 
	 * @Title: move 
	 * @Description: TODO 蛇移动的方法，通过去尾加头的方法实现蛇的移动
	 * @param  
	 * @return void
	 * @throws
	 */
	public void move() {
		oldTail = body.removeLast();											//去掉尾节点
		int x = body.getFirst().getX();
		int y = body.getFirst().getY();
		switch (body.getFirst().getDir()) {
		case UP:
			y--;
			/**
			 * 解决越界问题，以下类同
			 */
			if(y<0) {
				y = SNAKE_GRID_H -1;
			}
			break;
		case DOWN:
			y++;
			if(y >= SNAKE_GRID_H) {
				y = 0;
			}
			break;
		case LEFT:
			x--;
			if(x < 0) {
				x = SNAKE_GRID_W -1;
			}
			break;
		case RIGHT:
			x++;
			if(x >= SNAKE_GRID_W) {
				x = 0;
			}
			break;
		}
		SnakeNode newhead = new SnakeNode(x, y, body.getFirst().getDir());
		body.addFirst(newhead);													//增加头结点
	}
	
	
	/**
	 * 
	 * @Title: eatFood 
	 * @Description: TODO 蛇吃到食物后身体变长
	 * @param  
	 * @return void
	 * @throws
	 */
	public void eatFood() {		
		body.addLast(oldTail);
		foodCount++;
	}
	
	
	/**
	 * 
	 * @Title: isEatBody 
	 * @Description: TODO 判断蛇是否吃到了自己的身体
	 * @param  @return
	 * @return boolean
	 * @throws
	 */
	public boolean isEatBody() {
		for(int i=1;i<body.size();i++) {
			if(body.get(i).getX() == getHead().getX() && body.get(i).getY() == getHead().getY()) 
				return true;
		}	
			return false;	
	}
	
	
	/**
	 * 
	 * @Title: paintHead 
	 * @Description: TODO 画蛇头
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	public void paintHead(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(body.getFirst().getX()*SNAKE_CELL_SIZE, body.getFirst().getY()*SNAKE_CELL_SIZE,
				SNAKE_CELL_SIZE, SNAKE_CELL_SIZE);
	}
	
	
	/**
	 * 
	 * @Title: paintSnake 
	 * @Description: TODO 画蛇
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	public void paintSnake(Graphics g) {
		for (int i = 1; i < body.size(); i++) {
			g.setColor(Color.RED);
			g.fillRect(body.get(i).getX()*SNAKE_CELL_SIZE, body.get(i).getY()*SNAKE_CELL_SIZE, 
					SNAKE_CELL_SIZE, SNAKE_CELL_SIZE);
		}
		paintHead(g);
	}	
	
	
	public boolean isLife() {
		return life;
	}
	public void setLife(boolean life) {
		this.life = life;
	}
	public boolean isPause() {
		return pause;
	}
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	public Color getHeadColor() {
		return headColor;
	}
	public void setHeadColor(Color headColor) {
		this.headColor = headColor;
	}
	public Color getBodyColor() {
		return bodyColor;
	}
	public void setBodyColor(Color bodyColor) {
		this.bodyColor = bodyColor;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public SnakeNode getOldTail() {
		return oldTail;
	}
	public void setOldTail(SnakeNode oldTail) {
		this.oldTail = oldTail;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
}

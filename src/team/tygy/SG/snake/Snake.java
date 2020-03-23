package team.tygy.SG.snake;

import static team.tygy.SG.util.ConstantUtil.DOWN;
import static team.tygy.SG.util.ConstantUtil.LEFT;
import static team.tygy.SG.util.ConstantUtil.RIGHT;
import static team.tygy.SG.util.ConstantUtil.SNAKE_CELL_SIZE;
import static team.tygy.SG.util.ConstantUtil.SNAKE_GRID_H;
import static team.tygy.SG.util.ConstantUtil.SNAKE_GRID_W;
import static team.tygy.SG.util.ConstantUtil.UP;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
/**
 * 
 * @ClassName: Snake
 * @Description: TODO �����ߵ����Ժͷ���
 * @author ��˼��
 * @date 2020��3��19��-����11:11:35
 * @version 1.0
 *
 */
public class Snake {

	private LinkedList<SnakeNode> body = new LinkedList<SnakeNode>();			//�洢�ߵ�����ṹ
	private boolean life;														//�Ƿ����
	private boolean pause;														//�Ƿ���ͣ��Ϸ
	private int foodCount;														//�Ե�ʳ�������
	private SnakeNode oldTail;													//�ɵ�β�ͣ��ڳԵ�ʳ���ʱ��ʹ�ã�
	private Color headColor;													//ͷ����ɫ
	private Color bodyColor;													//�������ɫ
	private int sleepTime;														//�����ߵ��ٶ�
	
	
	/**
	 * 
	 * @Title: Snake
	 * @Description: TODO  �ڹ��췽���г�ʼ��
	 * @param:  
	 * @throws
	 */
	public Snake() {
		init();
	}
	
	
	/**
	 * 
	 * @Title: init 
	 * @Description: TODO ��ʼ��
	 * @param  
	 * @return void
	 * @throws
	 */
	private void init() {
		int x = SNAKE_GRID_W>>1;												//�൱��SNAKE_GRID_W/2
		int y = SNAKE_GRID_H>>1;												//�൱��SNAKE_GRID_H/2
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
	 * @Description: TODO ����ߵĽڵ�ķ�����������ʼһ���µ���Ϸ��
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
	 * @Description: TODO �������ķ���
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
	 * @Description: TODO ��ȡ������ͷ�Ľڵ�
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
	 * @Description: TODO ���ƶ��ķ�����ͨ��ȥβ��ͷ�ķ���ʵ���ߵ��ƶ�
	 * @param  
	 * @return void
	 * @throws
	 */
	public void move() {
		oldTail = body.removeLast();											//ȥ��β�ڵ�
		int x = body.getFirst().getX();
		int y = body.getFirst().getY();
		switch (body.getFirst().getDir()) {
		case UP:
			y--;
			/**
			 * ���Խ�����⣬������ͬ
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
		body.addFirst(newhead);													//����ͷ���
	}
	
	
	/**
	 * 
	 * @Title: eatFood 
	 * @Description: TODO �߳Ե�ʳ�������䳤
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
	 * @Description: TODO �ж����Ƿ�Ե����Լ�������
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
	 * @Description: TODO ����ͷ
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
	 * @Description: TODO ����
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

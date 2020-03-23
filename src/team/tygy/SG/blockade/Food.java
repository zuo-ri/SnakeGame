package team.tygy.SG.blockade;

import static team.tygy.SG.util.ConstantUtil.*;

import java.awt.Color;
import java.awt.Graphics;

import team.tygy.SG.snake.Snake;
import team.tygy.SG.util.MyUtil;
/**
 * 
 * @ClassName: Food
 * @Description: TODO ����ʳ������Ժͷ���
 * @author ��˼��
 * @date 2020��3��19��-����11:12:30
 * @version 1.0
 *
 */
public class Food {
	
	private int size;							//ʳ��ĳߴ�
	private int x;								//ʳ���λ��x
	private int y;								//ʳ���λ��y
	private Color color;						//ʳ�����ɫ
	private int type;							//ʳ�������
	
	
	/**
	 * 
	 * @Title: Food
	 * @Description: TODO  �ڹ��췽���г�ʼ��
	 * @param:  
	 * @throws
	 */
	public Food() {
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
		size = FOOD_SIZE;
		x = MyUtil.getRandomNumber(0,SNAKE_GRID_W);
		y = MyUtil.getRandomNumber(0, SNAKE_GRID_H);
		color = MyUtil.getRandomColor();
	}
	
	
	/**
	 * 
	 * @Title: paint 
	 * @Description: TODO ��ʳ��
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x*FOOD_SIZE, y*FOOD_SIZE, FOOD_SIZE, FOOD_SIZE);
	}

	
	/**
	 * 
	 * @Title: isFoodEated 
	 * @Description: TODO 
	 * @param  @param snake
	 * @param  @return
	 * @return boolean
	 * @throws
	 */
	public boolean isFoodEated(Snake snake) {
		int distance =  MyUtil.distance(snake.getHead().getX()*SNAKE_CELL_SIZE,
				snake.getHead().getY()*SNAKE_CELL_SIZE,
				getX()*FOOD_SIZE,
				getY()*FOOD_SIZE);
		int dis = (SNAKE_CELL_SIZE + FOOD_SIZE)>>1;
		if(distance < dis) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @Title: newFood 
	 * @Description: TODO ��������һ��ʳ��
	 * @param  @param food
	 * @return void
	 * @throws
	 */
	public void newFood(Food food) {
		setX(MyUtil.getRandomNumber(0, SNAKE_GRID_W));
		setY(MyUtil.getRandomNumber(0, SNAKE_GRID_H));
		setColor(MyUtil.getRandomColor());
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}

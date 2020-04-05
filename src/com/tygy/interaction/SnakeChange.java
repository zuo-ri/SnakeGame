package com.tygy.interaction;

import static com.tygy.util.ConstantUtil.DOWN;
import static com.tygy.util.ConstantUtil.LEFT;
import static com.tygy.util.ConstantUtil.RIGHT;
import static com.tygy.util.ConstantUtil.UP;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.tygy.role.Food;
import com.tygy.snake.Snake;

/**
 * @ClassName: SnakeChange
 * @Description: TODO
 * @author ��˼��
 * @date 2020��3��20��-����4:48:54
 * @version 1.0
 * 
 */
public class SnakeChange implements KeyListener{

	private Snake snake;
	private Food food;
	
	
	public SnakeChange(Snake snake,Food food) {
		this.snake = snake;
		this.food = food;
	}
	
	
	/**
	 * 
	 * @ClassName: SnakeDriver
	 * @Description: TODO �������ƶ����߳��ڲ���
	 * @author ��˼��
	 * @date 2020��3��20��-����12:04:15
	 * @version 1.0
	 *
	 */
	private class SnakeDriver implements Runnable {
		public void run() {
			while(snake.isLife()) {
				if(snake.isPause() == false) {
					if(food.isFoodEated(snake)) {
						snake.eatFood();
						food.newFood(food);
					}
					if(snake.isEatBody()) {
						snake.die();
					}
					snake.move();
				}
				try {	
					Thread.sleep(snake.getSleepTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @Title: begin 
	 * @Description: TODO �����̵߳ķ���
	 * @param  
	 * @return void
	 * @throws
	 */
	public void begin() {
		new Thread(new SnakeDriver()).start();
	}
	
	
	/**
	 * ���̼���
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_A :
			/**
			 * ����仯ʱ�߲��ܻ�ͷ��������ͬ
			 */
			if(snake.getHead().getDir() != RIGHT){
				snake.getHead().setDir(LEFT);
				}		
				
			
			break;
		case KeyEvent.VK_W :
			if(snake.getHead().getDir() != DOWN){
				snake.getHead().setDir(UP);
				}
			
			
			break;
		case KeyEvent.VK_D :
			if(snake.getHead().getDir() != LEFT){
				snake.getHead().setDir(RIGHT);
				}
			
			
			break;
		case KeyEvent.VK_S :
			if(snake.getHead().getDir() != UP){
				snake.getHead().setDir(DOWN);
				}
				
			
			break;
		case KeyEvent.VK_SPACE :
				/**
				 * ͨ��ȡԭ��״̬���෴��״̬��������Ϸ����ͣ�Ϳ�ʼ
				 * ע�⣺ֱ�Ӹ�ֵֻ�ܲ���һ��״̬����Ϸ��ͣ��ʼ
				 */
				snake.setPause(!snake.isPause());
			break;
			//����U����
		case KeyEvent.VK_U :
			if(snake.getSleepTime()!=50)
				snake.setSleepTime(50);
			break;
			//����I����
		case KeyEvent.VK_I :
			if(snake.getSleepTime()!=500)
				snake.setSleepTime(500);
			break;
		}		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		//�ͷ�U���ԭ�����ٶ�
		case KeyEvent.VK_U :			
				snake.setSleepTime(300);
			break;
		//�ͷ�I���ԭ�����ٶ�
		case KeyEvent.VK_I :			
				snake.setSleepTime(300);
			break;			
		}
		
		//TODO
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

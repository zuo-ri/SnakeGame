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
 * @author 陈思祥
 * @date 2020年3月20日-下午4:48:54
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
	 * @Description: TODO 控制蛇移动的线程内部类
	 * @author 陈思祥
	 * @date 2020年3月20日-上午12:04:15
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
	 * @Description: TODO 启动线程的方法
	 * @param  
	 * @return void
	 * @throws
	 */
	public void begin() {
		new Thread(new SnakeDriver()).start();
	}
	
	
	/**
	 * 键盘监听
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_A :
			/**
			 * 方向变化时蛇不能回头，以下类同
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
				 * 通过取原来状态的相反的状态，控制游戏的暂停和开始
				 * 注意：直接赋值只能产生一种状态：游戏暂停或开始
				 */
				snake.setPause(!snake.isPause());
			break;
			//按下U加速
		case KeyEvent.VK_U :
			if(snake.getSleepTime()!=50)
				snake.setSleepTime(50);
			break;
			//按下I减速
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
		//释放U变回原来的速度
		case KeyEvent.VK_U :			
				snake.setSleepTime(300);
			break;
		//释放I变回原来的速度
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

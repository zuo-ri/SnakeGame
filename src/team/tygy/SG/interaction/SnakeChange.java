package team.tygy.SG.interaction;

import static team.tygy.SG.util.ConstantUtil.DOWN;
import static team.tygy.SG.util.ConstantUtil.LEFT;
import static team.tygy.SG.util.ConstantUtil.RIGHT;
import static team.tygy.SG.util.ConstantUtil.UP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import team.tygy.SG.blockade.Food;
import team.tygy.SG.snake.Snake;

/**
 * @ClassName: SnakeChange
 * @Description: TODO ���������ƶ������з�������
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
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//TODO
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

package team.tygy.SG.ui;

import static team.tygy.SG.util.ConstantUtil.GAME_JPANEL_H;
import static team.tygy.SG.util.ConstantUtil.GAME_JPANEL_W;
import static team.tygy.SG.util.ConstantUtil.SNAKE_CELL_SIZE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import team.tygy.SG.blockade.Food;
import team.tygy.SG.interaction.SnakeChange;
import team.tygy.SG.snake.Snake;
/**
 * 
 * @ClassName: GameJPanel
 * @Description: TODO ������Ϸ�����
 * @author ��˼��
 * @date 2020��3��19��-����11:07:21
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private Food food = new Food();
	private Snake snake =new Snake();
	private SnakeChange change = new SnakeChange(snake, food);
	
	/**
	 * 
	 * @Title: GamePanel
	 * @Description: TODO  �ڹ��췽���г�ʼ��
	 * @param:  
	 * @throws
	 */
	public GamePanel() {
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
		this.setFocusable(true);					//��ý���
		this.addKeyListener(change);				//���̼���
		change.begin();								//�����ߵ��߳�
	}


	/**
	 * ��Ϸ���л��ƵĲ��ֶ�Ҫ�ٴ˵���
	 */
	public void paint(Graphics g) {
		super.paint(g);
		paintBackground(g);							//����Ϸ��
		paintGrid(g);								//������
		snake.paintSnake(g);						//����
		food.paint(g);								//��ʳ��
		
		if(snake.isLife() == false) {
			gameOver(g);
		}
		repaint();
	}
	
	
	/**
	 * 
	 * @Title: paintBackground 
	 * @Description: TODO ����Ϸ���ı���
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	private void paintBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GAME_JPANEL_W, GAME_JPANEL_H);
	}
	
	
	/**
	 * 
	 * @Title: paintGrid 
	 * @Description: TODO �ڱ����ϻ�����
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	private void paintGrid(Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i < GAME_JPANEL_W/20; i++) {
			g.drawLine(i*SNAKE_CELL_SIZE, 0, i*SNAKE_CELL_SIZE, GAME_JPANEL_H);
		}
		for (int i = 0; i < GAME_JPANEL_H/20; i++) {
			g.drawLine(0, i*SNAKE_CELL_SIZE, GAME_JPANEL_W, i*SNAKE_CELL_SIZE);
		}
	}
	
	
	/**
	 * 
	 * @Title: gameOver 
	 * @Description: TODO ��ʾ��Ϸ����
	 * @param  @param g
	 * @return void
	 * @throws
	 */
	public void gameOver(Graphics g) {
		paintBackground(g);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Serif",Font.BOLD,50));
		g.drawString("Game Over", GAME_JPANEL_W/2-125, GAME_JPANEL_H/2+10);			
	}


	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
}

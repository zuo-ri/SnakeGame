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
 * @Description: TODO 创建游戏的面板
 * @author 陈思祥
 * @date 2020年3月19日-下午11:07:21
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
	 * @Description: TODO  在构造方法中初始化
	 * @param:  
	 * @throws
	 */
	public GamePanel() {
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
		this.setFocusable(true);					//获得焦点
		this.addKeyListener(change);				//键盘监听
		change.begin();								//启动蛇的线程
	}


	/**
	 * 游戏所有绘制的部分都要再此调用
	 */
	public void paint(Graphics g) {
		super.paint(g);
		paintBackground(g);							//画游戏区
		paintGrid(g);								//画网格
		snake.paintSnake(g);						//画蛇
		food.paint(g);								//画食物
		
		if(snake.isLife() == false) {
			gameOver(g);
		}
		repaint();
	}
	
	
	/**
	 * 
	 * @Title: paintBackground 
	 * @Description: TODO 画游戏面板的背景
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
	 * @Description: TODO 在背景上画网格
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
	 * @Description: TODO 显示游戏结束
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

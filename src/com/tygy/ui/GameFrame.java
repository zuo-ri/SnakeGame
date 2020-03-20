package com.tygy.ui;

import static com.tygy.util.ConstantUtil.GAME_FRAME_H;
import static com.tygy.util.ConstantUtil.GAME_FRAME_POSITION_X;
import static com.tygy.util.ConstantUtil.GAME_FRAME_POSITION_Y;
import static com.tygy.util.ConstantUtil.GAME_FRAME_W;
import static com.tygy.util.ConstantUtil.GAME_TITLE;

import java.awt.Insets;

import javax.swing.JFrame;
/**
 * 
 * @ClassName: GameFrame
 * @Description: TODO 生成一个游戏窗口
 * @author 陈思祥
 * @date 2020年3月19日-下午11:05:25
 * @version 1.0
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class GameFrame extends JFrame{
	
	private GameJPanel panel = new GameJPanel();
	
	/**
	 * 
	 * @Title: GameFrame
	 * @Description: TODO  在构造方法中初始化
	 * @param:  
	 * @throws
	 */
	public GameFrame() {
		initFrame();
	}
	

	/** 
	 * @Title: initFrame 
	 * @Description: TODO 初始化窗口
	 * @param  
	 * @return void
	 * @throws 
	*/
	private void initFrame() {
		JFrame frame = new JFrame(GAME_TITLE);										//绘制一个静态窗口并添加标题
		frame.setBounds(GAME_FRAME_POSITION_X, GAME_FRAME_POSITION_Y,				//设置窗口的位置和大小
				GAME_FRAME_W, GAME_FRAME_H);	
		frame.setResizable(false);													//设置窗口大小不可改变
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//设置关闭窗口事件
		frame.add(panel);															//显示面板
		frame.setVisible(true);														//显示窗口
		
		
		//获取JFrame中菜单栏、边框
/*		Insets i = frame.getInsets();
		System.out.println("菜单栏的高度为："+i.top);
		System.out.println("JFrame左边框的宽度："+i.left);
		System.out.println("JFrame右边框的宽度："+i.right);
		System.out.println("JFrame下边框的宽度："+i.bottom);*/
	}
}

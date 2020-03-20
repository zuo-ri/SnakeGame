package com.tygy.util;
/**
 * 
 * @ClassName: ConstantUtil
 * @Description: TODO 包含所有的字面常量，方便修改
 * @author 陈思祥
 * @date 2020年3月19日-下午11:07:46
 * @version 1.0
 *
 */
public class ConstantUtil {

	public static final String GAME_TITLE = "贪吃蛇大作战";					//标题
	
	public static final int GAME_FRAME_POSITION_X = 445;					//窗口的位置X
	public static final int GAME_FRAME_POSITION_Y = 120;					//窗口的位置Y
	public static final int GAME_FRAME_BORDER_TOP = 32;						//菜单栏的宽度
	public static final int GAME_FRAME_BORDER_BOTTOM = 3;					//下边框的宽度
	public static final int GAME_FRAME_BORDER_LEFT = 3;						//左边框的宽度
	public static final int GAME_FRAME_BORDER_RIGHT = 3;					//右边框的宽度
	
	public static final int GAME_JPANEL_W = 800;							//游戏面板的宽度
	public static final int GAME_JPANEL_H = 600;							//游戏面板的高度
	
	public static final int GAME_FRAME_W = GAME_JPANEL_W + 					//窗口的宽度
			GAME_FRAME_BORDER_LEFT + GAME_FRAME_BORDER_RIGHT;			
	public static final int GAME_FRAME_H = GAME_JPANEL_H + 					//窗口的高度
			GAME_FRAME_BORDER_TOP + GAME_FRAME_BORDER_BOTTOM;
	
	public static final int SNAKE_CELL_SIZE = 20;							//蛇节点的尺寸
	public static final int SNAKE_GRID_W = GAME_JPANEL_W/20;				//列的数量
	public static final int SNAKE_GRID_H = GAME_JPANEL_H/20;				//行的数量

	public static final int UP    = 1;										//定义蛇的方向常量
	public static final int DOWN  = -1;										//定义蛇的方向常量
	public static final int LEFT  = 2;										//定义蛇的方向常量
	public static final int RIGHT = -2;										//定义蛇的方向常量
	
	public static final int FOOD_SIZE = 20;									//食物的尺寸
}

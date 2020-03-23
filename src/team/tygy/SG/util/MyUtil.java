package team.tygy.SG.util;

import java.awt.Color;
/**
 * 
 * @ClassName: RandomUtil
 * @Description: TODO 生成随机数
 * @author 陈思祥
 * @date 2020年3月19日-下午11:09:49
 * @version 1.0
 *
 */
public class MyUtil {

	/**
	 * 
	 * @Title: getRandomNumber 
	 * @Description: TODO 获得一定范围内的随机值
	 * @param  @param min
	 * @param  @param max
	 * @param  @return
	 * @return int
	 * @throws
	 */
	public static int getRandomNumber(int min,int max) {
		return (int)(Math.random()*(max - min) + min);
	}
	
	
	/**
	 * 随机颜色数组
	 */
	private static Color[] colors = {
			Color.WHITE,
			Color.GREEN,
			Color.PINK,
			Color.BLUE,
			Color.PINK,
			Color.ORANGE,
			Color.RED,
			Color.YELLOW,
			Color.CYAN,
			Color.GRAY
	};
	
	
	/**
	 * 
	 * @Title: getRandomColor 
	 * @Description: TODO 得到随机颜色
	 * @param  @return
	 * @return Color
	 * @throws
	 */
	public static Color getRandomColor() {
		return colors[getRandomNumber(0, colors.length)];
	}
	
	
	/**
	 * 
	 * @Title: distance 
	 * @Description: TODO 计算两点之间的距离
	 * @param  @param x0
	 * @param  @param y0
	 * @param  @param x1
	 * @param  @param y1
	 * @param  @return
	 * @return int
	 * @throws
	 */
	public static int distance(int x0,int y0, int x1,int y1) {
		int disX = x0 - x1;
		int disY = y0 - y1;
		return (int)Math.sqrt(disX * disX + disY * disY);
	}
}

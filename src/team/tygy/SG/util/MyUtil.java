package team.tygy.SG.util;

import java.awt.Color;
/**
 * 
 * @ClassName: RandomUtil
 * @Description: TODO ���������
 * @author ��˼��
 * @date 2020��3��19��-����11:09:49
 * @version 1.0
 *
 */
public class MyUtil {

	/**
	 * 
	 * @Title: getRandomNumber 
	 * @Description: TODO ���һ����Χ�ڵ����ֵ
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
	 * �����ɫ����
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
	 * @Description: TODO �õ������ɫ
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
	 * @Description: TODO ��������֮��ľ���
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

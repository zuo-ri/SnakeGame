package team.tygy.SG.util;
/**
 * 
 * @ClassName: ConstantUtil
 * @Description: TODO �������е����泣���������޸�
 * @author ��˼��
 * @date 2020��3��19��-����11:07:46
 * @version 1.0
 *
 */
public class ConstantUtil {

	public static final String GAME_TITLE = "̰���ߴ���ս";					//����
	
	public static final int GAME_FRAME_POSITION_X = 445;					//���ڵ�λ��X
	public static final int GAME_FRAME_POSITION_Y = 120;					//���ڵ�λ��Y
	public static final int GAME_FRAME_BORDER_TOP = 32;						//�˵����Ŀ��
	public static final int GAME_FRAME_BORDER_BOTTOM = 3;					//�±߿�Ŀ��
	public static final int GAME_FRAME_BORDER_LEFT = 3;						//��߿�Ŀ��
	public static final int GAME_FRAME_BORDER_RIGHT = 3;					//�ұ߿�Ŀ��
	
	public static final int GAME_JPANEL_W = 800;							//��Ϸ���Ŀ��
	public static final int GAME_JPANEL_H = 600;							//��Ϸ���ĸ߶�
	
	public static final int GAME_FRAME_W = GAME_JPANEL_W + 					//���ڵĿ��
			GAME_FRAME_BORDER_LEFT + GAME_FRAME_BORDER_RIGHT;			
	public static final int GAME_FRAME_H = GAME_JPANEL_H + 					//���ڵĸ߶�
			GAME_FRAME_BORDER_TOP + GAME_FRAME_BORDER_BOTTOM;
	
	public static final int SNAKE_CELL_SIZE = 20;							//�߽ڵ�ĳߴ�
	public static final int SNAKE_GRID_W = GAME_JPANEL_W/20;				//�е�����
	public static final int SNAKE_GRID_H = GAME_JPANEL_H/20;				//�е�����

	public static final int UP    = 1;										//�����ߵķ�����
	public static final int DOWN  = -1;										//�����ߵķ�����
	public static final int LEFT  = 2;										//�����ߵķ�����
	public static final int RIGHT = -2;										//�����ߵķ�����
	
	public static final int FOOD_SIZE = 20;									//ʳ��ĳߴ�
}

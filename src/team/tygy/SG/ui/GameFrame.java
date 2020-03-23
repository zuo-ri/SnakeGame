package team.tygy.SG.ui;

import static team.tygy.SG.util.ConstantUtil.GAME_FRAME_H;
import static team.tygy.SG.util.ConstantUtil.GAME_FRAME_POSITION_X;
import static team.tygy.SG.util.ConstantUtil.GAME_FRAME_POSITION_Y;
import static team.tygy.SG.util.ConstantUtil.GAME_FRAME_W;
import static team.tygy.SG.util.ConstantUtil.GAME_TITLE;
import static team.tygy.SG.util.ImagesUtil.frame_icon;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 
 * @ClassName: GameFrame
 * @Description: TODO ����һ����Ϸ����
 * @author ��˼��
 * @date 2020��3��19��-����11:05:25
 * @version 1.0
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class GameFrame extends JFrame{
	
	private GamePanel panel = new GamePanel();
	
	/**
	 * 
	 * @Title: GameFrame
	 * @Description: TODO  �ڹ��췽���г�ʼ��
	 * @param:  
	 * @throws
	 */
	public GameFrame() {
		initFrame();
	}
	

	/** 
	 * @Title: initFrame 
	 * @Description: TODO ��ʼ������
	 * @param  
	 * @return void
	 * @throws 
	*/
	private void initFrame() {
		JFrame frame = new JFrame(GAME_TITLE);										//����һ����̬���ڲ���ӱ���
		frame.setIconImage(frame_icon);												//�޸Ĵ��ڵ�logo
		frame.setBounds(GAME_FRAME_POSITION_X, GAME_FRAME_POSITION_Y,				//���ô��ڵ�λ�úʹ�С
				GAME_FRAME_W, GAME_FRAME_H);	
		frame.setResizable(false);													//���ô��ڴ�С���ɸı�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//���ùرմ����¼�
		frame.add(panel);															//��ʾ���
		frame.setVisible(true);														//��ʾ����
		
		
		//��ȡJFrame�в˵������߿�
/*		Insets i = frame.getInsets();
		System.out.println("�˵����ĸ߶�Ϊ��"+i.top);
		System.out.println("JFrame��߿�Ŀ�ȣ�"+i.left);
		System.out.println("JFrame�ұ߿�Ŀ�ȣ�"+i.right);
		System.out.println("JFrame�±߿�Ŀ�ȣ�"+i.bottom);*/
	}
}

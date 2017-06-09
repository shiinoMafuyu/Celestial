package com.celestial.agniRadiance.EzUtil;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *						---- wangzg 2017��5��27��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Util_UI {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * һЩui������Ϣ��
	 * </ul>
	 * @return
	 */
	public static String storage(){
		JFileChooser chooser = new JFileChooser(); //����ѡ���ļ�����
		chooser.setDialogTitle("��ѡ���ļ���");//���ñ���
//		chooser.setMultiSelectionEnabled(true);  //����ֻ��ѡ���ļ�
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg");//�����ѡ���ļ�����
//		chooser.setFileFilter(filter); //���ÿ�ѡ���ļ�����
		chooser.showOpenDialog(null); //��ѡ���ļ��Ի���,null������Ϊ�㵱ǰ�Ĵ���JFrame��Frame
		File file = chooser.getSelectedFile(); //fileΪ�û�ѡ���ͼƬ�ļ�
		System.out.println(file.getAbsolutePath());
//		panel.add(chooser);
		return Util_String.fmtPathStr(file.getAbsolutePath());
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ѡ��Ŀ¼��<br/>
	 * </ul>
	 * @return 
	 */
	public static String chooseDirctory() {
		JFileChooser chooser = new JFileChooser(); //����ѡ���ļ�����
		chooser.setDialogTitle("��ѡ���ļ���");//���ñ���
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(null); //��ѡ���ļ��Ի���,null������Ϊ�㵱ǰ�Ĵ���JFrame��Frame
		File file = chooser.getSelectedFile(); //fileΪ�û�ѡ���Ŀ¼
		return Util_String.fmtPathStr(file.getAbsolutePath());
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ӱ���ͼƬ
	 * </ul>
	 * @param panel
	 * @param imgPath 
	 */
	public static boolean addBackgroundImg(JPanel panel, String imgPath) {
		boolean b = false;
		try {
//			ImageIcon background = new ImageIcon(Util_UI.class.getResource("/"+imgPath));
//	        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
//	        JLabel label = new JLabel(background);  
//	        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
//	        label.setBounds(0, 0, panel.getWidth(), panel.getHeight());  
//	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
//	        JPanel imagePanel = panel.getContentPane();  
//	        imagePanel.setOpaque(false);  
//	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
//	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�̶��ߴ���ļ�ѡ����<br/>
	 * </ul>
	 * @param x
	 * @param y
	 * @return 
	 */
	public static JFileChooser getFixedJFileChooser(int x, int y) {
		return new JFileChooser(){
			/**  */
			private static final long serialVersionUID = 1L;
			
			@Override
			protected JDialog createDialog(Component parent) throws HeadlessException {
				JDialog d = super.createDialog(parent);
				d.setSize(984, 633);
				return d;
			}
			
		};
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡjFile��path,����ûѡ��͹ص��Ի�����ܵ��¿�ָ���쳣��<br/>
	 * ���Է�װ��<br/>
	 * </ul>
	 * @param jFileChooser
	 * @return 
	 */
	public static String getJFilePath(JFileChooser jFileChooser) {
		File f = jFileChooser.getSelectedFile();
		if(null == f)
			return "";
		return f.getAbsolutePath();
	}
	
	
}

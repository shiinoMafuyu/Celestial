package com.celestial.agniRadiance.EzUtil;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *						---- wangzg 2017年5月27日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Util_UI {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 一些ui设置信息。
	 * </ul>
	 * @return
	 */
	public static String storage(){
		JFileChooser chooser = new JFileChooser(); //创建选择文件对象
		chooser.setDialogTitle("请选择文件夹");//设置标题
//		chooser.setMultiSelectionEnabled(true);  //设置只能选择文件
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg");//定义可选择文件类型
//		chooser.setFileFilter(filter); //设置可选择文件类型
		chooser.showOpenDialog(null); //打开选择文件对话框,null可设置为你当前的窗口JFrame或Frame
		File file = chooser.getSelectedFile(); //file为用户选择的图片文件
		System.out.println(file.getAbsolutePath());
//		panel.add(chooser);
		return Util_String.fmtPathStr(file.getAbsolutePath());
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 选择目录。<br/>
	 * </ul>
	 * @return 
	 */
	public static String chooseDirctory() {
		JFileChooser chooser = new JFileChooser(); //创建选择文件对象
		chooser.setDialogTitle("请选择文件夹");//设置标题
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(null); //打开选择文件对话框,null可设置为你当前的窗口JFrame或Frame
		File file = chooser.getSelectedFile(); //file为用户选择的目录
		return Util_String.fmtPathStr(file.getAbsolutePath());
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 添加背景图片
	 * </ul>
	 * @param panel
	 * @param imgPath 
	 */
	public static boolean addBackgroundImg(JPanel panel, String imgPath) {
		boolean b = false;
		try {
//			ImageIcon background = new ImageIcon(Util_UI.class.getResource("/"+imgPath));
//	        // 把背景图片显示在一个标签里面  
//	        JLabel label = new JLabel(background);  
//	        // 把标签的大小位置设置为图片刚好填充整个面板  
//	        label.setBounds(0, 0, panel.getWidth(), panel.getHeight());  
//	        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
//	        JPanel imagePanel = panel.getContentPane();  
//	        imagePanel.setOpaque(false);  
//	        // 把背景图片添加到分层窗格的最底层作为背景  
//	        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取固定尺寸的文件选择器<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取jFile的path,由于没选择就关掉对话框可能导致空指针异常。<br/>
	 * 所以封装下<br/>
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

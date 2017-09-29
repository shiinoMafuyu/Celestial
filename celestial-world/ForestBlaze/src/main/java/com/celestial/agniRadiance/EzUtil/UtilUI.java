package com.celestial.agniRadiance.EzUtil;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

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
public class UtilUI {

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
		return UtilString.fmtPathStr(file.getAbsolutePath());
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
		return UtilString.fmtPathStr(file.getAbsolutePath());
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
				d.setSize(x, y);
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

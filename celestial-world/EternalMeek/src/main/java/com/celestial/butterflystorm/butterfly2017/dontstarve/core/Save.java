package com.celestial.butterflystorm.butterfly2017.dontstarve.core;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.butterflystorm.butterfly2017.dontstarve.ConfigVO;

public class Save {
	
	

	private Long interval = 1000L * 60 * 3;
	private String srcPath = "";
	private String desPath = "";
	
	private Long deleteInterval = 1000*60L;
	private Integer least = 20;
	
	
	private SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
	
	/**
	 * 根据配置信息进行备份操作
	 * @param configVO 配置信息vo
	 */
	public Save(ConfigVO configVO) {
		interval = configVO.getInterval();
		srcPath = configVO.getSrcPath();
		desPath = configVO.getDesPath();
		
		deleteInterval = configVO.getDeleteInterval();
		least = configVO.getLeast();
	}

	public void start() {
		
		if(!new File(srcPath).exists()){
			System.out.println("指定源文件路径不存在。srcPath：" + srcPath);
			return;
		}
			
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				save();
			}
		});
		t.run();
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				delete();
			}
		});
		t2.start();
		
	}

	private void save() {
		
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				//获取要拷贝的文件列表
				File srcFile = new File(srcPath);
				File[] files = new File[]{srcFile};
				if(srcFile.isDirectory()){
					UtilFile.findAllFile(srcPath);
					files = UtilFile.listDocument(srcFile);
				}
				
				String fiDesDirectory = desPath+"/"+sm.format(new Date());
				//拷贝文件
				for(File fi : files){
					String fiSrcPath = UtilString.fmtPathStr(fi.getAbsolutePath());
					String fileName = UtilString.getStrAfterLast(fiSrcPath, "/");
					String fiDesPath = fiDesDirectory + "/" + fileName;
					
					UtilFile.copyByCmdDRS(new File(fiSrcPath), new File(fiDesPath));
					System.out.println(String.format("拷贝文件：\n		%s\n---->%s", fiSrcPath,fiDesPath));
				}
				
				
			}
		}, 0, interval);
		
	}
	
	
	private void delete(){
		
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				File f = new File(desPath);
				File[] matchedFileArr = separate(UtilFile.listFile(f));
				
				File[] rangedFileArr = range(matchedFileArr);
				
				deleteDead(rangedFileArr);
				
			}
		}, 0, deleteInterval);
		
	}

	protected void deleteDead(File[] fArr) {
		if(fArr.length <= least)
			return;
		for(int i =0;i< fArr.length - least;i++){
			UtilFile.deleteFile(fArr[i]);
			System.out.println("删除文件:" + fArr[i].getName());
		}
			
			
			
		
	}

	protected File[] range(File[] arr) {
		if(null == arr)
			return new File[]{};
		for(int i = 0 ;i < arr.length ; i++){
			for(int j = arr.length -1;j >0;j --){
				boolean isEarly = false;
				try {
					isEarly = sm.parse(arr[j].getName()).before(sm.parse(arr[j-1].getName()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(isEarly){
					File temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	
	return arr;
}

	protected File[] separate(File[] fArr) {
		List<File> list = new ArrayList<File>();
		for(File fi : fArr){
			String name = fi.getName();
			boolean isBackup = UtilString.matchAllSameRegx(name, "\\d{4}-\\d{2}-\\d{2}\\s\\d{2}-\\d{2}-\\d{2}");
			if(isBackup){
				list.add(fi);
			}
		}
		File[] resArr = new File[]{};
		resArr = list.toArray(resArr);
		
		return resArr;
	}
	
}

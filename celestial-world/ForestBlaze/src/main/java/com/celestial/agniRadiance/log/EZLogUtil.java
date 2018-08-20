package com.celestial.agniRadiance.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.celestial.agniRadiance.EzUtil.UtilDate;
import com.celestial.agniRadiance.EzUtil.UtilUnicode;
import com.celestial.agniRadiance.constant.ConstantConfig;

public class EZLogUtil {
	public static final EZLogger operationLogger = new EZLogger("operation");

	public static final EZLogger systemLogger = new EZLogger("system");

	public static void showStartSuccess() {
		Class<?> clazz = getJarClass();
		Map<String,String> map = readMainFest(clazz);
		String title = map.get("MIDlet-WelcomeMSG") == null ? "" : (String) map.get("MIDlet-WelcomeMSG");
		String showMSG = null;
		try {
			showMSG = UtilUnicode.decodeUnicode(title);
		} catch (Exception e) {
			systemLogger.error("转换欢迎信息异常", e);
		}
		String version = (String) map.get("Signature-Version");
		showStartSuccess(showMSG, version);
	}

	private static void showStartSuccess(String showMSG, String version) {
		String versionName = "版本号：";

		String emptyString = "                                                                         ";

		String startEmpty = "";

		String endEmpty = "";

		StringBuilder builder = new StringBuilder();
		builder.append("\n===========================================================================").append("\n=").append(emptyString).append("=");

		if (showMSG == null) {
			showMSG = "";
			startEmpty = emptyString;
		} else {
			int length = showMSG.length() * 2;
			try {
				length = showMSG.getBytes("GBK").length;
			} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			}
			if (length < emptyString.length()) {
				int mode = (emptyString.length() - length) % 2;
				int sub = (emptyString.length() - length) / 2;
				startEmpty = emptyString.substring(0, sub + mode);
				endEmpty = emptyString.substring(0, sub);
			}
		}
		builder.append("\n=").append(startEmpty).append(showMSG).append(endEmpty).append("=");
		builder.append("\n=").append(emptyString).append("=");

		if (version == null) {
			version = "1.0";
		}
		int length = versionName.length() * 2 + version.length();
		try {
			length = (versionName + version).getBytes("GBK").length;
		} catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
		}
		if (length < emptyString.length()) {
			int mode = (emptyString.length() - length) % 2;
			int sub = (emptyString.length() - length) / 2;
			startEmpty = emptyString.substring(0, sub + mode);
			endEmpty = emptyString.substring(0, sub);
		}
		builder.append("\n=").append(startEmpty).append(versionName).append(version).append(endEmpty).append("=");
		builder.append("\n=").append(emptyString).append("=");

		builder.append("\n=").append(emptyString).append("=");
		builder.append("\n=").append(emptyString).append("=");
		builder.append("\n=").append(emptyString).append("=");

		builder.append("\n=                                         ").append(ConstantConfig.unionName).append("    =");
		builder.append("\n=").append(emptyString).append("=");

		String time = UtilDate.fmtTime(new Date());
		builder.append("\n=                                          启动于：").append(time).append("    =");
		builder.append("\n=").append(emptyString).append("=").append("\n===========================================================================");
		systemLogger.slightWarn(builder.toString());
	}

	@SuppressWarnings("resource")
	private static Map<String, String> readMainFest(Class<?> clazz) {
		Map<String, String> result = new HashMap<>();
		BufferedReader reader = null;
		InputStreamReader isr = null;
		InputStream input = null;
		try {
			String path = clazz.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();

			if (path.endsWith(".jar")) {
				File file = new File(path);
				JarFile jarFile = new JarFile(file);
				JarEntry entry = jarFile.getJarEntry("META-INF/MANIFEST.MF");
				input = jarFile.getInputStream(entry);
			} else {
				path = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
				File file = new File(path + "../../MANIFEST.MF");
				if (!file.exists()) {
					file = new File(path + "../../META-INF/MANIFEST.MF");
				}
				if (!file.exists()) {
					file = new File(path + "../MANIFEST.MF");
				}
				input = new FileInputStream(file);
			}

			isr = new InputStreamReader(input);
			reader = new BufferedReader(isr);
			String property = null;
			int propertyIndex = 0;
			String line = null;
			while ((line = reader.readLine()) != null) {
				int index = line.indexOf(":");
				if (index > 0) {
					if (property != null) {
						String key = property.substring(0, propertyIndex);
						String value = property.substring(propertyIndex + 1);
						result.put(key.trim(), value.trim());
					}
					property = line;
					propertyIndex = index;
				} else {
					property = property + line.trim();
				}
				if (property != null) {
					String key = property.substring(0, propertyIndex);
					String value = property.substring(propertyIndex + 1);
					result.put(key.trim(), value.trim());
				}
			}
		} catch (Exception e) {
			systemLogger.error("通过类 " + clazz.getCanonicalName() + " 读取MF文件失败", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception localException4) {
				}
				reader = null;
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (Exception localException5) {
				}
				isr = null;
			}
			if (input != null) {
				try {
					input.close();
				} catch (Exception localException6) {
				}
				input = null;
			}
		}
		return result;
	}

	private static Class<?> getJarClass() {
		StackTraceElement[] traces = Thread.currentThread().getStackTrace();

		StackTraceElement trace = null;

		if (traces.length > 3)
			trace = traces[3];
		else if (traces.length > 0) {
			trace = traces[(traces.length - 1)];
		}

		if (trace == null) {
			return null;
		}
		try {
			return Class.forName(trace.getClassName());
		} catch (ClassNotFoundException e) {
			systemLogger.error("通路径 " + trace.getClassName() + " 获取类失败", e);
		}

		return null;
	}
}

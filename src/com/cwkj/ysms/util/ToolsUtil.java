package com.cwkj.ysms.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月6日 下午3:25:03
 *
 */
public final class ToolsUtil {

	/**
	 * 从配置文件中获取数据
	 * 
	 * @param key
	 *            字段名称
	 * @return String 字段值
	 */
	public static String getPropertiesInfo(String file, String key) {
		Properties p = new Properties();
		String value = "";
		try {
			p = PropertiesLoaderUtils.loadAllProperties(file);
			value = p.getProperty(key);
			return value;
		} catch (Exception ioe) {
			ioe.printStackTrace();
			return value;
		}
	}

	/**
	 * 从配置文件中获取数据
	 * 
	 * @param key
	 *            字段名称
	 * @return String 字段值
	 */
	public static String getPropertiesInfoByRealPath(String file, String key) {
		Properties p = new Properties();
		InputStream in = null;
		String value = "";
		try {
			in = new FileInputStream(file);
			p.load(in);
			value = p.getProperty(key);
			return value;
		} catch (Exception ioe) {
			ioe.printStackTrace();
			return value;
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断列表是否为空
	 * 
	 * @param mobileIDs
	 *            列表
	 * @return boolean [空则返回true]
	 */
	public static boolean isEmpty(List<?> list) {
		if (null == list || 0 == list.size()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空 <功能详细描述>
	 * 
	 * @param mobileID
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isEmpty(String string) {
		return null == string || "".equals(string.trim());
	}

	/**
	 * 字符串转换为列表
	 * 
	 * @param input
	 *            输入字符串
	 * @return List<String>
	 */
	public static List<String> getList(String input) {
		List<String> result = new ArrayList<String>();
		if (!ToolsUtil.isEmpty(input)) {
			String[] in = input.split(",");

			result.addAll(Arrays.asList(in));
		}
		return result;
	}

	/**
	 * 获取当前日期的最后一天
	 * */
	public static int getLastDay(String d) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(d.split("-")[0]));
		cal.set(Calendar.MONTH, Integer.valueOf(d.split("-")[1]) - 1);
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}

	public static String getMonth(String d) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.valueOf(d.split("-")[1]) + 1);
		if ((d.split("-")[0]).equals("12")) {
			cal.set(Calendar.YEAR, Integer.valueOf(d.split("-")[0]) + 1);
		} else {
			cal.set(Calendar.YEAR, Integer.valueOf(d.split("-")[0]));
		}
		String month = String.valueOf(cal.get(Calendar.MONTH));
		String monthTemp = "";
		if (month.length() < 2) {
			monthTemp = "0" + month;
		} else {
			monthTemp = month;
		}
		String dat = String.valueOf(cal.get(Calendar.YEAR)) + "-" + monthTemp;
		return dat;
	}

	/**
	 * 获取当前上一年
	 * */
	public static String getYear(String d) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(d) - 1);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		return year;
	}

	/**
	 * 获取当前下一年
	 * */
	public static String getNextYear(String d) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(d) + 1);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		return year;
	}

	/**
	 * 将日期格式化成“上旬”格式输出
	 * 
	 * @param cal
	 * @return
	 */
	public static String getTenDayFormatString(int dayOfMonth) {
		String calStr = null;
		if (dayOfMonth < 1) {
			calStr = "";
		} else if (dayOfMonth < 11) {
			calStr = "上旬";
		} else if (dayOfMonth < 21) {
			calStr = "中旬";
		} else {
			calStr = "下旬";
		}
		return calStr;
	}

	/**
	 * 日期转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 * @throws Exception
	 */
	public static String FullDateToString(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return "";
	}

	/**
	 * Blob字段的通用转换 注意可能出现乱码
	 * 
	 * @return 转好的字符串，
	 * **/
	public static String BlobToString(byte[] blob) {
		String str = "";
		// 使用StringBuffer进行拼接
		ByteArrayInputStream in = null;
		// InputStream in=null;//输入字节流
		try {
			in = new ByteArrayInputStream(blob);
			// 一般接下来是把in的字节流写入一个文件中,但这里直接放进字符串
			byte[] buff = new byte[(int) blob.length];
			// byte[] buff=new byte[1024];
			// byte[] b = new byte[blob.getBufferSize()];
			for (int i = 0; (i = in.read(buff)) > 0;) {
				str += new String(buff, "UTF-8");
			}
			// str += new String(buff);

			return str;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				System.out.println("转换异常");
				e.printStackTrace();
			}
		}
		return null;
	}

	public static byte[] converToBlob(String content) {
		byte[] blob = null;
		// Blob blob = null;
		try {
			blob = content.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// String blobString = new String(blob.getBytes(1,
		// (int)blob.length()),"GBK");
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return blob;
	}

	/**
	 * 数字取整
	 * 
	 * @param value
	 * @return
	 */
	public static String roundUp(String value) {
		return new BigDecimal(value).setScale(0, BigDecimal.ROUND_HALF_UP)
				.toString();
	}

	/**
	 * 保留3位有效数字
	 * 
	 * @param value
	 * @return
	 */
	public static String formatThree(String value) {

		String rlt = value;
		double oriData = 0;
		try {
			oriData = Double.valueOf(value);
		} catch (Exception e) {
			return rlt;
		}

		if (oriData == 0) {
			rlt = "0.00";
		} else if (oriData < 10) {
			DecimalFormat df = new DecimalFormat("0.00");
			rlt = df.format(oriData);
		} else if (oriData < 100) {
			DecimalFormat df = new DecimalFormat("0.0");
			rlt = df.format(oriData);
			if (Double.parseDouble(rlt) == 100) {
				rlt = "100";
			}
		} else if (oriData < 1000) {
			DecimalFormat df = new DecimalFormat("0");
			rlt = df.format(oriData);
		} else if (oriData < 10000) {
			String str = value.substring(0, 3) + "0";
			int d = Integer.valueOf(str);
			if (oriData - d < 5) {
				rlt = str;
			} else {
				rlt = String.valueOf(d + 10);
			}
		} else if (oriData < 100000000) {
			String str = String.valueOf(oriData).substring(0, 3) + "00";
			int d = Integer.valueOf(str);
			if (oriData - d < 50) {
				rlt = str;
			} else {
				rlt = String.valueOf(d + 100);
			}
		}
		;
		return rlt;

	}

	/**
	 * 判断手机号格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 判断后缀是否为图片格式
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isImage(String fileName) {
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")
				|| suffix.equalsIgnoreCase("bmp")
				|| suffix.equalsIgnoreCase("jpeg")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断后缀是否为xls片格式
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isXLS(String fileName) {
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (suffix.equalsIgnoreCase("xls")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断邮箱格式
	 * 
	 * @param s
	 * @return
	 */
	public static boolean checkEmail(String s) {
		String regex = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * 判断是否含有汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChineseChar(String str) {
		boolean temp = false;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = true;
		}
		return temp;
	}

	/**
	 * 判断是否全是汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkChs(String str) {
		boolean flag=true;
		int count = 0;  
        String regEx = "[\\u4e00-\\u9fa5]";  
        Pattern p = Pattern.compile(regEx);  
        Matcher m = p.matcher(str);  
        while (m.find()) {  
            for (int i = 0; i <= m.groupCount(); i++) {  
                count = count + 1;  
            }  
        }  
//        System.out.println(count);
//        System.out.println(str.toCharArray().length);
        if(str.toCharArray().length!=count||str.toCharArray().length==0){
        	flag=false;
        }
        return flag;
	}

	
	
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	
	
	public static void main(String[] args) {
		System.out.println(checkChs(""));
	}
}

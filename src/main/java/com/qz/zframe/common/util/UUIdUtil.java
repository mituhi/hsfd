package com.qz.zframe.common.util;

import java.util.Random;
import java.util.UUID;

public class UUIdUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * ID
	 */
	public static long getID() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	public static void main(String[] args) {
		
	}
	
}

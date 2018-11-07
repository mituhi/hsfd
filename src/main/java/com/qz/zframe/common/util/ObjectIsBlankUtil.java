package com.qz.zframe.common.util;

import java.lang.reflect.Field;

/**
 * <p>Title: ObjectIsBlankUtil</p>
 * <p>@Description: 判断一个对象中的属性值是否为null或者为'' </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午2:56:19
 * @version:V1.0
 */
public class ObjectIsBlankUtil {
	
	/**
	 * @Description:  判断一个对象中的属性值是否为null或者为''
	 * @param: @param obj
	 * @param: @return 
	 * @param: @throws Exception   
	 * @return: boolean  如果存在未null 或者为'' 返回true
	 */
    public static boolean isExistFieldBlank(Object obj) throws Exception{
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = false;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); 
            Object val = f.get(obj);
            if(val==null || val == "") {
                flag = true;
                break;
            }
            if(val instanceof String){
            	String valStr = ((String) val).trim();
            	if(valStr.equals("")){
            		 flag = true;
                     break;
            	}
            }
            
        }
        return flag;
    }
	
}

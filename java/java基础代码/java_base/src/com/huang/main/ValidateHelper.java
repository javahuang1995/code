package com.huang.main;  
 
import java.text.ParseException;  
import java.util.Collection;  
import java.util.Map;  
 
/** 
 * ���õ���֤����������,�ṩ���ַ��������ϣ����飬��ֵ����֤ 
 *  
 * @au
package com.camel.jelly.helper;  
 
import java.text.ParseException;  
import java.util.Collection;  
import java.util.Map;  
 
/** 
 * ���õ���֤����������,�ṩ���ַ��������ϣ����飬��ֵ����֤ 
 *  
 * @author Jelly <br/>2009-11-29 
 */ 
public class ValidateHelper {  
    /** 
     * �ж�һ���ַ����Ƿ���һ�����ַ��� 
     *  
     * @param s Ҫ�жϵ��ַ��� 
     * @return �����Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isNotEmptyString(String s) {  
        //return ((s != null) && s.length() > 0);
    	return !isEmptyString(s);
    }  
 
    /** 
     * �ж�һ���ַ����Ƿ���һ�����ַ��� 
     *  
     * @param s Ҫ�жϵ��ַ��� 
     * @return ���Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isEmptyString(String s) {  
        return ((s == null) || (s.length() == 0));  
    }  
 
    /** 
     * �ж�һ��Collection���͵ļ����Ƿ���һ���ռ��� 
     *  
     * @param c Ҫ�жϼ��� 
     * @return �����Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isNotEmptyCollection(Collection c) {  
        return ((c != null) && (c.size() > 0));  
    }  
 
    /** 
     * �ж�һ��Collection���͵ļ����Ƿ���һ���ռ��� 
     *  
     * @param c Ҫ�жϼ��� 
     * @return ���Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isEmptyCollection(Collection c) {  
        return ((c == null) || (c.size() == 0));  
    }  
 
    /** 
     * �ж�һ��Map���͵ļ����Ƿ���һ���ռ��� 
     *  
     * @param c Ҫ�жϵļ��� 
     * @return �����Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isNotEmpty(Map m) {  
        return ((m != null) && (m.size() > 0));  
    }  
 
    /** 
     * �ж�һ��Map���͵ļ����Ƿ���һ���ռ��� 
     *  
     * @param c Ҫ�жϵļ��� 
     * @return ���Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isEmpty(Map m) {  
        return ((m == null) || (m.size() == 0));  
    }  
 
    /** 
     * �ж�һ��int���͵������Ƿ���һ�������� 
     *  
     * @param c Ҫ�жϵ����� 
     * @return �����Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isNotEmpty(int[] i) {  
        return ((i != null) && (i.length > 0));  
    }  
 
    /** 
     * �ж�һ��int���͵������Ƿ���һ�������� 
     *  
     * @param c Ҫ�жϵ����� 
     * @return ���Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isEmpty(int[] i) {  
        return ((i == null) || (i.length == 0));  
    }  
 
    /** 
     * �ж�һ��String���͵������Ƿ���һ�������� 
     *  
     * @param c Ҫ�жϵ����� 
     * @return �����Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isNotEmpty(String[] s) {  
        return ((s != null) && (s.length > 0));  
    }  
 
    /** 
     * �ж�һ��String���͵������Ƿ���һ�������� 
     *  
     * @param c Ҫ�жϵ����� 
     * @return ���Ϊ�շ���true�����򷵻�false 
     */ 
    public static boolean isEmpty(String[] s) {  
        return ((s == null) || (s.length == 0));  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ���Double���� 
     *  
     * @param s Ҫ��֤���ַ��� 
     * @return �����Double�����򷵻�true,���򷵻�false 
     */ 
    public static boolean isDouble(String s) {  
        if (s == null || s.equals(""))  
            return false;  
        String num = "0123456789.";  
        if (s.indexOf('.') >= 0)  
            if (s.indexOf('.', s.indexOf('.') + 1) > 0)  
                return false;  
        for (int i = 0; i < s.length(); i++) {  
            if (num.indexOf(s.charAt(i)) < 0) {  
                return false;  
            } else {  
                try {  
                    Double.parseDouble(s);  
                } catch (NumberFormatException e) {  
                    return false;  
                }  
            }  
        }  
        return true;  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ���Float���� 
     *  
     * @param s Ҫ��֤���ַ��� 
     * @return �����Float�����򷵻�true,���򷵻�false 
     */ 
    public static boolean isFloat(String s) {  
        if (s == null || s.equals(""))  
            return false;  
        String num = "0123456789.";  
        if (s.indexOf('.') >= 0)  
            if (s.indexOf('.', s.indexOf('.') + 1) > 0)  
                return false;  
        for (int i = 0; i < s.length(); i++) {  
            if (num.indexOf(s.charAt(i)) < 0) {  
                return false;  
            } else {  
                try {  
                    Float.parseFloat(s);  
                } catch (NumberFormatException e) {  
                    return false;  
                }  
            }  
        }  
        return true;  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ������� 
     *  
     * @param s Ҫ��֤���ַ��� 
     * @return ����������򷵻�true,���򷵻�false 
     */ 
    public static boolean isInteger(String s) {  
        if (s == null || s.length() == 0) {  
            return false;  
        } else {  
            String str = "0123456789";  
            String num = "-0123456789";  
            if (num.indexOf(s.charAt(0)) < 0)  
                return false;  
            for (int i = 1; i < s.length(); i++) {  
                if (str.indexOf(s.charAt(i)) < 0) {  
                    return false;  
                } else {  
                    try {  
                        Integer.parseInt(s);  
                    } catch (NumberFormatException e) {  
                        return false;  
                    }  
                }  
            }  
        }  
        return true;  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ���һ��.��һ��������� 
     *  
     * @param s Ҫ����������ַ��� 
     * @return �����һ�����������ַ���true,���򷵻�false 
     */ 
    public static boolean isLongNumber(String s) {  
        if (s == null || s.equals(""))  
            return false;  
        String num = "0123456789.";  
        if (s.indexOf('.') >= 0)  
            if (s.indexOf('.', s.indexOf('.') + 1) > 0)  
                return false;  
        for (int i = 0; i < s.length(); i++) {  
            if (num.indexOf(s.charAt(i)) < 0)  
                return false;  
        }  
        return true;  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ���������� 
     *  
     * @param s Ҫ��֤���ַ��� 
     * @return ����ַ�����������ɵ��򷵻�true,���򷵻�false 
     */ 
    public static boolean isNumber(String s) {  
        if (s == null || s.equals(""))  
            return false;  
        String num = "0123456789";  
        for (int i = 0; i < s.length(); i++) {  
            if (num.indexOf(s.charAt(i)) < 0)  
                return false;  
        }  
        return true;  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ�һ���Ϸ�����,���ڸ�ʽ��yyyy-MM-dd 
     *  
     * @param date Ҫ��֤���ַ������� 
     * @return ����ַ�����һ���Ϸ������ڷ���true,���򷵻�false 
     */ 
    public static boolean isDate(String date) {  
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");  
        try {  
            df.setLenient(false);  
            df.parse(date);  
            return true;  
        } catch (ParseException e) {  
            return false;  
        }  
    }  
 
    /** 
     * ��֤һ���ַ����Ƿ�һ���Ϸ�����ʱ��,����ʱ���ʽ��yyyy-MM-dd HH:mm:ss 
     *  
     * @param date Ҫ��֤���ַ�������ʱ�� 
     * @return ����ַ�����һ���Ϸ�������ʱ�䷵��true,���򷵻�false 
     */ 
    public static boolean isTimestamp(String time) {  
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        try {  
            df.setLenient(false);  
            df.parse(time);  
            return true;  
        } catch (ParseException e) {  
            return false;  
        }  
    }  
 
    /** 
     * �����ֽ�����ָ���Ŀ�ʼ�ͽ�β�����������ַ���ֵ 
     *  
     * @param bytes �ֽ����� 
     * @param begin ��ʼ���� 
     * @param end �������� 
     * @return ת������ַ������ 
     */ 
    public static String getString(byte[] bytes, int begin, int end) throws RuntimeException {  
        byte[] newBytes = new byte[end - begin];  
        for (int i = begin, j = 0; i < end; i++, j++) {  
            byte c = bytes[i];  
            newBytes[j] = c;  
        }  
        return (new String(newBytes));  
    }  
 
    /** 
     * �����ֽ�����ָ���Ŀ�ʼ�ͽ�β�����������ַ������ֽڳ��� 
     *  
     * @param bytes �ֽ����� 
     * @param begin ��ʼ���� 
     * @param end �������� 
     * @return ת������ַ������� 
     */ 
    public static int getLength(byte[] bytes, int begin, int end) {  
        byte[] newBytes = new byte[end - begin];  
        try {  
            for (int i = begin, j = 0; i < end; i++, j++) {  
                byte b = bytes[i];  
                newBytes[j] = b;  
            }  
        } catch (RuntimeException ex) {  
            ex.printStackTrace();  
        }  
        return (newBytes.length);  
    }  
 
} 
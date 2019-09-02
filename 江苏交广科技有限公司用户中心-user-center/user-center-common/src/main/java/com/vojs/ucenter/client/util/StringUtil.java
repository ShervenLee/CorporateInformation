package com.vojs.ucenter.client.util;

public class StringUtil {
	//  GENERAL_PUNCTUATION 判断中文的“号  
	  
    //  CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号  
  
    //  HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号  
  
    public static boolean isChinese(char c) {  
  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
  
            return true;  
  
        }  
  
        return false;  
  
    }  
  
  
  
    public static boolean isChinese(String strName) {  
  
        char[] ch = strName.toCharArray();  
  
        for (int i = 0; i < ch.length; i++) {  
  
            char c = ch[i];  
  
            if (isChinese(c) == true) {  
                return true;  
            }
        }  
        return false;
    }  
    
    public static boolean hasEncode(String strName) {  
    	String reg = "(([a-z]|[A-Z]|[0-9])*(\\%([a-z]|[A-Z]|[0-9]){1,2}))+([a-z]|[A-Z]|[0-9])*";
    	return strName.matches(reg);
    }  
  
    public static void main(String[] args) {  
//    	String test = "34gqgrer34h343gq";
//    	String ecode = URLEncoder.encode(test);
//    	System.out.println(ecode);
//    	System.out.println("-------"+hasEncode(ecode));
//    	System.out.println("-------"+URLDecoder.decode(ecode));
    	
//    	
//        isChinese("き");  
//        isChinese("sdfsdfsdfs");
//        isChinese("123456"); 
//        isChinese("fafgadf32sdbaa的吧身份的不"); 
//        isChinese("中国");  
  
    }
}

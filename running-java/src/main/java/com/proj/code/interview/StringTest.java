package com.proj.code.interview;

/**
 * "abvsdjofhelloflsadoi","sdohellozs"最大相同字符串值
 */
public class StringTest {
    public static void main(String[] args) {
        String maxSubString = findMaxSubString("abvsdjofhelloflsadoi", "sdohellozs");
        System.out.println(maxSubString);
    }

    public static String findMaxSubString(String str1, String str2) {

        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        if(maxStr.contains(minStr)){
            return minStr;
        }

        String result = "";
        for (int i = 0; i < minStr.length(); i++) {
            for (int j = minStr.length(); j > i; j--) {
                String substring = minStr.substring(i, j);
                if(maxStr.contains(substring)){
                    if(result.length() < substring.length()){
                        result = substring;
                    }
                }
            }
        }

        return result;
    }

}

package com.ResellBook.Tool;

import org.apache.commons.lang3.RandomStringUtils;
import sun.security.provider.MD5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SendMassageUtils {
    public static String sendMseeage(String tel,String availablTime){
        //短信发送网站的用户名和密码
        String userName = "";
        String passWord = "";
        //接收端的号码
        String phoneNum = tel;
        //生成四位数的验证码
        String code = RandomStringUtils.randomNumeric(4);
        //短信的内容
        String content = "【华广书吧】你的验证码为" + code + ",在" + availablTime + "分钟内有效";
        //短信发送网站的接口
        String url = "http://api.smsbao.com/sms";
        //接口所需要的参数
        StringBuffer arg = new StringBuffer();
        arg.append("u=").append(userName).append("&");
        arg.append("p=").append(md5(passWord)).append("&");
        arg.append("m=").append(phoneNum).append("&");
        arg.append("c=").append(encodeUrlString(content,"UTF-8")).append("&");

        //调用访问接口的方法
        String result = request(url,arg.toString());
        //返回生成的验证码
        return code;
    }

    private static  String request(String httpUrl ,String arg){
        BufferedReader reader = null;
        String result = null;
        StringBuffer buffer = null;
        httpUrl = httpUrl + "?" + arg;
        try{
            //生成URL
            URL url = new URL(httpUrl);
            //连接发短信的网站
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            //获取网站的输入流
            InputStream inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
           //写入字符缓存流
            String stringRead = reader.readLine();
            if(stringRead != null){
                buffer.append(stringRead);
                while ((stringRead = reader.readLine())!= null){
                    buffer.append("\n");
                    buffer.append(stringRead);
                }
            }
            reader.close();
            result = buffer.toString();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    //对密码进行加密
    private static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    //把字符串重新编码指定编码方式
    private static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }
}

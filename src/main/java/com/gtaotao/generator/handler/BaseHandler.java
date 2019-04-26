package com.gtaotao.generator.handler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gtaotao.generator.util.DateUtil;
import com.gtaotao.generator.util.FileHelper;
import com.gtaotao.generator.util.FreeMarkerUtil;

public abstract class BaseHandler<T> {
    protected String ftlName;
    protected String savePath;
    protected Map<String, String> param = new HashMap<String, String>();
    protected T info;
    
    private String generateFinalStr() {
        String temp = null;
        try {
            //   String temp = FileHelper.readFileToString(this.getClass().getClassLoader().getResource("/").getPath() + ftlName); //在打包成jar直接运行时，会报Null异常
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(ftlName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); // 实例化输入流，并获取网页代码
            String s; // 依次循环，至到读的值为空
            StringBuilder sb = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            reader.close();
            temp = sb.toString();
        }catch (Exception e){}
        return FreeMarkerUtil.getProcessValue(param, temp);
    }
    
    /**
     * 
     * 保存到文件
     */
    private void saveToFile(String str) {
        FileHelper.writeToFile(savePath, str);
    }
    
    /**
     * 组装参数
     */
    public abstract void combineParams(T info);
    
    /**
     * 
     * 设置一些公共的参数.
     */
    private void beforeGenerate() {
        String time = DateUtil.formatDataToStr(new Date(), "yyyy年MM月dd日");
        param.put("author", System.getProperty("user.name"));
        param.put("time", time);
    }
    
    /**
     * 生成文件
     */
    public void execute() {
        String str = null;
        combineParams(info);
        beforeGenerate();
        str = generateFinalStr();
        saveToFile(str);
    }
    
}

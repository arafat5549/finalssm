package com.ssf.common.mybatis.plugin.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by wangyaoyao on 2018/9/6.
 */
public class LogUtil {

    public static String DEST_PROJECT_PATH = "/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem";
    public static void printLog(String prefix,String log){
        System.out.println(prefix+":"+log);
    }

    //
    private static List<String> readSpecailAreas(String filePath,String start,String end){
        List<String> ret = Lists.newArrayList();
        try {
            List<String> lines = Files.readLines(new File(filePath), Charset.forName("UTF-8"));
            int lineno = -1;
            for (int i=0;i<lines.size();i++) {
                String line = lines.get(i);
                boolean flag = line.matches(start);
                boolean flag2 = line.matches(end);
                if(flag)
                {
                    lineno = i;
                }
                else if(flag2){

                    break;
                }
                else{
                    if(lineno >0){
                        ret.add(line);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static List<String> readSpecailAreas_file(String filePath){
        String regex_start = ".* START *以下为自己编写的代码区域 一般是多表之间的联合查询 *START .*";
        String regex_end = ".* END *以下为自己编写的代码区域 一般是多表之间的联合查询 *END .*";
        return readSpecailAreas(filePath,regex_start,regex_end);
    }

    private static List<String> readSpecailAreas_xml(String filePath){
        String regex_start = ".* START *以下为自己编写的代码区域 一般是多表之间的联合查询 *START .*";
        String regex_end = ".* END *以下为自己编写的代码区域 一般是多表之间的联合查询 *END .*";
        return readSpecailAreas(filePath,regex_start,regex_end);
    }

    public static List<String> readSpecailAreas_file(String type,String captailClsName){
        String base  = DEST_PROJECT_PATH+"/src/main/java";
        String base_xml  = DEST_PROJECT_PATH+"/src/main/resources";
        String filePath = "";

        if("model".equals(type))
            filePath = base + File.separator + "com/jqm/ssm/entity/" + captailClsName +".java";
        else if("dao".equals(type))
            filePath = base + File.separator + "com/jqm/ssm/dao/" + captailClsName +"Dao.java";
        else if("daoxml".equals(type))
            filePath  = base_xml + File.separator + "com/jqm/ssm/dao/" + captailClsName +"Dao.xml";

        System.out.println("----------------------------------"+type+","+captailClsName+"----------------------------------");
        List<String> ret = readSpecailAreas_file(filePath);
        //System.out.println(Joiner.on(" ").join(ret).trim());
        boolean isallblank = true;
        for (String l:ret) {
            boolean flag = "".equals(l.trim());
            //System.out.println();
            if(!flag){
                isallblank = false;
                break;
            }
            //System.out.println(l+","+flag);
        }
        //System.out.println(isallblank);
        return isallblank ? Lists.newArrayList() : ret;
    }




    public static void main(String[] args) {
        String base  = DEST_PROJECT_PATH+"/src/main/java";
        String filePath = base + File.separator + "com/jqm/ssm/entity/" + "User.java";

        base  = DEST_PROJECT_PATH+"/src/main/resources";
        filePath = base + File.separator + "com/jqm/ssm/dao/" + "UserDao.xml";
        //readSpecailAreas_xml(filePath);
    }
}

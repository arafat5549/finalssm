package com.ssf.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ：TestObjectUtils
 * @Description: 测试方法类-用于打印对象
 * @Author ：wangyao
 * @Date ：2018/11/15 下午3:22
 */
public class TestObjectUtils {
    //控制台打印颜色
    public enum PrintColor{
        C_HEADER("\033[95m"),
        C_OKBLUE("\033[94m"),
        C_OKGREEN("\033[92m"),
        C_WARNING("\033[93m"),
        C_CYAN("\033[36m"),
        C_FAIL("\033[91m"),
        C_ENDC("\033[0m"),
        C_BOLD("\033[1m"),
        C_UNDERLINE("\033[4m")
        ;
        public String value(){return  value;}
        private final String value;
        PrintColor(String value){
            this.value = value;
        }

    }


    public static String print(Object object,String prefix){
        return print(object,true,PrintColor.C_HEADER,prefix);
    }
    public static String print(Object object,String prefix,PrintColor header){
        return print(object,true,header,prefix);
    }

    public static String print(Object object){
        return print(object,true,PrintColor.C_HEADER,"");
    }
    public static String print(Object object,boolean isprint){
        return print(object,isprint,PrintColor.C_HEADER,"");
    }
    public static String print(Object object,boolean isprint,PrintColor header){
        return print(object,isprint,header,"");
    }

    /**
     * 默认只打印不为空的字段 会循环遍历父类
     * @param object
     * @param isprint
     * @return
     */
    public static String print(Object object,boolean isprint,PrintColor header,String prefix){
        if(object==null) return null;
        if(object instanceof  String) {
            System.out.println(prefix+object);
            return null;
        }
        if(object instanceof Integer || object instanceof Long || object instanceof Byte || object instanceof  Boolean
        || object instanceof  Float || object instanceof Double) {
            System.out.println(prefix+object);
            return null;
        }
        //
        StringBuffer sb = new StringBuffer();
        StringBuffer colorsb = new StringBuffer();
        sb.append("["+object.getClass().getSimpleName()+"] ");
        colorsb.append(header.value()+"["+object.getClass().getSimpleName()+"] "+PrintColor.C_ENDC.value());
        List<Object> subclz = new ArrayList();
        for (Class<?> clz = object.getClass(); clz != Object.class; clz = clz.getSuperclass()){
            Field fs [] = clz.getDeclaredFields();
            for(Field f:fs){
                if(Modifier.isFinal(f.getModifiers()) || Modifier.isStatic(f.getModifiers())){
                    continue;
                }
                String fname  =f.getName();
                Object value = ReflectionUtil.getFieldValue(object,fname);
                String typeName = f.getGenericType().toString();
                //System.out.println(typeName+","+fname);
                if(typeName.startsWith("class com.hikvision.sdk") || fname.equals("valueCondition")
                        || fname.equals("endCondition")
                        || fname.equals("beginCondition")
                        || fname.equals("equalCondition")
                        || fname.equals("orderByCondition")
                        || fname.equals("page")){
                    //subclz.add(value);
                    String str = print(value,false,PrintColor.C_OKBLUE);
                    if(!StringUtils.isNullOrEmpty(str)){
                        //System.out.println(fname);

                        sb.append("\n\t{"+fname+"}"+str);
                        colorsb.append("\n\t{"+fname+"}"+str);
                    }
                }
                else if( typeName.startsWith("java.util.List<T>")){//typeName.startsWith("java.util.List<com.hikvision.sdk") ||
                    if(value!=null){
                        sb.append("\n\t"+typeName);
                        colorsb.append("\n\t"+PrintColor.C_OKBLUE.value()+"["+typeName+"]"+fname+PrintColor.C_ENDC.value());
                        for(Object s:(List)value){
                            String str = print(s,false,PrintColor.C_BOLD);
                            //System.out.println(s+","+str);
                            sb.append("\n\t\t"+str);
                            colorsb.append("\n\t\t"+str);
                        }
                    }
                }
                else{
                    if(value!=null)
                    {
                        sb.append(fname+"="+value+",");
                        colorsb.append(PrintColor.C_UNDERLINE.value()+fname+PrintColor.C_ENDC.value()+"="+value+", ");
                    }
                }
            }
        }
//        for(Object value:subclz){
//            String str = print(value,false,PrintColor.C_OKBLUE);
//            if(!StringUtils.isNullOrEmpty(str)){
//                sb.append("\n\t"+str);
//                colorsb.append("\n\t"+str);
//            }
//        }

        if(isprint)
        {
            System.out.println(prefix+colorsb.toString());
        }
        return colorsb.toString();
    }


}

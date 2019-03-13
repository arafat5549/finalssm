//package com.jqmkj.roadtrip.common;
//
//import com.google.common.collect.Lists;
//import com.jqmkj.roadtrip.base.BaseEntity;
//import com.jqmkj.roadtrip.entity.*;
//import com.ssf.common.twitter.IDGenerator.IdWorker;
//import com.ssf.utils.ReflectionUtil;
//import com.ssf.utils.StringUtils;
//import org.yaml.snakeyaml.Yaml;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//
///**
// * @ClassName ：InitDataGenerator
// * @Description: 基础数据生成
// * @Author ：wangyao
// * @Date ：2019/1/4 上午11:05
// */
//public class InitDataGenerator {
//
//    public static void initCreateUser(BaseEntity object){
//        object.setCreateId(1L);
//        object.setUpdateId(1L);
//        Date now = new Date();
//        object.setCreateTime(now);
//        object.setUpdateTime(now);
//    }
//
//    /**
//     * 生成分类对象
//     * @param list
//     * @param sort
//     * @param level
//     * @param leaf
//     * @param idWorker
//     * @param pid
//     * @return
//     */
//    public static List<TripScenicCategory> initTripCategorty(List<String> list, int sort, int level, int leaf, IdWorker idWorker, long pid){
//        List<TripScenicCategory> rootlist = Lists.newArrayList();
//        for(String node:list) {
//            long id = idWorker.nextId();
//            TripScenicCategory rootCategory = new TripScenicCategory();
//            rootCategory.setId(id);
//            rootCategory.setParentId(pid);
//            rootCategory.setLevel(level);
//            rootCategory.setName(node);
//            rootCategory.setIsLeaf(leaf);
//            rootCategory.setSort(sort++);
//            InitDataGenerator.initCreateUser(rootCategory);
//            rootlist.add(rootCategory);
//        }
//        return rootlist;
//    }
//
//    /**
//     * 生成员工
//     * @return
//     */
//    public static List<SysEmployee> initEmployee(){
//        List<SysEmployee> rootlist = Lists.newArrayList();
//        SysEmployee emp1 = new SysEmployee();
//        emp1.setId(1L);
//        emp1.setDepartmentId(1L);
//        emp1.setUsername("admin");
//        emp1.setName("管理员");
//        emp1.setIsAdmin(1);
//        initCreateUser(emp1);
//        return rootlist;
//    }
//    public static List<SysUser> initUser(){
//        List<SysUser> rootlist = Lists.newArrayList();
//        return rootlist;
//    }
//
//    public static List<SysDepartment> initDepartment(){
//        List<SysDepartment> rootlist = Lists.newArrayList();
//        return rootlist;
//    }
//
//    /**
//     * 旅游线路
//     * @return
//     */
//    public static List<TripRoute> initTripRoute(){
//        //16898177399858178 个人自驾
//        List<TripRoute> rootlist = Lists.newArrayList();
//        return rootlist;
//    }
//
//
//    /**
//     * 读取yaml
//     */
//    public static Iterable<Object> loadYaml() throws FileNotFoundException {
//        Yaml yaml = new Yaml();
//        File f = new File("/Users/arafat/workspace/tree.yaml");
//        Iterable<Object> result = yaml.loadAll(new FileInputStream(f));
//        return result;
//    }
//
//    public static LinkedHashMap<String,Object> loadRoot(Iterable<Object> result,String root){
//        for (Object obj : result) {
//            LinkedHashMap<String,LinkedHashMap> map = (LinkedHashMap)obj;
//            for(String key:map.keySet()){
//                if(key.equals(root)){
//                    return map.get(key);
//                }
//            }
//        }
//        return null;
//    }
//
//    public static Object loadYamlValue(LinkedHashMap root,String target){
//        for (Object obj : root.keySet()) {
//            Object value = root.get(obj);
//            Object map = null;
//            if(obj.equals(target)){
//                if(value instanceof LinkedHashMap){
//                    map = (LinkedHashMap)value;
//                    return map;
//                }
//                else{
//                    return value;
//                }
//            }else{
//                if(value instanceof LinkedHashMap){
//                    return loadYamlValue((LinkedHashMap)value,target);
//                }
//                //else
//                // System.out.println(target+","+value);
//            }
//        }
//        return null;
//    }
//
//
//
//    public static void loadTree(int type){
//        Iterable<Object>  result = null;
//        try {
//            result = loadYaml();
//            LinkedHashMap root = loadRoot(result,"TripGoodsCategory");
//
//            String arr[] = StringUtils.split(root.toString(),",");
//            System.out.println(Arrays.toString(arr));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static <T> void parseBean2Yaml(Class<T> clz) throws IllegalAccessException, InstantiationException {
//        T t = clz.newInstance();
//        System.out.println(clz.getSimpleName()+":");
//        Field fileds [] = clz.getDeclaredFields();
//        for(Field f:fileds){
//            String fname = f.getName();
//            Field af = ReflectionUtil.getAccessibleField(t,fname);
//            if(af!=null && af.isAccessible())
//            {
//                Object value = ReflectionUtil.getFieldValue(t,fname);
//                System.out.println("  "+fname+": "+value);
//                Class type = af.getType();
//                String typeName = type.getSimpleName();
//                Object initval = null;
//
//                switch (typeName)
//                {
//                    case "byte":
//                    case "Byte":
//                        type =Byte.class;
//                        initval = (byte)0;
//                        break;
//                    case "short":
//                    case "Short":
//                        type =Short.class;
//                        initval = (short)0;
//                        break;
//                    case "int":
//                    case "Integer":
//                        type =Integer.class;
//                        initval = (Integer)0;
//                        break;
//                    case "long":
//                    case "Long":
//                        type =Long.class;
//                        initval = (long)0;
//                        break;
//                    case "float":
//                    case "Float":
//                        type =Float.class;
//                        initval = 0.0f;
//                        break;
//                    case "double":
//                    case "Double":
//                        type =Double.class;
//                        initval = 0.0;
//                        break;
//                    case "boolean":
//                    case "Boolean":
//                        type =Boolean.class;
//                        initval=false;
//                        break;
//                    case "char":
//                    case "Char":
//                        type =Character.class;
//                        initval=(char)0;
//                        break;
//                    case "String":
//                        type = String.class;
//                        initval = "";
//                    default:
//                        break;
//                }
//
//                System.out.println("[[: "+typeName+","+type+","+initval);
//                ReflectionUtil.setFieldValue(t,fname,initval);
//                //System.out.println(af.getType()+","+af.getType().getName()+","+af.getType().isPrimitive()+","+af.getType().getSimpleName());
//            }
//
//        }
//
//        System.out.println("\t:"+t);
//
//    }
//
//
//    public static void main(String[] args) throws Exception{
////        try {
////            Iterable<Object>  result = loadYaml();
////            LinkedHashMap root = loadRoot(result,"TripGoodsCategory");
////            System.out.println(root);
////            for (Object obj : root.keySet()) {
////                Object value = root.get(obj);
////                if(value instanceof LinkedHashMap){
////                    Object ret = loadYamlValue(root,obj.toString());
////                    System.out.println(obj+"#"+ret);
////                }else{
////                    System.out.println(obj+","+value);
////                }
////
////            }
////            //Object value = loadYamlValue(root,"展馆展览");
////            //System.out.println(value);
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
//
//        //loadTree(0);
//        //SysEmployee emp = new SysEmployee();
//        //System.out.println(emp);
//        parseBean2Yaml(SysEmployee.class);
//    }
//
//}

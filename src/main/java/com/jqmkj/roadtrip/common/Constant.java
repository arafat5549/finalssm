package com.jqmkj.roadtrip.common;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName ：Constant
 * @Description: TODO
 * @Author ：wangyao
 * @Date ：2019/1/4 上午11:06
 */
public class Constant {
    public  interface Common{
        int ROOT_SORT = 0;
        int ROOT_SUBSORT = 10000;
        int ROOT_CHILDSORT = 100000000;
    }
    //自驾游GPS点类型
    public enum TripGpsType{
        TripGps_Scenic(0,"景区","Scenic",Lists.newArrayList("全部","景点/门票","展馆展览")),
        TripGps_Hotel(1,"酒店","Hotel",Lists.newArrayList("国内","国际/港澳台","民宿短租")),
        TripGps_Shopping(2,"购物","Shopping",null),
        TripGps_CarRent(3,"租车服务","CarRent",null),
        TripGps_CarService(4,"救援维修","CarService",null),
        TripGps_Store(5,"商城","Store",null),
        TripGps_GasStation(6,"高速加油站信息","GasStation",null),
        TripGps_Other(7,"其他","Other",null),
        TripGps_Route(8,"线路","Route",Lists.newArrayList("全部","个人自驾","跟团自驾"));

        public static List<String> all(){
            return all(-1);
        }
        public static List<String> all(int type){
            List ret = Lists.newArrayList();
            for(TripGpsType t:values()){
                if(t.type == type || type<0)
                ret.add(t.value());
            }
            return  ret;
        }
        public static List<String> getListByName(String name){
            for(TripGpsType t:values()){
                if(t.value().equals(name)){
                    return  t.list();
                }
            }
            return null;
        }

        public int    type(){return type;}
        public String value(){return value;}
        public List<String> list(){return list;}

        private final Integer type;
        private final String  value;
        private final String  code;
        private final List<String>  list;
        TripGpsType(Integer type,String value,String code,List<String> list){
            this.type=type;
            this.value=value;
            this.code=code;
            this.list = list;
        }
    }


    //-------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        String str ="0->景区#Scenic；1->酒店#Hotel；2->购物#Shopping；3->租车服务#CarRent；4->救援维修#CarService；5->商城#Store；6->高速加油站信息#GasStation；7->其他#Other；8->路线#Route";
        String attrs [] = str.split("；");

        StringBuffer sb = new StringBuffer();
        for(String a:attrs){
            String eums[] = a.split("->");
            if(eums.length>1){
                String keys[] = eums[1].split("#");
                sb.append("\""+keys[0]+"#"+keys[1]+"\",");
                System.out.println("TripGps_"+keys[1]+"("+eums[0]+",\""+keys[0]+"\",\""+keys[1]+"\"),");
            }

        }

        List<String> root = Constant.TripGpsType.all();
        System.out.println(sb.toString());
    }
}

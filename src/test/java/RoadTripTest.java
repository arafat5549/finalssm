//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.jqmkj.roadtrip.base.BaseMapper;
//import com.jqmkj.roadtrip.common.Constant;
//import com.jqmkj.roadtrip.common.InitDataGenerator;
//import com.jqmkj.roadtrip.dao.TripHotelCategoryDao;
//import com.jqmkj.roadtrip.dao.TripRouteCategoryDao;
//import com.jqmkj.roadtrip.dao.TripScenicCategoryDao;
//import com.jqmkj.roadtrip.entity.TripScenicCategory;
//import com.ssf.common.twitter.IDGenerator.IdWorker;
//import com.ssf.utils.TestObjectUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName ：RoadTripTest
// * @Description: TODO
// * @Author ：wangyao
// * @Date ：2019/1/4 上午11:49
// */
//
//public class RoadTripTest {
//
//    private TripScenicCategoryDao tripScenicCategoryDao;
//    private TripRouteCategoryDao  tripRouteCategoryDao;
//    private TripHotelCategoryDao  tripHotelCategoryDao;
//
//
//    private IdWorker idWorker;
//    private Iterable<Object> yaml;
//    @Before
//    public void prepare() throws Exception {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
//
//        tripScenicCategoryDao = (TripScenicCategoryDao) ctx.getBean("tripScenicCategoryDao");
//        tripRouteCategoryDao  = (TripRouteCategoryDao) ctx.getBean("tripRouteCategoryDao");
//        tripHotelCategoryDao  = (TripHotelCategoryDao) ctx.getBean("tripHotelCategoryDao");
//
//        idWorker = new IdWorker(1,1);
//        yaml = InitDataGenerator.loadYaml();
//    }
//
//    private BaseMapper getCategoryDao(int type){
//        BaseMapper mapper = null;
//        if (type == Constant.TripGpsType.TripGps_Scenic.type()){
//            mapper = tripScenicCategoryDao;
//        }
//        else if (type == Constant.TripGpsType.TripGps_Route.type()){
//            mapper = tripRouteCategoryDao;
//        }
//        else if (type == Constant.TripGpsType.TripGps_Hotel.type()){
//            mapper = tripHotelCategoryDao;
//        }
//        return mapper;
//    }
//
//
//
//    @Test
//    public void selectListByMapTest() {
//        int type = Constant.TripGpsType.TripGps_Scenic.type();
//        List<TripScenicCategory> ret = getCategoryDao(type).selectListByMap(null);
//        System.out.println("测试selectListByMap："+ret);
//    }
//
//
//    /**
//     * 自驾游分类
//     */
//    @Test
//    public void initTripCategorty(){
//        int type = Constant.TripGpsType.TripGps_Scenic.type();
//        Map<String,List<String>> map = Maps.newHashMap();
//        map.put("全部", Lists.newArrayList("全部"));
//        map.put("景点/门票",Lists.newArrayList("全部景点/门票","自然风光","名胜古迹","观光街区","公园游乐场","其他景点/门票"));
//        map.put("展馆展览",Lists.newArrayList("全部展馆展览","科技馆","美术馆","博物馆","天文馆","蜡像馆","其他展馆展览"));
//        _inittripCategory(map,type);
//
//        //线路
//        _inittripCategory(null,Constant.TripGpsType.TripGps_Route.type());
//    }
//
//
//
//
//    private void _inittripCategory( Map<String,List<String>> map,int type){
//        List<String> root = Constant.TripGpsType.all(type);
//
//        List<TripScenicCategory> alllist = Lists.newArrayList();
//        List<TripScenicCategory> rootlist = InitDataGenerator.initTripCategorty(root,Constant.Common.ROOT_SORT,0,0,idWorker,0);
//        alllist.addAll(rootlist);
//
//        for(TripScenicCategory c:rootlist){
//            List<String> level1 = Constant.TripGpsType.getListByName(c.getName());
//            if (level1!=null){
//                List<TripScenicCategory> sublist = InitDataGenerator.initTripCategorty(level1,Constant.Common.ROOT_SUBSORT,1,0,idWorker,c.getId());
//                alllist.addAll(sublist);
//
//                for(TripScenicCategory c2:sublist){
//                    if(map!=null){
//                        for(String key:map.keySet()){
//                            if (c2.getName().startsWith(key)){
//                                alllist.addAll(InitDataGenerator.initTripCategorty(map.get(key),Constant.Common.ROOT_CHILDSORT,2,1,idWorker,c2.getId()));
//                            }
//                        }
//                    }
//                }
//            }
//            else{
//
//            }
//        }
//        for(TripScenicCategory c:alllist){
//            if(c.getLevel()==0){
//                TestObjectUtils.print(c.getName());
//            }
//            else if(c.getLevel()==1)
//                TestObjectUtils.print(c.getName(),"\t", TestObjectUtils.PrintColor.C_OKBLUE);
//            else if(c.getLevel()==2)
//                TestObjectUtils.print(c.getName(),"\t\t",TestObjectUtils.PrintColor.C_OKGREEN);
//        }
//        System.out.println(alllist.size()+","+rootlist.size());
//        getCategoryDao(type).batchInsert(alllist);
//    }
//
//
//
//}

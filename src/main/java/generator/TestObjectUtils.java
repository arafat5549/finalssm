package generator;

/**
 * @ClassName ：TestObjectUtils
 * @Description: TODO
 * @Author ：wangyao
 * @Date ：2018/12/28 上午9:07
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

    public static String printColor(String s,PrintColor color){
        return  printColor(s,color,"","");
    }

    public static String printColor(String s){
        return  printColor(s,PrintColor.C_OKBLUE,"","");
    }

    public static String printColor(String s,PrintColor color,String prefix,String suffix){
        StringBuffer sb= new StringBuffer();
        sb.append(prefix);
        sb.append(color.value()+s+PrintColor.C_ENDC.value());
        sb.append(suffix);
        System.out.println(sb.toString());
        return sb.toString();

    }
}

package generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * 运行sql语句 创建数据库和测试数据
 * @author wyy
 *
 */
public class DataBasePopulator {

	
	//private static Logger logger = LoggerFactory.getLogger(DataBasePopulator.class);
	//private static boolean init =false;
	

	
	public static Connection getConnection(Properties props) 
	{
		String driver   = props.getProperty("jdbc.driverClassName");
		String url      = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return connection;
	}
	
	public static void initDatabase(Properties props,List<String> sqls)
	{
		Connection connection = null;
		Reader reader = null;
		try {
			
			connection = getConnection(props);
			ScriptRunner scriptRunner = new ScriptRunner(connection);
			
			for (String sql:sqls) {
				//reader = Resources.getResourceAsReader(sql);
				reader= Files.newReader(new File(sql), Charset.defaultCharset());
				scriptRunner.runScript(reader);
				//logger.info("执行sql文件成功:["+sql+"]");
			}
			
//			reader = Resources.getResourceAsReader("sql/finalssm_data.sql");
//			scriptRunner.runScript(reader);
//			logger.info("生成数据成功:[sql/finalssm_data.sql]");
			
			connection.commit();
			reader.close();
			scriptRunner.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取数据库表信息
	 */
	public static List<String> getTableContent(Properties props,String dbName,String databaseId,String tableName){
		String sql = "select * from information_schema.columns where table_schema = '"+dbName+"' and table_name = '"+tableName+"'";
		if(databaseId == "oracle"){
			return Lists.newArrayList();
		}
		List<String> lists = Lists.newArrayList();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(props);
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()){
				String tname = rs.getString("COLUMN_NAME");
				lists.add(tname);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null )   rs.close();
				if(ptmt!=null ) ptmt.close();
				if(conn!=null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}

	/**
	 * 获取所有数据库的名称
	 * 
	 * 
	 * @param databaseId ='mysql' , "oracle" , "sqlserver" 默认为 mysql
	 * @return
	 */
	public static List<String> getTableNames(Properties props,String dbName,String databaseId)
	{
		//用sql获取数据库中所有的表名的方法：
		//1、oracle下：select table_name from all_tables;
		//2、MySQL下：select table_name from information_schema.tables where table_schema='csdb' and table_type='base table';
		//3、sql server下：select name from sys.tables go
		
		String sql = "select table_name from information_schema.tables where table_schema='"+dbName+"' ;"; //and table_type='base table'
		if(databaseId == "oracle"){
			sql = "select table_name from all_tables;";
		}
		
		List<String> lists = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(props);
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			//ResultSetMetaData rsmd = rs.getMetaData();
			//int columnCount = rsmd.getColumnCount();
			while(rs.next()){
				String tname = rs.getString("table_name"); 
				lists.add(tname);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null )   rs.close();
				if(ptmt!=null ) ptmt.close();
				if(conn!=null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
	/**
	 * 获取数据库表的注释信息
	 *
	 */
	public static Map<String,String> getTableComments(Properties props, String dbName, String databaseId,boolean all)
	{
		String sql = "select table_name,table_comment from information_schema.tables where table_schema='"+dbName+"' ;"; //and table_type='base table'
		if(databaseId == "oracle"){
			sql = "select table_name,table_comment from all_tables;";
		}
		Map<String,String> maps = Maps.newHashMap();//new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(props);
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();;
			while(rs.next()){
				String tname   = rs.getString("table_name");
				String comment = rs.getString("table_comment");
				if(all)
				{
					maps.put(tname, comment);
				}else{
					if(MybatisGenerator.isMacthPrefix(tname))
						maps.put(tname, comment);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null )   rs.close();
				if(ptmt!=null ) ptmt.close();
				if(conn!=null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maps;
	}

}

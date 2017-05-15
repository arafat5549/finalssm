package guava.database;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 运行sql语句
 * @author wyy
 *
 */
public class DataBasePopulator {

	private static final Properties PROPERTIES = new Properties();
	private static Logger logger = LoggerFactory.getLogger(DataBasePopulator.class);
	
	static
	{
		try {
			InputStream is = DataSourceFactory.class.getResourceAsStream("/jdbc.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() 
	{
		String driver   = PROPERTIES.getProperty("jdbc.driverClassName");
		String url      = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return connection;
	}
	
	public static void initDatabase()
	{
		Connection connection = null;
		Reader reader = null;
		try {
			
			connection = getConnection();
			ScriptRunner scriptRunner = new ScriptRunner(connection);
			
			reader = Resources.getResourceAsReader("sql/finalssm.sql");
			scriptRunner.runScript(reader);
			logger.info("创建数据表结构成功:[sql/finalssm.sql]");
			
			reader = Resources.getResourceAsReader("sql/finalssm_data.sql");
			scriptRunner.runScript(reader);
			logger.info("生成数据成功:[sql/finalssm_data.sql]");
			
			connection.commit();
			reader.close();
			scriptRunner.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		initDatabase();
	}
}

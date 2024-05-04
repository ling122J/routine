package hx.userdao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/customer?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "WLJ122927";
    private Connection conn = null;

    public DBConnection() throws Exception { // 进行数据库连接
        try {
            Class.forName(Driver); // 用反射加载数据库驱动
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("数据库驱动加载失败");
        }
    }
    public Connection getConnection() {
        return this.conn; // 取得数据库的连接
    }
    public void close() throws Exception { // 关闭数据库
        if (this.conn != null) {
            try {
                this.conn.close(); // 数据库关闭
            } catch (Exception e) {
                throw e;
            }
        }
    }
}

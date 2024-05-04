package hx.userdao;

import hx.entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private Connection con = null;
    private PreparedStatement pst = null;

    public UserDaoImpl(Connection con) {
        this.con = con;
    }
    @Override
    public boolean AddUser(Users user){
        System.out.println("调用UserDaoImpl-----add方法");
        boolean flag = false;
        String userSql = "insert into users(userName,password,sex,email) values (?,?,?,?)";
        String managerSql = "insert into manager(userName,password,sex,email) values (?,?,?,?)";
        try {
            if (user.isManager()) {
                pst = this.con.prepareStatement(managerSql);
            } else {
                pst = this.con.prepareStatement(userSql);
            }
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getSex());
            pst.setString(4, user.getEmail());
            if (pst.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("UserDaoImpl---add方法pst对象关闭异常");
            }
        }
        return flag;
    }

    @Override
    public List<Users> findByUserEmail(String email){
        System.out.println("调用UserDaoImpl----find方法");
        List<Users> u =  new ArrayList<Users>();
        String userSql = "select * from users where email=?";
        String managerSql = "select * from manager where email=?";
        String query = "select * from manager union all select * from users";
        ResultSet rs = null;
        try {//先通过传入的邮箱进行身份识别,管理员|普通用户|未记录在数据库的新邮箱
            pst = this.con.prepareStatement(managerSql);//先查管理员表
            pst.setString(1, email);
            rs = pst.executeQuery();//rs不会为null
            if(!rs.isBeforeFirst()) {//用isBeforeFirst()方法判断rs是否为空(),结果集为空返回false
                rs.close();
                pst.close();
                pst = this.con.prepareStatement(userSql);
                pst.setString(1,email);
                rs = pst.executeQuery();
                while(rs.next()){
                    u.add(new Users(rs.getInt(1),rs.getString(2),
                            rs.getString(3), rs.getString(4),
                            rs.getString(5)));
                }
            }else{//管理员可以查询所有人信息,以下代码实现此功能
                rs.close();
                pst.close();
                pst = this.con.prepareStatement(query);
                rs = pst.executeQuery();
//                System.out.println(rs.isBeforeFirst());//调试结果:false|true,查看条件正确的情况下是否执行到此分支
                while(rs.next()){
                    u.add(new Users(rs.getInt(1),rs.getString(2),
                            rs.getString(3), rs.getString(4),
                            rs.getString(5)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("UserDaoImpl---find方法pst/rs对象关闭异常");
            }
            //System.out.println(u.size());
            return u;
        }
    }
    /*@Override
    public boolean LogOff(String name,String password,String email){
        boolean flag = false;
        //进行身份核验
        List<Users> list = this.findByUserEmail(email);
        return flag;
    }*/
}

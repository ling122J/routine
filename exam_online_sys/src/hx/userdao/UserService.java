package hx.userdao;

import hx.entity.Users;

import java.util.List;


public class UserService implements UserDao{
    private DBConnection dbcon = null;
    private UserDao dao = null;
    public UserService() throws Exception{
        System.out.println("已进入UserService");
        this.dbcon = new DBConnection();//建立连接
        dao = new UserDaoImpl(dbcon.getConnection());
    }
    @Override
    public boolean AddUser(Users user){
        System.out.println("调用UserService----add方法");
        boolean flag = false;
        try {
            if(dao.findByUserEmail(user.getEmail()).isEmpty()){
                flag = dao.AddUser(user);
            }
        } catch (Exception e) {
            System.out.println("UserService----add方法异常");
            e.printStackTrace();
        } finally {
            try {
                this.dbcon.close();
            } catch (Exception e) {
                System.out.println("UserService---连接关闭异常");
            }
        }
        return flag;
    }

    @Override
    public List<Users> findByUserEmail(String email) {
        System.out.println("调用UserService----find方法");
        List<Users> list = null;
        try {
            list = dao.findByUserEmail(email);
        } catch (Exception e) {
            System.out.println("UserService----find方法异常");
            e.printStackTrace();
        } finally {
            try {
                this.dbcon.close();
            } catch (Exception e) {
                System.out.println("UserService----find方法异常");
                e.printStackTrace();
            }
        }
        return list;
    }
}

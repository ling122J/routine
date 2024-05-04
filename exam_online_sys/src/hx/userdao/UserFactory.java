package hx.userdao;

public class UserFactory {
    public static UserDao getUserDaoInstance() throws Exception{
        System.out.println("已进入UserFactory");
        return new UserService();
    }
}

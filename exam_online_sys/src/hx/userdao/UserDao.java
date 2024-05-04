package hx.userdao;

import hx.entity.Users;

import java.util.List;

public interface UserDao {
    boolean AddUser(Users user);
    List<Users> findByUserEmail(String email);
    /*boolean LogOff(String name,String password,String email);
    boolean Modify(String name,String password,String email);*/
}

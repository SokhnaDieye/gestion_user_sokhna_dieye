package dao;

import entity.Role;
import entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{
    private DB db=new DB();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(User u) {
        String sql="INSERT INTO user VALUES(NULL,?,?,?,?)";
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1,u.getEmail());
            db.getPstm().setString(2,u.getPassword());
            db.getPstm().setString(3,u.getPassword_hashed());
            db.getPstm().setInt(4,u.getRole().getId());
            ok=db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> list() {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM user u,role r WHERE u.id_role = r.id";
        try {
            db.initPrepar(sql);
            rs = db.executeSelct();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("u.id"));
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.password"));
                u.setPassword_hashed(rs.getString("u.password_hashed"));
                IRole roleDao = new RoleImpl();
                Role role = roleDao.get(rs.getInt("r.id"));
                u.setRole(role);
                user.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

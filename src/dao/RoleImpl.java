package dao;

import entity.Role;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleImpl implements IRole{
    private DB db = new DB();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Role r) {
        String sql = "INSERT INTO role(id, name) VALUES(null, ?)";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, r.getName());
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Role> list() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role";
        try {
            db.initPrepar(sql);
            rs = db.executeSelct();
            while (rs.next()){
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                roles.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role get(int id) {
        String sql = "SELECT * FROM role WHERE id = ?";
        Role r = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            rs = db.executeSelct();
            if (rs.next()){
                r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }
}

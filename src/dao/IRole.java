package dao;


import entity.Role;

import java.util.List;

public interface IRole {
    public int add(Role r);
    public List<Role> list();

    Role get(int id);
}

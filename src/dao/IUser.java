package dao;

import entity.User;

import java.util.List;

public interface IUser {
    public int add(User u);
    public List<User> list();

}

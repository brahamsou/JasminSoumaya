package fr.jasmin.model.dao.interfaces;

import java.util.List;

import fr.jasmin.entity.User;



public interface IUserDao {
    void addClient(User user) throws Exception;
    User getClient(Integer id) throws Exception;
    void updateClient(User user) throws Exception;
    void removeClient(Integer id) throws Exception;
    List<User> getClients();
    void removeClient(User user) throws Exception;
}


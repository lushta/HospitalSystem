package model.dao;


import model.beans.User;

import java.util.List;

/**
 * Created by lushta on 07.06.14.
 */
public interface UserDAO {

    List<User> getUsers();
    User getUser(User user);
    List<User> getPatientsForDoctor(int doctorId);
    List<User> getUsersDoctors(int user);
    boolean addUser(User user);
    boolean deleteUser(int id);
    User getUserById(int id);
    List<User> getAllDoctors();
    List<User> getAllPatients();
    List<User> getDischargedPatients();
}
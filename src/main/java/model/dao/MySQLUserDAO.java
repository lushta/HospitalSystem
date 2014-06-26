package model.dao;


import model.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static logger.HospitalLogger.LOGGER;

/**
 * Created by lushta on 07.06.14.
 */
public class MySQLUserDAO implements UserDAO {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement statement;
    List<User> users;
    User user;

    public MySQLUserDAO(){
        connection = ConnectionPool.getConnection();
        resultSet = null;
        statement = null;
        users = new ArrayList();
        user = null;
    }

    //find and return all users
    @Override
    public List<User> getUsers() {
        try {
            statement = connection.prepareStatement(SQlQueries.FIND_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //create user from resultSet's data
    private User load(ResultSet resultSet) {
        User user = new User();
            try{
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setPatronymic(resultSet.getString("patronymic"));
                user.setDate_of_birth(resultSet.getDate("date_of_birth"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setRole_id(resultSet.getInt("role_id"));
            } catch (SQLException e){
                LOGGER.error(e);
            }
        return user;
    }
    //find doctors by patient id
    @Override
    public List<User> getUsersDoctors(int userId) {
        try {
            statement = connection.prepareStatement(SQlQueries.FIND_DOCTORS_BY_PATIENT_ID);
            statement.setString(1, String.valueOf(userId));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //find user by login and password
    @Override
    public User getUser(User user) {
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.FIND_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();
            if(resultSet.first()){
                User newUser = load(resultSet);
                return newUser;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //find doctor's patients
    @Override
    public List<User> getPatientsForDoctor(int doctorId) {
        try {
            statement = connection.prepareStatement(SQlQueries.FIND_PATIENTS_BY_DOCTOR_ID);
            statement.setString(1, String.valueOf(doctorId));
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //find user by his id
    @Override
    public User getUserById(int id) {
        try {
            statement = connection.prepareStatement(SQlQueries.GET_USER_BY_ID);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            if(resultSet.first()){
                User newUser = load(resultSet);
                return newUser;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //return list of all doctors and nurses
    @Override
    public List<User> getAllDoctors() {
        try {
            statement = connection.prepareStatement(SQlQueries.GET_STAFF);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }
    //close resources
    private void close(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public List<User> getAllPatients() {
        try {
            statement = connection.prepareStatement(SQlQueries.GET_ALL_PATIENTS);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;    }

    @Override
    public boolean addUser(User user) {
        try{
            statement = connection.prepareStatement(SQlQueries.COUNT_USERS_BY_LOGIN);
            statement.setString(1, user.getLogin());
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getInt(1) != 0){
                    return false;
                }
            }
        }catch (SQLException e){
            LOGGER.error(e);
            e.printStackTrace();
        }finally {
            close(resultSet, statement, connection);
        }
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.ADD_USER);
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getFirst_name());
            statement.setString(3, user.getPatronymic());
            statement.setDate(4, user.getDate_of_birth());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPhone_number());
            statement.setInt(7, user.getRole_id());
            statement.setString(8, user.getLogin());
            statement.setString(9, user.getPassword());
            int i = statement.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            e.printStackTrace();
        } finally {
            close(resultSet, statement, connection);
        }
        return false;
    }

    @Override
    public List<User> getDischargedPatients() {
        try {
            statement = connection.prepareStatement(SQlQueries.GET_DISCHARGED_PATIENTS);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                user = load(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            statement = connection.prepareStatement(SQlQueries.DELETE_USER);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            close(resultSet, statement, connection);
        }
        return false;
    }
}

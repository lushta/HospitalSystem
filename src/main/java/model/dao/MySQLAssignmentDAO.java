package model.dao;

import model.beans.Assignment;
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
public class MySQLAssignmentDAO implements AssignmentDAO {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement statement;
    List result;
    List<Assignment> assignments;
    List<String> staff;
    Assignment assignment;

    public MySQLAssignmentDAO(){
        connection = null;
        resultSet = null;
        statement = null;
        result = new ArrayList<>();
        assignments = new ArrayList<>();
        staff = new ArrayList<>();
        assignment = new Assignment();
    }
    //return assignments by admission's id
    @Override
    public List getAssignments(int id) {
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.GET_ASSIGNMENTS_BY_ADMISSION_ID);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                assignment = load(resultSet);
                assignments.add(assignment);
            }
            result.add(assignments);
            return result;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return null;
    }

    @Override
    public List<Assignment> getActiveAssignments(String userRole, int userId) {
        try {
            connection = ConnectionPool.getConnection();
            if("2".equals(userRole)){
                statement = connection.prepareStatement(SQlQueries.GET_ACTIVE_ASSIGNMENTS_FOR_DOCTOR);
                statement.setInt(1,userId);
            }else{
                statement = connection.prepareStatement(SQlQueries.GET_ACTIVE_ASSIGNMENTS_FOR_NURSE);
            }
            resultSet = statement.executeQuery();
            User user = null;
            List<User> userList = new ArrayList<>();
            while(resultSet.next()){
                assignment = load(resultSet);
                assignments.add(assignment);
                user = new User();
                user.setFirst_name(resultSet.getString("first_name"));
                user.setSurname(resultSet.getString("surname"));
                userList.add(user);
            }
            result.add(assignments);
            result.add(userList);
            return result;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return null;
    }

    //add new treatment
    @Override
    public boolean prescribeTreatment(int admissionId, String name, String type, String date,
                                      String time) {
        time = time + ":00";
        Date treatmentDate = Date.valueOf(date);
        Time treatmentTime = Time.valueOf(time);
        Calendar treatmentDateTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
        treatmentDateTime.setTimeInMillis(treatmentDate.getTime() + treatmentTime.getTime());
        java.sql.Date mySqlDate = new java.sql.Date(treatmentDateTime.getTimeInMillis());
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.ADD_NEW_TREATMENT);
            statement.setInt(1, admissionId);
            statement.setString(2, name);
            statement.setString(3, type);
            statement.setDate(4, mySqlDate);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return false;
    }
    //set performer of assignment
    @Override
    public boolean setPerformer(int performerId, int assignmentId) {
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.SET_PERFORMER);
            statement.setInt(1, performerId);
            statement.setInt(2, assignmentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return false;
    }

    //create assignment from resultSet's data
    private Assignment load(ResultSet resultSet) {
        Assignment assignment = new Assignment();
        try{
            assignment.setId(resultSet.getInt("id"));
            assignment.setAdmission_id(resultSet.getInt("admission_id"));
            assignment.setName(resultSet.getString("name"));
            assignment.setType(resultSet.getString("type"));
            assignment.setDate_of_execution(resultSet.getDate("date_of_execution"));
            assignment.setPerformer_id(resultSet.getInt("performer_id"));
        } catch (SQLException e){
            LOGGER.error(e);
        }
        return assignment;
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
}

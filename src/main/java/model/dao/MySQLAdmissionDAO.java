package model.dao;

import model.beans.Admission;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static logger.HospitalLogger.LOGGER;

/**
 * Created by lushta on 07.06.14.
 */
public class MySQLAdmissionDAO implements AdmissionDAO {

    Connection connection;
    ResultSet resultSet;
    PreparedStatement statement;
    List result;
    List<Admission> admissions;
    List<String> doctors;
    Admission admission;

    public MySQLAdmissionDAO(){
        connection = null;
        resultSet = null;
        statement = null;
        result = new ArrayList<>();
        admissions = new ArrayList<>();
        doctors = new ArrayList<>();
        admission = new Admission();
    }
    //select admissions by patient id
    @Override
    public List getAdmissions(int id) {
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.GET_ADMISSIONS_BY_PATIENT_ID);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                admission = load(resultSet);
                admissions.add(admission);
                doctors.add(resultSet.getString("surname"));
            }
            result.add(admissions);
            result.add(doctors);
            return result;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return null;
    }
    private Admission load(ResultSet resultSet) {
        Admission admission = new Admission();
        try{
            admission.setId(resultSet.getInt("id"));
            admission.setDoctor_id(resultSet.getInt("doctor_id"));
            admission.setDate_of_admission(resultSet.getDate("date_of_admission"));
            admission.setDate_of_discharge(resultSet.getDate("date_of_discharge"));
            admission.setDiagnosis(resultSet.getString("diagnosis"));
        } catch (SQLException e){
            LOGGER.error(e);
        }
        return admission;
    }
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
    //discharge patient
    @Override
    public boolean discharge(int admissionId, String diagnosis, String date) {
        Date dischargeDate = Date.valueOf(date);
        Calendar dischargeDateTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
        dischargeDateTime.setTimeInMillis(dischargeDate.getTime());
        java.sql.Date mySqlDate = new java.sql.Date(dischargeDateTime.getTimeInMillis());
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQlQueries.DISCHARGE);
            statement.setDate(1, mySqlDate);
            statement.setString(2, diagnosis);
            statement.setInt(3, admissionId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(resultSet,statement,connection);
        }
        return false;
    }
}

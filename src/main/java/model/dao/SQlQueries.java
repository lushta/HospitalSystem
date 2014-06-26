package model.dao;

import java.util.ResourceBundle;

/**
 * Created by lushta on 22.06.14.
 */
public class SQlQueries {

    static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("queries");

    static final String GET_ADMISSIONS_BY_PATIENT_ID =
            RESOURCE_BUNDLE.getString("getAdmissionsByPatientId");

    static final String DISCHARGE =
            RESOURCE_BUNDLE.getString("discharge");

    static final String GET_ASSIGNMENTS_BY_ADMISSION_ID =
            RESOURCE_BUNDLE.getString("getAssignmentsByAdmissionId");

    static final String GET_ACTIVE_ASSIGNMENTS_FOR_DOCTOR =
            RESOURCE_BUNDLE.getString("getActiveAssignmentsForDoctor");

    static final String GET_ACTIVE_ASSIGNMENTS_FOR_NURSE =
            RESOURCE_BUNDLE.getString("getActiveAssignmentsForNurse");

    static final String ADD_NEW_TREATMENT =
            RESOURCE_BUNDLE.getString("addNewTreatment");

    static final String SET_PERFORMER =
            RESOURCE_BUNDLE.getString("setPerformer");

    static final String FIND_ALL_USERS =
            RESOURCE_BUNDLE.getString("findAllUsers");

    static final String FIND_DOCTORS_BY_PATIENT_ID =
            RESOURCE_BUNDLE.getString("findDoctorsByPatientId");

    static final String FIND_USER_BY_LOGIN_AND_PASSWORD =
            RESOURCE_BUNDLE.getString("findUserByLoginAndPassword");

    static final String FIND_PATIENTS_BY_DOCTOR_ID =
            RESOURCE_BUNDLE.getString("findPatientsByDoctorId");

    static final String GET_USER_BY_ID =
            RESOURCE_BUNDLE.getString("getUserById");

    static final String GET_STAFF =
            RESOURCE_BUNDLE.getString("getStaff");

    static final String GET_ALL_PATIENTS =
            RESOURCE_BUNDLE.getString("getAllPatients");

    static final String ADD_USER =
            RESOURCE_BUNDLE.getString("addUser");

    static final String COUNT_USERS_BY_LOGIN =
            RESOURCE_BUNDLE.getString("count_users_by_login");

    static final String GET_DISCHARGED_PATIENTS =
            RESOURCE_BUNDLE.getString("get_discharged_patients");

    static final String DELETE_USER =
            RESOURCE_BUNDLE.getString("delete_user");
}

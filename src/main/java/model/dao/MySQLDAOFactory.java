package model.dao;

/**
 * Created by lushta on 07.06.14.
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new MySQLRoleDAO();
    }

    @Override
    public AdmissionDAO getAdmissionDAO() {
        return new MySQLAdmissionDAO();
    }

    @Override
    public AssignmentDAO getAssignmentDAO() {
        return new MySQLAssignmentDAO();
    }
}

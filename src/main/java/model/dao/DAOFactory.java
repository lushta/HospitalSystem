package model.dao;

/**
 * Created by lushta on 07.06.14.
 */
public abstract class DAOFactory {
    public enum Factories {
        MYSQL
    }

    public abstract UserDAO getUserDAO();
    public abstract RoleDAO getRoleDAO();
    public abstract AdmissionDAO getAdmissionDAO();
    public abstract AssignmentDAO getAssignmentDAO();

    public static DAOFactory getDAOFactory(Factories factoryName) {
        switch (factoryName) {
            case MYSQL: return new MySQLDAOFactory();
            default: return null;
        }
    }
}

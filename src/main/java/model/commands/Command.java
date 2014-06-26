package model.commands;

import model.dao.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lushta on 07.06.14.
 */
public abstract class Command {
    protected static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}

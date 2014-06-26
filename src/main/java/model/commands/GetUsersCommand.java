package model.commands;


import model.beans.User;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lushta on 10.06.14.
 */
public class GetUsersCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        UserDAO userDAO = daoFactory.getUserDAO();
        List<User> users = userDAO.getUsers();
        if (users != null) {
            request.setAttribute("users", users);
        }
    }
}

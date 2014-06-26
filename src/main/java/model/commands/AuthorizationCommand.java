package model.commands;

import model.beans.User;
import model.dao.UserDAO;
import static logger.HospitalLogger.LOGGER;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lushta on 14.06.14.
 */
public class AuthorizationCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try{
            if(login.length() > 2 && password.length() > 2){
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                UserDAO userDAO = daoFactory.getUserDAO();
                User checkedUser = userDAO.getUser(user);
                if (checkedUser != null) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userId", checkedUser.getId());
                    session.setAttribute("userRole", checkedUser.getRole_id());
                    session.setAttribute("userName", checkedUser.getFirst_name() + " " +
                                            checkedUser.getSurname());
                    session.setAttribute("language", request.getParameter("language"));
                }
            }
        }catch (Exception e){
            LOGGER.error(e);
        }
    }
}

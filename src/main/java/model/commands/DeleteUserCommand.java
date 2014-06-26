package model.commands;

import model.dao.UserDAO;
import static logger.HospitalLogger.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lushta on 25.06.14.
 */
public class DeleteUserCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = daoFactory.getUserDAO();
        try{
            boolean isDeleted = userDAO.deleteUser(
                    Integer.valueOf(request.getParameter("patient id")));
            if(isDeleted){
                request.setAttribute("isDeleted", isDeleted);
            }
        } catch (Exception e){
            LOGGER.error(e);
        }
    }
}

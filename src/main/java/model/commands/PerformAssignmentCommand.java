package model.commands;

import model.dao.AssignmentDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static logger.HospitalLogger.LOGGER;

/**
 * Created by lushta on 22.06.14.
 */
public class PerformAssignmentCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AssignmentDAO assignmentDAO = daoFactory.getAssignmentDAO();
        try{
            boolean isPerformed = assignmentDAO.setPerformer(
                    (Integer)request.getSession().getAttribute("userId"),
                    Integer.valueOf(request.getParameter("assignmentId")));
            request.setAttribute("isPerformed", isPerformed);
        } catch (Exception e){
            LOGGER.error(e);
        }
    }
}

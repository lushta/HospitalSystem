package model.commands;

import model.dao.AssignmentDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lushta on 21.06.14.
 */
public class GetActiveAssignmentsCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AssignmentDAO assignmentDAO = daoFactory.getAssignmentDAO();
        List result = assignmentDAO.getActiveAssignments(
                String.valueOf(request.getSession().getAttribute("userRole")),
                (Integer)request.getSession().getAttribute("userId"));
        if (result != null) {
            request.setAttribute("assignments", result.get(0));
            request.setAttribute("users", result.get(1));
        }
    }
}

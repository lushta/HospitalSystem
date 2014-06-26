package model.commands;

import model.dao.AssignmentDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lushta on 18.06.14.
 */
public class GetAssignmentsCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AssignmentDAO assignmentDAO = daoFactory.getAssignmentDAO();
        List assignments = assignmentDAO.getAssignments(
                Integer.valueOf(request.getParameter("admissionId")));
        if (assignments != null) {
            request.setAttribute("assignments", assignments.get(0));
        }
    }
}

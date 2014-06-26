package model.commands;

import model.beans.Assignment;
import model.dao.AdmissionDAO;
import model.dao.AssignmentDAO;

import static logger.HospitalLogger.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lushta on 21.06.14.
 */
public class PrescribeTreatmentCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AssignmentDAO assignmentDAO = daoFactory.getAssignmentDAO();
        boolean isPrescribed = assignmentDAO.prescribeTreatment(
                Integer.valueOf((String)request.getSession().getAttribute("admissionId")),                   request.getParameter("name"),
                request.getParameter("type"),
                request.getParameter("date"),
                request.getParameter("time"));
        request.setAttribute("isPrescribed", isPrescribed);
    }
}

package model.commands;

import model.beans.Admission;
import model.beans.User;
import model.dao.AdmissionDAO;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lushta on 20.06.14.
 */
public class GetAdmissionsByPatientIdCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AdmissionDAO admissionDAO = daoFactory.getAdmissionDAO();
        List admissionsList = admissionDAO.getAdmissions(
                Integer.valueOf(request.getParameter("patientId")));
        List admissions = (List)admissionsList.get(0);
        if (admissions != null) {
            request.setAttribute("admissions", admissions);
            UserDAO userDAO = daoFactory.getUserDAO();
            User user = userDAO.getUserById(
                    Integer.valueOf(request.getParameter("patientId")));
            request.setAttribute("patient", user);
        }
    }
}

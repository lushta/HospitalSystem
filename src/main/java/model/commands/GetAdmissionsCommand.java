package model.commands;

import model.dao.AdmissionDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lushta on 18.06.14.
 */
public class GetAdmissionsCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AdmissionDAO admissionDAO = daoFactory.getAdmissionDAO();
        List admissions = admissionDAO.getAdmissions(
                (Integer)request.getSession().getAttribute("userId"));
        if (admissions != null) {
            request.setAttribute("doctors", admissions.get(1));
            request.setAttribute("admissions", admissions.get(0));
        }
    }
}

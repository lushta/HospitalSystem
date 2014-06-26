package model.commands;

import model.dao.AdmissionDAO;
import static logger.HospitalLogger.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lushta on 21.06.14.
 */
public class DischargePatientCommand extends Command {

    //try to discharge patient by admission
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        AdmissionDAO admissionDAO = daoFactory.getAdmissionDAO();
        try{
            boolean isDischarged = admissionDAO.discharge(
                    Integer.valueOf((String)request.getSession().getAttribute("admissionId")),
                    request.getParameter("diagnosis"),
                    request.getParameter("date"));
            request.setAttribute("isDischarged", isDischarged);
        } catch (Exception e){
            LOGGER.error(e);
        }
    }
}

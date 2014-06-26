package model.commands;

import model.beans.User;
import model.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by lushta on 24.06.14.
 */
public class AddPatientCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = daoFactory.getUserDAO();
        User newPatient = new User();
        newPatient.setSurname(request.getParameter("surname"));
        newPatient.setFirst_name(request.getParameter("first_name"));
        newPatient.setPatronymic(request.getParameter("patronymic"));
        newPatient.setDate_of_birth(Date.valueOf(request.getParameter("date_of_birth")));
        newPatient.setAddress(request.getParameter("address"));
        newPatient.setPhone_number(request.getParameter("phone_number"));
        newPatient.setRole_id(1);
        newPatient.setLogin(request.getParameter("login"));
        newPatient.setPassword(request.getParameter("password"));
        boolean isAdd = userDAO.addUser(newPatient);
        if(isAdd){
            request.setAttribute("isAdd", isAdd);
        }
    }
}

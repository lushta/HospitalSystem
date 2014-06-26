package controller;

import model.commands.Command;
import model.commands.CommandFactory;
import static logger.HospitalLogger.LOGGER;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by lushta on 31.05.14.
 */

public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request,response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        String url = "/WEB-INF/pages/";
        HttpSession session = request.getSession();
        CommandFactory commandFactory = CommandFactory.getInstance();
        Command command = null;

        if(userPath.equals("/authorization")){
            command = commandFactory.getCommand("authorization");
            command.execute(request, response);
            if (session.getAttribute("userId") == null) {
                url += "common/authorization.jsp";
            } else if (Integer.valueOf(session.getAttribute("userRole").toString()) == 1){
                command = commandFactory.getCommand("get_admissions");
                command.execute(request, response);
                url += "patient/patientAdmissions.jsp";
            } else if (Integer.valueOf(session.getAttribute("userRole").toString()) == 2){
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }else if (Integer.valueOf(session.getAttribute("userRole").toString()) == 3){
                command = commandFactory.getCommand("get_all_patients");
                command.execute(request, response);
                url += "nurse/nursePatients.jsp";
            }
        } else if(userPath.equals("/assignments")){
            if (Integer.valueOf(session.getAttribute("userRole").toString()) == 1){
                command = commandFactory.getCommand("get_assignments");
                command.execute(request, response);
                url += "patient/patientAssignments.jsp";
            }else if (Integer.valueOf(session.getAttribute("userRole").toString()) == 2 ||
                    Integer.valueOf(session.getAttribute("userRole").toString()) == 3){
                command = commandFactory.getCommand("get_assignments");
                command.execute(request, response);
                url += "doctor/doctorAssignments.jsp";
            }
        } else if(userPath.equals("/admissions")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("get_admissions_by_patient_id");
                command.execute(request, response);
                url += "doctor/doctorAdmissions.jsp";
            }if(session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("get_admissions_by_patient_id");
                command.execute(request, response);
                url += "nurse/nurseAdmissions.jsp";
            }
        }else if(userPath.equals("/start_page")){
            if(session.getAttribute("userRole").equals(1)){
                command = commandFactory.getCommand("get_admissions");
                command.execute(request, response);
                url += "patient/patientAdmissions.jsp";
            } else if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }else if(session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("get_all_patients");
                command.execute(request, response);
                url += "nurse/nursePatients.jsp";
            }
        } else if(userPath.equals("/show_doctors")){
            if(session.getAttribute("userRole").equals(1)){
                command = commandFactory.getCommand("get_users_doctors");
                command.execute(request, response);
                url += "patient/patientDoctors.jsp";
            }else if(session.getAttribute("userRole").equals(2) ||
                    session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("get_all_doctors");
                command.execute(request, response);
                url += "doctor/doctorStaff.jsp";
            }
        }else if(userPath.equals("/logout")){
            command = commandFactory.getCommand("exit");
            command.execute(request, response);
            url += "common/authorization.jsp";
        }else if(userPath.equals("/discharge_patient")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("discharge_patient");
                command.execute(request, response);
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }
        }else if(userPath.equals("/prescribe_treatment")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("prescribe_treatment");
                command.execute(request, response);
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }else if(session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("prescribe_treatment");
                command.execute(request, response);
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }
        }else if(userPath.equals("/treat")){
            if(session.getAttribute("userRole").equals(2) ||
                    session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("get_active_assignments");
                command.execute(request, response);
                url += "doctor/doctorActiveAssignments.jsp";
            }
        }else if(userPath.equals("/treat_param")){
            if(session.getAttribute("userRole").equals(2) ||
                    session.getAttribute("userRole").equals(3)){
                command = commandFactory.getCommand("perform_assignment");
                command.execute(request, response);
                command = commandFactory.getCommand("get_active_assignments");
                command.execute(request, response);
                url += "doctor/doctorActiveAssignments.jsp";
            }
        }else if(userPath.equals("/get_form_discharge_patient")){
            session.setAttribute("admissionId",request.getParameter("admissionId"));
            if(session.getAttribute("userRole").equals(2)){
                url += "doctor/doctorDischargePatient.jsp";
            }
        }else if(userPath.equals("/get_form_prescribe_treatment")){
            session.setAttribute("admissionId",request.getParameter("admissionId"));
            if(session.getAttribute("userRole").equals(2)){
                url += "doctor/doctorPrescribeTreatment.jsp";
            }
        }else if(userPath.equals("/add_patient")){
            if(session.getAttribute("userRole").equals(2)){
                url += "doctor/addPatient.jsp";
            }
        }else if(userPath.equals("/insert_patient")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("add_patient");
                command.execute(request, response);
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }
        }else if(userPath.equals("/hospitalize_patient")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("get_discharged_patients");
                command.execute(request, response);
                url += "doctor/hospitalizePatient.jsp";
            }
        }else if(userPath.equals("/remove_patient")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("delete_patient");
                command.execute(request, response);
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/doctorPatients.jsp";
            }
        }else if(userPath.equals("/get_patients_for_remove_patient")){
            if(session.getAttribute("userRole").equals(2)){
                command = commandFactory.getCommand("get_patients");
                command.execute(request, response);
                url += "doctor/patientsForRemove.jsp";
            }
        }

        try {
            getServletConfig().getServletContext().getRequestDispatcher(
                    url).forward(request,response);
        } catch (ServletException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

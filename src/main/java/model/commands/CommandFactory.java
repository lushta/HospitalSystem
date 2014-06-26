package model.commands;

import model.dao.DAOFactory;

import java.util.HashMap;

/**
 * Created by lushta on 07.06.14.
 */
public class CommandFactory {

    private HashMap<String, Command> commands;
    private static CommandFactory instance;

    private CommandFactory() {
        commands = new HashMap<>();
        Command.setDAOFactory(DAOFactory.getDAOFactory(DAOFactory.Factories.MYSQL));
        commands.put("get_users", new GetUsersCommand());
        commands.put("exit", new ExitCommand());
        commands.put("authorization", new AuthorizationCommand());
        commands.put("get_admissions", new GetAdmissionsCommand());
        commands.put("get_assignments", new GetAssignmentsCommand());
        commands.put("get_users_doctors", new GetUsersDoctorsCommand());
        commands.put("get_all_doctors", new GetAllDoctorsCommand());
        commands.put("get_admissions", new GetAdmissionsCommand());
        commands.put("get_patients", new GetPatientsCommand());
        commands.put("get_admissions_by_patient_id", new GetAdmissionsByPatientIdCommand());
        commands.put("discharge_patient", new DischargePatientCommand());
        commands.put("prescribe_treatment", new PrescribeTreatmentCommand());
        commands.put("get_active_assignments", new GetActiveAssignmentsCommand());
        commands.put("perform_assignment", new PerformAssignmentCommand());
        commands.put("get_all_patients", new GetAllPatientsCommand());
        commands.put("add_patient", new AddPatientCommand());
        commands.put("get_discharged_patients", new GetDischargedPatientsCommand());
    }

    public static synchronized CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(String id) {
        return commands.get(id);
    }
}

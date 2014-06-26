package model.dao;

import model.beans.Assignment;

import java.util.List;

/**
 * Created by lushta on 07.06.14.
 */
public interface AssignmentDAO {
    public List<Assignment> getAssignments(int id);
    public boolean prescribeTreatment(int admissionId,String name,String type,String date,String time);
    public List<Assignment> getActiveAssignments(String userRole, int userId);
    public boolean setPerformer(int performerId, int assignmentId);
}

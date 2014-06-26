package model.dao;

import model.beans.Admission;
import model.beans.User;

import java.util.List;

/**
 * Created by lushta on 07.06.14.
 */
public interface AdmissionDAO {
    public List<Admission> getAdmissions(int id);
    public boolean discharge(int admissionId, String diagnosis, String date);
}

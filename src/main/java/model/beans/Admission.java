package model.beans;

import java.util.Date;

/**
 * Created by lushta on 07.06.14.
 */
public class Admission {
    private int id;
    private int patient_id;
    private int doctor_id;
    private Date date_of_admission;
    private Date date_of_discharge;
    private String diagnosis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getDate_of_admission() {
        return date_of_admission;
    }

    public void setDate_of_admission(Date date_of_admission) {
        this.date_of_admission = date_of_admission;
    }

    public Date getDate_of_discharge() {
        return date_of_discharge;
    }

    public void setDate_of_discharge(Date date_of_discharge) {
        this.date_of_discharge = date_of_discharge;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

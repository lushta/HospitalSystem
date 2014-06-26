package model.beans;

import java.util.Date;

/**
 * Created by lushta on 07.06.14.
 */
public class Assignment {
    private int id;
    private int admission_id;
    private String name;
    private String type;
    private Date date_of_execution;
    private int performer_id;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getAdmission_id() {
        return admission_id;
    }

    public void setAdmission_id(int admission_id) {
        this.admission_id = admission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_of_execution() {
        return date_of_execution;
    }

    public void setDate_of_execution(Date date_of_execution) {
        this.date_of_execution = date_of_execution;
    }

    public int getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(int performer_id) {
        this.performer_id = performer_id;
    }
}

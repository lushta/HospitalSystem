package model.beans;

/**
 * Created by lushta on 07.06.14.
 */
public class Role {
    private int id;
    private String name;
    private boolean make_an_appointment;
    private boolean do_surgery;
    private boolean give_medicine;
    private boolean carry_out_the_procedure;
    private boolean define_the_diagnosis;
    private boolean take_the_patient;
    private boolean discharged_patients;
    private boolean add_employee;
    private boolean remove_the_employee;
    private boolean view_information_about_yourself;
    private boolean view_information_about_patients;
    private boolean view_information_about_the_staff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMake_an_appointment() {
        return make_an_appointment;
    }

    public void setMake_an_appointment(boolean make_an_appointment) {
        this.make_an_appointment = make_an_appointment;
    }

    public boolean isDo_surgery() {
        return do_surgery;
    }

    public void setDo_surgery(boolean do_surgery) {
        this.do_surgery = do_surgery;
    }

    public boolean isGive_medicine() {
        return give_medicine;
    }

    public void setGive_medicine(boolean give_medicine) {
        this.give_medicine = give_medicine;
    }

    public boolean isCarry_out_the_procedure() {
        return carry_out_the_procedure;
    }

    public void setCarry_out_the_procedure(boolean carry_out_the_procedure) {
        this.carry_out_the_procedure = carry_out_the_procedure;
    }

    public boolean isDefine_the_diagnosis() {
        return define_the_diagnosis;
    }

    public void setDefine_the_diagnosis(boolean define_the_diagnosis) {
        this.define_the_diagnosis = define_the_diagnosis;
    }

    public boolean isTake_the_patient() {
        return take_the_patient;
    }

    public void setTake_the_patient(boolean take_the_patient) {
        this.take_the_patient = take_the_patient;
    }

    public boolean isDischarged_patients() {
        return discharged_patients;
    }

    public void setDischarged_patients(boolean discharged_patients) {
        this.discharged_patients = discharged_patients;
    }

    public boolean isAdd_employee() {
        return add_employee;
    }

    public void setAdd_employee(boolean add_employee) {
        this.add_employee = add_employee;
    }

    public boolean isRemove_the_employee() {
        return remove_the_employee;
    }

    public void setRemove_the_employee(boolean remove_the_employee) {
        this.remove_the_employee = remove_the_employee;
    }

    public boolean isView_information_about_yourself() {
        return view_information_about_yourself;
    }

    public void setView_information_about_yourself(boolean view_information_about_yourself) {
        this.view_information_about_yourself = view_information_about_yourself;
    }

    public boolean isView_information_about_patients() {
        return view_information_about_patients;
    }

    public void setView_information_about_patients(boolean view_information_about_patients) {
        this.view_information_about_patients = view_information_about_patients;
    }

    public boolean isView_information_about_the_staff() {
        return view_information_about_the_staff;
    }

    public void setView_information_about_the_staff(boolean view_information_about_the_staff) {
        this.view_information_about_the_staff = view_information_about_the_staff;
    }
}

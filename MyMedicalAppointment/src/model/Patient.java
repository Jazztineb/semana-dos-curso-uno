package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Encapsulamiento con modificadores de acceso.

    private String birthday;
    private String blood;
    private double weight;
    private double height;

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    private ArrayList<AppointmentDoctor> appointmentDoctors =  new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses   = new ArrayList<>();


    public Patient(String name, String email) {
        super(name, email); //Método constructor sobrecargado.

    }

    //Get y set validan todo dato que se quiera asignar.
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return this.weight + "Kg.";
    }

    public String getHeight() {
        return height + "Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + getWeight() + "\nHeight: " + getHeight() + "\nBlood: " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo del paciente");
    }
}

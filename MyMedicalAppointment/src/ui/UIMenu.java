package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[]  MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio","Julio","Agosto","Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor    doctorLogged;
    public static Patient   patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to my Appointments");
        System.out.println("Select an option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authenticationUser(1);
                    response = 0;
                    break;
                case 2:
                    response = 0;
                    authenticationUser(2);
                    UIPatientMenu.showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thanks for visiting.");
                    break;
                default:
                    System.out.println("Please select a correct answer.");
            }
        }while (response != 0);
    }

    private static void authenticationUser(int userType){
        //userType  = 1 -> Doctor
        //userType  = 2 ->  Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Daniel Conrado", "conrado@mail.com"));
        doctors.add(new Doctor("Karen Correa", "correa@mail.com"));
        doctors.add(new Doctor("Estefania Palma", "palma@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Ana Maria Cortez Sanchez", "acortez68@mail.com"));
        patients.add(new Patient("Liliana Canche", "canche@mail.com"));
        patients.add(new Patient("Vicente David Cortez Sanchez", "david@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert the correct email syntax: [a@a.com]");
            Scanner sc      = new Scanner(System.in);
            String  email   = sc.nextLine();
            if(userType==1){
                for (Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el doctor loggeado.
                        doctorLogged    =   d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType==2){
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el paciente loggeado.
                        patientLogged   =   p;
                        //showPatientMenu
                    }
                }

            }
        } while (!emailCorrect);

    }

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}

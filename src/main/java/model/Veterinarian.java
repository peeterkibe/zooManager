package model;

import javax.persistence.*;

@Entity
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVeterinarian;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToMany
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public int getIdVeterinarian() {
        return idVeterinarian;
    }

    public void setIdVeterinarian(int idVeterinarian) {
        this.idVeterinarian = idVeterinarian;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "idVeterinarian=" + idVeterinarian +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

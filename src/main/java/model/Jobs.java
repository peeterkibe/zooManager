package model;

import javax.persistence.*;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJobs;
    private String jobDescription;

    @ManyToOne
    @JoinColumn( name = "idHandler")
    private Handler handler;

    @OneToMany
    @JoinColumn(name = "workSchedule")
    private Schedule schedule;


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getIdJobs() {
        return idJobs;
    }

    public void setIdJobs(int idJobs) {
        this.idJobs = idJobs;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "idJobs=" + idJobs +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}

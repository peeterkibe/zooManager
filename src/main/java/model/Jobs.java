package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJobs;
    private String jobDescription;

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

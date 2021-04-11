package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;
    private Date morningShift;
    private Date nightShift;
    private Date reserve;

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getMorningShift() {
        return morningShift;
    }

    public void setMorningShift(Date morningShift) {
        this.morningShift = morningShift;
    }

    public Date getNightShift() {
        return nightShift;
    }

    public void setNightShift(Date nightShift) {
        this.nightShift = nightShift;
    }

    public Date getReserve() {
        return reserve;
    }

    public void setReserve(Date reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", morningShift=" + morningShift +
                ", nightShift=" + nightShift +
                ", reserve=" + reserve +
                '}';
    }
}

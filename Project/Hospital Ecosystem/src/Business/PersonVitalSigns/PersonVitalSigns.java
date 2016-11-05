/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PersonVitalSigns;

/**
 *
 * @author Nauka Salot
 */
public class PersonVitalSigns {

    private int respiratoryrate;
    private int bloodpressure;
    private int age;
    private int heartrate;

    public int getRespiratoryrate() {
        return respiratoryrate;
    }

    public void setRespiratoryrate(int respiratoryrate) {
        this.respiratoryrate = respiratoryrate;
    }

    public int getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(int bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    @Override
    public String toString() {
        return String.valueOf(respiratoryrate);
    }

}

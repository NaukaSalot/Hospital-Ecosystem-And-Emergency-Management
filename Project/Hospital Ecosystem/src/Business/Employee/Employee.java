/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.PersonVitalSigns.PersonVitalSignHistory;
import Business.WorkQueue.AmbulanceWorkRequest;
import Business.WorkQueue.PatientDetailsRequest;

/**
 *
 * @author raunak
 */
public class Employee {

    private String name;
    private int id;
    private static int count = 1;
    private PatientDetailsRequest pdr;
    private PersonVitalSignHistory personVitalSignHistory;
    private AmbulanceWorkRequest ambulanceWorkRequest;

    public Employee() {
        id = count;
        count++;
        personVitalSignHistory = new PersonVitalSignHistory();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AmbulanceWorkRequest getAmbulanceWorkRequest() {
        return ambulanceWorkRequest;
    }

    public void setAmbulanceWorkRequest(AmbulanceWorkRequest ambulanceWorkRequest) {
        this.ambulanceWorkRequest = ambulanceWorkRequest;
    }

    @Override
    public String toString() {
        return name;
    }

    public PatientDetailsRequest getPdr() {
        return pdr;
    }

    public void setPdr(PatientDetailsRequest pdr) {
        this.pdr = pdr;
    }

    public PersonVitalSignHistory getPersonVitalSignHistory() {
        return personVitalSignHistory;
    }

    public void setPersonVitalSignHistory(PersonVitalSignHistory personVitalSignHistory) {
        this.personVitalSignHistory = personVitalSignHistory;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;

/**
 *
 * @author raunak
 */
public class LabTestWorkRequest extends WorkRequest {

    private String testResult;
    private Employee patient;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Employee getPatient() {
        return patient;
    }

    public void setPatient(Employee patient) {
        this.patient = patient;
    }

}

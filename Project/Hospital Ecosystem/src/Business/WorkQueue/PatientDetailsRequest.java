/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientDetails.PatientDetails;
import java.util.ArrayList;

/**
 *
 * @author Nauka Salot
 */
public class PatientDetailsRequest extends LabTestWorkRequest {

    private PatientDetails patientDetails;
    private ArrayList<WorkRequest> workRequest;

    public PatientDetailsRequest() {
        patientDetails = new PatientDetails();
        workRequest = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequest() {
        return workRequest;
    }

    public PatientDetails getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(PatientDetails patientDetails) {
        this.patientDetails = patientDetails;
    }

    public void addRequest(WorkRequest workRequest) {
        this.workRequest.add(workRequest);
    }
}

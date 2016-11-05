/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Lab.getValue())) {
            organization = new LabOrganization();
            organizationList.add(organization);
        } //        else if (type.getValue().equals(Type.Pharmacy.getValue())){
        //            organization=new PharmacyOrganization();
        //            organizationList.add(organization);
        //        }
        else if (type.getValue().equals(Type.Person.getValue())) {
            organization = new PersonOrganization();
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.Patient.getValue())) {
            organization = new PatientOrganization();
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.Receptionist.getValue())) {
            organization = new ReceptionistOrganization();
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.Account.getValue())) {
            organization = new AccountOrganization();
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.Ambulance.getValue())) {
            organization = new AmbulanceOrganization();
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.Government.getValue())) {
            organization = new GovernmentOrganization();
            organizationList.add(organization);

        }
        return organization;
    }
}

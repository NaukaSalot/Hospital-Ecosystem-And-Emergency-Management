    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AmbulanceRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Nauka Salot
 */
public class AmbulanceOrganization extends Organization {

    public AmbulanceOrganization() {
        super(Organization.Type.Ambulance.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmbulanceRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PersonVitalSigns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nauka Salot
 */
public class PersonVitalSignHistory {

    private List<PersonVitalSigns> vitalsignlist;

    public List<PersonVitalSigns> getVitalsignlist() {
        return vitalsignlist;
    }

    public void setVitalsignlist(List<PersonVitalSigns> vitalsignlist) {
        this.vitalsignlist = vitalsignlist;
    }

    public PersonVitalSignHistory() {
        this.vitalsignlist = new ArrayList<>();
    }

    public PersonVitalSigns addvitalsign() {
        PersonVitalSigns vitalsign = new PersonVitalSigns();
        vitalsignlist.add(vitalsign);
        return vitalsign;
    }
}

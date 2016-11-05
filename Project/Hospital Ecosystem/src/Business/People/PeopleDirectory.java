/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.People;

//import Business.Person.VitalSign;
import java.util.ArrayList;

/**
 *
 * @author Nauka Salot
 */
public class PeopleDirectory {

    private ArrayList<People> history;

    public PeopleDirectory() {
        history = new ArrayList<>();
    }

    public ArrayList<People> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<People> history) {
        this.history = history;
    }

    public People createAndAddVitalSign() {
        People p = new People();
        history.add(p);
        return p;
    }

    public void deleteVitalSign(People p) {
        history.remove(p);
    }
}

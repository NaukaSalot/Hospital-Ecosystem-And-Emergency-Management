/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.CheckUp.CheckUp;

/**
 *
 * @author Nauka Salot
 */
public class CheckUpRequest extends LabTestWorkRequest {

    private CheckUp checkUp;

    public CheckUpRequest() {
        checkUp = new CheckUp();
    }

    public CheckUp getCheckUp() {
        return checkUp;
    }

    public void setCheckUp(CheckUp checkUp) {
        this.checkUp = checkUp;
    }

}

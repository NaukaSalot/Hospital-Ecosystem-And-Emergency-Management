/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AccountOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AccountRole.AccountWorkAreaJPanel;

/**
 *
 * @author Nauka Salot
 */
public class AccountRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AccountWorkAreaJPanel(userProcessContainer, account, enterprise, organization, business);//To change body of generated methods, choose Tools | Templates.
    }

}

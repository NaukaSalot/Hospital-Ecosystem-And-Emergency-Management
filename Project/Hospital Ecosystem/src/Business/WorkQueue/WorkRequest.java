/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;

    private Date requestDate;
    private Date resolveDate;
    //private String 

    public WorkRequest() {
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

//    @Override
//    public String toString() {
//        return message;
//    }
//    @Override
//    public String toString() {
//       SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
//        return ft.format(requestDate);
//    }
//    @Override
//    public String toString() {
//        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
//       return ft.format(requestDate);
//        //return "WorkRequest{" + "message=" + message + ", sender=" + sender + ", receiver=" + receiver + ", status=" + status + ", requestDate=" + requestDate + ", resolveDate=" + resolveDate + '}';
//    }
//    @Override
//    public String toString() {
//        return sender.toString();
//    }
    @Override
    public String toString() {
        return String.valueOf(this.requestDate);
    }
}
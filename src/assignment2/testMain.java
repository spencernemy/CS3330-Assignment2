package assignment2;

import java.util.ArrayList;
import java.util.List;

public class testMain {
public static void main(String[] args) {
    
    Technician one = new Technician("John");
    Technician two = new Technician("Bill");
    Technician too = new Technician("Bill");
    Technician three = new Technician("Jill");

    List<Technician> list = new ArrayList<>();
    list.add(one);
    list.add(two);
    list.add(too);
    list.add(three);

    PasswordResetRequest pass1 = new PasswordResetRequest(1, "help", 1, "bingo");
    PasswordResetRequest pass2 = new PasswordResetRequest(2, "HELP!!!", 5, "bongo");
    PasswordResetRequest pass3 = new PasswordResetRequest(3, "HELP!!!", 5, "dave");
    NetworkIssueRequest net1 = new NetworkIssueRequest(4, "aid", 3243, 3);
    NetworkIssueRequest net2 = new NetworkIssueRequest(5, "AID!!!", 2,1);
    NetworkIssueRequest net3 = new NetworkIssueRequest(6, "Help!!!", 3,2);
    HelpDesk desk = new HelpDesk();
    //adding the requests to systtem.
    desk.addRequest(pass1);
    desk.addRequest(pass2);
    desk.addRequest(pass3);
    desk.addRequest(net1);
    desk.addRequest(net2);
    desk.addRequest(net3);
    //assigning to techs
    desk.assignRequest(three, 1);
    desk.assignRequest(three, 2);
    desk.assignRequest(two, 3);
    desk.assignRequest(one, 4);
    desk.assignRequest(too, 5);
    
    //resolves the requests
    desk.resolveRequest(three, 1);
    desk.resolveRequest(three, 2);
    desk.resolveRequest(one, 4);
    desk.printAllRequests();
    desk.printAssignmentsFor(one);
    desk.printAssignmentsFor(two);
    desk.printAssignmentsFor(too);
    desk.printAssignmentsFor(three);

    int total = HelpDeskUtils.sumPoints(list);

    System.out.println("total = " + total);
    
    }

}
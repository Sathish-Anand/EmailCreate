package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternativeEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        System.out.println("Department of "+this.firstName+" is "+this.department);

        this.password = setRandomPassword(defaultPasswordLength);
        System.out.println("The Password is :"+this.password);

        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+this.department+".fluent.com";

    }
    private String setDepartment(){
        System.out.println("Department Code:\n1 for Sales\n2 for Development\n3 for Accounting\n4 for None\nEnter the department:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "Sales";
        }
        else if(depChoice == 2){
            return "Development";
        }
        else if(depChoice == 3){
            return "Accounting";
        }
        else if (depChoice == 4){
            return "None";
        }
        else {
            return "";
        }
    }

    private String setRandomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVabcdefghijklmnopqrstuvwwxyz!@#$";
        char[] password = new char[length];
        for (int i=0;i<length;i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setAlternativeEmail(String alterEmail) {
        this.alternativeEmail = alterEmail;
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getAlternativeEmail(){ return alternativeEmail; }
    public String getChangePasword(){ return password; }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + "  " + lastName + ". \nCompany Emailid is :"+email+
                ".\nMailbox Capacity is:"+mailboxCapacity+"mb";
    }
}

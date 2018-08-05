package pkg282project1;
/**
 * Name: Robert Florence
 * Date: Oct 9, 2013 
 * Professor Ferguson
 * Java 282
 * Project #1
 * The goal this project is to create a disk based hash file database for tracking an Internet sites users
 **************************************************
 */
public class MyRecord {

    private String email;
    private String firstname;
    private String lastname;
    private String color1;
    private String color2;

    MyRecord() {
        
        email="";
        firstname="";
        lastname="";
        color1="";
        color2="";
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }
    
}
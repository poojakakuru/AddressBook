package com.mphasis.model;

public class Person {
    private String firstName;
    private String lastName;
    private String Address;
    private String city;
    private int pincode;
    private long Number;
    /*
     * Functionality:to initialize the person object
     * @param:firstName:first name of the person
     * @param:LastName:Last name of the person
     * @param:address:address of a person
     * @param:city:city of the person
     * @param:pincode:pincode of the person
     * @param:Number:number of a person*/
    public Person(String firstName, String lastName, String adress, String city, int pincode, long number) {
        this.firstName = firstName;
        this.lastName = lastName;
        Address = adress;
        this.city = city;
        this.pincode = pincode;
        this.Number = number;
    }
    /*Functionality:default constructor for person*/
    public Person() {
    }
    /*Functionality:to get the first name of person*/
    public String getFirstName() {
        return firstName;
    }
    /*Functionality:to set the first name of person
     * @param:firstName:first name of the person*/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /*Functionality:to get last name of person*/
    public String getLastName() {
        return lastName;
    }
    /*Functionality:set the last name of the person
     * @param:Lastname:last name of the person*/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /*Functionality:to get address of person*/
    public String getAdress() {
        return Address;
    }
    /*Functionality:to set the address of person
     * @param:address:address of a person*/
    public void setAdress(String adress) {
        Address = adress;
    }
    /*Functionality: to get city of a person*/
    public String getCity() {
        return city;
    }
    /*Functionality:to set city of a person
     * @param:city:city of a person*/
    public void setCity(String city) {
        this.city = city;
    }
    /*Functionality:to get pincode of person*/
    public int getPincode() {
        return pincode;
    }
    /*Functionality:to set the pincode of person
     * @param:pincode:pincode of person*/
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    /*Functionality:to get number of the person*/
    public long getNumber() {
        return Number;
    }
    /*Functionality:to set the number of person
     * @param:number:number of a person*/
    public void setNumber(long number) {
        Number = number;
    }
    /*Functionality:to convert object to a string*/
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Adress='" + Address + '\'' +
                ", city='" + city + '\'' +
                ", pincde=" + pincode +
                ", Number=" + Number +
                '}';
    }
}

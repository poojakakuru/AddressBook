package com.mphasis.services;

import com.mphasis.model.Addressbook;
import com.mphasis.model.Person;

import java.util.*;

import com.mphasis.model.Person;


public class PersonServices {
    /*Functionality:to add a person to addressbook
     * @param:addressbook:object of addressbook
     * @return:addressbook:object of addressbook*/
    public Addressbook addPerson(Addressbook addressbook){
        String firstName;
        String lastName;
        String adress;
        String city;
        int pincode;
        long number;
        Person person=new Person();
        System.out.println("enter the first name : ");
        Scanner scanner=new Scanner(System.in);
        firstName=scanner.nextLine();
        person.setFirstName(firstName);
        System.out.println("enter the last name : ");
        lastName=scanner.nextLine();
        person.setLastName(lastName);
        System.out.println("enter the address : ");
        adress=scanner.nextLine();
        person.setAdress(adress);
        System.out.println("enter the city : ");
        city=scanner.nextLine();
        person.setCity(city);
        System.out.println("enter the pincode : ");
        pincode=scanner.nextInt();
        person.setPincode(pincode);
        System.out.println("enter the Number : ");
        number=scanner.nextLong();
        person.setNumber(number);
        addressbook.getAddressbook().add(person);
        return addressbook;
    }
    /*Functionality:edit a person details in addressbook*/
    public void editPerson(String personname,Addressbook addressboook){
        List personlist=addressboook.getAddressbook();
        Person requiredperson=null;
        Iterator it=personlist.iterator();
        while(it.hasNext()){
            Person person=(Person) it.next();
            //System.out.println(person.getFirstName()+" "+personname);
            if(person.getFirstName().equalsIgnoreCase(personname)){
                requiredperson=person;
                break;
            }
        }
        System.out.println("enter a case to edit person details");
        System.out.println("case 1 : address , case 2 : city , case 3 : pincode , case 4 : number ");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        scanner.nextLine();
        switch (input){
            case 1:
                System.out.println("enter the new address");
                String address=scanner.nextLine();
                requiredperson.setAdress(address);
                break;

            case 2:
                System.out.println("enter the new city name");
                String city=scanner.nextLine();
                requiredperson.setCity(city);
                break;
            case 3:
                System.out.println("enter the new pincode");
                int pincode=scanner.nextInt();
                requiredperson.setPincode(pincode);
                break;
            case 4:
                System.out.println("enter the new Number");
                long number=scanner.nextLong();
                requiredperson.setNumber(number);
                break;

        }

    }
    /*Functionality:to delete a person from addressbook
     * @param:personname:name of the person
     * @param:addressbook:object of addressbook
     * @return:addressbook:object of addressbook*/
    public Addressbook deleteperson(Addressbook addressbook,String personname){
        List personlist=addressbook.getAddressbook();
        Person requiredperson=null;
        Iterator it=personlist.iterator();
        while(it.hasNext()){
            Person person=(Person) it.next();
            if(person.getFirstName().equalsIgnoreCase(personname)){
                requiredperson=person;
                break;
            }
        }
        addressbook.getAddressbook().remove(requiredperson);
        return addressbook;
    }
    /*Functionality:sort an addressbook
     * @param:addressbook:object of addressbook
     * @return:addressbook:object of addressbook*/
    public Addressbook Sort(Addressbook addressbook){
        System.out.println("enter a case number to sort ");
        System.out.println("case 1 : sort by Last name , case 2 : sort by zip code ");
        Scanner scanner=new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input){
            case 1:
                class SortByLastName implements Comparator<Person>{
                    public int compare(Person a, Person b){
                        return a.getLastName().compareTo(b.getLastName());
                    }
                }
                Collections.sort(addressbook.getAddressbook(),new SortByLastName());
                break;
            case 2:
                class SortByzipcode implements Comparator<Person>{
                    public int compare(Person a, Person b){
                        return a.getPincode()-b.getPincode();
                    }
                }
                Collections.sort(addressbook.getAddressbook(),new SortByzipcode());

        }
        return addressbook;
    }
    /*Functionality:to print a persons details in addressbook
     * @param:addressbook:object of addressbook */
    public void printPersons(Addressbook addressbook){
        for(Person person : addressbook.getAddressbook()){
            System.out.println("Firstname :"+person.getFirstName()+" "+"Lastname :"+person.getLastName()+"\n"+
                    "Number :"+person.getNumber()+"\n"+"Address :"+person.getAdress()
                    +"\n"+"City :"+person.getCity()+","+"Pincode :"+person.getPincode());
            System.out.println("============================================================================");
            System.out.println("\n");
        }
    }
}

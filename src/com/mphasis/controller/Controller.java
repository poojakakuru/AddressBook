package com.mphasis.controller;

import com.mphasis.main.Main;
import com.mphasis.model.Addressbook;
import com.mphasis.model.Person;
import com.mphasis.services.Addressbookservices;
import com.mphasis.services.PersonServices;

import java.util.HashMap;
import java.util.List;

import java.util.Scanner;


public class Controller {
    public static HashMap<Addressbook,String> adressbookmap=new HashMap<Addressbook,String>();
    /*Functionality:To create a addressbook*/
    public static void create(){
        if(adressbookmap.containsValue("open")){
            System.out.println("close the current addressbook to create new one");
            Main.mainmenu();
        }
        else {
            System.out.println("enter the addressbook name :");
            Scanner scanner=new Scanner(System.in);
            String addressbookname=scanner.nextLine()+".csv";
            Addressbookservices addressbookservices=new Addressbookservices();
            Addressbook addressbook=addressbookservices.createAddressbook(addressbookname);
            addressbook.setaddressbookname(addressbookname);
            addressbook.setSaved("yes");
            adressbookmap.put(addressbook,"open");
            System.out.println("choose a case ");
            System.out.println("Case1 :add a person , Case2 :Back to main menu");
            int input=scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    PersonServices personServices=new PersonServices();
                    addressbook=personServices.addPerson(addressbook);
                    //Addressbookservices.WriteToACsv(addressbook,addressbookname);
                    addressbook.setSaved("no");
                    addressbook=Controller.helper(addressbook,addressbookname,personServices,addressbookservices);
                    break;
                case 2:
                    addressbookservices.close();
                    break;
            }}
    }
    /*Functionality:To open a existing addressbook*/
    public static void Openaddressbook(){
        //System.out.println(adressbookmap.containsValue("open"));
        if(adressbookmap.containsValue("open")){
            System.out.println("please close current addressbook first");
            Main.mainmenu();
        }
        else {
            System.out.println("enter the addressbook name :");
            Scanner scanner=new Scanner(System.in);
            String addressbookname=scanner.nextLine();
            addressbookname=addressbookname+".csv";
            List personlist=Addressbookservices.readFromACsv(addressbookname);
            Addressbook addressbook=new Addressbook();
            addressbook.setaddressbookname(addressbookname);
            addressbook.setAddressbook(personlist);
            PersonServices personServices=new PersonServices();
            Addressbookservices addressbookservices=new Addressbookservices();
            addressbook.setSaved("yes");
            adressbookmap.put(addressbook,"open");
            helper(addressbook,addressbookname,personServices,addressbookservices);}
    }
    /*Functionality:To save a addressbook as*/
    public static void saveAS(){
        Addressbook addressbook=null;
        for(Addressbook ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("open or create addressbook to use saveas functionality");
            Main.mainmenu();
        }
        addressbook.setSaved("yes");
        Addressbookservices addressbookservices=new Addressbookservices();
        addressbookservices.saveAs(addressbook.getaddressbookname(),addressbook);
        System.out.println("saved details sucessfully");
        Main.mainmenu();
    }
    /*Functionality:To save a addressbook*/
    public static void save(){
        Addressbook addressbook=null;
        for(Addressbook ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("open or create address book to use save functionallity");
            Main.mainmenu();
        }
        if(addressbook.getSaved().equalsIgnoreCase("yes")){
            System.out.println("nothing to save");
            Main.mainmenu();
        }
        else {
            addressbook.setSaved("yes");
            Addressbookservices addressbookservices=new Addressbookservices();
            addressbookservices.save(addressbook.getaddressbookname(),addressbook);
            System.out.println("details saved sucessfully");
            Main.mainmenu();}
    }
    /*Functionality:To close the addressbook*/
    public static void close(){
        Addressbook addressbook=null;
        Addressbookservices addressbookservices=new Addressbookservices();
        for(Addressbook ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("open or create a addressbook to use close functionality");
            Main.mainmenu();
        }
        adressbookmap.put(addressbook,"closed");
        if(addressbook.getSaved()=="yes"){
            System.out.println("addressbook closed sucessfully");
            Main.mainmenu();
        }
        else {
            System.out.println("the addressbook is not saved:");
            System.out.println("choose a case below");
            System.out.println("case 1:save addressbook , case 2: save addressbook as , case 3:don't save changes");
            Scanner scanner=new Scanner(System.in);
            int input=scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    addressbook.setSaved("yes");
                    addressbookservices.save(addressbook.getaddressbookname(),addressbook);
                    System.out.println("addressbook closed sucessfully");
                    Main.mainmenu();
                case 2:
                    addressbook.setSaved("yes");
                    addressbookservices.saveAs(addressbook.getaddressbookname(),addressbook);
                    System.out.println("addressbook closed sucessfully");
                    Main.mainmenu();
                case 3:
                    System.out.println("addressbook closed sucessfully");
                    Main.mainmenu();
            }
        }

    }
    /*Functionality:To quit the addressbook application*/
    public static void quit(){
        Addressbook addressbook=null;
        Addressbookservices addressbookservices=new Addressbookservices();
        for(Addressbook ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("program terminated");
            System.exit(0);
        }
        adressbookmap.put(addressbook,"closed");
        if(addressbook.getSaved()=="yes"){
            System.out.println("program terminated");
            System.exit(0);
        }
        else {
            System.out.println("the addressbook is not saved:");
            System.out.println("choose a case below");
            System.out.println("case 1:save addressbook , case 2: save addressbook as , case 3:don't save changes");
            Scanner scanner=new Scanner(System.in);
            int input=scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    addressbook.setSaved("yes");
                    addressbookservices.save(addressbook.getaddressbookname(),addressbook);
                    System.out.println("program terminated");
                    System.exit(0);
                case 2:
                    addressbook.setSaved("yes");
                    addressbookservices.saveAs(addressbook.getaddressbookname(),addressbook);
                    System.out.println("program terminated");
                    System.exit(0);
                case 3:
                    System.out.println("program terminated");
                    System.exit(0);
            }
        }
    }
    /*Functionality:To provide sub menu functions to main menu
     * @param:addressbook:addressbook object
     * @param:addressbookname:name of the addressbook name
     * @param:personservices:personservices object
     * @param:addressbookservices:addressbookservices object
     * @return:addressbook:addressbook object*/
    public static Addressbook helper(Addressbook addressbook,String addressbookname,PersonServices personServices
            ,Addressbookservices addressbookservices){
        System.out.println("choose a case");
        System.out.println("Case1:Add person , Case2:Edit a person , Case3:Delete a person" +
                "Case4 :Sort a addressbook , Case5:Print a person , Case6:Back to main menu");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        scanner.nextLine();
        switch (input){
            case 1:
                addressbook=personServices.addPerson(addressbook);
                addressbook.setSaved("no");
                System.out.println("person added to address book");
                helper(addressbook,addressbookname,personServices,addressbookservices);
                break;
            case 2:
                System.out.println("enter the name of person name");
                String personname=scanner.nextLine();
                personServices.editPerson(personname,addressbook);
                addressbook.setSaved("no");
                System.out.println("person details edited sucessfully");
                helper(addressbook,addressbookname,personServices,addressbookservices);
                break;
            case 3:
                System.out.println("enter name of the person to be deleted");
                String deleteperson=scanner.nextLine();
                addressbook=personServices.deleteperson(addressbook,deleteperson);
                System.out.println("person removed from the address book");
                addressbook.setSaved("no");
                helper(addressbook,addressbookname,personServices,addressbookservices);
                break;
            case 4:
                addressbook=personServices.Sort(addressbook);
                addressbook.setSaved("no");
                System.out.println("addressbook sorted sucessfully");
                helper(addressbook,addressbookname,personServices,addressbookservices);
                break;
            case 5:
                personServices.printPersons(addressbook);
                helper(addressbook,addressbookname,personServices,addressbookservices);
                break;
            case 6:
                addressbookservices.close();
        }
        return addressbook;
    }
}

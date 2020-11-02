package com.mphasis.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Addressbook {
    private List book;
    private String name;
    private String saved;
    private List<Person> addressbook =new ArrayList<Person>();
    /*Functionality: initate the Addressbook constructor */
    public Addressbook(){
        this.book= addressbook;
    }
    /*Functionality:to get the addressbook list*/
    public  List<Person> getAddressbook(){
        return this.book;
    }
    /*Functionality:to set the book property of addressbook
     * @param:personlist:Array list of persons*/
    public void setAddressbook(List personlist){
        book=personlist;
    }
    /*Functionality:to set name property of addressbook
     * @param:name:name of the address book*/
    public void setaddressbookname(String name){
        this.name=name;
    }
    /*Functionality:to get the value of name property*/
    public String getaddressbookname(){
        return this.name;
    }
    /*Functionality:to set the saved value of addressbook
     * @param:saved:show if addressbook is saved or not*/
    public void setSaved(String saved){
        this.saved=saved;
    }
    /*Functionality:to get the saved value of addressbook*/
    public String getSaved( ){
        return this.saved;
    }
}

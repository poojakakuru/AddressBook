package com.mphasis.services;

import com.mphasis.main.Main;
import com.mphasis.model.Addressbook;
import com.mphasis.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Addressbookservices {
    /*Functionality:to write to a csv file
     * @param:addressbook:addressbook object
     * @param:addressbookname:name of addressbook*/
    public static void WriteToACsv(Addressbook addressbook,String addressbookname){
        final String COMMA_DELIMITER = ",";
        final String LINE_SEPARATOR = "\n";
        String PATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+addressbookname;
        final String HEADER = "Firstname,LastName,Address,City,Pincode,Number";
        List personList=addressbook.getAddressbook();
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(PATH);
            fileWriter.append(HEADER);
            fileWriter.append("\n");
            Iterator it=personList.iterator();
            while (it.hasNext()){
                Person person=(Person) it.next();
                fileWriter.append(person.getFirstName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getAdress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getCity());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(person.getPincode()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(person.getNumber()));
                fileWriter.append(LINE_SEPARATOR);
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the fileWriter");
                ie.printStackTrace();
            }
        }
    }
    /*Functionality:read from a csv file
     * @param:addressbookname:name of the addressbook
     * @return:personlist:list of person objects*/
    public static List readFromACsv(String addressbookname){
        final String COMMA_DELIMITER = ",";
        String PATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+addressbookname;
        List<Person> personList=new ArrayList<Person>();
        BufferedReader br =null;
        try{
            br=new BufferedReader(new FileReader(PATH));
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] personDetails = line.split(COMMA_DELIMITER);

                if(personDetails.length > 0 )
                {
                    //Save the employee details in Employee object
                    Person person = new Person(personDetails[0],
                            personDetails[1],personDetails[2],personDetails[3],Integer.parseInt(personDetails[4]),
                            Long.parseLong(personDetails[5]));
                    personList.add(person);
                }
            }

        }catch (Exception fe){
            fe.printStackTrace();
        }
        finally {
            try{
                br.close();
            }
            catch (IOException ie){
                ie.printStackTrace();
            }
        }
        return personList;
    }
    /*Functionality:to crate a addressbook
     * @param:addressbookname:name of addressbook
     * @return:addressbook:addressbook object*/
    public Addressbook createAddressbook(String addressbookname){
        try{
            String PATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+addressbookname;
            File file=new File(PATH);
            if(file.createNewFile()){
                System.out.println("welcome to addressbook "+addressbookname);
                return new Addressbook();
            }
            else {
                System.out.println("file already exits");
                Main.mainmenu();
            }
        }catch (IOException ee){
            System.out.println("error");
            ee.printStackTrace();
        }
        return null;
    }
    /*Functionality:open an addressbook
     * @param:addressbookname:name of the addressbook
     * @return:personlist:list of the persons*/
    public List  Openanaddressbook(String addressbookname){
        String PATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+addressbookname;
        File file=new File(PATH);
        if(file.exists()){
            return Addressbookservices.readFromACsv(addressbookname);
        }
        else {
            System.out.println("address book with given name donot exits");
        }
        return null;
    }
    /*Functionality:to close an addressbook*/
    public void close(){
        System.out.println("address book is closed");
        Main.mainmenu();
    }
    /*Functionality:to save a addressbook
     * @param:addressbookname:name of the addressbook
     * @param:addressbook:object of addressbook*/
    public void save(String addressbookname,Addressbook addressbook){
        Addressbookservices.WriteToACsv(addressbook,addressbookname);
    }
    /*Functionality:to save a addressbook as
     * @param:addressbookname:name of the addressbook
     * @param:addressbook:object of addressbook*/
    public void saveAs(String addressbookname,Addressbook addressbook){
        Addressbookservices.WriteToACsv(addressbook,addressbookname);
        String OldPATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+addressbookname;
        File oldfile=new File(OldPATH);
        System.out.println("enter the name of addressbook want to save as:");
        Scanner scanner=new Scanner(System.in);
        String newaddressbookname=scanner.nextLine()+".csv";
        String NewPATH="C:\\Users\\pooja\\IdeaProjects\\AddressBookProject\\src\\com\\mphasis\\data"+"\\"+newaddressbookname;
        File newfile=new File(NewPATH);
        oldfile.renameTo(newfile);
    }

}

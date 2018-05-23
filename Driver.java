/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import Factory.LedgerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Gabriel Gordon, Midterm Project
 * 10/9/2015, CS174
 * This project reads in as many files of purchase orders as demanded,
 * sorts the PO's and creates a ledger
 * Then it will ask the user which ledger they would like to see
 * @author gagordon
 */
public class Driver {
    public static void main(String[] args) throws IOException{
        ArrayList<Ledger> bigLedger=new ArrayList<Ledger>();//will hold all the ledgers from many files
        ArrayList<String> years=new ArrayList<String>();//will hold the years from each submitted ledger
        //call ledgerfactory
        Scanner in=new Scanner(System.in);
        String fileName=" ";
        while (!fileName.toLowerCase().equals("q")){//read in files until user prompts to quit
            System.out.print("Woh! We made it! Please enter the file name you would like us to read: ");
            fileName=in.nextLine();
            LedgerFactory ledgerF=new LedgerFactory();
           
            if(!fileName.toLowerCase().equals("q")){
                Ledger ledger = ledgerF.createLedger(fileName);
                bigLedger.add(ledger);
                years.add(ledger.getYear());
            }
        }
        System.out.println("Pick a year you would like to see the ledger from: ");
        System.out.println(years);
        String yearPicked=in.nextLine();
        int size=bigLedger.size();
        for(int i=0;i<size;i++){
            if(bigLedger.get(i).getYear().equals(yearPicked)){
                System.out.println(bigLedger.get(i).toString());
            }else{
                System.out.println("There was an error, program terminated - Arnold has arrived! ");
            }
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import midtermproject.Ledger;

/**
 *
 * @author gagordon
 */
public class LedgerFactory {
    
        private static final String PO_START="+++";
        private static final String PO_END="---";
        private String _year;
        private ArrayList<String> po=new ArrayList<String>();
        /*
        //make singleton from ledger
        private static LedgerFactory _instance;
    
        public static LedgerFactory getInstance(){
            if(_instance==null){
            _instance=new LedgerFactory();
        }
        return _instance;
    }*/
    
        
        
    public Ledger createLedger(String fileName) throws FileNotFoundException, IOException{
        PurchaseOrder p=new PurchaseOrder();//***TRIAL!!***
        ArrayList<String> file = new ArrayList<>();//Array list that will hold each sentence of the file
        Ledger ledger=new Ledger();
        //ArrayList<PurchaseOrder> ledgerTrial=new ArrayList<>();
        FileReader test  = new FileReader(fileName); //reads in file
        BufferedReader textReader = new BufferedReader(test);//reads file
        //Outputs which file is being tested
        String words;//Used to check there is a line and is then added to list
        while((words = textReader.readLine()) != null){//Checks there is a line
            file.add(words);//Adds line line to String arraylist
        }
        int size=file.size();

        
        ledger.setYear(p.checkYear(file.get(0)));
        for(int i=0;i<size;i++){
            ArrayList<String> po=new ArrayList<String>();
            if(file.get(i).equals(PO_START)){
                while(!file.get(i).equals(PO_END)){
                    po.add(file.get(i));
                    i++;
                }
                po.add(file.get(i));
    //        PurchaseOrder p=new PurchaseOrder();
            p=PurchaseOrderFactory.createPO(po);
            ledger.addOrder(p);
            //ledgerTrial.add(p);
            
            }
        }

        return ledger;
    }
    public String getYear(){
        return _year;
    }
}

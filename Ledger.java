/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import Factory.LedgerFactory;
import Factory.PurchaseOrder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Gabriel Gordon
 * Midterm Project
 * Ledger is the Parent class to Purchase Order
 * @author gagordon
 */
public class Ledger {
    private static String _year;
    private String _toString;
    private ArrayList<PurchaseOrder> po=new ArrayList<PurchaseOrder>();

    //set singleton to ledgerFactory
    //LedgerFactory lf=LedgerFactory.getInstance();
    
    /**
     * @param args the command line arguments
     */
    public Ledger(){}
    
    public void setYear(String year){
        _year=year;
    }
    public static String getYear(){
        return _year;
    }
       
    public void addOrder(PurchaseOrder pOrder){
        po.add(pOrder);
    }

    @Override
    public String toString(){
        for(int i=0;i<po.size();i++){
            _toString=_toString+po.get(i).toString();
        }
        return _toString;
    }
}
        
       
  

     
    
        
        
            
    
        
               

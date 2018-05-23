/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cost;

import Factory.PurchaseOrder;
import java.util.ArrayList;

/**
 *
 * @author gagordon
 */
public class Item {
    private String _itemName;
    private String _taxable;
    private double _itemPrice;
    private double _taxCost;
    private boolean _boolTaxable;
    
    //takes in item and splits it up for later use
    public Item(double itemPrice,String itemName,String taxable){
        _itemPrice=itemPrice;
        _itemName=itemName;
        _taxable=taxable;
    
    }
    public boolean getTaxable(){
        if(_taxable.equals("T")){
            _boolTaxable=true;
        }else{
            _boolTaxable=false;
        }
        return _boolTaxable;
    }
    public String toString(){
        return _itemName;
    }

    public double getTax(double _taxRate){
        _taxCost=_itemPrice*_taxRate;
        return _taxCost;
    }
    public double getBaseCost(){
        return _itemPrice;
    }

}

        
 

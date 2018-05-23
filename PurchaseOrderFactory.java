/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Cost.Item;
import java.util.ArrayList;

/**
 *
 * @author gagordon
 */
public class PurchaseOrderFactory {

    private static PurchaseOrder _po = new PurchaseOrder();
    private static final String ITEM_START = "===";
    private static final String PO_END = "---";
    private static final String US = "US";
    private static final String ITALY = "IT";
    private static final String ROK = "SK";
    
    //set singleton from PurchaseOrder Class
     private static PurchaseOrderFactory _instance;
    
     /**
     private PurchaseOrderFactory(){}
     public static PurchaseOrderFactory getInstance(){
     if(_instance==null){
     _instance=new PurchaseOrderFactory();
     }
     return _instance;
     }
     */

    public static PurchaseOrder createPO(ArrayList<String> pOrder) {
        ArrayList<Item> alIt = new ArrayList<>();//holds items for item class
        _po.setPickID(pOrder.get(1));
        _po.setOrderDate(pOrder.get(2));
        _po.setDeliveryDate(pOrder.get(3));
        _po.setCountry(pOrder.get(4));
        String _country = pOrder.get(4);
        int size=pOrder.size();
        if (_country.equals(US)) {
            _po.setName(pOrder.get(5));//name
            _po.setAppartment(pOrder.get(6));//apartment
            _po.setAddress(pOrder.get(7));//address
            _po.setTown(pOrder.get(8));//town
            _po.setState(pOrder.get(9));//state
            _po.setPostalCode(pOrder.get(10));//postalCode
            if (pOrder.get(11).equals(ITEM_START)) {
                size=size-1;
                for(int j=12;j<size;j=j+3){
                    if(j<size){//total size 18
                        Item it = new Item(Double.parseDouble(pOrder.get(j)), pOrder.get(j+1), pOrder.get(j+2));
                        alIt.add(it);
                    }
                }
                _po.setItem(alIt);
            
            }
        } else {
            if (_country.equals(ITALY)) {
                _po.setName(pOrder.get(5));
                _po.setAddress(pOrder.get(6));
                _po.setPostalCode(pOrder.get(7));
                _po.setCity(pOrder.get(8));
                _po.setProvince(pOrder.get(9));
                if (pOrder.get(10).equals(ITEM_START)) {
                    size=size-1;
                    for(int j=11;j<size;j=j+3){
                        if((j)!=size){//total size 17
                            Item it = new Item(Double.parseDouble(pOrder.get(j)), pOrder.get(j+1), pOrder.get(j+2));
                            alIt.add(it);
                    }
                }
                _po.setItem(alIt);
            
            }
            } else {
                if (_country.equals(ROK)) {
                    _po.setName(pOrder.get(5));
                    _po.setAddress(pOrder.get(6));
                    _po.setSubdivision(pOrder.get(7));
                    _po.setCity(pOrder.get(8));
                    _po.setProvince(pOrder.get(9));
                    if (pOrder.get(10).equals(ITEM_START)) {
                        size=size-1;
                        for(int j=11;j<size;j=j+3){
                            if((j)!=size){//total size 17
                                Item it = new Item(Double.parseDouble(pOrder.get(j)), pOrder.get(j+1), pOrder.get(j+2));
                                alIt.add(it);
                            }
                        }
                        _po.setItem(alIt);
                    }
                } else {
                    //set boolean to tell program to end due to bad input
                }
            }
        }
        return _po;

    }

}

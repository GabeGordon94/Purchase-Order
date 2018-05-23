/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.ArrayList;
import Address.*;
import Cost.*;
import Status.*;
import java.util.Date;
import java.util.GregorianCalendar;
import midtermproject.Ledger;

/**
 *
 *
 * @author gagordon
 */
public class PurchaseOrder {

    private static final String US = "US";
    private static final String ITALY = "IT";
    private static final String ROK = "SK";

    private String _Year;
    private String _name;
    
//used in the address class for different countries
    private String _address;
    private String _formattedAddress;
    private String _apartmentAdd;
    private String _town;
    private String _state;
    private String _postalCode;
    private String _province;
    private String _subdivision;
    private String _fullCountry;
    private String _city;

    //recieved from file and set for toString
    private String _pickID;
    private String _status;

    private Dates _delDate;//delivery date using gregorian calendar
    private Dates _orderDate;//order date using greg calendar

    private double _taxRate;//tax rate which will be calculated in method
    private double _baseCost;//gets base cost of each item to add up

    private String _country;//country for PO
    private double _totalCost;//adds up totalCost
    private String _toString;//returns a string formatted for PO
    private String _year;//year of PO

    private ArrayList<Item> _poItems;//stores each item in an arraylist of member data Item
    private Address _finalAddress;//formats final address
    private double _totalTax;//counter for total tax

    //set Singleton to PurchaseOrderfactory
    //PurchaseOrderFactory pof=PurchaseOrderFactory.getInstance();
    
    public String checkYear(String year){
        boolean correctInput=true;
        int size=year.length();
        if(size==4){
            return year;
        }else{
            year="Invalid Input";
            return year;
        }
    }
    
    
    public void setYear(String year) {
        _year = Ledger.getYear();
    }

    public String getYear(){
        Ledger year=new Ledger();
        _year=Ledger.getYear();
        return _year;
    }
    
    public void setPickID(String pickID) {
        _pickID = pickID;
    }

    public void setOrderDate(String orderDate) {
        Dates od = new Dates(orderDate);
        od.getDates();
        _orderDate = od;
    }

    public void setDeliveryDate(String deliveryDate) {
        Dates dd = new Dates(deliveryDate);
        dd.getDates();
        _delDate = dd;
    }

    public void setCountry(String Country) {
        _country = Country;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public void setAppartment(String appartmentAdd) {
        _apartmentAdd = appartmentAdd;
    }

    public void setTown(String town) {
        _town = town;
    }

    public void setState(String state) {
        _state = state;
    }

    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    public void setCity(String city) {
        _city = city;
    }

    public void setProvince(String province) {
        _province = province;
    }

    public void setSubdivision(String subdivision) {
        _subdivision = subdivision;
    }

    public void setItem(ArrayList<Item> poItems) {
        _poItems = poItems;
    }

    public String getStatus() {//get todays date and play around
        GregorianCalendar CurrentDay = new GregorianCalendar();
        String _currentMonth = String.valueOf(CurrentDay.get(GregorianCalendar.MONTH));
        String _currentDay = String.valueOf(CurrentDay.get(GregorianCalendar.DAY_OF_MONTH));
        String _currentYear = String.valueOf(CurrentDay.get(GregorianCalendar.YEAR));

        if (CurrentDay.after(_delDate)) {
            _status = "Delivered!";
        } else {
            if (CurrentDay.before(_delDate)) {
                _status = "Out for Delivery";
            } else {
                _status = "Open";
            }
        }
        return _status;
    }

    public double getTaxRate() {
        if (_country.equals(US)) {
            UStax taxRate = new UStax(_state);
            _taxRate = UStax.getTax();
        } else {
            if (_country.equals(ROK)) {
                _taxRate = SkTax.getTax();
            } else {
                if (_country.equals(ITALY)) {
                    _taxRate = ItalyTax.getTax();
                } else {
                    _taxRate = 0.0;
                }
            }
        }
        return _taxRate;
    }

    public double calculateTax() {
        int size = _poItems.size();
        _taxRate = getTaxRate();
        
        for (int i = 0; i < size; i++) {
            Item item=_poItems.get(i);
            if (item.getTaxable()==true) {
                _totalTax = ((_poItems.get(i)).getTax(_taxRate)) + _totalTax;
            } else {
                _totalTax = 0 + _totalTax;
            }
        }
        return _totalTax;
    }
    
     public double getBaseCost(){
         int size = _poItems.size();
         for(int i=0;i<size;i=i+3){
             _baseCost=_baseCost+(_poItems.get(i).getBaseCost());
         }
         return _baseCost;
     }

    public String getAddress() {
        if (_country.equals(US)) {
            USaddress ad = new USaddress(_name, _apartmentAdd, _address, _city, _state, _postalCode);
            _formattedAddress = USaddress.getAddress();
        } else {
            if (_country.equals(ROK)) {
                SKaddress ad = new SKaddress(_name, _address, _subdivision, _city, _province);
                _formattedAddress = SKaddress.getAddress();
            } else {
                if (_country.equals(ITALY)) {
                    ITaddress ad = new ITaddress(_name, _address, _postalCode, _city, _province);
                    _formattedAddress = ITaddress.getAddress();
                } else {
                    _formattedAddress = "MAKE ME FAIL";
                }
            }
        }
        return _formattedAddress;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        //create tostring in item poitem
        //YOURE ALOMST DONE!!!! HOLY SHIT!!!!!
        _toString = "\nYour Purchase Order reference number is: " + _pickID + "\nThis order was made in the year " + getYear() + "\nIt was shipped to:\n"
                + getAddress() + "\nYour orders status is: " + getStatus() + "\nThis purchase order was for " + _poItems.toString() +"\nThe tax Rate on taxable items are: $"+(getTaxRate()*100)+"%\nThe tax cost for this PO was: $" + calculateTax()
                +"\nThe base cost for this PO was:$"+getBaseCost()+"\nThe delivery fee is $1.00\n\n";
        return _toString;
    }

    }


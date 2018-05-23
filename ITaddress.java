/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Address;

/**
 *
 * @author gagordon
 */
public class ITaddress extends Address {
    private static String _name;
    private static String _address;
    private static String _postalCode;
    private static String _city;
    private static String _province;
    
    private static String _formattedAddress;

    public ITaddress(String name, String address, String postalCode, String city, String province){
        _name=name;
        _address=address;
        _postalCode=postalCode;
        _city=city;
        _province=province;
    }
    
    public static String getAddress(){
        _formattedAddress="\n\n"+_name+"\n"+_address+"\n"+_postalCode+"\n"+_city+"\n"+_province+"\nItaly\n\n";
        return _formattedAddress;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

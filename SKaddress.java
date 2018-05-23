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
public class SKaddress extends Address {
    private static String _name;
    private static String _address;
    private static String _subdivision;
    private static String _city;
    private static String _province;
    
    private static String _formattedAddress;

    public SKaddress(String name, String address, String subdivision, String city, String province){
        _name=name;
        _address=address;
        _subdivision=subdivision;
        _city=city;
        _province=province;
    }
    
    public static String getAddress(){
        _formattedAddress="\n\n"+_name+"\n"+_address+"\n"+_subdivision+"\n"+_city+"\n"+_province+"\nSouth Korea\n\n";
        return _formattedAddress;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

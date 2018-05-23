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
public class USaddress extends Address {
    private static String _name;
    private static String _apartment;
    private static String _address;
    private static String _city;
    private static String _state;
    private static String _postalCode;
    
    private static String _formattedAddress;

    public USaddress(String name, String apartment, String address, String city, String state, String postalCode){
        _name=name;
        _apartment=apartment;
        _address=address;
        _city=city;
        _state=state;
        _postalCode=postalCode;
    }
    
    public static String getAddress(){
        _formattedAddress="\n\n"+_name+"\n"+_apartment+"\n"+_address+"\n"+_city+","+_state+" "+_postalCode+"\n\n";
        return _formattedAddress;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

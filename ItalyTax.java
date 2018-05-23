/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cost;

/**
 *
 * @author gagordon
 */
public class ItalyTax extends Tax{

    public ItalyTax() {
        
    }
    
    public static double getTax(){
        double _taxRate=.22;
        return _taxRate;
    }
}

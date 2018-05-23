/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cost;

import static java.lang.Character.toLowerCase;

/**
 *
 * @author gagordon
 */
public class UStax extends Tax {

    private static String _state;
    private static double _taxRate;
    public UStax(String state) {
        _state=state;
    }
    
    public static double getTax(){
        char letter=_state.charAt(0);
        letter=toLowerCase(letter);
        if((letter>='a')&&(letter<='m')){
            _taxRate=.065;
        } else {
            _taxRate=.075;
        }
        return _taxRate;
    }
}

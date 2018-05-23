/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Status;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author gagordon
 */
public class Dates {

    private String[] _orderDate;
    private int _month;
    private int _year;
    private int _day;
    private GregorianCalendar _finalOrderDate;

    public Dates(String orderDate) {
        _orderDate = orderDate.split("/");
        _year = Integer.parseInt(_orderDate[0]);
        _month = Integer.parseInt(_orderDate[1]);
        _day = Integer.parseInt(_orderDate[2]);
    }

    public GregorianCalendar getDates() {
        return _finalOrderDate = new GregorianCalendar(_year, _month, _day);
    }

}

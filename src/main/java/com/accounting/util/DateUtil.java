package com.accounting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.accounting.util.exception.UtilException;

public class DateUtil {

  public static String convertDateToString(Date date) {
    if (date == null) {
      return null;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(date);
  }


  public static Date convertStringToDate(String line) throws UtilException {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return sdf.parse(line);
    } catch (ParseException e) {
      throw new UtilException(e);
    }
  }

  public static Date getDateRusFormat(String line) throws UtilException {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
      return sdf.parse(line);
    } catch (ParseException e) {
      throw new UtilException(e);
    }
  }
  
  public static Date getDifferenceBetweenDates(Date date1, Date date2) {
    return new Date(date2.getTime() - date1.getTime());
  }
  
  public static Date getTimePastFromDate(String string) throws UtilException {
    Date date1 = convertStringToDate(string);
    return new Date(new Date().getTime() - date1.getTime());
  }
}

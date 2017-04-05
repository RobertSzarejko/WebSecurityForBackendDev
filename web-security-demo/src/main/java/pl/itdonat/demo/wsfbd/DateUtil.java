package pl.itdonat.demo.wsfbd;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_DMY_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private static final DateTimeFormatter dateTimeDMYFormatter = DateTimeFormatter.ofPattern(DATE_TIME_DMY_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {}

    public static String localDateTimeToString(LocalDateTime localDateTime){
        String localDateTimeToString;

        if(localDateTime==null){
            localDateTimeToString = "";
        }else{
            localDateTimeToString = dateTimeFormatter.format(localDateTime);
        }
        return localDateTimeToString;
    }

    public static String localDateTimeDMYToString(LocalDateTime localDateTime){
        String localDateTimeToString;

        if(localDateTime==null){
            localDateTimeToString = "";
        }else{
            localDateTimeToString = dateTimeDMYFormatter.format(localDateTime);
        }
        return localDateTimeToString;
    }

    public static LocalDateTime stringToLocalDateTime(String value){
        LocalDateTime localDateTime;

        if(Strings.isNullOrEmpty(value)){
            localDateTime = null;
        }else{
            localDateTime = LocalDateTime.parse(value, dateTimeFormatter);
        }
        return localDateTime;
    }

    public static String localDateToString(LocalDate localDate){
        return localDateToString(localDate, DATE_FORMATTER_YYYY_MM_DD);
    }
    
	public static String localDateTimeToOnlyDateString(LocalDateTime localDate) {
		return localDateToString(localDate, DATE_FORMATTER_YYYY_MM_DD);
	}

	public static String localDateTimeToOnlyTimeString(LocalDateTime localDate) {
		return localDateToString(localDate, timeFormatter);
	}

    public static String localDateToString(LocalDate localDate, DateTimeFormatter formatter){
        String localDateToString;

        if(localDate==null){
            localDateToString = "";
        }else{
            localDateToString = formatter.format(localDate);
        }
        return localDateToString;
    }
    
    public static String localDateToString(LocalDateTime localDate, DateTimeFormatter formatter){
        String localDateToString;

        if(localDate==null){
            localDateToString = "";
        }else{
            localDateToString = formatter.format(localDate);
        }
        return localDateToString;
    }
    
  
    public static LocalDate stringToLocalDate(String value, DateTimeFormatter formatter){
        LocalDate localDate;

        if(Strings.isNullOrEmpty(value)){
            localDate = null;
        }else{
            try{
                localDate = LocalDate.parse(value, formatter);
            }catch (Exception exp){
                LOG.error("Incorrect data format: "+value, exp);
                localDate = LocalDate.now();
            }

        }
        return localDate;
    }

    public static LocalDate stringToLocalDate(String value){
        return stringToLocalDate(value, DATE_FORMATTER_YYYY_MM_DD);
    }

    public static Date localDateToDate(LocalDate localDate){
        Date date;

        if(localDate==null){
            date = null;
        }else{
            date = Timestamp.valueOf(localDate.atStartOfDay());
        }
        return date;
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        Date date;

        if(localDateTime==null){
            date = null;
        }else{
            date = Timestamp.valueOf(localDateTime);
        }
        return date;
    }

    public static LocalDate dateToLocalDate(Date date){
        LocalDate localDate;

        if(date==null){
            localDate = null;
        }else{
            Timestamp timestamp = new Timestamp(date.getTime());
            localDate = timestamp.toLocalDateTime().toLocalDate();
        }
        return localDate;
    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        LocalDateTime localDateTime;

        if(date==null){
            localDateTime = null;
        }else{
            Timestamp timestamp = new Timestamp(date.getTime());
            localDateTime = timestamp.toLocalDateTime();
        }
        return localDateTime;
    }

    public static boolean isEmptyOrNotBeforeCurrentDate(LocalDate localDate){
        boolean isEmptyOrAfterCurrentDate;

        if(localDate==null){
            isEmptyOrAfterCurrentDate = true;
        }else{
            isEmptyOrAfterCurrentDate = !LocalDate.now().isAfter(localDate);
        }
        return isEmptyOrAfterCurrentDate;
    }

    public static boolean isEmptyOrNotBeforeCurrentDate(LocalDateTime localDateTime){
        boolean isEmptyOrAfterCurrentDate;

        if(localDateTime==null){
            isEmptyOrAfterCurrentDate = true;
        }else{
            isEmptyOrAfterCurrentDate = !LocalDate.now().isAfter(localDateTime.toLocalDate());
        }
        return isEmptyOrAfterCurrentDate;
    }

    public static boolean isEmptyOrAfterCurrentDate(LocalDate localDate){
        boolean isEmptyOrAfterCurrentDate;

        if(localDate==null){
            isEmptyOrAfterCurrentDate = true;
        }else{
            isEmptyOrAfterCurrentDate = localDate.isAfter(LocalDate.now());
        }
        return isEmptyOrAfterCurrentDate;
    }

    public static boolean isEmptyOrAfterCurrentDate(LocalDateTime localDateTime){
        boolean isEmptyOrAfterCurrentDate;

        if(localDateTime==null){
            isEmptyOrAfterCurrentDate = true;
        }else{
            isEmptyOrAfterCurrentDate = localDateTime.toLocalDate().isAfter(LocalDate.now());
        }
        return isEmptyOrAfterCurrentDate;
    }
}

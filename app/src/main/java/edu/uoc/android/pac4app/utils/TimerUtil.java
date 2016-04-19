package edu.uoc.android.pac4app.utils;

/**
 * Created by Marc on 25/11/2015.
 */
public class TimerUtil {

    public static final String CHRONO_FORMAT_MILLIS = "00:00:00.000";

    /**
     * Method to get a String time format.
     *
     * @param chronoFormat
     * @param millis
     * @return
     */
    public static String getChronoStyleFromMillis(String chronoFormat, long millis) {
        String result;
        long tempChrono = millis;
        long mm = (millis % 1000);
        tempChrono = tempChrono / 1000;
        long sec = tempChrono % 60;
        tempChrono = tempChrono / 60;
        long min = tempChrono % 60;
        tempChrono = tempChrono / 60;
        long hours = tempChrono;
        if (hours > 23)
            hours = hours % 24;

        String hourString = Long.toString(hours);
        String minString = Long.toString(min);
        String secString = Long.toString(sec);
        String mmString = Long.toString(mm);
        if (hourString.length() == 1)
            hourString = "0" + hourString;
        if (minString.length() == 1)
            minString = "0" + minString;
        if (secString.length() == 1)
            secString = "0" + secString;
        if (mmString.length() == 1)
            mmString = "00" + mmString;
        else if (mmString.length() == 2)
            mmString = "0" + mmString;

        switch (chronoFormat) {
            case CHRONO_FORMAT_MILLIS:
                result = hourString + ":" + minString + ":" + secString + "." + mmString;
                break;
            default:
                result = "00:00:00";
                break;
        }
        return result;
    }
}

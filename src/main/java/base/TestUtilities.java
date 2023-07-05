package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestUtilities extends BaseTest{

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
    Date date = new Date();
    String date1 = dateFormat.format(date);

    // STATIC SLEEP
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Generate random value
    protected static String emailAdd(){
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() <3) { // length of the random string.
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    // Random value
    public static String userEmail = emailAdd();
}

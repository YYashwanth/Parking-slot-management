
/**
 * This class is used to interact with IO console
 * 
 * @author Yashwanth
 * @version 1.0
 */

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class IO_Support
{
    //static class variable
    public static Scanner in = new Scanner(System.in);
    
    public static String getString(String stringInput)
    {
        System.out.print(stringInput+" ");
        return in.nextLine();
    }
    
    public static Integer getInteger(String stringInput)
    {
        Integer integerVar=0;
        while(true)
        {
            try
            {
                System.out.print(stringInput+" ");
                integerVar = Integer.parseInt(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid integer.");
            }
        }
        return integerVar;
    }
    
    public static Double getDouble(String stringInput)
    {
        Double doubleVar=0.0;
        while(true)
        {
            try
            {
                System.out.print(stringInput+" ");
                doubleVar = Double.parseDouble(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid double.");
            }
        }
        return doubleVar;
    }

    public static LocalDateTime getLocalDateTime(String stringInput)
    {
        LocalDateTime tempDateTime;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM");

        while(true)
        {
            try
            {
                System.out.print(stringInput+" ");
                tempDateTime = LocalDateTime.parse(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not entered in a valid format" + e);
            }
        }
        return tempDateTime;
    }
    
    public static void println(String stringInput)
    {
        System.out.println(stringInput);
    }

    
}

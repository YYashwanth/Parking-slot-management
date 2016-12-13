import java.util.*;
import java.time.*;
import java.lang.Math;
import java.time.format.*;
/**
 * Tests the functionality of the car parking system
 * 
 * @author Yashwanth Yellapragada
 * @version 1.1
 */
public class ParkingTest
{
    /**
     * The following attributes help in the execution/testing of the system:
     * <li>carObject : contains the object of class Car.
     * <li>spotTemp: contains the object of the Spot class.
     * <li>carParkObject: contains the object of CarPark class.
     */
   
    public static Car carObject;
    public static Spot spotTemp = new Spot();
    public static CarPark carParkObject;
    
    
/**
 * Constructor for objects of class UserInterface
 */
 public ParkingTest(CarPark carParkObject)
 {
            this.carParkObject=carParkObject;
 }
   

 /**
 * This method is responsible for the menu option selection
 */
 public void run()
 {
     boolean condition = true;
       
        while(condition)
        {

       
       
        switch(menu()){
            
            case 1: 
            addingSpot();
            break;
            
            case 2:
            getAvailableSpots();
            break;
            
            case 3:
            deletingSpot();
            break;
            
            case 6:
            Find();
            break;
            
            case 4:
            parkingCar();
            break;
            
            case 5:
            collect();
            break;
            
            case 7:
            move();
            break;
            
            case 10:
            System.out.println("See you again soon!");
            condition = false;
            break;
            
            case 9:
            displaySpotReport();
            break;
            
            case 8:
            getOccupiedSpots();
            break;
            
            default:
            IO_Support.println("Please enter a valid option");
            break;
                     
        }
        
    }
}
        
        
/**
 * The following method displays the menu
 *
 */

    public int menu(){
        
         IO_Support.println("\n1.Add Spot\n2.Get Available Spots\n3.Delete Spot\n4.Park Car\n5.Collect Car\n6.Find Car\n7.Move Car\n8.Get Occupied Spots\n9.Display Spot Report\n10.Exit");
         return IO_Support.getInteger("Enter your choice: ");
         
        
    }
    
    /**
     * The following method adds a spot to the collection of spots
     *
     */
    public void addingSpot(){
        
        String spotName = IO_Support.getString("Please enter the spot name :");
        Car parked = null;
        double hourlyRate = IO_Support.getDouble("Please enter the hourly rate :");
        LocalDateTime timeIn = null;
        boolean spotAvailable = true;
        Spot spotObject = new Spot(spotName, parked, hourlyRate, timeIn, spotAvailable);
        carParkObject.addSpot(spotObject);
     
    }
    
    /**
     * The following method helps in parking a car in the spot.
     */

    public void parkingCar(){
        
        String ownerName = IO_Support.getString("Please enter the vehicle owner's name :");
        String regNum = IO_Support.getString("Please enter the vehicle's registration number :");
        LocalDateTime expected = IO_Support.getLocalDateTime("Please enter the expected collection date/time in YYYY-MM-DDTHH:MM format :");
        String spotName = IO_Support.getString("Enter the slot number :");
       
        for(Spot s : carParkObject.getAllSpots()){
            
            if(s.getCar() != null && s.getCar().getRegNum().equals(regNum))
            {
            IO_Support.println("above registration number already exists");
            break;
            }
           else
           {
                if(s.getName().equals(spotName)){
                    if(s.isAvailable())
                        {
                            carObject = new Car(ownerName, regNum, expected);
                            s.setStatus(false);
                            s.parkCar(carObject);
                            s.setTimeIn(LocalDateTime.now());
                            if(s.parkCar(carObject))             
                            IO_Support.println("Car parked successfully");
                            break;
                        }
                        else{
                        IO_Support.println("Spot not available");
                        break;
                    }
             
                    }
                    else{
                    IO_Support.println("Spot not found ");
                    break;
                }
            
            
        }
        
        
    }
}
   
    /**
     * The following method gets the list of Available spots.
     */

    public void getAvailableSpots(){
        
       
     //  ArrayList<Spot> temp = new ArrayList<Spot>();
      // temp = carParkObject.getAvailableSpots();
       IO_Support.println("SpotName"+"\t"+"HourlyRate"+"\t"+"SpotAvailable");
       for(Spot s : carParkObject.getAvailableSpots()){
           
           IO_Support.println(s.getName() +"\t\t"+s.getHourlyRate()+"\t\t"+s.isAvailable());
           
        }
        
    }
    
    /**
     * This method gets the list of occupied spots.
     * 
     */
     public void getOccupiedSpots(){
         
       IO_Support.println("SpotName"+"\t"+"HourlyRate"+"\t"+"SpotAvailable");
       for(Spot s : carParkObject.getOccupiedSpots()){
           
           IO_Support.println(s.getName() +"\t\t"+s.getHourlyRate()+"\t\t"+s.isAvailable());
           
        }
        
    }
    
    /**
     * The following method deletes a spot from the collection of spots.
     */

    public void deletingSpot(){
        
      carParkObject.removeSpot(IO_Support.getString("Please enter the name of the spot you want to delete:"));
      
    }
        
    /**
     * The following method collects the car from the spot.
     */

    public void collect(){
        
        String regNum = IO_Support.getString("Please enter the car's registration number:");
        String spotName = IO_Support.getString("Please enter the slot name where you parked :");
        carObject = new Car();
        boolean stat = false;
        Car temp;
       for(Spot s : carParkObject.getAllSpots()){
           
           
           if(s.getName().equals(spotName))
           {
               stat = true;
               temp = s.getCar();
                   
               if(temp != null && temp.getRegNum().equals(regNum))
               {
                   s.setStatus(true);
                   s.removeCar();
                  
                   IO_Support.println("The total cost is $ " + s.getCurrentCharge(s));
                      
                   
               }
               else
               IO_Support.println("Could not find the car with the above registration number");
            }
            
    
        }
        if(!stat)
        IO_Support.println("Could not find the spot mentioned");
        
    }
    
      
    /**
     * The following method moves the car from one spot to another.
     */
  
    public void move(){
        
        String regNum = IO_Support.getString("Please enter the car's registration number:");
        String spotName2 = IO_Support.getString("Please enter the slot name where you want to move :");
        
        
        spotTemp.moveCar(regNum, spotName2,carParkObject);
        
        
    }
    
    
    /**
     * The following method finds a car based on its registration num
     */

    public void Find(){
        
        String regNum = IO_Support.getString("Please enter the car's registration number:");
        boolean stat = false;
        Car temp;
        
        for(Spot s : carParkObject.getAllSpots()){
            
            if(s.getCar()!=null && s.getCar().getRegNum().equals(regNum)){
                stat = true;
                IO_Support.println("Your car is parked in " + s.getName());
        }
         
        }
         if(!stat)
        IO_Support.println("Could not find the car with the given details. Please contact the help desk.");
        
        
    }
    
    
    private void displaySpotReport()
    {
        String formattedHeader=String.format("%-15s%-15s%-20s%-15s%-25s%-10s","Spot ID","Arrival Time","Arrival Date","Time IN","Car Registration ID","Fee");
        IO_Support.println(formattedHeader);
        for(Spot s : carParkObject.getAllSpots())
        {
            if(s.getCar()==null)
            IO_Support.println("");
            
            else
            {
            Duration duration = Duration.between(s.getTimeIn(),LocalDateTime.now());
            String temp="",minute="min.";

            long minutes=(duration.getSeconds())/60;
            double fee = spotTemp.getCurrentCharge(s);
           
           
            int day=s.getCarParkedDate().getDayOfMonth();
            int year=s.getCarParkedDate().getYear();
            
            if(s.getTimeIn().getHour() > 12)
            {
                temp="pm";
            }
            else
            {
                temp="am";
            }
            
            String Hour = String.valueOf(s.getTimeIn().getHour());
            String Min = String.valueOf(s.getTimeIn().getMinute());
            String formattedOutput=String.format("%-15s%s%-10s%-22s%d%-18s%-20s%s",s.getName(),Hour+":"+Min,temp,s.getCarParkedDate().getMonth().toString()+" "+day+", "+year,minutes,minute,s.getCar().getRegNum(),"$"+fee);
            IO_Support.println(formattedOutput);
        }
    }
}


}

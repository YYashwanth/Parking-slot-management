
import java.time.*;
/**
 * This class has the attributes to understand the behaviour of a parking spot and various methods used to access and get the data.
 * 
 * @author Yashwanth Yellapragada 
 * @version 1.1
 */
public class Spot
{

    /**
     * The following attributes help in describing the Car object:
     * <li>name : describes the name of the spot.
     * <li>parked: describes the car that is parked in the spot.
     * <li>hourlyRate: describes the hourly rate of parking in the spot
     * <li>timeIn: describes the time when a car has parked in the spot.
     * <li>spotAvailable: states if the spot is available for parking.
     * <li>totalCharge: gives the total cost of parking.
     */
   private String name;
   private Car parked;
   private double hourlyRate,totalCharge, tempCharge, tempCharge1;
   private LocalDateTime timeIn;
   private boolean spotAvailable;
   
   
   //default constructor
    public Spot()
    {
        this.name="";
        this.parked=null;
        this.timeIn=null;
        this.hourlyRate=0.0;
    }
   
   /**
     * The following constructor initialises the variables of the class
     * @param name It takes in a parameter of type String and initialises spotName
     * @param parked takes in the car object
     * @param hourlyRate takes in a double value that states the cost of parking in the spot.
     * @param timeIn takes in a value of type LocalDateTime that is used to calculate the cost.
     * @param spotAvailable takes in a boolean value that states the availability of the spot.
     */
   public Spot(String name, Car parked, double hourlyRate, LocalDateTime timeIn, boolean spotAvailable){
       
        if(name.trim().isEmpty())
        IO_Support.println("Invalid name of the spot");
        else
        this.name = name;
        
        this.parked = parked;
        this.hourlyRate = hourlyRate;
        this.timeIn = timeIn;
        this.spotAvailable = spotAvailable;
       
       
    }

    /**
     * The following method returns the name of the spot.
     * 
     * @return String returns the name of the spot as a string.
     * 
     */
    
    public String getName(){
        
        
       return name; 
    }
    
    /**
     * The following method gets the car object stored in the spot.
     * 
     * @return Car returns the car object stored.
     * 
     */
    
    public Car getCar(){
        
        
        return parked;
    }
   
    /**
     * The following method sets the status of the spot availability
     * 
     * @param status it takes status as the parameter of type boolean
     * 
     */

    public void setStatus(boolean status){
       
        spotAvailable = status;
        
    }
    
    /**
     * The following method adds a car object to the spot.
     * 
     * @param aCar it takes aCar of type Car and stores it in the variable parked.
     * @return boolean it returns true if the car is parked properly else false.
     */

    public boolean parkCar(Car aCar){
        
        if(aCar == null)
        return false;

        else{        
        parked = aCar;        
        return true;
        }
        
    }
    
    /**
     * The following method removes a car from the spot
     * 
     */

    public void removeCar(){
             
        parked = null;        
        
        }
        
    
    
   
    /**
     * The following method sets the time of the car when it parks in the car
     * 
     * @param local it takes local as a parameter of type LocalDateTime that is used to assign the parking time of the car.
     * 
     */

    
    public void setTimeIn(LocalDateTime local){
        
        timeIn = local;
        
    }
    
   
    /**
     * The following method gets the hourly rate of the spot
     * 
     * @return double the hourly rate of the spot.
     * 
     */
    public double getHourlyRate(){
        
        
        return hourlyRate;
    }
    
    /**
     * The following method gets the time when a car is parked in the spot.
     * 
     * @return LocalDateTime returns the time in of a car parked.
     * 
     */

    public LocalDateTime getTimeIn(){
        
        return timeIn;
    }
    
    /**
     * The following method sets the hourly rate of a spot
     * 
     * @param rate it takes in a parameter of type double to assign the hourly rate of the spot.
     * 
     */

    public void setChargeRate(double rate){

        hourlyRate = rate;

    }
    
    /**
     * The following method tells if the spot is available for parking or not.
     * 
     * @return boolean tells if the spot is available for parking.
     * 
     */
    public boolean isAvailable(){
        
        
        return spotAvailable;
    }
    
     /**
     * This method returns the current charge
     * @param s takes in s of type Spot
     * @return double currentCharge
     */
    public double getCurrentCharge(Spot s)
    {
         Duration elapsed = Duration.between(s.getTimeIn(), LocalDateTime.now());
                   long seconds = elapsed.getSeconds();
                   long minutes = seconds/60;
                   double halfHours=minutes/30.0;
                   if(halfHours==0.0)
                   {
                       totalCharge=(s.getHourlyRate()/2);
                       return totalCharge;
                    }
                   totalCharge=(long)halfHours*(s.getHourlyRate()/2);
                   if(((long)halfHours)>0.000001)
                   totalCharge=totalCharge+(s.getHourlyRate()/2);
                   return totalCharge;
    }
    
    
    /**
     * This method helps in moving a car from one spot to another
     * @return double currentCharge
     */
    public void moveCar(String regNum, String spotName2, CarPark carparkObject)
    {
        
        Car tempCar = null;
        
        
         for(Spot s : carparkObject.getAllSpots()){
            
            if(s.getCar()!= null && s.getCar().getRegNum().equals(regNum))
            {
                tempCar = s.getCar();
                tempCharge = s.getHourlyRate();
                
                
                
                 for(Spot s1 : carparkObject.getAllSpots()){
                    if(s1.getName().equals(spotName2) && s.getName()!= s1.getName())
                    {
                        
                             if(s1.isAvailable())
                             {
                                 
                                           if(tempCharge >= s1.getHourlyRate())
                                            tempCharge = s1.getHourlyRate();                                            
                                            s.parkCar(null);
                                            s.setStatus(true);                                            
                                            s1.setStatus(false);
                                            s1.setTimeIn(LocalDateTime.now());
                                            s1.parkCar(tempCar);
                                            s1.setChargeRate(tempCharge);
                                
                            }
                            else
                            IO_Support.println("Chosen spot is already full");
                            }
                        }
            }           
            
        }
    }
    
    /**
     * This method returns the car parked date
     * @return LocalDate carParkedDate
     */
    public LocalDate getCarParkedDate()
    {
        return timeIn.toLocalDate();
    }
    
    /**
     * The following method is used to get all the variables of the class
     * 
     * @return String returns the variables of the class as a String.
     * 
     */

    public String toString(){
        
        
        return "Spot name is :" + name +" and charges : " + hourlyRate + " per hour";
    }
    
    
}

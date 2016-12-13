import java.time.*;
/**
 * This describes the various attributes used to understand the behaviour of a Car in a parking system. There are various methods used to access and modify the state
 * 
 * @author Yashwanth Yellapragada
 * @version 1.1
 */
public class Car
{
    /**
     * The following attributes help in describing the Car object:
     * <li>timeIn : describes the total time a car was parked.
     * <li>ownerName: describes the name of the car owner.
     * <li>regNum: describes the registration number of the car.
     * <li> expected: describes the expected collection time of the car.
     */
    private Instant timeIn;
    private String ownerName = "";
    private String regNum;
    private LocalDateTime expected;
    
    /**
     * The constructor initialises the above described variables.
     * 
     */
    public Car()
    {
        
        this.ownerName="";
        this.regNum="";
        this.expected=null;
    }
    
    /**
     * The following constructor initialises the variables of the class
     * @param name It takes in a parameter of type String and initialises ownername.
     * @param regnum It takes in a parameter of type String and initialises registration number.
     * @param expected it takes in a parameter of type LocalDateTime and initialises expected collection date.
     * 
     */
    
    public Car(String name, String regnum, LocalDateTime expected){
        
        timeIn = Instant.now();
        
        if(name.trim().isEmpty())
        IO_Support.println("Invalid Owner Name");
        else
        ownerName = name;

        if(regnum.trim().isEmpty() || regnum == null)
        IO_Support.println("Invalid registration number");
        else
        regNum = regnum;
        
        
    }
    
   
     /**
     * The following method assigns the expected collection time of the car.
     * @param expected it takes in a parameter of type LocalDateTime and initialises expected collection date.
     * 
     */
    
    public void expectedCollection(LocalDateTime expected){
        
        this.expected = expected;
        
    }
    
     /**
     * The following method gets the registration number of the car
     * 
     * @return String it returns the registration number of the car.
     */
    public String getRegNum(){
        
        
        return regNum;
    }
    
    /**
     * The following method returns the owner's name of the car.
     * 
     * @return String it returns the owner's name of the car.
     */
    public String getOwner(){
        
        
        return ownerName;
    }
    
    /**
     * The following method returns the total time parked in the parking slot.
     * 
     * @return long the total time a car has been in the parking spot.
     */
    public long timeParked(){
        
        Duration elapsed = Duration.between(timeIn, Instant.now());
        
        return elapsed.getSeconds();
    }
    
    
    
    /**
     * The following method returns the variables of the class.
     * 
     * @return String outputs the variables as a string.
     */
    
    public String toString(){
        
        
        
        return "Owner name : " + ownerName + "\nRegistered vehicle number :" + regNum + "\nExpected collection time :" + expected;
    }
    
}

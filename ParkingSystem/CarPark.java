import java.util.*;
/**
 * This class contains the methods for the administrative work of a parking system management
 * 
 * @author Yashwanth Yellapragada
 * @version 1.3
 */
public class CarPark
{
    /**
     * The following attributes help in describing the CarPark object:
     * <li>spotCollection : contains a list of all the spots in the system.
     * <li>occupiedSpots: contains a list of spots that are occupied.
     * <li>availableSpots: contains a list of spots that are available for parking.
     * 
     */
    private ArrayList<Spot> spotCollection, occupiedSpots, availableSpots;
    
    /**
     * The constructor initialised the list.
     * 
     */
    CarPark(){
        
        spotCollection = new ArrayList<Spot>();
        
    }
    
    /**
     * The following method adds a spot to the array list collection.
     * 
     * @param newSpot it takes newSpot of type Spot as a parameter and adds it to the collection of spots
     * 
     */
    
    public boolean addSpot(Spot newSpot){
        
        
        if(newSpot == null)
        {
        IO_Support.println("Invalid Spot format. Cannot add");
        return false;
        }
        
        else if(newSpot.getName() == null)
        {
        IO_Support.println("Invalid name. Cannot add");
        return false;
        }
        
        Iterator SpotIterator = spotCollection.iterator();
        Spot tempSpot;
        while(SpotIterator.hasNext())
        {
            tempSpot = (Spot)SpotIterator.next();
            if(tempSpot.getName().equals(newSpot.getName())){
               
               IO_Support.println("Cannot add a duplicate record. Name already exists");
              return false;
            }
        }
        
        spotCollection.add(newSpot);
        IO_Support.println("Spot added Successfully");
        return true;
       
        
    }
    
    /**
     * The following method removes a spot from the collection of spots.
     * 
     *@param spotName it takes spotName of type Spot as a parameter and removes it from the collection of spots
     */
    public void removeSpot(String spotName){
        
        for(Spot s : spotCollection)
        {
            if(s.getName().equals(spotName)){
                spotCollection.remove(s);
                IO_Support.println("Spot Removed");
                break;
            }
            
            
            else
            IO_Support.println("Could not find the Spot with the given name");
            
        }
        
        
        
    }
    
    /**
     * The following method finds a spot in the array list collection.
     * 
     * @param spotId it takes spotId of type String as a parameter and finds the spot among the collection of spots.
     * @return it finds a spot based on the input parameter and returns an output of type spot.
     */
    
    public Spot findSpot(String spotId){
        
        Spot temp = null;
        
        if(spotId.trim().isEmpty())
        {
        IO_Support.println("Search criteria cannot be empty");
        return temp;
        }
        
        else
        {
        for(Spot s : spotCollection){
            
            if(s.getName().equals(spotId))                
                temp = s;
            
        }
        
        return temp;
    }
}
    
    /**
     * The following method returns the collection of spots.
     * 
     * @return ArrayList returns the collection of all spots
     */
    public ArrayList<Spot> getAllSpots(){

        return spotCollection;
        
    }
    
    /**
     * The following method returns the list of AvailableSpots.
     * 
     * @return ArrayList returns the collection of all available spots.
     */
    public ArrayList<Spot> getAvailableSpots(){
        
        
        availableSpots = new ArrayList<Spot>();
        
        for(Spot s : spotCollection)
        {
            if(s.getCar() == null){
               
                availableSpots.add(s);
                
            }
            
        }
        
        
        return availableSpots;
        
    }
    
    /**
     * The following method returns a list of occupied spots.
     * 
     * @return ArrayList returns the list of occupied spots.
     */
    public ArrayList<Spot> getOccupiedSpots(){
        occupiedSpots = new ArrayList<Spot>();
        
        for(Spot s: spotCollection){
            
            if(s.getCar() != null)
            {
                occupiedSpots.add(s);
            }
            
        }
        
        
        return occupiedSpots;
    }
    
    /**
     * The following method finds a car based on the its registration number
     * 
     * @param criteria it takes criteria of type String as a parameter and checks it against the collection of spots.
     * @return Car it finds the car based on the search criteria and returns an object of type Car.
     */
    public Car findCar(String criteria){

        Car temp = null;
        Car tempcar = null;
        
        if(criteria.trim().isEmpty())
        {
        IO_Support.println("Search criteria cannot be empty");
        return tempcar;
        }
        else
        {
        for(Spot s : spotCollection){
           
           temp = s.getCar();
           if(temp.getRegNum().equals(criteria))
           tempcar = temp;
           
                  
        }
        
        return tempcar;
    }
}
    
    /**
     * The following method displays the variables of the class.
     * 
     * @return String it returns the variables as a string.
     * 
     */
    public String toString(){
               
        String temp = "";
        for(Spot s : spotCollection)
        temp = temp + " " + s.getName();
        
        return temp;
    }
}

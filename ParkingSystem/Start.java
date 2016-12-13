
/**
 * This class starts and initiailises the car park object which is used for adding of spots etc. This calls the run function which starts the system.
 * 
 * @author Yashwanth Yellapragada 
 * @version 1.1
 */
public class Start
{
    public static void main(String args[])
    {
        CarPark carParkObject=new CarPark();
        ParkingTest test= new ParkingTest(carParkObject);
        test.run();
    }
}

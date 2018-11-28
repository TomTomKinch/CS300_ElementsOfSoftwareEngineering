package chocan;
import java.io.PrintWriter;
import java.util.*;

//public class Data
public abstract class Data
{
//    boolean debug = true;

 //   protected Set<Data> services;   This one may be adding the wrong class
   // protected List<Service> services;
    protected ArrayList<Service> services;
    protected PrintWriter toFile;

/*    public String firstName;
    public String lastName;
    public int number;
 */

    protected String firstName;
    protected String lastName;
    protected int number;  // THIS NEEDS TO BE DELETED AFTER REMOVING number FROM THE PDirecteory Class
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected int id;

    // Default constructor
    public Data()
    {
/*        boolean debug = true;
        if(debug == true)   // May not need this for this class
        {
            System.out.println("Data default constructor");
        }
*/
        services = null;
        toFile = null;
        firstName = null;
        lastName = null;
        number = 0;  // not sure what number is for, but will remain 0 for now
        address = null;
        city = null;
        state = null;
        zip = 0;
        id = 0;
    }

    /**
     *
     * @param fName
     * @param lName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param id
     */
    public Data(String fName, String lName, String address, String city, String state, int zip, int id)
    {
/*        boolean debug = true;
        // May not print the right info for member or provider
        if(debug == true)
        {
            System.out.println("Data constructor");
            System.out.println("fName = " + fName);
            System.out.println("lName = " + lName);
//            System.out.println("num = " + num);
            System.out.println("address = " + address);
            System.out.println("city = " + city);
            System.out.println("state = " + state);
            System.out.println("zip = " + zip);
        }
*/
        services = null;
        toFile = null;
        this.firstName = fName;
        this.lastName = lName;
//        this.number = num;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.id = id;
    }



    // Outputs attributes to a screen or a file, depending on output stream
    public String toString()
    {
        boolean debug = !true;
        String person;
        String location;

        if(debug == true)
        {
            System.out.println("Data toString");
        }

//        String data = "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName+ "\nAddress: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip + "ID: " + this.id + "\n" ;

//        return data;


        person = "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nID Number: " + this.id;
        location = "Address: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip;
        return person + "\n" + location;

    }



    /** Edits provider or member's information
     *
     * @param info - all string type data: first name, last name, address, city, and state
     * @param number - all integer type data:  id and zip code
     * @param choice - selects the data to edit
     * @return
     */
    public boolean edit (String info, int number, int choice)
    {
        boolean flag = true;
        if (info != null)
        {
            switch (choice)
            {
                case 1:
                    lastName = new String(info);
                    break;
                case 2:
                    firstName = new String(info);
                    break;
                case 4:
                    address = new String(info);
                    break;
                case 5:
                    city = new String(info);
                    break;
                case 6:
                    state = new String(info);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        if (number > 0) {

            switch (choice) {
                case 3:
                    id = number;
                    break;
                case 7:
                    zip = number;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
       return flag;
    }


    //  Allow subclasses to write and append their data to a file
    //public abstract void buildReport(String fileName);   // Old version,  can delete after testing
    //public abstract boolean buildReport(String fileName, boolean append);  // old version, can delete
    public abstract String[] report();


    // Allow subclasses to add services to their own list of services
    public abstract boolean addService(Service aService, String name, int id);

    // Allows members and providers to display their data only, excluding their services.
 //   public abstract void displayPerson();   // Don't need this method b/c of toString method

    // Allow subclasses to output their data, and all of their services
    public abstract void displayAll();
}

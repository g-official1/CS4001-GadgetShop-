/**
 * The Mobile class is a subclass of Gadget. It represents a mobile phone
 * and adds the number of minutes of calling credit that the phone has left.
 *
 * @author  Student
 * @version 1.0
 */
public class Mobile extends Gadget
{
    // The number of minutes of calling credit remaining on the phone
    private int credit;

    /**
     * Constructor for the Mobile class.
     * The first four parameters are passed to the Gadget constructor
     * using super(). The fifth parameter sets the starting credit.
     */
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        // Call the Gadget constructor with the first four values
        super(model, price, weight, size);

        // Save the starting credit into the credit attribute
        this.credit = credit;
    }

    /**
     * Accessor method that returns the current calling credit in minutes.
     */
    public int getCredit()
    {
        return credit;
    }

    /**
     * Adds calling credit to the phone.
     * If the amount passed in is greater than zero it is added on.
     * If not, a message is printed asking for a positive amount.
     */
    public void addCredit(int amount)
    {
        // Only add the credit if the amount is a positive number
        if (amount > 0) {
            credit = credit + amount;
            System.out.println(amount + " minutes of credit added. Total credit: " + credit);
        }
        else {
            // Show a message if zero or a negative number was entered
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    /**
     * Makes a phone call. Takes the phone number and the duration in minutes.
     * If there is enough credit the call is "made" and the credit is reduced.
     * Otherwise a message is printed that there is not enough credit.
     */
    public void makeCall(String number, int duration)
    {
        // Check if the current credit is enough for the whole call
        if (duration <= credit) {
            // Enough credit so "make" the call and take the minutes off
            System.out.println("Calling " + number + " for " + duration + " minutes.");
            credit = credit - duration;
            System.out.println("Remaining credit: " + credit + " minutes.");
        }
        else {
            // Not enough credit so warn the user
            System.out.println("Not enough credit to make this call.");
        }
    }

    /**
     * Displays the details of the mobile phone.
     * The display method from Gadget is called first for the shared details,
     * and then the credit is printed after.
     */
    public void display()
    {
        // Call the display method of the parent class to print basic info
        super.display();

        // Print the credit with a label so the user knows what it means
        System.out.println("Credit: " + credit + " minutes");
    }
}

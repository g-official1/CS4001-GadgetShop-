/**
 * The MP3 class is a subclass of Gadget. It represents an MP3 player
 * and adds the amount of available memory that the player has.
 *
 * @author  Student
 * @version 1.0
 */
public class MP3 extends Gadget
{
    // The amount of memory available on the MP3 player, measured in MB
    private int availableMemory;

    /**
     * Constructor for the MP3 class.
     * The first four values are passed up to the Gadget constructor
     * and the fifth value is the starting available memory.
     */
    public MP3(String model, double price, int weight, String size, int availableMemory)
    {
        // Pass the first four values to the parent Gadget constructor
        super(model, price, weight, size);

        // Save the available memory for this player
        this.availableMemory = availableMemory;
    }

    /**
     * Accessor method that returns the available memory in MB.
     */
    public int getAvailableMemory()
    {
        return availableMemory;
    }

    /**
     * Downloads a piece of music, which uses up some of the free memory.
     * If there is enough free memory it is taken away from available memory.
     * Otherwise an error message is printed.
     */
    public void downloadMusic(int amount)
    {
        // Only download if there is enough space on the player
        if (amount <= availableMemory) {
            availableMemory = availableMemory - amount;
            System.out.println("Music downloaded (" + amount + "MB). Available memory: " + availableMemory + "MB");
        }
        else {
            // Not enough space so show a message to the user
            System.out.println("Not enough memory to download this music.");
        }
    }

    /**
     * Deletes a piece of music which frees up the memory that it took up.
     * The amount of memory that the track used is added back to available memory.
     */
    public void deleteMusic(int amount)
    {
        // Add the freed memory back to the amount available
        availableMemory = availableMemory + amount;
        System.out.println("Music deleted (" + amount + "MB freed). Available memory: " + availableMemory + "MB");
    }

    /**
     * Displays the details of the MP3 player.
     * Calls the display in the parent class first then prints memory after.
     */
    public void display()
    {
        // Print the attributes that belong to the Gadget class first
        super.display();

        // Print the available memory with a label
        System.out.println("Available memory: " + availableMemory + "MB");
    }
}

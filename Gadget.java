/**
 * The Gadget class is the superclass for the gadgets sold in the shop.
 * It holds the basic details that every gadget has.
 *
 * @author  Grady Mpila
 */
public class Gadget
{
    // The model name of the gadget, for example "Samsung S24"
    private String model;

    // The price of the gadget in pounds (decimal number)
    private double price;

    // The weight of the gadget in grams (whole number)
    private int weight;

    // The size of the gadget as text, for example "71mm x 137mm x 9mm"
    private String size;

    /**
     * Constructor for objects of class Gadget.
     * Takes in four parameters and saves them into the attributes above.
     */
    public Gadget(String model, double price, int weight, String size)
    {
        // Each parameter is assigned to its matching attribute
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * Accessor method that returns the model of the gadget.
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Accessor method that returns the price of the gadget.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Accessor method that returns the weight of the gadget.
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Accessor method that returns the size of the gadget.
     */
    public String getSize()
    {
        return size;
    }

    /**
     * Displays the details of the gadget to the terminal window.
     * Each line is labelled so the user can tell what each value is.
     */
    public void display()
    {
        // Print each attribute on its own line with a label in front
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}

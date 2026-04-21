import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The GadgetShop class is the GUI for the shop system.
 * It stores all of the gadgets in an ArrayList and lets the user add
 * mobile phones, MP3 players, make calls, download music, etc.
 *
 * This class has a main method so that it can be run from the command
 * prompt using "java GadgetShop".
 *
 * @author  Student
 * @version 1.0
 */
public class GadgetShop extends JFrame implements ActionListener
{
    // -----------------------------------------------------------------
    // Text fields used in the GUI (one for each value the user can enter)
    // -----------------------------------------------------------------
    private JTextField modelField;              // for the model name
    private JTextField priceField;              // for the price in pounds
    private JTextField weightField;             // for the weight in grams
    private JTextField sizeField;               // for the physical size
    private JTextField creditField;             // starting credit for Mobile
    private JTextField memoryField;             // starting memory for MP3
    private JTextField phoneNumberField;        // phone number for a call
    private JTextField durationField;           // duration of a call in minutes
    private JTextField downloadSizeField;       // size of the music to download
    private JTextField displayNumberField;      // position of gadget in list

    // -----------------------------------------------------------------
    // Buttons used in the GUI
    // -----------------------------------------------------------------
    private JButton addMobileButton;            // add a new Mobile phone
    private JButton addMP3Button;               // add a new MP3 player
    private JButton clearButton;                // clear every text field
    private JButton displayAllButton;           // list every gadget to terminal
    private JButton makeCallButton;             // make a call on a Mobile
    private JButton downloadMusicButton;        // download music on an MP3

    // -----------------------------------------------------------------
    // The ArrayList that holds every gadget that has been added so far
    // -----------------------------------------------------------------
    private ArrayList<Gadget> gadgets;

    /**
     * Constructor: builds the window, adds all of the components to it
     * and registers the action listeners for the buttons.
     */
    public GadgetShop()
    {
        // Give the window a title at the top of the frame
        super("Gadget Shop");

        // Create the empty ArrayList ready to store gadgets in
        gadgets = new ArrayList<Gadget>();

        // Set the size of the window (width x height) in pixels
        setSize(520, 520);

        // Make the program close properly when the X button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use a simple grid layout so labels and text fields line up neatly.
        // Using 0 rows means "as many as needed", with 2 columns.
        setLayout(new GridLayout(0, 2, 5, 5));

        // ----- Create the text fields and add them with labels -----
        modelField = new JTextField();
        add(new JLabel(" Model:"));
        add(modelField);

        priceField = new JTextField();
        add(new JLabel(" Price (£):"));
        add(priceField);

        weightField = new JTextField();
        add(new JLabel(" Weight (g):"));
        add(weightField);

        sizeField = new JTextField();
        add(new JLabel(" Size:"));
        add(sizeField);

        creditField = new JTextField();
        add(new JLabel(" Initial Credit (min):"));
        add(creditField);

        memoryField = new JTextField();
        add(new JLabel(" Initial Memory (MB):"));
        add(memoryField);

        phoneNumberField = new JTextField();
        add(new JLabel(" Phone Number:"));
        add(phoneNumberField);

        durationField = new JTextField();
        add(new JLabel(" Call Duration (min):"));
        add(durationField);

        downloadSizeField = new JTextField();
        add(new JLabel(" Download Size (MB):"));
        add(downloadSizeField);

        displayNumberField = new JTextField();
        add(new JLabel(" Display Number:"));
        add(displayNumberField);

        // ----- Create the buttons, add them, and set up listeners -----
        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");

        // Add the buttons to the frame in pairs so they line up in the grid
        add(addMobileButton);
        add(addMP3Button);
        add(clearButton);
        add(displayAllButton);
        add(makeCallButton);
        add(downloadMusicButton);

        // Register this class as the listener for every button
        // so the actionPerformed method below is called when one is clicked
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        // Make the window show up on the screen
        setVisible(true);
    }

    // =================================================================
    // TEXT FIELD INPUT METHODS
    // Each method reads the text from one of the text fields and
    // converts it to the correct data type before returning it.
    // =================================================================

    /**
     * Returns the model as a String straight from the text field.
     */
    public String getModel()
    {
        return modelField.getText();
    }

    /**
     * Returns the price as a double. The text is parsed using
     * Double.parseDouble so "19.99" becomes the number 19.99.
     */
    public double getPrice()
    {
        return Double.parseDouble(priceField.getText());
    }

    /**
     * Returns the weight as an int.
     */
    public int getWeight()
    {
        return Integer.parseInt(weightField.getText());
    }

    /**
     * Returns the size as a String.
     */
    public String getSize()
    {
        return sizeField.getText();
    }

    /**
     * Returns the starting credit as an int.
     */
    public int getCredit()
    {
        return Integer.parseInt(creditField.getText());
    }

    /**
     * Returns the starting memory as an int.
     */
    public int getMemory()
    {
        return Integer.parseInt(memoryField.getText());
    }

    /**
     * Returns the phone number as a String.
     */
    public String getPhoneNumber()
    {
        return phoneNumberField.getText();
    }

    /**
     * Returns the call duration as an int.
     */
    public int getDuration()
    {
        return Integer.parseInt(durationField.getText());
    }

    /**
     * Returns the download size as an int.
     */
    public int getDownloadSize()
    {
        return Integer.parseInt(downloadSizeField.getText());
    }

    /**
     * Returns the display number after checking that it is valid.
     * The method starts by setting the display number to -1, which
     * stands for "invalid". A try/catch is used to catch anything
     * that is not a whole number, and we also check that it is in range.
     *
     * If anything is wrong, an error dialog box is shown and -1 is
     * returned. Otherwise the real display number is returned.
     */
    public int getDisplayNumber()
    {
        // Start off with -1 which means "not a valid number"
        int displayNumber = -1;

        // If there are no gadgets in the list there is nothing to pick
        if (gadgets.size() == 0) {
            JOptionPane.showMessageDialog(this,
                "There are no gadgets in the list yet.",
                "Empty List",
                JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        try {
            // Try to turn the text in the field into a whole number
            displayNumber = Integer.parseInt(displayNumberField.getText());

            // Check that the number is an actual index in the list
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                // Out of range so reset to -1 and show an error dialog
                JOptionPane.showMessageDialog(this,
                    "The display number is not in range. Please enter a number between 0 and " + (gadgets.size() - 1) + ".",
                    "Out of Range",
                    JOptionPane.ERROR_MESSAGE);
                displayNumber = -1;
            }
        }
        catch (NumberFormatException e) {
            // The text was not a whole number at all
            JOptionPane.showMessageDialog(this,
                "The display number must be a whole number.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
            displayNumber = -1;
        }

        return displayNumber;
    }

    // =================================================================
    // BUTTON HANDLING
    // This method runs every time a button is pressed. It looks at which
    // button was clicked and runs the right piece of code for it.
    // =================================================================
    public void actionPerformed(ActionEvent event)
    {
        // Find the source of the click (which button it was)
        Object source = event.getSource();

        if (source == addMobileButton) {
            addMobile();
        }
        else if (source == addMP3Button) {
            addMP3();
        }
        else if (source == clearButton) {
            clearFields();
        }
        else if (source == displayAllButton) {
            displayAll();
        }
        else if (source == makeCallButton) {
            makeCall();
        }
        else if (source == downloadMusicButton) {
            downloadMusic();
        }
    }

    /**
     * Reads the model, price, weight, size and credit from the GUI,
     * builds a new Mobile object and adds it to the ArrayList.
     * Invalid number inputs are caught with try/catch.
     */
    private void addMobile()
    {
        try {
            // Get each value from its text field
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSize();
            int credit = getCredit();

            // Create a new Mobile object from the values
            Mobile m = new Mobile(model, price, weight, size, credit);

            // Add the new Mobile to the ArrayList of gadgets
            gadgets.add(m);

            // Show a message so the user knows it worked
            JOptionPane.showMessageDialog(this, "Mobile added successfully.");
        }
        catch (NumberFormatException e) {
            // One of the number fields had text that wasn't a number
            JOptionPane.showMessageDialog(this,
                "Please check the number fields (price, weight, credit).",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reads the model, price, weight, size and memory from the GUI,
     * builds a new MP3 object and adds it to the ArrayList.
     */
    private void addMP3()
    {
        try {
            // Get each value from its text field
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSize();
            int memory = getMemory();

            // Build a new MP3 object
            MP3 mp3 = new MP3(model, price, weight, size, memory);

            // Add it to the ArrayList
            gadgets.add(mp3);

            // Confirm to the user
            JOptionPane.showMessageDialog(this, "MP3 player added successfully.");
        }
        catch (NumberFormatException e) {
            // One of the number fields had text that wasn't a number
            JOptionPane.showMessageDialog(this,
                "Please check the number fields (price, weight, memory).",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears every text field in the GUI so the user can start again.
     */
    private void clearFields()
    {
        // Set the text in each field back to an empty string
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    /**
     * Prints the display number of every gadget to the terminal window
     * followed by the details of that gadget. Works by looping through
     * the ArrayList in order.
     */
    private void displayAll()
    {
        // If the list is empty let the user know
        if (gadgets.size() == 0) {
            System.out.println("There are no gadgets in the list.");
            return;
        }

        // Loop through every gadget in the ArrayList
        for (int i = 0; i < gadgets.size(); i++) {
            // Print the display number (same as the index)
            System.out.println("Display Number: " + i);

            // Call the display method on the gadget at this position
            gadgets.get(i).display();

            // Print a line to separate gadgets in the terminal output
            System.out.println("---------------------------");
        }
    }

    /**
     * Makes a phone call using the mobile at the entered display number.
     * First checks that the display number is valid, then checks that
     * the gadget at that index really is a Mobile, then gets the phone
     * number and duration and calls makeCall on it.
     */
    private void makeCall()
    {
        // Get the display number (returns -1 if invalid)
        int displayNumber = getDisplayNumber();

        // Only carry on if the display number was valid
        if (displayNumber != -1) {
            // Check that the gadget at this index is really a Mobile
            Gadget g = gadgets.get(displayNumber);

            if (g instanceof Mobile) {
                try {
                    // Cast the Gadget to a Mobile so we can call its methods
                    Mobile m = (Mobile) g;

                    // Read the phone number and the duration from the GUI
                    String number = getPhoneNumber();
                    int duration = getDuration();

                    // Ask the Mobile object to make the call
                    m.makeCall(number, duration);
                }
                catch (NumberFormatException e) {
                    // Duration wasn't a whole number
                    JOptionPane.showMessageDialog(this,
                        "Please enter a whole number for the duration.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                // The gadget at this index is not a Mobile
                JOptionPane.showMessageDialog(this,
                    "The gadget at this display number is not a Mobile phone.",
                    "Wrong Type",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Downloads a piece of music to the MP3 player at the chosen
     * display number. Works the same way as makeCall: check the
     * number, check the type, cast, call the method.
     */
    private void downloadMusic()
    {
        // Get the display number (returns -1 if invalid)
        int displayNumber = getDisplayNumber();

        // Only continue if the number was valid
        if (displayNumber != -1) {
            // Get the gadget at the chosen position in the list
            Gadget g = gadgets.get(displayNumber);

            if (g instanceof MP3) {
                try {
                    // Cast to MP3 so we can use its download method
                    MP3 mp3 = (MP3) g;

                    // Get the download size from the GUI
                    int size = getDownloadSize();

                    // Ask the MP3 to download the music
                    mp3.downloadMusic(size);
                }
                catch (NumberFormatException e) {
                    // The download size wasn't a whole number
                    JOptionPane.showMessageDialog(this,
                        "Please enter a whole number for the download size.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                // The gadget at this index is not an MP3 player
                JOptionPane.showMessageDialog(this,
                    "The gadget at this display number is not an MP3 player.",
                    "Wrong Type",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * The main method. This is the entry point used when the program
     * is run from the command prompt with "java GadgetShop".
     * It simply creates a new GadgetShop object which opens the GUI.
     */
    public static void main(String[] args)
    {
        // Create a new GadgetShop, which starts up the GUI
        new GadgetShop();
    }
}


/**
 * Write a description of class Horse here.
 * 
 * @author (Emma Smith) 
 * @version (20/04/2024)
 */
public class Horse
{
    //Fields of class Horse
    private String horseName;
    private char horseSymbol;
    private int distanceTravelled;
    private boolean fallen;
    private double horseConfidence;
    private String colour;
    private String mane;

    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, String colour, String mane)
    {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = 0.5;
        this.distanceTravelled = 0; 
        this.fallen = false;
        this.colour = colour;
        this.mane = mane;

    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.fallen = true;
    }
    
    public double getConfidence()
    {
        return horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return distanceTravelled;
    }
    
    public String getName()
    {
        return horseName;
    }
    
    public char getSymbol()
    {
        return horseSymbol; 
    }

    public String getColour() {
        return colour;
    }

    public String getMane() {
        return mane;
    }
    
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
    }
    
    public boolean hasFallen()
    {
        return fallen;
    }

    public void moveForward()
    {
        this.distanceTravelled++;   
    }

    public void setConfidence(double newConfidence)
    {
        this.horseConfidence = newConfidence;
    }
    
    public void setSymbol(char newSymbol)
    {
        this.horseSymbol = newSymbol;
    }
    
    public void setColour(String newColour)
    {
        this.colour = newColour;
    }
    
    public void setMane(String newMane)
    {
        this.mane = newMane;
    }
}

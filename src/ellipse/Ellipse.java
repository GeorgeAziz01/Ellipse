/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellipse;

import java.util.Random;

/**
 * Class of Ellipse, first OOP assignment 
 * @author George Aziz 
 */
public class Ellipse {

    private double majorAxis;
    private double minorAxis;
    
    public Ellipse() {
        int minRange = 5;
        int maxRange = 10;
        Random rand = new Random();
        double randomNum = rand.nextDouble();
        double result = minRange + (randomNum * (maxRange - minRange));
        double randomNum2 = rand.nextDouble();
        double result2 = minRange + (randomNum2 * (maxRange - minRange));
        this.majorAxis = result;
        this.minorAxis = result2; 
    }

    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }
    
    /**
     * Copy constructor
     * @param ellipse another ellipse
     */    
    public Ellipse(Ellipse ellipse) {
        this.majorAxis = ellipse.majorAxis;
        this.minorAxis = ellipse.minorAxis;
    }
    
    /**
     * Calculate the area of the ellipse
     * @return the value of the ellipse's area
     */
    public double calcArea() {
        return Math.PI * majorAxis * minorAxis;
    }
    
    /**
     * Calculate the perimeter of the ellipse
     * @return the value of the ellipse's perimeter
     */
    public double calcPerimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(majorAxis, 2) + 
                Math.pow(minorAxis, 2)) / 2);
    }
    
    /**
     * Checks if the ellipse is a circle or not 
     * @return a string that says if it's a circle or not 
     */
    public String isCircle() {
        if (majorAxis == minorAxis)
            return "This ellipse is a circle";
        else
            return "This ellipse is not a circle";
    }
    
    /**
     * Checks if the value of the major axis is valid or not
     * @param majorAxis the major axis
     * @return a boolean value whether the value of the major axis is valid or not
     */
    public boolean isMajorAxisValid(double majorAxis) {
        return !(majorAxis <= 0);
    }
    
    /**
     * Checks if the value of the minor axis is valid or not
     * @param minorAxis the minor axis
     * @return a boolean value whether the value of the major axis is valid or not
     */
    public boolean isMinorAxisValid(double minorAxis) {
        return !(minorAxis <= 0);
    }
    
    /**
     * Formats ellipse data to a string
     * @return formatted string containing ellipse data
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s: %.2f\n", "Major-Axis", majorAxis);
        str += String.format("%-20s: %.2f\n", "Minor-Axis", minorAxis);
        str += String.format("%-20s: %.2f\n", "Area", calcArea());
        str += String.format("%-20s: %.2f\n", "Perimeter", calcPerimeter());
        str += String.format("\n%s\n", isCircle());
        
        return str;
    }

    public boolean equals(Ellipse ellipse) {
        return this.majorAxis == ellipse.majorAxis && 
                this.minorAxis == ellipse.minorAxis;
    }

    public double getMajorAxis() {
        return majorAxis;
    }

    public void setMajorAxis(double majorAxis) {
        if (isMajorAxisValid(majorAxis)) 
            this.majorAxis = majorAxis;
        else
            System.out.println("The new value must be a positive value");
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(double minorAxis) {
        if (isMinorAxisValid(minorAxis)) 
            this.minorAxis = minorAxis;
        else
            System.out.println("The new value must be a positive value");
    }
}

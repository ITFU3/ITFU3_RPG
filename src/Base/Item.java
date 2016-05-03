/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

/**
 *
 * @author steffen
 */
public class Item {
    
    
    private Size size;
    private double weigth;
    
    public Item() {
        this.size = new Size();
        this.weigth = 1.0;
    }
    
    public Item(double weight, double length, double width) {
        this.size = new Size();
        this.size.length = length;
        this.size.width = width;
        this.weigth = weight;
                
                
    }

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * @return the weigth
     */
    public double getWeigth() {
        return weigth;
    }

    /**
     * @param weigth the weigth to set
     */
    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }
}



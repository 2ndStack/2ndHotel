/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package latief.hotel.enumeration;

/**
 * Enumeration untuk Jenis Kamar.
 * @author Latief
 */
public enum JenisKamar {
    SINGLE(400000), TWIN(800000), SUITE(1350000);
    
    private int cost;

    private JenisKamar(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
    
    public String getFormattefCost(){
        return "";
    } 
}

/*
 * created : Jun 18, 2011
 * by : Latief
 */
package latief.hotel.model;

import java.util.Calendar;

/**
 * Object untuk Tamu. Digunakan untuk menyimpan daftar Tamu.
 * @author Latief
 */
public class Tamu {
    
    private String noIdentitas;
    private String nama;
    private Calendar checkIn;
    private Calendar checkOut;
    private Kamar kamar;
    private int totalBiaya;

    /**
     * @return the noIdentitas
     */
    public String getNoIdentitas() {
        return noIdentitas;
    }

    /**
     * @param noIdentitas the noIdentitas to set
     */
    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the checkIn
     */
    public Calendar getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Calendar checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Calendar getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Calendar checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the kamar
     */
    public Kamar getKamar() {
        return kamar;
    }

    /**
     * @param kamar the kamar to set
     */
    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    /**
     * @return the totalBiaya
     */
    public int getTotalBiaya() {
        return totalBiaya;
    }

    /**
     * @param totalBiaya the totalBiaya to set
     */
    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tamu other = (Tamu) obj;
        if ((this.noIdentitas == null) ? (other.noIdentitas != null) : !this.noIdentitas.equals(other.noIdentitas)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if (this.checkIn != other.checkIn && (this.checkIn == null || !this.checkIn.equals(other.checkIn))) {
            return false;
        }
        if (this.checkOut != other.checkOut && (this.checkOut == null || !this.checkOut.equals(other.checkOut))) {
            return false;
        }
        if (this.kamar != other.kamar && (this.kamar == null || !this.kamar.equals(other.kamar))) {
            return false;
        }
        if (this.totalBiaya != other.totalBiaya) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.noIdentitas != null ? this.noIdentitas.hashCode() : 0);
        hash = 23 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 23 * hash + (this.checkIn != null ? this.checkIn.hashCode() : 0);
        hash = 23 * hash + (this.checkOut != null ? this.checkOut.hashCode() : 0);
        hash = 23 * hash + (this.kamar != null ? this.kamar.hashCode() : 0);
        hash = 23 * hash + this.totalBiaya;
        return hash;
    }

    @Override
    public String toString() {
        return "Tamu{" + "noIdentitas=" + noIdentitas + ", nama=" + nama + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", kamar=" + kamar + ", totalBiaya=" + totalBiaya + '}';
    }
}

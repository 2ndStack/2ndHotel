/*
 * created : Jun 18, 2011
 * by : Latief
 */
package latief.hotel.model;

import java.util.Calendar;
import latief.hotel.enumeration.JenisKamar;

/**
 * Object untuk Tagihan. Hanya digunakan untuk menampilkan daftar tagihan saja.
 * Tagihan merupakan hasil konversi Tamu dan Kamar untuk dilaporkan.
 * @author Latief
 */
public class Tagihan {
    private int noKamar;
    private JenisKamar jenisKamar;
    private String noIdentitas;
    private String nama;
    private Calendar checkIn;
    private Calendar checkOut;
    private int totalBiaya;

    public Calendar getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Calendar checkIn) {
        this.checkIn = checkIn;
    }

    public Calendar getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Calendar checkOut) {
        this.checkOut = checkOut;
    }

    public JenisKamar getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(JenisKamar jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public int getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(int noKamar) {
        this.noKamar = noKamar;
    }

    public int getTotalBiaya() {
        return totalBiaya;
    }

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
        final Tagihan other = (Tagihan) obj;
        if (this.noKamar != other.noKamar) {
            return false;
        }
        if (this.jenisKamar != other.jenisKamar) {
            return false;
        }
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
        if (this.totalBiaya != other.totalBiaya) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.noKamar;
        hash = 37 * hash + (this.jenisKamar != null ? this.jenisKamar.hashCode() : 0);
        hash = 37 * hash + (this.noIdentitas != null ? this.noIdentitas.hashCode() : 0);
        hash = 37 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 37 * hash + (this.checkIn != null ? this.checkIn.hashCode() : 0);
        hash = 37 * hash + (this.checkOut != null ? this.checkOut.hashCode() : 0);
        hash = 37 * hash + this.totalBiaya;
        return hash;
    }

    @Override
    public String toString() {
        return "Tagihan{" + "noKamar=" + noKamar + ", jenisKamar=" + jenisKamar + ", noIdentitas=" + noIdentitas + ", nama=" + nama + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", totalBiaya=" + totalBiaya + '}';
    }

}

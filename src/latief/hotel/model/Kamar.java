/*
 * created : Jun 18, 2011
 * by : Latief
 */
package latief.hotel.model;

import latief.hotel.enumeration.JenisKamar;
import latief.hotel.enumeration.StatusKamar;

/**
 * Object untuk Kamar.
 * @author Latief
 */
public class Kamar {
    
    private int no;
    private StatusKamar statusKamar;
    private JenisKamar jenisKamar;

    public Kamar() {
    }

    public Kamar(int no, StatusKamar statusKamar, JenisKamar jenisKamar) {
        this.no = no;
        this.statusKamar = statusKamar;
        this.jenisKamar = jenisKamar;
    }
    
    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    public StatusKamar getStatusKamar() {
        return statusKamar;
    }

    public void setStatusKamar(StatusKamar statusKamar) {
        this.statusKamar = statusKamar;
    }

    /**
     * @return the jenisKamar
     */
    public JenisKamar getJenisKamar() {
        return jenisKamar;
    }

    /**
     * @param jenisKamar the jenisKamar to set
     */
    public void setJenisKamar(JenisKamar jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kamar other = (Kamar) obj;
        if (this.no != other.no) {
            return false;
        }
        if (this.statusKamar != other.statusKamar) {
            return false;
        }
        if (this.jenisKamar != other.jenisKamar) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.no;
        hash = 79 * hash + (this.statusKamar != null ? this.statusKamar.hashCode() : 0);
        hash = 79 * hash + (this.jenisKamar != null ? this.jenisKamar.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return no + "";
    }
    
}

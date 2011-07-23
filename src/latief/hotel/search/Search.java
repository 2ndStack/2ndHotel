/*
 * created : Jul 22, 2011
 * by : Latief
 */
package latief.hotel.search;

import java.util.ArrayList;
import java.util.List;
import latief.hotel.model.Tamu;

/**
 *
 * @author Latief
 */
public final class Search {
    
    /**
     * Pencarian nama tamu daru daftar tamu dengan methode sequence
     * @param tamus
     * @param nama
     * @return Tamu yang dicari. null jika tidak ditemukan.
     */
    public static Tamu sequence(List<Tamu> tamus, String nama){
        for(int i=0;i<tamus.size();i++){
            if(tamus.get(i).getNama().equals(nama))
                return tamus.get(i);
        }
        return null;
    }
    
    /**
     * Pencarian nama Tamu dari daftar tamu dengan methode rekursif binary
     * @param tamus
     * @param nama
     * @return 
     */
    public static Tamu binaryRecursion(List<Tamu> tamus, String nama){
        
        if(tamus == null || tamus.isEmpty()){
            return null;
        }
        
        //Jika daftar tamus hanya ada satu, langsung bandingkan saja.
        if(tamus.size() == 1){
            if(tamus.get(0).getNama().equals(nama))
                return tamus.get(0);
            return null;
        }
        
        int left = 0;
        int right = tamus.size();
        int center = tamus.size()/2;
        
        //bandingkan dengan tamu di index tengah
        int compare = compare(tamus.get(center), nama);
        
        //jika hasil perbandingan nol, maka cocok.
        if(compare == 0)
            return tamus.get(center);
        
        /**
         * jika hasil perbandingan 1 atau lebih besar dari nilai di tengah
         * berarti pencarian selanjutnya disebelah kanan.
         */
        if(compare == 1){
            left = center+1;
        }
        
        /**
         * jika hasil perbandingan -1 atau lebih kecil dari nilai di tengah
         * berarti pencarian selanjutnya disebelah kiri.
         */
        if(compare == -1){
            right = center;
        }
        
        //rekursif kan kembali subList daftar tamu yg hendak dicari
        return binaryRecursion(tamus.subList(left, right), nama);
    }
    
    /**
     * Pencarian nama tamu daru daftar tamu dengan methode sequence
     * @param tamus
     * @param nama
     * @return Tamu yang dicari. null jika tidak ditemukan.
     */
    public static Tamu binaryIteration(List<Tamu> tamus, String nama){
        if (tamus.isEmpty()) {
            return null;
        }

        Tamu tamu = null;

        //jika data hanya satu
        if (tamus.size() == 1) {
            //jika data satu itu ternyata sama, returnkan
            if (tamus.get(0).getNama().equals(nama)) {
                tamu = tamus.get(0);
            }
            return tamu;
        }

        int pointer = tamus.size() / 2;
        int left = -1;
        int right = tamus.size();
        int compare;
        Tamu tempTamu;

        //cari data tamunya
        while (true) {
            tempTamu = tamus.get(pointer);
            compare = compare(tempTamu, nama);

            //jika sama ambil, hentikan loop;
            if (compare == 0) {
                if (tempTamu.getNama().equals(nama)) {
                    tamu = tempTamu;
                }
                break;
            }

            //ada sebelah kiri, pindah pointer ke tengah kiri
            if (compare < 0) {
                //jika sudah tidak ada child lg, break
                if (pointer - left == 1) {
                    break;
                }
                right = pointer;
                pointer = ((right - left) / 2) + left;
            }

            //ada sebelah kanan. pindah pointer ke tengah kanan
            if (compare > 0) {
                //jika sudah tidak ada child lg, break
                if (right - pointer == 1) {
                    break;
                }
                left = pointer;
                pointer = ((right - left) / 2) + left;
            }
        }

        return tamu;
    }
    
    /**
     * pencarian tamu secara binary
     * @param nama
     * @return 
     */
    public static List<Tamu> insertBinaryIteration(List<Tamu> tamus, Tamu tamu) {
        if (tamu == null) {
            return tamus;
        }

        if(tamus == null){
            tamus = new ArrayList<Tamu>();
        }
        
        if (tamus.isEmpty()) {
            tamus.add(tamu);
            return tamus;
        }

        int pointer = tamus.size() / 2;
        int left = -1;
        int right = tamus.size();
        int compare;
        String nama = tamu.getNama();

        //cari data tamunya
        while (true) {
            compare = Search.compare(tamus.get(pointer), nama);

            //jika ada data sama, insert saja diindex tersebut, data akan bergeser ke kanan, hentikan loop;
            if (compare == 0) {
                tamus.add(pointer, tamu);
                break;
            }

            //ada sebelah kiri, pindah pointer ke tengah kiri
            if (compare < 0) {
                //jika data hanya 1 atau pointer-left=1 masukkan data baru di index pointer, break.
                if (tamus.size() == 1 || pointer - left == 1) {
                    tamus.add(pointer, tamu);
                    break;
                }
                right = pointer;
                pointer = ((right - left) / 2) + left;
            }

            //ada sebelah kanan. pindah pointer ke tengah kanan
            if (compare > 0) {
                //jika data hanya satu tambahkan tamu di akhir lgsg.
                if (tamus.size() == 1) {
                    tamus.add(tamu);
                    break;
                }
                //jika selisih right dan pointer adalah 1
                if (right - pointer == 1) {
                    //jika right sama dengan ukuran data, tambahkan tamu baru diakhir
                    if (right == tamus.size()) {
                        tamus.add(tamu);
                    } //jika tidak tambahkan diindex right
                    else {
                        tamus.add(right, tamu);
                    }
                    break;
                }
                left = pointer;
                pointer = ((right - left) / 2) + left;
            }
        }
        
        return tamus;
    }
    
    /**
     * Bandingkan nama dari Tamu dengan nama.
     * 
     * @param tamu
     * @param nama
     * @return 0 jika hasilnya sama, -1 jika nama kurang dari tamu. 1 jika
     * tamu lebih besar dari nama.
     */
    public static int compare(Tamu tamu, String nama) {
        int compare = tamu.getNama().compareTo(nama);

        if (compare > 0) {
            return -1;
        }
        if (compare < 0) {
            return 1;
        }

        return 0;
    }
}

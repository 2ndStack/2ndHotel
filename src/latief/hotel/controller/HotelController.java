/*
 * created : Jun 19, 2011
 * by : Latief
 */
package latief.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import latief.hotel.enumeration.JenisKamar;
import latief.hotel.enumeration.StatusKamar;
import latief.hotel.model.Kamar;
import latief.hotel.model.Tagihan;
import latief.hotel.model.Tamu;
import latief.hotel.search.Search;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Class untuk operasi logic dan perhitungan dari program hotel.
 * @author Latief
 */
public class HotelController {

    /**
     * Daftar kamar.
     */
    private Kamar[] kamars;
    /**
     * Daftar Tamu
     */
    private List<Tamu> tamus;
    /**
     * File yang akan disimpan
     */
    private File fileSave;

    public HotelController() {
        fileSave = new File("tamu.json");
        initDaftarKamar();
        tamus = new ArrayList<Tamu>();
        loadData();
    }

    /**
     * init Daftar Kamar
     */
    private void initDaftarKamar() {
        kamars = new Kamar[20];
        Kamar kamar101 = new Kamar(101, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[0] = kamar101;
        Kamar kamar102 = new Kamar(102, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[1] = kamar102;
        Kamar kamar103 = new Kamar(103, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[2] = kamar103;
        Kamar kamar104 = new Kamar(104, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[3] = kamar104;
        Kamar kamar105 = new Kamar(105, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[4] = kamar105;

        Kamar kamar201 = new Kamar(201, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[5] = kamar201;
        Kamar kamar202 = new Kamar(202, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[6] = kamar202;
        Kamar kamar203 = new Kamar(203, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[7] = kamar203;
        Kamar kamar204 = new Kamar(204, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[8] = kamar204;
        Kamar kamar205 = new Kamar(205, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[9] = kamar205;

        Kamar kamar301 = new Kamar(301, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[10] = kamar301;
        Kamar kamar302 = new Kamar(302, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[11] = kamar302;
        Kamar kamar303 = new Kamar(303, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[12] = kamar303;
        Kamar kamar304 = new Kamar(304, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[13] = kamar304;
        Kamar kamar305 = new Kamar(305, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[14] = kamar305;
        Kamar kamar306 = new Kamar(306, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[15] = kamar306;
        Kamar kamar307 = new Kamar(307, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[16] = kamar307;
        Kamar kamar308 = new Kamar(308, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[17] = kamar308;
        Kamar kamar309 = new Kamar(309, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[18] = kamar309;
        Kamar kamar310 = new Kamar(310, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[19] = kamar310;


    }

    /**
     * Ambil data tersimpan dari file.
     */
    private void loadData() {
        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonParser jsonParser = jsonFactory.createJsonParser(fileSave);
            jsonParser.nextToken();
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                Tamu tamu = new Tamu();
                while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    String fieldTamu = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (fieldTamu.equals("kamar")) {
                        Kamar kamar = new Kamar();
                        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                            String fieldKamar = jsonParser.getCurrentName();
                            jsonParser.nextToken();
                            if (fieldKamar.equals("no")) {
                                kamar.setNo(jsonParser.getIntValue());
                            } else if (fieldKamar.equals("statusKamar")) {
                                String statusKamar = jsonParser.getText();
                                if (statusKamar.equals("KOSONG")) {
                                    kamar.setStatusKamar(StatusKamar.KOSONG);
                                } else if (statusKamar.equals("ISI")) {
                                    kamar.setStatusKamar(StatusKamar.ISI);
                                }
                            } else if (fieldKamar.equals("jenisKamar")) {
                                String jenisKamar = jsonParser.getText();
                                if (jenisKamar.equals("SINGLE")) {
                                    kamar.setJenisKamar(JenisKamar.SINGLE);
                                } else if (jenisKamar.equals("SUITE")) {
                                    kamar.setJenisKamar(JenisKamar.SUITE);
                                } else if (jenisKamar.equals("TWIN")) {
                                    kamar.setJenisKamar(JenisKamar.TWIN);
                                }
                            }
                        }
                        tamu.setKamar(kamar);
                    } else if (fieldTamu.equals("noIdentitas")) {
                        tamu.setNoIdentitas(jsonParser.getText());
                    } else if (fieldTamu.equals("nama")) {
                        tamu.setNama(jsonParser.getText());
                    } else if (fieldTamu.equals("checkIn")) {
                        Calendar calendar = new GregorianCalendar();
                        calendar.setTimeInMillis(jsonParser.getLongValue());
                        tamu.setCheckIn(calendar);
                    } else if (fieldTamu.equals("checkOut")) {
                        Calendar calendar = new GregorianCalendar();
                        calendar.setTimeInMillis(jsonParser.getLongValue());
                        tamu.setCheckOut(calendar);
                    } else if (fieldTamu.equals("totalBiaya")) {
                        tamu.setTotalBiaya(jsonParser.getIntValue());
                    }
                }
                //tambahkan tamu
                insert(tamu);
                //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.ISI
                updateStatusKamar(tamu.getKamar().getNo(), StatusKamar.ISI);
            }
        } catch (IOException ex) {
            Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Tambah Tamu.
     * @param tamu 
     */
    public void addTamu(Tamu tamu) {
        if (tamu == null) {
            return;
        }

        //Tambah Daftar Tamu
        insert(tamu);

        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.ISI
        updateStatusKamar(tamu.getKamar().getNo(), StatusKamar.ISI);

        //Simpan daftar tamu
        saveTamus(tamus);
    }

    /**
     * Hapus Tamu dari daftar.
     * @param tamu 
     */
    public void removeTamu(Tamu tamu) {
        if (tamu == null) {
            return;
        }

        //Hapus daftar Tamu
        tamus.remove(tamu);

        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.KOSONG
        updateStatusKamar(tamu.getKamar().getNo(), StatusKamar.KOSONG);

        saveTamus(tamus);
    }

    /**
     * Hapus Tamu dari daftar berdasarkan Kamar.
     * @param kamar 
     */
    public void removeTamu(Kamar kamar) {
        if (kamar == null) {
            return;
        }
        //Hapus tamu
        removeTamu(findTamu(kamar));
    }

    /**
     * update StatusKamar dari daftar Kamar. 
     * Yaitu StatusKamar.ISI menjadi StatusKamar.KOSONG atau sebaliknya.
     * @param noKamar
     * @param newStatusKamar 
     */
    public void updateStatusKamar(int noKamar, StatusKamar newStatusKamar) {
        if (newStatusKamar == null) {
            return;
        }

        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.ISI
        Kamar kamar = findKamar(noKamar);
        if (kamar != null) {
            kamar.setStatusKamar(newStatusKamar);
        }
    }

    /**
     * Dapatkan daftar Kamar
     * @return 
     */
    public Kamar[] getKamars() {
        return kamars;
    }

    /**
     * Dapatkan daftar Kamar
     * @return 
     */
    public List<Kamar> getListKamars() {
        List<Kamar> listKamars = new ArrayList<Kamar>();
        listKamars.addAll(Arrays.asList(kamars));
        return listKamars;
    }

    /**
     * Dapatkan daftar tamu
     * @return 
     */
    public List<Tamu> getTamus() {
        return tamus;
    }

    /**
     * Dapatkan Daftar Tagihan dari melakukan konversi Daftar Tamu.
     * @return 
     */
    public List<Tagihan> getTagihans() {
        List<Tagihan> tagihans = new ArrayList<Tagihan>();
        for (Tamu tamu : tamus) {
            Tagihan tagihan = new Tagihan();
            tagihan.setNoKamar(tamu.getKamar().getNo());
            tagihan.setJenisKamar(tamu.getKamar().getJenisKamar());
            tagihan.setNoIdentitas(tamu.getNoIdentitas());
            tagihan.setNama(tamu.getNama());
            tagihan.setCheckIn(tamu.getCheckIn());
            tagihan.setCheckOut(tamu.getCheckOut());
            tagihan.setTotalBiaya(tamu.getTotalBiaya());
            tagihans.add(tagihan);
        }

        return tagihans;
    }

    /**
     * Cari Kamar berdasarkan noKamar
     * @param noKamar
     * @return 
     */
    public Kamar findKamar(int noKamar) {
        for (int i = 0; i < kamars.length; i++) {
            if (kamars[i].getNo() == noKamar) {
                return kamars[i];
            }
        }
        return null;
    }

    /**
     * Dapatkan daftar Kamar yang berstatus KOSONG
     * @return 
     */
    public List<Kamar> findEmptyKamars() {
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for (int i = 0; i < kamars.length; i++) {
            if (kamars[i].getStatusKamar().equals(StatusKamar.KOSONG)) {
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }

    /**
     * Dapatkan daftar Kamar yang berstatus ISI
     * @return 
     */
    public List<Kamar> findFullKamars() {
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for (int i = 0; i < kamars.length; i++) {
            if (kamars[i].getStatusKamar().equals(StatusKamar.ISI)) {
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }

    /**
     * Cari kamar berdasarkan StatusKamarnya
     * @return 
     */
    public List<Kamar> findKamars(StatusKamar statusKamar) {
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for (int i = 0; i < kamars.length; i++) {
            if (kamars[i].getStatusKamar().equals(statusKamar)) {
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }

    /**
     * Cari Tamu berdsarkan Kamar nya
     * @param kamar
     * @return 
     */
    public Tamu findTamu(Kamar kamar) {
        if (kamar == null) {
            return null;
        }

        for (Tamu tamu : tamus) {
            if (tamu.getKamar().getNo() == kamar.getNo()) {
                return tamu;
            }
        }
        return null;
    }

    /**
     * Hitung Total biaya sewa kamar.
     * @param kamar
     * @param in
     * @param out
     * @return 
     */
    public int calculateCost(Kamar kamar, Calendar in, Calendar out) {
        //Hitung berapa hari menginap
        int day = (int) (out.getTimeInMillis() - in.getTimeInMillis()) / 86400000;
        day += 1;
        //Kalikan dengan harga kamar perhari nya.
        return kamar.getJenisKamar().getCost() * day;
    }

    /**
     * Simpan data tamu ke dalam file.
     * @param tamus 
     */
    public void saveTamus(List<Tamu> tamus) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(fileSave, tamus);
        } catch (IOException ex) {
            Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * pencarian tamu secara binary
     * @param nama
     * @return 
     */
    public void insert(Tamu tamu) {
        tamus = Search.insertBinaryIteration(tamus, tamu);
    }

    /**
     * pencarian tamu secara binary
     * @param nama
     * @return 
     */
    public Tamu search(String nama, int searchMethod) {
        if (tamus.isEmpty()) {
            return null;
        }

        if(searchMethod == 0)
            return Search.sequence(tamus, nama);
        if(searchMethod == 1)
            return Search.binaryIteration(tamus, nama);
        if(searchMethod == 2)
            return Search.binaryRecursion(tamus, nama);
        
        return Search.sequence(tamus, nama);
    }
}

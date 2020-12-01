package core.domain;

public class Urun extends BaseDomain{
    private int id;
    private int id_kategori;
    private String ad;
    private String aciklama;

    public Urun(int id, int id_kategori, String ad, String aciklama) {
        this.id = id;
        this.id_kategori = id_kategori;
        this.ad = ad;
        this.aciklama = aciklama;
    }
    public Urun(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", id_kategori=" + id_kategori +
                ", ad='" + ad + '\'' +
                ", aciklama='" + aciklama + '\'' +
                '}';
    }
}

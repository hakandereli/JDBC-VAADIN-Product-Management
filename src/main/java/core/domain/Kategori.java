package core.domain;

public class Kategori extends BaseDomain{
    private int id;
    private String ad;

    public Kategori(int id, String ad) {
        this.id=id;
        this.ad=ad;
    }

    public Kategori() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return ad;
    }
}

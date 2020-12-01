package core.domain;

public class Menu extends BaseDomain {
    private int id;
    private String ad;
    private String classdirectory;

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

    public String getClassdirectory() {
        return classdirectory;
    }

    public void setClassdirectory(String classdirectory) {
        this.classdirectory = classdirectory;
    }
}

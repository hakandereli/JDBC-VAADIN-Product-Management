package ui.views;

import com.vaadin.ui.*;
import core.domain.Kategori;
import core.domain.Urun;
import core.service.KategoriService;
import ui.field.KategoriComboField;

public class UrunDisplayPage extends VerticalLayout {
    TextField idTextField;
    TextField id_kategori;
    TextField urunAdi;
    TextArea urunAciklamasi;
    Urun urun;
    Window myDisplayWindow;
    KategoriComboField kategoriComboField;

    public UrunDisplayPage(Urun urun) {
        this.urun=urun;
        buildMainlayout();
    }

    private void buildMainlayout() {
        setWidth("95%");

        getirIdTextField();
        getirIdKategori();
        getirKategoriAdi();
        getirUrunAdi();
        getirUrunAciklamasi();
    }

    private void getirIdTextField() {

        idTextField=new TextField();
        idTextField.setWidth("95%");
        idTextField.setValue(String.valueOf(urun.getId()));
        idTextField.setEnabled(false);
        addComponent(new Label("Ürün ID"));
        addComponent(idTextField);
    }

    private void getirIdKategori() {
        id_kategori=new TextField();
        id_kategori.setWidth("95%");
        id_kategori.setValue(String.valueOf(urun.getId_kategori()));
        id_kategori.setEnabled(false);
        addComponent(new Label("Ürün Kategori ID"));
        addComponent(id_kategori);
    }

    private void getirKategoriAdi() {
        TextField kategoriAdi=new TextField();
        kategoriAdi.setWidth("95%");
        addComponent(new Label("Ürün Kategorisi"));
        addComponent(kategoriAdi);
        kategoriAdi.setEnabled(false);

        //Kategori kategori = (Kategori) kategoriComboField.getValue();
        Kategori kategori = null;
        if (urun.getId_kategori() > 0) {
            KategoriService kategoriService = new KategoriService();
            try {
                kategori= kategoriService.findById(urun.getId_kategori());
            }catch (Exception exception) {
                Notification.show(exception.getMessage());
            }
            kategoriAdi.setValue(kategori.getAd());
        }
    }

    private void getirUrunAdi() {
        urunAdi=new TextField();
        urunAdi.setWidth("95%");
        urunAdi.setValue(urun.getAd());
        urunAdi.setEnabled(false);
        addComponent(new Label("Ürün Adı"));
        addComponent(urunAdi);
    }

    private void getirUrunAciklamasi() {
        urunAciklamasi=new TextArea();
        urunAciklamasi.setWidth("95%");
        urunAciklamasi.setValue(urun.getAciklama());
        urunAciklamasi.setEnabled(false);
        addComponent(new Label("Ürün Açıklaması"));
        addComponent(urunAciklamasi);
    }

    public void setMyDisplayWindow(Window myDisplayWindow) {
        this.myDisplayWindow = myDisplayWindow;
    }

    public Window getMyDisplayWindow() {
        return myDisplayWindow;
    }

}

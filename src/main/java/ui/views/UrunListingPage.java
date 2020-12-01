package ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanUtil;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import core.domain.Urun;
import core.service.UrunService;

import java.util.List;

public class UrunListingPage extends VerticalLayout {
    Table table;
    IndexedContainer indexedContainer;

    public UrunListingPage() {
        buildTableIndexedContainer();
        buildTable();
        fillTable();
        addComponent(new Label("<h3>Ürün Tablosu</h3>", ContentMode.HTML));
        addComponent(table);
    }
    private void buildTableIndexedContainer() {

        indexedContainer = new IndexedContainer();

        indexedContainer.addContainerProperty("guncelle",Button.class,null);
        indexedContainer.addContainerProperty("sil",Button.class,null);
        indexedContainer.addContainerProperty("izle",Button.class,null);

        indexedContainer.addContainerProperty("id", Integer.class, null);
        indexedContainer.addContainerProperty("id_kategori", Integer.class, null);
        indexedContainer.addContainerProperty("ad", String.class, null);
        indexedContainer.addContainerProperty("aciklama", String.class, null);

    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);

        table.setWidth("100%");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        //Tablo Başlıkları
        table.setColumnHeaders("","","","ID", "ID Kategori", "Ad", "Açıklama");

        table.setColumnCollapsingAllowed(true);
        table.setColumnCollapsed("id", true);
        table.setColumnCollapsed("id_kategori", true);
        table.setColumnCollapsed("aciklama", true);

        table.setColumnWidth("guncelle",70);
        table.setColumnAlignment("guncelle", Table.Align.LEFT);
        table.setColumnWidth("sil",70);
        table.setColumnAlignment("sil", Table.Align.LEFT);
        table.setColumnWidth("izle",70);
        table.setColumnAlignment("izle", Table.Align.LEFT);
        //urun = (Urun) itemClickEvent.getItemId();
    }

    private void fillTable() {
        indexedContainer.removeAllItems();
        UrunService urunService = new UrunService();
        List<Urun> urunList = urunService.findAll();

        for (Urun urun : urunList) {
            Item item = indexedContainer.addItem(urun);

            //Ürün Güncelleme
            Button editButton=new Button();
            urunGuncelle(urun,editButton);

            //Ürün Silme
            Button trashButton=new Button();
            urunSil(urun,trashButton);

            //Ürün Detay Göster
            Button infoButton=new Button();
            urunDetayGoster(urun,infoButton);

            //Kolonları Doldurma
            fillColumns(urun,item,editButton,trashButton,infoButton);
        }

    }

    private void fillColumns(Urun urun, Item item, Button editButton, Button trashButton, Button infoButton) {
        item.getItemProperty("guncelle").setValue(editButton);
        item.getItemProperty("sil").setValue(trashButton);
        item.getItemProperty("izle").setValue(infoButton);

        item.getItemProperty("id").setValue(urun.getId());
        item.getItemProperty("id_kategori").setValue(urun.getId_kategori());
        item.getItemProperty("ad").setValue(urun.getAd());
        item.getItemProperty("aciklama").setValue(urun.getAciklama());
    }

    private void urunGuncelle(Urun urun,Button editButton) {
        editButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        editButton.setIcon(FontAwesome.EDIT);
        editButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Window urunUpdateWindow = new Window("Ürün Güncelleme");

                UrunAddUpdatePage urunAddUpdatePage = new UrunAddUpdatePage(urun);
                urunAddUpdatePage.setMyUpdateWindow(urunUpdateWindow);
                urunAddUpdatePage.setMargin(true);

                urunUpdateWindow.setContent(urunAddUpdatePage);
                urunUpdateWindow.center();
                urunUpdateWindow.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent closeEvent) {
                        fillTable();
                    }
                });
                UI.getCurrent().addWindow(urunUpdateWindow);
            }
        });
    }

    private void urunSil(Urun urun,Button trashButton) {

        trashButton.setIcon(FontAwesome.TRASH);
        trashButton.addStyleName(ValoTheme.BUTTON_DANGER);
        trashButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Window urunDeleteWindow = new Window("Ürün Silme");
                urunDeleteWindow.setWidth("25%");
                urunDeleteWindow.setHeight("200px");

                UrunDeletePage urunDeletePage=new UrunDeletePage(urun);
                urunDeletePage.setMyDeleteWindow(urunDeleteWindow);
                urunDeletePage.setMargin(true);

                urunDeleteWindow.setContent(urunDeletePage);
                urunDeleteWindow.center();
                urunDeleteWindow.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent closeEvent) {
                        fillTable();
                    }
                });
                UI.getCurrent().addWindow(urunDeleteWindow);
            }
        });
    }

    private void urunDetayGoster(Urun urun,Button infoButton) {
        infoButton.setIcon(FontAwesome.INFO);
        infoButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Window urunDisplayWindow = new Window("Ürün Görüntüleme");
                urunDisplayWindow.setWidth("25%");

                UrunDisplayPage urunDisplayPage = new UrunDisplayPage(urun);
                urunDisplayPage.setMyDisplayWindow(urunDisplayWindow);
                urunDisplayPage.setMargin(true);

                urunDisplayWindow.setContent(urunDisplayPage);
                urunDisplayWindow.center();
                UI.getCurrent().addWindow(urunDisplayWindow);
            }
        });
    }

    //List item click olayı
        /*
        urunListField.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                Urun urun=(Urun) itemClickEvent.getItemId();
                deleteButton.setEnabled(true);

                deleteButton.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        Notification.show(urun.getAd());
                    }
                });
            }
        });
        addComponent(deleteButton);
         */
}

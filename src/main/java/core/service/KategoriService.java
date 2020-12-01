package core.service;

import core.data.KategoriDao;
import core.domain.Kategori;

import java.util.List;

public class KategoriService {
    KategoriDao kategoriDao=new KategoriDao();

    public void addKategori(Kategori kategori){
        kategoriDao.addKategori(kategori);
    }

    public List<Kategori> findAll(){
        return kategoriDao.listingKategori();
    }

    public Kategori findById(int kategoriId){
        return kategoriDao.findById(kategoriId);
    }

    public void deleteKategori(Kategori kategori1){
        kategoriDao.deleteKategori(kategori1);
    }

}

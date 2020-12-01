package core.data;

import core.domain.Kategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategoriDao {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addKategori(Kategori kategori){
        try {
            String kategoriAd=kategori.getAd();
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO universalyazilim.kategori (ad) VALUES (?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, kategoriAd);
            ps.executeUpdate();

        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }
    }

    public List<Kategori> listingKategori(){
        List<Kategori> kategoriList=new ArrayList<Kategori>();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM universalyazilim.kategori ORDER BY id ASC;";
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                kategoriList.add(new Kategori(
                        rs.getInt("id"),
                        rs.getString("ad")
                ));
            }
        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }
        return kategoriList;
    }

    public void deleteKategori(Kategori kategori1) {
        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement("DELETE FROM universalyazilim.kategori WHERE (id=?);");
            String deleteKategoriItemId=String.valueOf(kategori1.getId());
            ps.setString(1, deleteKategoriItemId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException | NullPointerException hata) {
            throw new RuntimeException(hata);
        }
    }

    public Kategori findById(int kategoriId) {
        Kategori kategori=new Kategori();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM universalyazilim.kategori WHERE id="+kategoriId+";";
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                kategori.setId(rs.getInt("id"));
                kategori.setAd(rs.getString("ad"));
            }
        }catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }
        return kategori;
    }
}

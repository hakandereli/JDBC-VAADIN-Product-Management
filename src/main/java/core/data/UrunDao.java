package core.data;

import core.domain.Urun;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrunDao {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void deleteUrun(Urun urun) {
        try {
            connection =DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "DELETE FROM universalyazilim.urun WHERE id = "+urun.getId()+";";
            stmt.executeUpdate(sql);
        }catch (SQLException | ClassNotFoundException | NullPointerException hata) {
            throw new RuntimeException(hata);
        }
    }

    public void addOrUpdate(Urun urun){
        try {
            connection = DatabaseConnection.getConnection();
            //ID si varsa güncelleme işlemidir. Güncelleme yapılacak
            if (urun.getId() > 0) {
                String sql =
                "UPDATE `universalyazilim`.`urun` SET "+
                    "`id_kategori` = '"+urun.getId_kategori()+"' , "+
                    "`ad` = '"+urun.getAd()+"' , "+
                    "`aciklama` = '"+urun.getAciklama()+"'"+
                    " WHERE (`id` = '"+urun.getId()+"');";
                    Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
            }

            //ID si yoksa ekleme işlemidir ekleme yapacak.
            else {

                String sql = "INSERT INTO universalyazilim.urun (id_kategori,ad,aciklama) VALUES (?,?,?);";
                ps = connection.prepareStatement(sql);
                String kategoriId = String.valueOf(urun.getId_kategori());
                ps.setString(1, kategoriId);
                ps.setString(2, urun.getAd());
                ps.setString(3, urun.getAciklama());
                ps.executeUpdate();
            }
        }catch (Exception hata) {
            throw new RuntimeException(hata);
        }
    }

    public List<Urun> urunListing(){

        List<Urun> urunList = new ArrayList<Urun>();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM universalyazilim.urun ORDER BY id ASC;";
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                urunList.add(new Urun(
                        rs.getInt("id"),
                        rs.getInt("id_Kategori"),
                        rs.getString("ad"),
                        rs.getString("aciklama")
                ));
            }
        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }
        return urunList;
    }
}
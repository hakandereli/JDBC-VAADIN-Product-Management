package core.data;

import core.domain.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Menu> menuList = new ArrayList<Menu>();

    public List<Menu> menuGetir() throws SQLException, ClassNotFoundException {
        //Menüyü listele listelenen menüyü geri dön
        connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM universalyazilim.menu;";

        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Menu childMenu = new Menu();
            childMenu.setId(resultSet.getInt("id"));
            childMenu.setAd(resultSet.getString("ad"));
            childMenu.setClassdirectory(resultSet.getString("classdirectory"));
            menuList.add(childMenu);
        }
        return menuList;
    }
}

package core.service;

import core.data.MenuDao;
import core.domain.Menu;
import java.sql.SQLException;
import java.util.List;

public class MenuService {
    MenuDao menuDao;

    public MenuService() {
        this.menuDao = new MenuDao();
    }

    public List<Menu> menuGetir() throws SQLException, ClassNotFoundException {
        return menuDao.menuGetir();
    }
}

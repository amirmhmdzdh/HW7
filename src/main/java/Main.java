import menu.Menu;

import java.sql.SQLException;

import static menu.Menu.brandMenu;
import static menu.Menu.categoryMenu;

public class Main {
    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        menu.publicMenu();
        brandMenu();
        categoryMenu();
    }

}

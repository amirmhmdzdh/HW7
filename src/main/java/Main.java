import menu.Menu;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        menu.publicMenu();
        menu.brandMenu();
        menu.categoryMenu();
        menu.productMenu();
        menu.shareholderMenu();
    }

}

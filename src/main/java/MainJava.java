import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Владелец on 03.04.2017.
 */
public class MainJava {
    public static void main(String[] args) throws IOException, SQLException {
        Menu men = new Menu();

        men.ShowCommands();

    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        UtenteRepo utenteRepo = new UtenteRepo();
        Utente u = utenteRepo.getUtente(1);
        System.out.println(u);
        Utente u2 = utenteRepo.getUtenteByEmail("pippo@gmail.com");
        System.out.println(u2);
    }

}

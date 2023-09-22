import java.sql.*;

public class UtenteRepo {

    // questo metodo ritorna l'utente con id id.
    public Utente getUtente(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM utente WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String nome = resultSet.getString("nome");
        String cognome = resultSet.getString("cognome");
        String indirizzo = resultSet.getString("indirizzo");
        String email = resultSet.getString("email");
        String telefono = resultSet.getString("telefono");
        Utente u;
        if (telefono == null) {
            u = new Utente(id, nome, cognome, indirizzo, email);
        }
        else u = new Utente(id, nome, cognome, indirizzo, email, telefono);
        ConnectionFactory.closeConnection();
        return u;
    }

    public Utente getUtenteByEmail(String email) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utente WHERE email = ?");
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String cognome = resultSet.getString("cognome");
        String indirizzo = resultSet.getString("indirizzo");
        String telefono = resultSet.getString("telefono");
        Utente u;
        if (telefono == null) {
            u = new Utente(id, nome, cognome, indirizzo, email);
        }
        else u = new Utente(id, nome, cognome, indirizzo, email, telefono);
        ConnectionFactory.closeConnection();
        return u;
    }

}

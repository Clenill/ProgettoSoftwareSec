package com.hcs.healtcaresolution.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RaccoltaDati {

    public static void droppaDB(Statement statement) {
        try {
            statement.executeUpdate("drop table if exists paziente");
            statement.executeUpdate("drop table if exists dottore");
            statement.executeUpdate("drop table if exists autorizzazioni");
            statement.executeUpdate("drop table if exists infermiere");
            statement.executeUpdate("drop table if exists caregiver");
            statement.executeUpdate("drop table if exists visita");
            statement.executeUpdate("drop table if exists provincie");
            statement.executeUpdate("drop table if exists utenti");  // Aggiungi questa linea
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void creatabelleDB(Statement statement) {
        try {
            statement.executeUpdate("create table provincie (idProvincia integer PRIMARY KEY, nomeProvincia string)");
            statement.executeUpdate("create table autorizzazioni (idAuth integer PRIMARY KEY, ruolo string)");
            statement.executeUpdate("create table paziente (idPaziente integer PRIMARY KEY, nomePaziente string, cognomePaziente string, idRuoloP integer, numProv integer, FOREIGN KEY(numProv) REFERENCES provincie(idProvincia),FOREIGN KEY(idRuoloP) REFERENCES autorizzazioni(idAuth))");
            statement.executeUpdate("create table dottore (idDottore integer PRIMARY KEY, nomeDottore string, cognomeDottore string, idRuoloD integer, FOREIGN KEY(idRuoloD) REFERENCES autorizzazioni(idAuth))");
            statement.executeUpdate("create table infermiere (idInf integer PRIMARY KEY, nomeInfermiere string, cognomeInfermiere string, idRuoloI integer, FOREIGN KEY(idRuoloI) REFERENCES autorizzazioni(idAuth))");
            statement.executeUpdate("create table caregiver (idCareGiver integer PRIMARY KEY, nomeCareGiv string, congomeCareGiv string, idRuoloC integer, FOREIGN KEY(idRuoloC) REFERENCES autorizzazioni(idAuth))");
            statement.executeUpdate("create table visita (idVisita integer PRIMARY KEY, invio string, conferma string, riferimentoDottore integer, riferimentoPaziente integer, FOREIGN KEY(riferimentoDottore) REFERENCES dottore(idDottore), FOREIGN KEY(riferimentoPaziente) REFERENCES paziente(idPaziente))");
            statement.executeUpdate("create table utenti (idUtente integer PRIMARY KEY, username string, password string)");  // Aggiungi questa linea
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void inserisciInPaziente(Statement statement) {
        try {
            statement.executeUpdate("insert into paziente (nomePaziente, cognomePaziente, idRuoloP) values ('Leo', 'DiCaprio', 1)");
            statement.executeUpdate("insert into paziente (nomePaziente, cognomePaziente, idRuoloP) values ('Stoshi', 'Nakamoto', 1)");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void queryAlDB(Statement statement, String abc) {
        try {
            ResultSet rs = statement.executeQuery("SELECT p.idPaziente, p.nomePaziente, p.cognomePaziente, a.ruolo " +
                                                  "FROM paziente p " +
                                                  "JOIN autorizzazioni a ON p.idRuoloP = a.idAuth ");

            while (rs.next()) {
                // leggi il risultato
                System.out.println("idPaziente = " + rs.getInt("idPaziente"));
                System.out.println("nomePaziente = " + rs.getString("nomePaziente"));
                System.out.println("cognomePaziente = " + rs.getString("cognomePaziente"));
                System.out.println("Ruolo Paziente: " + rs.getString("ruolo"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void secondaqueryAlDB(Statement statement, String abc) {
        try {
            ResultSet rs = statement.executeQuery(abc);

            while (rs.next()) {
                // read the result set
                System.out.println("invio: " + rs.getString("invio"));
                System.out.println("conferma: " + rs.getString("conferma"));
                System.out.println("idVisita = " + rs.getInt("idVisita"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void inserireAutorizzazioni(Statement statement) {
        try {
            statement.executeUpdate("insert into autorizzazioni (ruolo) values ('paziente')");
            statement.executeUpdate("insert into autorizzazioni (ruolo) values ('dottore')");
            statement.executeUpdate("insert into autorizzazioni (ruolo) values ('infermiere')");
            statement.executeUpdate("insert into autorizzazioni (ruolo) values ('caregiver')");
            //Si parte dall'Id 1
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void stampaAutorizzazioni(Statement statement) {
        //stampo le autorizzazioni per verificare che il DB è popolato
        try {
            ResultSet rs = statement.executeQuery("select * from autorizzazioni");

            while (rs.next()) {
                // stampa il risultato della query
                System.out.println("Id autorizzazione = " + rs.getInt("idAuth"));
                System.out.print(", Ruolo assegnato = " + rs.getString("ruolo"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void inserireUtenti(Statement statement) {
        try {
            statement.executeUpdate("insert into utenti (username, password) values ('user1', 'password1')");
            statement.executeUpdate("insert into utenti (username, password) values ('user2', 'password2')");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static boolean verificaLogin(String username, String password, String userType) {
        String tableName;
        switch (userType) {
            case "Medico" -> tableName = "dottore";
            case "Infermiere" -> tableName = "infermiere";
            case "Caregiver" -> tableName = "caregiver";
            case "Paziente" -> tableName = "paziente";
            default -> {
                return false;
            }
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:prova.db;foreign keys=true;");
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM " + tableName + " WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = statement.executeQuery(query);
            return rs.next(); // Ritorna true se c'è un risultato, altrimenti false
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    public static void creazioneDatabase() {
        // Creazione e connessione al db
        // chiudere connessione e statement 
        try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:prova.db;foreign keys=true;");
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            droppaDB(statement);
            creatabelleDB(statement);
            inserireAutorizzazioni(statement);
            inserisciInPaziente(statement);
            inserireUtenti(statement);  // Aggiungi questa linea

            queryAlDB(statement, "select * from paziente");
            secondaqueryAlDB(statement, "select * from visita");

            // Verifica login (per esempio)
            if (verificaLogin("user1", "password1", "Paziente")) {
                System.out.println("Login riuscito per user1");
            } else {
                System.out.println("Login fallito per user1");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
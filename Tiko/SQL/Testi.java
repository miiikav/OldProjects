/*
Ohje:
1. kopioi kotihakemistoon shell.sis.uta.fi:ssa
2. kääntäminen shell.sis.fi:ssa komennolla: javac Testi.java
3. ajo shell.sis.uta.fi:ssa komennolla: java -classpath /usr/share/java/postgresql.jar:. Testi
*/


import java.sql.*;
import java.util.Scanner;

public class Testi {

  // tietokannan ja käyttäjän tiedot

  // private static final String AJURI = "org.postgresql.Driver";
  private static final String PROTOKOLLA = "jdbc:postgresql:";
  private static final String PALVELIN = "dbstud2.sis.uta.fi";
  private static final int PORTTI = 5432;
  private static final String TIETOKANTA = "ti427620";  // tähän oma käyttäjätunnus
  private static final String KAYTTAJA = "ti427620";  // tähän oma käyttäjätunnus
  private static final String SALASANA = "s7AA5j5ksm";  // tähän tietokannan salasana

  public static void main(String args[]) {

    // Vaihe 1: tietokanta-ajurin lataaminen
    // Tätä ei enää tarvita - ajurin lataaminen tapahtuu 
    // automaattisesti vaiheessa 2    
 
    // try {
    //  Class.forName(AJURI);
    //} catch (ClassNotFoundException poikkeus) {
    //  System.out.println("Ajurin lataaminen ei onnistunut. Lopetetaan ohjelman suoritus.");
    //  return;
    //}

    // Vaihe 2: yhteyden ottaminen tietokantaan

    Connection con = null;
    try {
      con = DriverManager.getConnection(PROTOKOLLA + "//" + PALVELIN + ":" + PORTTI + "/" + TIETOKANTA, KAYTTAJA, SALASANA);

      // Vaihe 3.1: tähän tehtäväkohtainen koodi   

      Scanner input = new Scanner(System.in);
      Statement stmt = con.createStatement();
      System.out.print("Anna ensimmäinen tilinumero: ");
      String ltili = input.next();

      System.out.print("Anna toinen tilinumero: ");
      String stili = input.next();

      System.out.print("anna summa: ");
      String summa = input.next();
      
      stmt.executeUpdate("UPDATE tilit SET saldo = saldo - "+summa+"WHERE tilinumero = '"+ltili+"' AND saldo>"+summa+";");
      stmt.executeUpdate("UPDATE tilit SET saldo = saldo + "+summa+"WHERE tilinumero = '"+stili+";");
      
      stmt.close();  // sulkee automaattisesti myös tulosjoukon rset

    } catch (SQLException poikkeus) {

        // Vaihe 3.2: tähän toiminta mahdollisessa virhetilanteessa

        System.out.println("Tapahtui seuraava virhe: " + poikkeus.getMessage());
    }       

    // Vaihe 4: yhteyden sulkeminen 
 
    if (con != null) try {     // jos yhteyden luominen ei onnistunut, con == null
      con.close();
    } catch(SQLException poikkeus) {
      System.out.println("Yhteyden sulkeminen tietokantaan ei onnistunut. Lopetetaan ohjelman suoritus.");
      return;
    }
  }
}
package database.beans;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pracownik extends Encja {


    private static String[] fieldNames = {"ID_Pracownika", "Ime", "Nazwisko",
            "Stanowisko", "Pesel", "ID_Siedziby"};
    private SimpleStringProperty ID_Pracownika;
    private SimpleStringProperty Ime;
    private SimpleStringProperty Nazwisko;
    private SimpleStringProperty Stanowisko;
    private SimpleStringProperty Pesel;
    private SimpleStringProperty ID_Siedziby;


    public Pracownik(ResultSet wyniki) throws SQLException {
        ID_Pracownika = new SimpleStringProperty(wyniki.getString("ID_Pracownika"));
        Ime = new SimpleStringProperty(wyniki.getString("Ime"));
        Nazwisko = new SimpleStringProperty(wyniki.getString("Nazwisko"));
        Stanowisko = new SimpleStringProperty(wyniki.getString("Stanowisko"));
        Pesel = new SimpleStringProperty(wyniki.getString("Pesel"));
        ID_Siedziby = new SimpleStringProperty(wyniki.getString("ID_Siedziby"));


    }


    public void getInfo() {
        System.out.println("ID: " + ID_Pracownika + "\nnImie: " + Ime + "\nNazwisko" + Nazwisko +
                "\nStanowisko" + Stanowisko + "\nPesel" + Pesel + "\nID_Siedziby" + ID_Siedziby + "\n\n--------------------------------------------------");

    }

    public static String getFieldNames(int i) {
        return fieldNames[i];
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public String getSpecificName(String fieldName) {
        switch (fieldName) {
            case ("ID_Pracownika"):
                return ID_Pracownika.get();
            case ("Ime"):
                return Ime.get();
            case ("Nazwisko"):
                return Nazwisko.get();
            case ("Stanowisko"):
                return Stanowisko.get();
            case ("Pesel"):
                return Pesel.get();
            case ("ID_Siedziby"):
                return ID_Siedziby.get();
        }

        return null;
    }

/*    public static void setFieldNames(String[] fieldNames) {
        Pracownik.fieldNames = fieldNames;
    }
*/
    public String getID_Pracownika() {
        return ID_Pracownika.get();
    }

    public SimpleStringProperty ID_PracownikaProperty() {
        return ID_Pracownika;
    }

    public void setID_Pracownika(String ID_Pracownika) {
        this.ID_Pracownika.set(ID_Pracownika);
    }

    public String getIme() {
        return Ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return Ime;
    }

    public void setIme(String ime) {
        this.Ime.set(ime);
    }

    public String getNazwisko() {
        return Nazwisko.get();
    }

    public SimpleStringProperty nazwiskoProperty() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.Nazwisko.set(nazwisko);
    }

    public String getStanowisko() {
        return Stanowisko.get();
    }

    public SimpleStringProperty stanowiskoProperty() {
        return Stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.Stanowisko.set(stanowisko);
    }

    public String getPesel() {
        return Pesel.get();
    }

    public SimpleStringProperty peselProperty() {
        return Pesel;
    }

    public void setPesel(String pesel) {
        this.Pesel.set(pesel);
    }

    public String getID_Siedziby() {
        return ID_Siedziby.get();
    }

    public SimpleStringProperty ID_SiedzibyProperty() {
        return ID_Siedziby;
    }

    public void setID_Siedziby(String ID_Siedziby) {
        this.ID_Siedziby.set(ID_Siedziby);
    }
}



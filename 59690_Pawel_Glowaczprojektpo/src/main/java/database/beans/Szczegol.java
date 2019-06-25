package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Szczegol extends Encja {

    private static String[] fieldNames = {"id_zlecenia", "nazwa_uslugi", "opis_uslugi",
            "id_podzespolu", "cena"};
    private SimpleStringProperty id_zlecenia;
    private SimpleStringProperty nazwa_uslugi;
    private SimpleStringProperty opis_uslugi;
    private SimpleStringProperty id_podzespolu;
    private SimpleStringProperty cena;

    public Szczegol(ResultSet wyniki) throws SQLException {
        id_zlecenia = new SimpleStringProperty(wyniki.getString("ID_Zlecenia"));
        nazwa_uslugi = new SimpleStringProperty(wyniki.getString("Nazwa_Uslugi"));
        opis_uslugi = new SimpleStringProperty(wyniki.getString("Opis_Uslugi"));
        id_podzespolu = new SimpleStringProperty(wyniki.getString("ID_Podzespolu"));
        cena = new SimpleStringProperty(wyniki.getString("Cena"));


    }

    public void getInfo() {
        System.out.println("ID Zlecenia: " + id_zlecenia + "\nnNazwa Uslugi: " + nazwa_uslugi + "\nOpis_Uslugi" + opis_uslugi +
                "\nID_Podzespolu" + id_podzespolu + "\nCena " + cena + "\n\n--------------------------------------------------");

    }

    public static String getFieldNames(int i){
        return fieldNames[i];
    }

    public String [] getFieldNames(){
        return fieldNames;
    }

    @Override
    public String getSpecificName(String fieldName) {
        switch (fieldName) {
            case ("id_zlecenia"):
                return id_zlecenia.get();
            case ("nazwa_uslugi"):
                return nazwa_uslugi.get();
            case ("opis_uslugi"):
                return opis_uslugi.get();
            case ("id_podzespolu"):
                return id_podzespolu.get();
            case ("cena"):
                return cena.get();
        }

        return null;
    }

    public static void setFieldNames(String[] fieldNames) {
        Szczegol.fieldNames = fieldNames;
    }

    public String getId_zlecenia() {
        return id_zlecenia.get();
    }

    public SimpleStringProperty id_zleceniaProperty() {
        return id_zlecenia;
    }

    public void setId_zlecenia(String id_zlecenia) {
        this.id_zlecenia.set(id_zlecenia);
    }

    public String getNazwa_uslugi() {
        return nazwa_uslugi.get();
    }

    public SimpleStringProperty nazwa_uslugiProperty() {
        return nazwa_uslugi;
    }

    public void setNazwa_uslugi(String nazwa_uslugi) {
        this.nazwa_uslugi.set(nazwa_uslugi);
    }

    public String getOpis_uslugi() {
        return opis_uslugi.get();
    }

    public SimpleStringProperty opis_uslugiProperty() {
        return opis_uslugi;
    }

    public void setOpis_uslugi(String opis_uslugi) {
        this.opis_uslugi.set(opis_uslugi);
    }

    public String getId_podzespolu() {
        return id_podzespolu.get();
    }

    public SimpleStringProperty id_podzespoluProperty() {
        return id_podzespolu;
    }

    public void setId_podzespolu(String id_podzespolu) {
        this.id_podzespolu.set(id_podzespolu);
    }

    public String getCena() {
        return cena.get();
    }

    public SimpleStringProperty cenaProperty() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena.set(cena);
    }
}
package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dostawca extends Encja {

    private static String[] fieldNames = {"id_dostawcy", "nazwa_dostawcy", "adres",
            "kraj", "kod_pocztowy", "telefon"};
    private SimpleStringProperty id_dostawcy;
    private SimpleStringProperty nazwa_dostawcy;
    private SimpleStringProperty adres;
    private SimpleStringProperty kraj;
    private SimpleStringProperty kod_pocztowy;
    private SimpleStringProperty telefon;


    public Dostawca(ResultSet wyniki) throws SQLException {
        id_dostawcy = new SimpleStringProperty(wyniki.getString("ID_Dostawcy"));
        nazwa_dostawcy = new SimpleStringProperty(wyniki.getString("Nazwa_Dostawcy"));
        adres = new SimpleStringProperty(wyniki.getString("Adres"));
        kraj = new SimpleStringProperty(wyniki.getString("Kraj"));
        kod_pocztowy = new SimpleStringProperty(wyniki.getString("Kod_Pocztowy"));
        telefon = new SimpleStringProperty(wyniki.getString("Telefon"));


    }
    public void getInfo() {
        System.out.println("ID: " + id_dostawcy + "\nnNazwa dostawcy: " + nazwa_dostawcy + "\nNAdres" + adres + "\nNKraj" + kraj +
                "\nKod Pocztowy" + kod_pocztowy + "\nTelefon" + telefon + "\n\n--------------------------------------------------");

    }

    public static String getFieldNames(int i){
        return fieldNames[i];
    }

    public String [] getFieldNames(){
        return fieldNames;
    }

    @Override
    public String getSpecificName(String fieldName) {
        switch(fieldName){
            case("id_dostawcy"):
                return id_dostawcy.get();
            case("nazwa_dostawcy"):
                return nazwa_dostawcy.get();
            case("adres"):
                return adres.get();
            case("kraj"):
                return kraj.get();
            case("kod_pocztowy"):
                return kod_pocztowy.get();
            case("kod_telefon"):
                return telefon.get();
        }

        return null;
    }



    public static void setFieldNames(String[] fieldNames) {
        Dostawca.fieldNames = fieldNames;
    }

    public String getId_dostawcy() {
        return id_dostawcy.get();
    }

    public SimpleStringProperty id_dostawcyProperty() {
        return id_dostawcy;
    }

    public void setId_dostawcy(String id_dostawcy) {
        this.id_dostawcy.set(id_dostawcy);
    }

    public String getNazwa_dostawcy() {
        return nazwa_dostawcy.get();
    }

    public SimpleStringProperty nazwa_dostawcyProperty() {
        return nazwa_dostawcy;
    }

    public void setNazwa_dostawcy(String nazwa_dostawcy) {
        this.nazwa_dostawcy.set(nazwa_dostawcy);
    }

    public String getAdres() {
        return adres.get();
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }

    public String getKraj() {
        return kraj.get();
    }

    public SimpleStringProperty krajProperty() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj.set(kraj);
    }

    public String getKod_pocztowy() {
        return kod_pocztowy.get();
    }

    public SimpleStringProperty kod_pocztowyProperty() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy.set(kod_pocztowy);
    }

    public String getTelefon() {
        return telefon.get();
    }

    public SimpleStringProperty telefonProperty() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon.set(telefon);
    }
}













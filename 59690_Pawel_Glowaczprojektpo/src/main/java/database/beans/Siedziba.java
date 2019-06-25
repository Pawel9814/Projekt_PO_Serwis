package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Siedziba extends Encja {

    private static String[] fieldNames = {"id_siedziby", "adres", "kod_pocztowy",
            "telefon",};
    private SimpleStringProperty id_siedziby;
    private SimpleStringProperty adres;
    private SimpleStringProperty kod_pocztowy;
    private SimpleStringProperty telefon;



    public Siedziba(ResultSet wyniki) throws SQLException {
        id_siedziby = new SimpleStringProperty(wyniki.getString("ID_Siedziby"));
        adres = new SimpleStringProperty(wyniki.getString("Adres"));
        kod_pocztowy = new SimpleStringProperty(wyniki.getString("Kod_Pocztowy"));
        telefon = new SimpleStringProperty(wyniki.getString("Telefon"));


    }


    public void getInfo() {
        System.out.println("ID Siedziby: " + id_siedziby + "\nAdres: " + adres + "\nKod Pocztowy: " + kod_pocztowy +
                "\nTelefon: " + telefon + "\n\n--------------------------------------------------");

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
            case("id_siedziby"):
                return id_siedziby.get();
            case("adres"):
                return adres.get();
            case("kod_pocztowy"):
                return kod_pocztowy.get();
            case("kod_telefon"):
                return telefon.get();
    }

        return null;
    }




    public static void setFieldNames(String[] fieldNames) {
        Siedziba.fieldNames = fieldNames;
    }

    public String getId_siedziby() {
        return id_siedziby.get();
    }

    public SimpleStringProperty id_siedzibyProperty() {
        return id_siedziby;
    }

    public void setId_siedziby(String id_siedziby) {
        this.id_siedziby.set(id_siedziby);
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
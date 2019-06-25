package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klient extends Encja{

    private static String[] fieldNames = {"id_klienta", "imie", "nazwisko",
                                                "kodPocztowy", "telefon"};
    private SimpleStringProperty id_klienta;
    private SimpleStringProperty imie;
    private SimpleStringProperty nazwisko;
    private SimpleStringProperty kodPocztowy;
    private SimpleStringProperty telefon;


    public Klient(ResultSet wyniki) throws SQLException{
        id_klienta = new SimpleStringProperty(wyniki.getString("ID_Klienta"));
        imie = new SimpleStringProperty(wyniki.getString("Ime"));
        nazwisko = new SimpleStringProperty(wyniki.getString("Nazwisko"));
        kodPocztowy = new SimpleStringProperty(wyniki.getString("Kod_Pocztowy"));
        telefon = new SimpleStringProperty(wyniki.getString("Telefon"));


    }
    public void getInfo(){
        System.out.println("ID: "+id_klienta +"\nnImie: "+ imie + "\nNazwisko"+nazwisko +
                "\nKod Pocztowy"+ kodPocztowy + "\nTelefon"+ "\n\n--------------------------------------------------");

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
            case("id_klienta"):
                return id_klienta.get();
            case("imie"):
                return imie.get();
            case("nazwisko"):
                return nazwisko.get();
            case("kodPocztowy"):
                return kodPocztowy.get();
            case("telefon"):
                return telefon.get();
        }

        return null;
    }


    public String getId_klienta() {
        return id_klienta.get();
    }

    public SimpleStringProperty id_klientaProperty() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta.set(id_klienta);
    }

    public String getImie() {
        return imie.get();
    }

    public SimpleStringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public SimpleStringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public SimpleStringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy.set(kodPocztowy);
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

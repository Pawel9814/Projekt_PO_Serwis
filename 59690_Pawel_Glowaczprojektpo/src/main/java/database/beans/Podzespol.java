package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Podzespol extends Encja {

    private static String[] fieldNames = {"id_podzespolu", "nazwa_podzespolu", "id_dostawcy",
            "cena"};
    private SimpleStringProperty id_podzespolu;
    private SimpleStringProperty nazwa_podzespolu;
    private SimpleStringProperty id_dostawcy;
    private SimpleStringProperty cena;


    public Podzespol(ResultSet wyniki) throws SQLException {
        id_podzespolu = new SimpleStringProperty(wyniki.getString("ID_Podzespolu"));
        nazwa_podzespolu = new SimpleStringProperty(wyniki.getString("Nazwa_Podzespolu"));
        id_dostawcy = new SimpleStringProperty(wyniki.getString("ID_Dostawcy"));
        cena = new SimpleStringProperty(wyniki.getString("Cena"));

    }


    public void getInfo() {
        System.out.println("ID Podzespolu: " + id_podzespolu + "\nNazwa Podzespolu: " + nazwa_podzespolu + "\nID Dostawcy: " + id_dostawcy +
                "\nCena " + cena + "\n\n------ --------------------------------------------");

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
            case("id_podzespolu"):
                return id_podzespolu.get();
            case("nazwa_podzespolu"):
                return nazwa_podzespolu.get();
            case("id_dostawcy"):
                return id_dostawcy.get();
            case("cena"):
                return cena.get();
        }

        return null;
    }


    public static void setFieldNames(String[] fieldNames) {
        Podzespol.fieldNames = fieldNames;
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

    public String getNazwa_podzespolu() {
        return nazwa_podzespolu.get();
    }

    public SimpleStringProperty nazwa_podzespoluProperty() {
        return nazwa_podzespolu;
    }

    public void setNazwa_podzespolu(String nazwa_podzespolu) {
        this.nazwa_podzespolu.set(nazwa_podzespolu);
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

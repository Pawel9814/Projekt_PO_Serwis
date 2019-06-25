package database.beans;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Zlecenie extends Encja {

    private static String[] fieldNames = {"id_zlecenia", "id_klienta", "id_pracownika",
            "data_zlecenia"};
    private SimpleStringProperty id_zlecenia;
    private SimpleStringProperty id_klienta;
    private SimpleStringProperty id_pracownika;
    private SimpleStringProperty data_zlecenia;

    public Zlecenie(ResultSet wyniki) throws SQLException {
        id_zlecenia = new SimpleStringProperty(wyniki.getString("ID_Zlecenia"));
        id_klienta = new SimpleStringProperty(wyniki.getString("ID_Klienta"));
        id_pracownika = new SimpleStringProperty(wyniki.getString("ID_Pracownika"));
        // TODO ----------
        data_zlecenia = new SimpleStringProperty(wyniki.getString("Data_Zlecenia"));


    }
    public void getInfo(){
        System.out.println("ID Zlecenia: "+id_zlecenia +"\nnID Klienta: "+ id_klienta + "\nID_Pracownika"+ id_pracownika +
                "\nData Zlecenia"+ data_zlecenia + "\n\n--------------------------------------------------");

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
            case("id_zlecenia"):
                return id_zlecenia.get();
            case("id_klienta"):
                return id_klienta.get();
            case("id_pracownika"):
                return id_pracownika.get();
            case("data_zlecenia"):
                return data_zlecenia.get();
        }

        return null;
    }

    public static void setFieldNames(String[] fieldNames) {
        Zlecenie.fieldNames = fieldNames;
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

    public String getId_klienta() {
        return id_klienta.get();
    }

    public SimpleStringProperty id_klientaProperty() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta.set(id_klienta);
    }

    public String getId_pracownika() {
        return id_pracownika.get();
    }

    public SimpleStringProperty id_pracownikaProperty() {
        return id_pracownika;
    }

    public void setId_pracownika(String id_pracownika) {
        this.id_pracownika.set(id_pracownika);
    }

    public String getData_zlecenia() {
        return data_zlecenia.get();
    }

    public SimpleStringProperty data_zleceniaProperty() {
        return data_zlecenia;
    }

    public void setData_zlecenia(String data_zlecenia) {
        this.data_zlecenia.set(data_zlecenia);
    }
}
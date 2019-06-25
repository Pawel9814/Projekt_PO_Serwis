package database;

import java.sql.SQLException;

public class DBUpdateManager {

    //metoda dodawania
    public static void createNewEntity(String entityClass, String arguments) throws SQLException {
        switch(entityClass){

            case "database.beans.Klient":
                DBConnector.connect().insertRecord("Insert into KLIENCI (ID_Klienta, Ime, Nazwisko, Kod_Pocztowy, Telefon) Values(" + arguments +")");
                break;
            case "database.beans.Pracownik":
                DBConnector.connect().insertRecord("Insert into PRACOWNICY (ID_Pracownika, Ime, Nazwisko, Stanowisko, Pesel, ID_Siedziby) Values(" + arguments +")");
                break;
            case "database.beans.Zlecenie":
                DBConnector.connect().insertRecord("Insert into ZLECENIA (ID_Zlecenia, ID_Klienta, ID_Pracownika, Data_Zlecenia) Values(" + arguments +")");
                break;
             case "database.beans.Szczegol":
                DBConnector.connect().insertRecord("Insert into SZCZEGOLY_ZLECENIA (ID_Zlecenia, Nazwa_Uslugi, Opis_Uslugi, ID_Podzespolu, Cena) Values(" + arguments +")");
                break;
            case "database.beans.Podzespol":
                DBConnector.connect().insertRecord("Insert into ZAMAWIANE_PODZESPOLY (ID_Podzespolu, Nazwa_Podzespolu, ID_Dostawcy, Cena) Values(" + arguments +")");
                break;
            case "database.beans.Dostawca":
                DBConnector.connect().insertRecord("Insert into DOSTAWCY (ID_Dostawcy, Nazwa_Dostawcy, Adres, Kraj, Kod_Pocztowy, Telefon) Values(" + arguments +")");
                break;
            case "database.beans.Siedziba":
                DBConnector.connect().insertRecord("Insert into SIEDZIBA (ID_Siedziby, Adres, Kod_Pocztowy, Telefon) Values(" + arguments +")");

               break;

        }
    }
    //metoda edytowania
    public static void editEntity(String entityClass, String arguments, String entityId ) throws SQLException{

        switch(entityClass){
            case "database.beans.Klient":
                DBConnector.connect().insertRecord("DELETE FROM KLIENCI WHERE ID_Klienta ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into KLIENCI (ID_Klienta, Ime, Nazwisko, Kod_Pocztowy, Telefon) Values(" + arguments +")");
                break;
            case "database.beans.Pracownik":
                DBConnector.connect().insertRecord("DELETE FROM PRACOWNICY WHERE ID_Pracownika ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into PRACOWNICY (ID_Pracownika, Ime, Nazwisko, Stanowisko, Pesel, ID_Siedziby) Values(" + arguments +")");
                break;
            case "database.beans.Zlecenie":
                DBConnector.connect().insertRecord("DELETE FROM ZLECENIA WHERE ID_Zlecenia ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into ZLECENIA (ID_Zlecenia, ID_Klienta, ID_Pracownika, Data_Zlecenia) Values(" + arguments +")");
                break;
            case "database.beans.Szczegol":
                DBConnector.connect().insertRecord("DELETE FROM SZCZEGOLY_ZLECENIA WHERE ID_Szczegol ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into SZCZEGOLY_ZLECENIA (ID_Zlecenia, Nazwa_Uslugi, Opis_Uslugi, ID_Podzespolu, Cena) Values(" + arguments +")");
                break;
            case "database.beans.Podzespol":
                DBConnector.connect().insertRecord("DELETE FROM ZAMAWIANE_PODZESPOLY WHERE ID_Podzespolu ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into ZAMAWIANE_PODZESPOLY (ID_Podzespolu, Nazwa_Podzespolu, ID_Dostawcy, Cena) Values(" + arguments +")");
                break;
            case "database.beans.Dostawca":
                DBConnector.connect().insertRecord("DELETE FROM DOSTAWCY WHERE ID_Dostawcy ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into DOSTAWCY (ID_Dostawcy, Nazwa_Dostawcy, Adres, Kraj, Kod_Pocztowy, Telefon) Values(" + arguments +")");
                break;
            case "database.beans.Siedziba":
                DBConnector.connect().insertRecord("DELETE FROM SIEDZIBA WHERE ID_Siedziby ='" + entityId + "'");
                DBConnector.connect().insertRecord("Insert into SIEDZIBA (ID_Siedziby, Adres, Kod_Pocztowy, Telefon) Values(" + arguments +")");
                break;
        }
    }

}

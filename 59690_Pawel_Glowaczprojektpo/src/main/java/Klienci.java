import database.DBConnector;
import database.EntityValueWindow;
import database.beans.Encja;
import database.beans.Klient;
import database.beans.Pracownik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klienci {

    private static ObservableList<Encja> data = FXCollections.observableArrayList();
    private static Klienci klienci;



    private static void clearData(){
        if(data.isEmpty() == false){
            data = FXCollections.observableArrayList();
        }
    }
    public static void setValues() {

        /*
                                    TODO              Opcja 'Wyswietl' 100% ZROBIONE
         */
        App.getAppMenuBar().getMenus().get(1).getItems().get(0).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                try {
                    App.clearColumns();
                    clearData();
                    ResultSet wynikiZapytania = DBConnector
                            .connect()
                            .createResultSet
                                    ("SELECT * FROM KLIENCI");
                    int ammountOfColumns = wynikiZapytania.getMetaData().getColumnCount();
                    for(int i = 1; i <= ammountOfColumns ; i++){


                        TableColumn firstNameCol = new TableColumn(wynikiZapytania.getMetaData().getColumnName((i)));
                        firstNameCol.setCellValueFactory(
                                new PropertyValueFactory<Klient, String>(Klient.getFieldNames(i - 1))
                        );
                        App.getTableView().getColumns().add(firstNameCol);
                    }
                    while(wynikiZapytania.next()){
                        data.add(new Klient(wynikiZapytania));
                    }
                    App.getTableView().setItems(data);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        });

        /*
                                            Opcja 'Edytuj'
         */
        App.getAppMenuBar().getMenus().get(1).getItems().get(1).setOnAction(new EventHandler<ActionEvent>(){
            // do zmiennej pracownik zostaje przypisana wartosc z App.editCell
            public void handle(ActionEvent event) {
                Klient pracownik = (Klient) App.editCell();
                EntityValueWindow.createScene(pracownik, "Edytuj");
            }
        });

        /*
                                           Opcja 'Dodaj'
         */
        App.getAppMenuBar().getMenus().get(1).getItems().get(2).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                Klient pracownik = (Klient) App.editCell();
                EntityValueWindow.createScene(pracownik, "Dodaj");
            }

        });

        /*
                               todo intresing           Opcja 'Usun'
         */
        App.getAppMenuBar().getMenus().get(1).getItems().get(3).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                Klient klient = (Klient) App.editCell();
                try {
                    DBConnector.connect()
                            .insertRecord(
                                    "DELETE FROM KLIENCI " +
                                            "WHERE ID_Klienta ='" +
                                            klient.getId_klienta() +"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

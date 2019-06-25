import database.DBConnector;
import database.EntityValueWindow;
import database.beans.Encja;
import database.beans.Klient;
import database.beans.Pracownik;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pracownicy  {

    private static ObservableList<Encja> data = FXCollections.observableArrayList();


    public Pracownicy(TableView<Encja> resultView){

    }
    private static void clearData(){
        if(data.isEmpty() == false){
            data = FXCollections.observableArrayList();
        }
    }
    public static void setValues() {

        /*
                                TODO                 Opcja 'Wyswietl'
         */

        App.getAppMenuBar().getMenus().get(0).getItems().get(0).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                try {
                    App.clearColumns();
                    clearData();
                    ResultSet wynikiZapytania = DBConnector
                            .connect()
                            .createResultSet
                                    ("SELECT * FROM PRACOWNICY");
                    int ammountOfColumns = wynikiZapytania.getMetaData().getColumnCount();
                    for(int i = 1; i <= ammountOfColumns; i++){
                        TableColumn firstNameCol = new TableColumn(wynikiZapytania.getMetaData().getColumnName(i));
                        firstNameCol.setCellValueFactory(
                                new PropertyValueFactory<Pracownik, String>(Pracownik.getFieldNames(i-1))
                        );
                        App.getTableView().getColumns().add(firstNameCol);
                    }
                    while(wynikiZapytania.next()){
                        data.add(new Pracownik(wynikiZapytania));
                    }
                    App.getTableView().setItems(data);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        });



        /*
                                    TODO               Opcja 'Edytuj'
         */
        App.getAppMenuBar().getMenus().get(0).getItems().get(1).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                Pracownik pracownik = (Pracownik) App.editCell();
                EntityValueWindow.createScene(pracownik, "Edytuj");
            }
        });

        /*
                                     TODO           Opcja 'Dodaj'
         */
        App.getAppMenuBar().getMenus().get(0).getItems().get(2).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                System.out.println("test+-");
                Pracownik pracownik = (Pracownik) App.editCell();
                EntityValueWindow.createScene(pracownik, "Dodaj");
            }
        });

        /*
                                  TODO              Opcja 'Usun'
         */
        App.getAppMenuBar().getMenus().get(0).getItems().get(3).setOnAction(new EventHandler<ActionEvent>(){

        public void handle(ActionEvent event) {
            Pracownik pracownik = (Pracownik) App.editCell();
            try {
                DBConnector.connect()
                        .insertRecord(
                                "DELETE FROM PRACOWNICY " +
                                        "WHERE ID_Pracownika ='" +
                                        pracownik.getID_Pracownika()+"'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    });
    }
}

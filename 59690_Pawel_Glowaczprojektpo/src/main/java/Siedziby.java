import database.DBConnector;
import database.EntityValueWindow;
import database.beans.Encja;
import database.beans.Klient;
import database.beans.Siedziba;
import database.beans.Zlecenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Siedziby {


    private static ObservableList<Encja> data = FXCollections.observableArrayList();


    public Siedziby(TableView<Encja> resultView){

    }

    private static void clearData(){
        if(data.isEmpty() == false){
            data = FXCollections.observableArrayList();
        }
    }

    public static void setValues() {

        /*
                                                 Opcja 'Wyswietl'
         */
        App.getAppMenuBar().getMenus().get(6).getItems().get(0).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                try {
                    App.clearColumns();
                    clearData();
                    ResultSet wynikiZapytania = DBConnector
                            .connect()
                            .createResultSet
                                    ("SELECT * FROM SIEDZIBA");
                    int ammountOfColumns = wynikiZapytania.getMetaData().getColumnCount();
                    for(int i = 1; i <= ammountOfColumns; i++){
                        TableColumn firstNameCol = new TableColumn(wynikiZapytania.getMetaData().getColumnName(i));
                        firstNameCol.setCellValueFactory(
                                new PropertyValueFactory<Siedziba, String>(Siedziba.getFieldNames(i-1))
                        );
                        App.getTableView().getColumns().add(firstNameCol);
                    }
                    while(wynikiZapytania.next()){
                        data.add(new Siedziba(wynikiZapytania));
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
        App.getAppMenuBar().getMenus().get(6).getItems().get(1).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                Siedziba pracownik = (Siedziba) App.editCell();
                EntityValueWindow.createScene(pracownik, "Edytuj");
            }
        });

        /*
                                                Opcja 'Dodaj'
         */
        App.getAppMenuBar().getMenus().get(6).getItems().get(2).setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                Siedziba pracownik = (Siedziba) App.editCell();
                EntityValueWindow.createScene(pracownik, "Dodaj");
            }

        });

        /*
                                                Opcja 'Usun'
         */
        App.getAppMenuBar().getMenus().get(6).getItems().get(3).setOnAction(new EventHandler<ActionEvent>(){

                public void handle(ActionEvent event) {
                    Siedziba klient = (Siedziba) App.editCell();
                    try {
                        DBConnector.connect()
                                .insertRecord(
                                        "DELETE FROM SIEDZIBA " +
                                                "WHERE ID_SIEDZIBY ='" +
                                                klient.getId_siedziby()+"'");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

}

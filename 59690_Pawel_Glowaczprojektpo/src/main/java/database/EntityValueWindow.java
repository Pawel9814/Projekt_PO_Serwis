package database;

import database.beans.Encja;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityValueWindow {
    private static List<HBox> hBoxList = new ArrayList<>();
    private static String entity_id;

    //Tworzenie okna do dodawanie i edycji rekordow
    public static void createScene(Encja encja, String opcja){
        hBoxList = new ArrayList<>();
        Stage stage = new Stage();
        VBox box = new VBox();
        //text oraz okno do wpisywania wartosci zostaną wyswietlone na srodku okna
        box.setAlignment(Pos.CENTER);

        String [] values = encja.getFieldNames();

        for(int i = 0; i < values.length; i++){
            //AUTOGENERATE FROM HERE
            //inner box
            HBox firstBox = new HBox();
            firstBox.setAlignment(Pos.CENTER);
            Label testLabel = new Label(values[i]);
            //pobieranie i wyswietlanie textu(nazwy atrybutu)
            firstBox.setMargin(testLabel, new Insets(0,0,20,0));
            firstBox.getChildren().add(testLabel);
            TextField testField = new TextField();
            //pobieranie i wsywietlanie testfieldu gdzie bedzie sie wpisywac wartosci
            testField.setText(encja.getSpecificName(values[i]));
            firstBox.setMargin(testField, new Insets(0,0,20,0));
            firstBox.getChildren().add(testField);

            box.getChildren().add(firstBox);
            hBoxList.add(firstBox);
        }

        //
        Button confirm = new Button("OK");

        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Okno dla opcji Dodaj
                if(opcja.equals("Dodaj")){
                    Iterator iterator = hBoxList.iterator();

                    //do entityArguments bedzie przypisany string z argumentami jakie bedzie trzeba wysłąc do bazy
                    // aby zaszly oczekiwane zmiany

                    String entityArguments = "";
                    int i = 0;
                    while(iterator.hasNext()){
                        // Pobieranie label'a oraz textfielda atrybuty z rekordu które pobierzemy
                        TextField field = (TextField) hBoxList.get(i).getChildren().get(1);
                        entityArguments += "'"+ field.getText() + "'" + ",";
                        i++;
                        iterator.next();
                    }
                    //usuwa ostatni przecinek aby zapytanie sql bylo poprawne
                    entityArguments = entityArguments.substring(0, entityArguments.length()-1);
                    try {
                        DBUpdateManager.createNewEntity(encja.getClass().getName(), entityArguments);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

                if(opcja.equals("Edytuj")){

                    Iterator iterator = hBoxList.iterator();

                    String entityArguments = "";
                    int i = 0;
                    while(iterator.hasNext()){
                        if(i == 0){
                            TextField field = (TextField) hBoxList.get(i).getChildren().get(1);
                            entity_id = field.getText();
                        }
                        TextField field = (TextField) hBoxList.get(i).getChildren().get(1);
                        entityArguments += "'"+ field.getText() + "'" + ",";
                        i++;
                        iterator.next();
                    }
                    //usuwa ostatni przecinek aby zapytanie sql bylo poprawne
                    entityArguments = entityArguments.substring(0, entityArguments.length()-1);
                    try {
                        DBUpdateManager.editEntity(encja.getClass().getName(), entityArguments, entity_id);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
        //getChildern metoda z fxml pobiera wszystkie wartosci jakie są w box
        box.getChildren().add(confirm);
        //utworzenie okna, przypisanie szerokosci i wysokosci
        Scene scene = new Scene(box, 420,300);

        stage.setScene(scene);
        stage.show();
    }
}

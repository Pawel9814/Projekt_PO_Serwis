
import database.beans.Encja;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {
// appMenuBar jest zaimplementowane w fxml czyli "importujemy" z menu.fxml
    @FXML
    MenuBar appMenuBar;

    @FXML
    TableView <Encja> resultView;

    private static MenuBar appMenuBar2;
    static TableView <Encja> view;


    public void initialize(URL location, ResourceBundle resources) {
        appMenuBar2 = appMenuBar;
        view = resultView;

//wywoalanie metody menuEventTrigger z klasy MenuBaController która inicjalizuje pola paska menu
        MenuBarController.menuEventTrigger(appMenuBar);
    }


    public static void main(String[] args){
        launch();

    }
    //
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/FXML/menu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    //zamykanie aplikacji
    public void closeApp(){
        Platform.exit();
    }
    //inne klasy mogą korzystac z appMenuBar2
    public static MenuBar getAppMenuBar(){
        return appMenuBar2;
    }
    //view= tabela wyników
    public static TableView<Encja> getTableView(){
        return view;
    }
    // czyszczenie wszystkich kolumn
    public static void clearColumns(){
        view.getColumns().remove(0 , view.getColumns().size());
    }
    //pobieranie wartosci z wybranego miejsca
    public static Encja editCell(){
        return view.getSelectionModel().getSelectedItem();
    }
    //metoda która sprawdza czy dane pole jest zaznaczone
    public static boolean isSelected(){
        return view.getSelectionModel().getSelectedCells().isEmpty();
    }
}

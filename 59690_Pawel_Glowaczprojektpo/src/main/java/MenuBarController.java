import com.sun.scenario.effect.impl.prism.ps.PPSZeroSamplerPeer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuBarController {

    public MenuBarController(){

    }
    public static void menuEventTrigger(final MenuBar menuBar){

            Pracownicy.setValues();
            Klienci.setValues();
            Zlecenia.setValues();
            Szczegoly.setValues();
            Podzespoly.setValues();
            Siedziby.setValues();
            Dostawcy.setValues();

    }
}

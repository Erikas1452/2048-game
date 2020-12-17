import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.Parent;

import javax.swing.text.StyledEditorKit;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game newGame = Game.getInstance();
        newGame.startGame();
    }
}

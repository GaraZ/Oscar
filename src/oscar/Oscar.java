package oscar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author GaraZ
 */
public class Oscar extends Application {
    
    
    final static double WIDTH = 200;
    final static double HEIGTH = 300;
    
    @Override
    public void start(Stage primaryStage) {        
        StackPane root = new StackPane(); 
        Scene scene = new Scene(root, WIDTH, HEIGTH);
        
        Human oscar = new Human();
        root.getChildren().add(oscar);     
        primaryStage.setTitle("Oscar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

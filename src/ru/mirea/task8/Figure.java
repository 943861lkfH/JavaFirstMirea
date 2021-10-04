package ru.mirea.task8;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.Group;
//import javafx.scene.text.Text;

public class Figure extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dogs application");
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);

        InputStream iconStream =
                getClass().getResourceAsStream("/images/someImage.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        Button button = new Button("WOF WOF ???'");

        button.setOnAction(e -< {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "WOF WOF WOF!!!");
        alert.showAndWait();
        });
        Scene primaryScene = new Scene(button);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
}

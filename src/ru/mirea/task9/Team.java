package ru.mirea.task9;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.Group;

public class Team extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);

        Label label1 = new Label("");
        Label label2 = new Label("");
        Label label3 = new Label("");

        Button button1 = new Button("Winx");
        Button button2 = new Button("W.I.T.C.H.");

        Group root = new Group();
        root.getChildren().addAll(label1, label2, label3, button1, button2);
        Scene scene = new Scene(root, 600, 500, Color.PALETURQUOISE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

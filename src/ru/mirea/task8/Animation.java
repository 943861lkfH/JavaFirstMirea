package ru.mirea.task8;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.Group;

public class Animation extends Application {
    public static void main(String[] args)  {
        Application.launch();
    }
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("My animation");
        myStage.setWidth(600);
        myStage.setHeight(500);

        Image im1 = new Image("https://www.meme-arsenal.com/memes/776d8d15fab5254f3aeaaa7ea8f035b5.jpg");
        ImageView imageView1 = new ImageView(im1);
        imageView1.setFitHeight(1);
        imageView1.setFitWidth(1);
        Image im2 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcZ7kkL3umZiVVm2n1VKHvlJIdJ7ayr9DFyd8JIK_Y_WqxqAGtUH_T2c-g2j0yhiSEF1A&usqp=CAU");
        ImageView imageView2 = new ImageView(im2);
        imageView2.setFitHeight(1);
        imageView2.setFitWidth(1);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.0), e -> {

                    imageView1.setFitHeight(300);
                    imageView1.setFitWidth(300);
                    }),
                new KeyFrame(Duration.seconds(2.0), e -> {

                    imageView2.setFitHeight(300);
                    imageView2.setFitWidth(300);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Group root = new Group();
        root.getChildren().addAll(imageView1, imageView2);
        Scene scene = new Scene(root, 600, 500, Color.WHITE);
        myStage.setScene(scene);
        myStage.show();

    }
}

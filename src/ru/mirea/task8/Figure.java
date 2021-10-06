package ru.mirea.task8;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.Group;
import java.io.InputStream;

public class Figure extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Attention, work is underway"); //название окна
        myStage.setWidth(600);     // ширина окна
        myStage.setHeight(500);    // длина окна

        myStage.getIcons().add(new Image("C:/Users/Эльдорадо/Pictures/gZVlsTlqicE.jpg")); // вставка иконки окна

        Group root = new Group();
        Circle circle1 = new Circle(15,20,5);
        circle1.setFill(Color.BLUE);
        Circle circle2 = new Circle(45,20,15);
        circle2.setFill(Color.CHOCOLATE);
        Circle circle3 = new Circle(90,20,20);
        circle3.setFill(Color.PINK);
        Circle circle4 = new Circle(140,20,11);
        circle4.setFill(Color.LIME);
        Circle circle5 = new Circle(180,20,20);
        circle5.setFill(Color.OLIVE);
        Rectangle rect1 = new Rectangle(15,50, 20, 50);
        rect1.setFill(Color.GRAY);
        Rectangle rect2 = new Rectangle(45, 50, 100, 50);
        rect2.setFill(Color.GREEN);
        Rectangle rect3 = new Rectangle(160, 50, 10, 9);
        rect3.setFill(Color.RED);
        Rectangle rect4 = new Rectangle(160, 70, 90, 15);
        rect4.setFill(Color.BROWN);
        Rectangle rect5 = new Rectangle(300, 70, 20, 20);
        rect5.setFill(Color.BROWN);
        Ellipse ellipse1 = new Ellipse(30,150,20,30);
        ellipse1.setFill(Color.BLUE);
        Ellipse ellipse2 = new Ellipse(70,150,10,15);
        ellipse2.setFill(Color.GREEN);
        Ellipse ellipse3 = new Ellipse(110,150,20,10);
        ellipse3.setFill(Color.YELLOW);
        Ellipse ellipse4 = new Ellipse(150,150,2,30);
        ellipse4.setFill(Color.BLACK);
        Ellipse ellipse5 = new Ellipse(200,150,35,30);
        ellipse5.setFill(Color.BEIGE);
        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(new Double[]{
                20.0, 200.0,
                20.0, 220.0,
                40.0, 220.0});
        triangle1.setFill(Color.RED);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(new Double[]{
                60.0, 200.0,
                50.0, 220.0,
                80.0, 220.0});
        triangle2.setFill(Color.DARKTURQUOISE);
        Polygon triangle3 = new Polygon();
        triangle3.getPoints().addAll(new Double[]{
                90.0, 200.0,
                120.0, 200.0,
                100.0, 220.0});
        triangle3.setFill(Color.GRAY);
        Polygon triangle4 = new Polygon();
        triangle4.getPoints().addAll(new Double[]{
                140.0, 200.0,
                145.0, 220.0,
                150.0, 220.0});
        triangle4.setFill(Color.YELLOW);
        Polygon triangle5 = new Polygon();
        triangle5.getPoints().addAll(new Double[]{
                180.0, 200.0,
                160.0, 220.0,
                180.0, 220.0});
        triangle5.setFill(Color.SEASHELL);

        Image image = new Image("C:/Users/Эльдорадо/Pictures/gZVlsTlqicE.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        BorderPane pane = new BorderPane();
        pane.setPrefSize(800, 600);
        pane.setCenter(imageView);

        root.getChildren().addAll(circle1,circle2,circle3, circle4, circle5, rect1,rect2,rect3,rect4, rect5, ellipse5, ellipse1, ellipse2, ellipse3, ellipse4, triangle1, triangle2, triangle3, triangle4, triangle5, pane);
        Scene scene = new Scene(root, 600, 500, Color.WHITE);
        myStage.setScene(scene);
        myStage.show();
    }
}

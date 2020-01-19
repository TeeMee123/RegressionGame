package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Main extends Application {

    Random rng = new Random();

    VBox root;
    StackPane sp;
    Canvas canvas;

    /**
     * Contains the main code for the game.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        sp = (StackPane) root.getChildren().get(1);

        canvas = new Canvas(380, 380); //(Canvas) ((StackPane) root.getChildren().get(1)).getChildren().get(0);
        sp.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked((event -> {
            System.out.println(sp.getChildren());
            gc.setFill(Color.MAGENTA);
            gc.fillRect(rng.nextInt(390), rng.nextInt(390), 10, 10);
        }));

        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,400,400);

        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

/*
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(10,10,10,10);
        gc.setStroke(Color.RED);
        canvas.setOnMouseClicked(this::handleCanvasClick);
        System.out.println(canvas.getBoundsInParent());
    }

    public void handleCanvasClick(MouseEvent event){
        //drawCanvas(event);
        System.out.println("test 1");
        gc.setFill(Color.PINK);
        gc.fillRect(100, 100, 100, 100);
    }

    @FXML private void drawCanvas(ActionEvent event) {
        System.out.println("test 2");
        gc.setFill(Color.BLUE);
        gc.fillRect(100, 100, 100, 100);
    }*/

}

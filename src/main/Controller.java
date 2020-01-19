package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Canvas canvas;
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
    }

}

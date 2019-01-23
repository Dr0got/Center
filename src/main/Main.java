package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import model.Model;
import view.MainViewer;

public class Main extends Application {

    Settings settings;

    @Override
    public void start(Stage primaryStage) throws Exception{
        settings = Settings.getSettings();

        HBox root = new HBox();

        Canvas canvas = new Canvas();
        canvas.setHeight(settings.defaultWindowHeight);
        canvas.setWidth(settings.defaultWindowWidth);

        /*ctx.strokeArc(300, 300, 200, 200, 0, 270, ArcType.OPEN);
        ctx.strokeArc(275, 275, 250, 250, 0, 270, ArcType.OPEN);*/

        root.getChildren().add(canvas);
        primaryStage.setTitle("Center");
        primaryStage.setScene(new Scene(root, settings.defaultWindowWidth, settings.defaultWindowHeight));
        primaryStage.show();

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        Model model = new Model(settings);
        MainViewer mv = new MainViewer(settings, ctx);
        mv.drawStart();
        mv.drawModel(model);
    }


    public static void main(String[] args) {
        //setSettings();
        launch(args);
    }

    private static void setSettings(){
        main.Settings settings = new main.Settings();

        settings.defaultWindowWidth = 600;
        settings.defaultWindowHeight = 600;

        settings.xCenter = 300;
        settings.yCenter = 300;

        settings.ringWidth = 50;
        settings.startRadius = 100;

        settings.part = 0.33;
        settings.setSettings();

        System.exit(0);
    }
}

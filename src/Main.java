import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();

        Canvas canvas = new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(600);

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.strokeArc(300, 300, 200, 200, 0, 270, ArcType.OPEN);

        root.getChildren().add(canvas);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package Main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class KochSnowflakeFX extends Application {

    @Override
    public void start(Stage s) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.WHITE);

        double startX = 400;
        double startY = 10;
        double endX = 200;
        double endY = 780;

        drawKochSnowflake(root, 3, startX, startY, endX, endY);

        s.setTitle("Koch Snowflake");
        s.setScene(scene);
        s.show();
    }

    private void drawKochSnowflake(Group group, int depth, double x1, double y1, double x2, double y2) {
        if (depth == 0) {
            group.getChildren().add(new Line(x1, y1, x2, y2));
        } else {
            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            double xC = x1 + deltaX / 3;
            double yC = y1 + deltaY / 3;
            double xD = x1 + 2 * deltaX / 3;
            double yD = y1 + 2 * deltaY / 3;
            double angle = Math.PI/3; //given
            double xE = xC + (xD - xC) * Math.cos(angle) - (yD - yC) * Math.sin(angle);
            double yE = yC + (xD - xC) * Math.sin(angle) + (yD - yC) * Math.cos(angle);
            drawKochSnowflake(group, depth - 1, x1, y1, xC, yC);
            drawKochSnowflake(group, depth - 1, xC, yC, xE, yE);
            drawKochSnowflake(group, depth - 1, xE, yE, xD, yD);
            drawKochSnowflake(group, depth - 1, xD, yD, x2, y2);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
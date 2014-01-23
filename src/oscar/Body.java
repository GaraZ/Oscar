package oscar;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

/**
 *
 * @author Garaz
 */
public class Body extends Circle {
    
    private double startX, startY, endX, endY;
    private Point2D startPoint, endPoint;
    
    public Body(final Color color, int radius) {
        super(radius, new RadialGradient(0, 0, 0.2, 0.3, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
            new Stop(0, Color.rgb(250,250,255)),
            new Stop(1, color)
        }));
        
        setEffect(new InnerShadow(7, color.darker().darker()));
        setCursor(Cursor.HAND);
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                setFill(new RadialGradient(0, 0, 0.2, 0.3, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
                    new Stop(0, Color.rgb(250,250,255)),
                    new Stop(1, Color.BLUE)
                }));
            }
        });
        
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                setFill(new RadialGradient(0, 0, 0.2, 0.3, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
                    new Stop(0, Color.rgb(250,250,255)),
                    new Stop(1, color)
                }));
            }
        });
        
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                double dragX = me.getSceneX() - startPoint.getX();
                double dragY = me.getSceneY() - startPoint.getY();
                //calculate new position of the circle
                double newXPosition = startX + dragX;
                double newYPosition = startY + dragY;
                setTranslateX(newXPosition);
                setTranslateY(newYPosition);
            }
        });
        
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                startX = getTranslateX();
                startY = getTranslateY();
                startPoint = new Point2D(me.getSceneX(), me.getSceneY());
            }
        });
        
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                endX = getTranslateX();
                endY = getTranslateY();
                endPoint = new Point2D(me.getSceneX(), me.getSceneY());
            }
        });
    }
}

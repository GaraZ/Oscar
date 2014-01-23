package oscar;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author GaraZ
 */
public class Human extends Group {
    private Body head, chest, pelvis, rigthElbow, leftElbow, rightPalm, leftPalm, 
            rightKnee, leftKnee, rightFoot, leftFoot;
    
    static final Duration duration = Duration.millis(2000);
    static final int CYRCLE_COUNT = 10;
    
    public Human() {
        super();
        
        head = new Body(Color.YELLOWGREEN, 20);
        head.setTranslateX(0);
        head.setTranslateY(-70);
        getChildren().add(head);
        
        chest = new Body(Color.YELLOWGREEN, 30);
        chest.setTranslateX(0);
        chest.setTranslateY(-20);
        getChildren().add(chest);
        
        pelvis = new Body(Color.YELLOWGREEN, 20);
        pelvis.setTranslateX(0);
        pelvis.setTranslateY(30);
        getChildren().add(pelvis);
        
        rigthElbow  = new Body(Color.YELLOWGREEN, 10);
        rigthElbow.setTranslateX(-40);
        rigthElbow.setTranslateY(-15);
        getChildren().add(rigthElbow);
        
        leftElbow  = new Body(Color.YELLOWGREEN, 10);
        leftElbow.setTranslateX(40);
        leftElbow.setTranslateY(-15);
        getChildren().add(leftElbow);
        
        rightPalm  = new Body(Color.RED, 10);
        rightPalm.setTranslateX(-40);
        rightPalm.setTranslateY(40);
        getChildren().add(rightPalm);
        
        leftPalm  = new Body(Color.RED, 10);
        leftPalm.setTranslateX(40);
        leftPalm.setTranslateY(40);
        getChildren().add(leftPalm);
        
        rightKnee  = new Body(Color.YELLOWGREEN, 10);
        rightKnee.setTranslateX(-20);
        rightKnee.setTranslateY(80);
        getChildren().add(rightKnee);
        
        leftKnee  = new Body(Color.YELLOWGREEN, 10);
        leftKnee.setTranslateX(20);
        leftKnee.setTranslateY(80);
        getChildren().add(leftKnee);
        
        rightFoot  = new Body(Color.BROWN, 10);
        rightFoot.setTranslateX(-20);
        rightFoot.setTranslateY(130);
        getChildren().add(rightFoot);
        
        leftFoot  = new Body(Color.BROWN, 10);
        leftFoot.setTranslateX(20);
        leftFoot.setTranslateY(130);
        getChildren().add(leftFoot);
        
        dance();

    }
    
    TranslateTransition movement(int cycleCount, boolean revers, double oldX, double newX) {
        TranslateTransition tt = new TranslateTransition(duration);
        tt.setFromX(oldX);
        tt.setToX(oldX + newX);
        tt.setCycleCount(cycleCount);
        tt.setAutoReverse(revers);
        return tt;
    }
    
    TranslateTransition movement(int cycleCount, boolean revers, double oldX, double newX,
            double oldY, double newY) {
        TranslateTransition tt = new TranslateTransition(duration);
        tt.setFromX(oldX);
        tt.setToX(oldX + newX);
        tt.setFromY(oldY);
        tt.setToY(oldY + newY);
        tt.setCycleCount(cycleCount);
        tt.setAutoReverse(revers);
        return tt;
    }
    
    ScaleTransition resize(int cycleCount, boolean revers, double byX, double byY) {
        ScaleTransition stRightFoot = new ScaleTransition(duration);
        stRightFoot.setByX(byX);
        stRightFoot.setByY(byY);
        stRightFoot.setCycleCount(cycleCount);
        stRightFoot.setAutoReverse(revers);
        return stRightFoot;
    }
    
    void dance() {
        SequentialTransition seqTHead = new SequentialTransition (head, 
                movement(CYRCLE_COUNT, true, head.getTranslateX(), -10));
        seqTHead.play();
        ParallelTransition seqTChest = new ParallelTransition (chest, 
                movement(CYRCLE_COUNT, true, chest.getTranslateX(), -3),
                resize(CYRCLE_COUNT, true, 0.1, 0.1));
        seqTChest.play();
        
        SequentialTransition seqTPelvis = new SequentialTransition (pelvis, 
                movement(CYRCLE_COUNT, true, pelvis.getTranslateX(), -3, pelvis.getTranslateY(), 3));
        seqTPelvis.play();
        
        SequentialTransition seqTRigthElbow = new SequentialTransition (rigthElbow,
                movement(1, false, rigthElbow.getTranslateX(), -5, rigthElbow.getTranslateY(), -10),
                new ParallelTransition(
                    movement(CYRCLE_COUNT - 1, true, rigthElbow.getTranslateX() - 5, -5),
                    resize(CYRCLE_COUNT - 1, true, 0.1, 0.1))
                );
        seqTRigthElbow.play();
        
        SequentialTransition seqTRightPalm = new SequentialTransition (rightPalm,
                movement(1, false, rightPalm.getTranslateX(), -20, rightPalm.getTranslateY(), -120),
                new ParallelTransition(
                    movement(CYRCLE_COUNT - 1, true, rightPalm.getTranslateX() - 20, -30),
                    resize(CYRCLE_COUNT - 1, true, 0.2, 0.2)));
        seqTRightPalm.play();
        
        SequentialTransition seqTLeftElbow = new SequentialTransition (leftElbow,
                movement(1, false, leftElbow.getTranslateX(), -5, leftElbow.getTranslateY(), -10),
                new ParallelTransition(
                    movement(CYRCLE_COUNT - 1, true, leftElbow.getTranslateX() - 5, -5),
                    resize(CYRCLE_COUNT - 1, true, 0.1, 0.1)
                ));
        seqTLeftElbow.play();
        
        SequentialTransition seqTLeftPalm = new SequentialTransition (leftPalm,
                movement(1, false, leftPalm.getTranslateX(), -20, leftPalm.getTranslateY(), -120),
                new ParallelTransition(
                    movement(CYRCLE_COUNT - 1, true, leftPalm.getTranslateX() - 20, -30),
                    resize(CYRCLE_COUNT - 1, true, 0.2, 0.2)
                ));
        seqTLeftPalm.play();
        
        SequentialTransition seqTRightKnee = new SequentialTransition (rightKnee,
                movement(CYRCLE_COUNT, true, rightKnee.getTranslateX(), -10, rightKnee.getTranslateY(), -10));
        seqTRightKnee.play();
        
        SequentialTransition seqTRightFoot = new SequentialTransition (rightFoot,
                movement(CYRCLE_COUNT, true, rightFoot.getTranslateX(), -20, rightFoot.getTranslateY(), -20));
        seqTRightFoot.play();
    }
}

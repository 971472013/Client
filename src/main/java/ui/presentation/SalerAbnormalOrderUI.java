package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.PromotionController;

/**
 * Created by 婧婧 on 2016/11/30.
 */
public class SalerAbnormalOrderUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SalerAbnormalOrder.fxml"));
        PromotionController.setPrimaryStage(primaryStage);
        PromotionController.setRoot(root);
        Scene myScene = new Scene(root,1180,660);
        primaryStage.setX(450);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}

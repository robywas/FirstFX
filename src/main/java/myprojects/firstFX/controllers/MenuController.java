package myprojects.firstFX.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    private MainController mainController;

    @FXML
    public void openApplication() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppController appController = loader.getController();
        appController.setMainController(mainController);
        mainController.setScreen(pane);

    }

    @FXML
    public void options() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/OptionScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OptionController optionController = loader.getController();
        optionController.setMainController(mainController);
        mainController.setScreen(pane);

    }

    @FXML
    public void exit() {
        Platform.exit();

    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

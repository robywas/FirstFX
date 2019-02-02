package myprojects.firstFX.controllers;

import javafx.event.ActionEvent;

public class AppController {

    MainController mainController;



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void backMenu() {
        mainController.loadMenuScreen();
    }
}

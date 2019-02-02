package myprojects.firstFX.controllers;

public class OptionController {

    private MainController mainController;

    public void backMenu() {

        mainController.loadMenuScreen();

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

package myprojects.firstFX.examples;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class BindingController {

    @FXML
    private TextField nameTextField;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Label surnameLabel;
    @FXML
    private TextField yearTextField;
    @FXML
    private CheckBox confirmCheckBox;

    @FXML
    private Button loginButton;
    @FXML
    private Label ageLabel;

    private PersonViewModel personViewModel = new PersonViewModel();

    @FXML
    public void initialize() {

        nameTextField.textProperty().bindBidirectional(personViewModel.getNameProperty());
        nameLabel.visibleProperty().bindBidirectional(personViewModel.getNameOkProperty());
        surnameTextField.textProperty().bindBidirectional(personViewModel.getSurnameProperty());
        surnameLabel.visibleProperty().bindBidirectional(personViewModel.getSurnameOkProperty());
        surnameTextField.disableProperty().bindBidirectional(personViewModel.getDisableSurnameProperty());
        confirmCheckBox.selectedProperty().bindBidirectional(personViewModel.getConfirmProperty());
        ageLabel.textProperty().bindBidirectional(personViewModel.getAgeProperty());

        loginButton.disableProperty().bind(personViewModel.getButtonProperty());

        StringConverter converter = new NumberStringConverter();
        yearTextField.textProperty().bindBidirectional(personViewModel.getYearProperty(), converter);



    }

}

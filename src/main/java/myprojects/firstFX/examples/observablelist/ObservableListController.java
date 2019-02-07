package myprojects.firstFX.examples.observablelist;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ObservableListController {

    @FXML
    private ComboBox<Person> comboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;


    private ObservableList<Person> personList;
    private ListProperty<Person> listProperty;
    private Person person;

    @FXML
    public void initialize() {
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("John", "Rambo"));
        arrayList.add(new Person("James", "Bond"));
        arrayList.add(new Person("Indiana", "Jones"));
        arrayList.add(new Person("Robin", "Hood"));

        listProperty = new SimpleListProperty<>();
        personList = FXCollections.observableArrayList(arrayList);
        listProperty.set(personList);

        comboBox.itemsProperty().bindBidirectional(listProperty);
        personList.addListener(this::onChanged);

    }


    public void addPerson() {
        person = new Person(nameTextField.getText(), surnameTextField.getText());
        personList.add(person);
        System.out.println(personList);
    }

    public void deletePerson() {
        Person person = comboBox.getSelectionModel().getSelectedItem();
        personList.remove(person);
        System.out.println(personList);

    }

    private void onChanged(Change change) {
        while (change.next()) {
            if (change.wasRemoved())
                System.out.println("Coś usunięto");
            else if (change.wasAdded())
                System.out.println("Coś dodano");
        }

    }
}

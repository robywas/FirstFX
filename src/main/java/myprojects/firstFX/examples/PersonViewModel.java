package myprojects.firstFX.examples ;


import javafx.beans.binding.When;
import javafx.beans.property.*;

import java.time.LocalDate;

public class PersonViewModel {


    //textfield name
    private StringProperty nameProperty = new SimpleStringProperty();
    //label OK name
    private BooleanProperty nameOkProperty = new SimpleBooleanProperty(false);

    //textfield surname
    private StringProperty surnameProperty = new SimpleStringProperty();
    //label OK surname
    private BooleanProperty surnameOkProperty = new SimpleBooleanProperty(false);
    // on/off surname field
    private BooleanProperty disableSurnameProperty = new SimpleBooleanProperty(false);
    //textfield year of birth
    private IntegerProperty yearProperty = new SimpleIntegerProperty();
    // confirm CheckBox
    private BooleanProperty confirmProperty = new SimpleBooleanProperty(false);
    //counted age value
    private StringProperty ageProperty = new SimpleStringProperty();
    //button
    private BooleanProperty buttonProperty = new SimpleBooleanProperty(false);
    //current year
    private IntegerProperty actualYearProperty = new SimpleIntegerProperty(LocalDate.now().getYear());


    public PersonViewModel() {
        nameOkProperty.bind(nameProperty.isNotEmpty());
        surnameOkProperty.bind(surnameProperty.isNotEmpty());
//        disableSurnameProperty.bind(nameProperty.isEmpty());
        buttonProperty.bind(confirmProperty.not());
        ageProperty.bind(new When(yearProperty.isNotEqualTo(0)).
                then(actualYearProperty.subtract(yearProperty).asString()).otherwise(""));

    }




    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public StringProperty getSurnameProperty() {
        return surnameProperty;
    }

    public BooleanProperty getDisableSurnameProperty() {
        return disableSurnameProperty;
    }

    public IntegerProperty getYearProperty() {
        return yearProperty;
    }

    public BooleanProperty getConfirmProperty() {
        return confirmProperty;
    }


    public StringProperty getAgeProperty() {
        return ageProperty;
    }

    public BooleanProperty getNameOkProperty() {
        return nameOkProperty;
    }

    public BooleanProperty getSurnameOkProperty() {
        return surnameOkProperty;
    }

    public BooleanProperty getButtonProperty() {
        return buttonProperty;
    }
}

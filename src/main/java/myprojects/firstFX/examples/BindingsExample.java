package myprojects.firstFX.examples;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingsExample {

    public static void main(String[] args) {
        bindings();

    }

    public static void bindings() {
        DoubleProperty a = new SimpleDoubleProperty(3.0);
        IntegerProperty b = new SimpleIntegerProperty(4);


        System.out.println("DZIAŁANIA LICZBOWE");

        NumberBinding resultAdd = a.add(b);
        System.out.println("Wynik dodawania to " + resultAdd.intValue());

        DoubleBinding resultDiv = a.divide(b);
        System.out.println("Wynik dzielenia to " + resultDiv.doubleValue());

        NumberBinding resultSub = a.subtract(b);
        System.out.println("Wynik odejmowania to " + resultSub.intValue());

        NumberBinding resultMultiply = a.multiply(b);
        System.out.println("Wynik mnożenia to " + resultMultiply.intValue());

        NumberBinding negate = a.negate();
        System.out.println("Negacja liczby A: " + negate.intValue());

    }



}

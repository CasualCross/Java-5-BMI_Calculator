package main.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller
{
    @FXML
    private TextField bmiValue;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField categoryValue;

    @FXML
    private Button clearButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField heightValue;

    @FXML
    private TextField weightValue;

    @FXML
    private AnchorPane windowGeneral;

    private void clearFields()
    {
        heightValue.clear();
        weightValue.clear();
        bmiValue.clear();
        categoryValue.clear();
    }

    private void calculateBMI()
    {
        try
        {
            double height = Double.parseDouble(heightValue.getText()) / 100;
            double weight = Double.parseDouble(weightValue.getText());
            double bmi = weight / (height * height);
            bmiValue.setText(String.format("%.2f", bmi));

            if(bmi < 18.5)
            {
                categoryValue.setText("Underweight");
            }
            else if(bmi >= 18.5 && bmi < 24.9)
            {
                categoryValue.setText("Normal");
            }
            else if(bmi >= 25 && bmi < 29.9)
            {
                categoryValue.setText("Overweight");
            }
            else
            {
                categoryValue.setText("Obese");
            }
        }
        catch (NumberFormatException e)
        {
            bmiValue.setText("Invalid Input");
            categoryValue.setText("Invalid Input");
        }
    }

    @FXML
    void initialize()
    {
        calculateButton.setOnAction(event -> calculateBMI());
        clearButton.setOnAction(event -> clearFields());
        exitButton.setOnAction(event -> javafx.application.Platform.exit());
    }
}
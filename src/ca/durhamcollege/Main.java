/*  Names: Jordan Wriker, Ahmed Rizvi
    Date: December 18, 2020
    Course: OOP3200
    Assignment: Java Lab 5
* */

package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    // Sey height and width attributes
    public static int WIDTH = 650;
    public static int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Java Lab 5");

        // Set height and width of the primary stage as well as min and max of each
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMinWidth(WIDTH);

        // create all label controls
        Label weightLabel = new Label("   My Weight: ");
        Label heightLabel = new Label("   My Height: ");
        Label poundsLabel = new Label("/lbs");
        Label inchesLabel = new Label("/inches");
        Label bmiLabel = new Label("      My BMI: ");
        Label bmiStringLabel = new Label("");

        // create all text field controls
        TextField weightInput = new TextField();
        TextField heightInput = new TextField();
        TextField bmiOutput = new TextField();

        // create button control
        Button calculateBMI = new Button("Calculate BMI");

        // make bmi output
        bmiOutput.setEditable(false);

        // create font setting
        Font font = Font.font("Consolas", FontWeight.NORMAL, 20);

        // set font attribute of controls
        weightLabel.setFont(font);
        heightLabel.setFont(font);
        poundsLabel.setFont(font);
        inchesLabel.setFont(font);
        bmiLabel.setFont(font);
        bmiStringLabel.setFont(font);
        calculateBMI.setFont(font);

        // calculate button event handler
        calculateBMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean isValid = true;
                double bmi;
                String bmiString;
                String bmiOut;
                String bmiResult = "";

                // check if height and weight are empty
                if(heightInput.getText() == null || heightInput.getText().trim().isEmpty())
                {
                    bmiStringLabel.setText("You must enter a height. Please try again.");
                    isValid = false;
                }
                else if(weightInput.getText() == null || weightInput.getText().trim().isEmpty())
                {
                    bmiStringLabel.setText("You must enter a weight. Please try again.");
                    isValid = false;
                }

                // if height and weight are valid calculate bmi
                if (isValid == true)
                {
                    bmi = (Double.parseDouble(weightInput.getText()) * 703) /
                            (Double.parseDouble(heightInput.getText()) * Double.parseDouble(heightInput.getText()));
                    bmiString = String.format("%.1f", bmi);
                    bmiOut = String.format("With a bmi of %.1f you are considered ", bmi);

                    // give bmi result based on calculation
                    if (bmi < 18.5)
                    {
                        bmiResult = "Underweight.";
                    }
                    else if (bmi >= 18.5 && bmi <= 24.9)
                    {
                        bmiResult = "Normal.";
                    }
                    else if (bmi >= 25 && bmi <= 29.9)
                    {
                        bmiResult = "Overweight.";
                    }
                    else if(bmi > 30)
                    {
                        bmiResult = "Obese.";
                    }

                    // out put bmi info to appropriate controls
                    bmiOutput.setText(bmiString);
                    bmiStringLabel.setText(bmiOut + bmiResult);
                }
            }
        });

        // create a new grid pane
        GridPane pane = new GridPane();
        // set grid pane horizontal gap
        pane.setHgap(10);
        // set grid pane vertical gap
        pane.setVgap(10);
        // set grid pane padding
        pane.setPadding(new Insets(10));

        // add all controls to the gird pane
        pane.add(heightLabel, 1, 13);
        pane.add(weightLabel, 1, 14);
        pane.add(bmiLabel, 1 , 15);
        pane.add(inchesLabel, 3, 13);
        pane.add(poundsLabel, 3, 14);
        pane.add(heightInput, 2, 13);
        pane.add(weightInput, 2, 14);
        pane.add(bmiOutput, 2, 15);
        // need to figure our row span
        pane.add(calculateBMI, 1, 17, 3, 1);
        pane.add(bmiStringLabel, 1 ,19, 3, 1);

        // create new scene, add gird pane, and set height and width;
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        // set the primary stage scene
        primaryStage.setScene(scene);
        // show the primary stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
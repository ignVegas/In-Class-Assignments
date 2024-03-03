package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public
 
class TipCalculatorGUI extends Application {
    private TextField billAmountTextField;
    private Slider taxSlider;
    private Slider tipSlider;
    private Label totalAmountLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");

        // Create text field for bill amount
        billAmountTextField = new TextField();
        billAmountTextField.setPromptText("Enter bill amount");
        billAmountTextField.setOnAction(this::calculateTotalAmount);

        // Create slider for tax percentage
        taxSlider = new Slider(40, 70, 46);
        taxSlider.setLabel("Tax Percentage:");
        taxSlider.valueProperty().addListener((observable, oldValue, newValue) -> calculateTotalAmount());

        // Create slider for tip percentage
        tipSlider = new Slider(0, 30, 0);
        tipSlider.setLabel("Tip Percentage:");
        tipSlider.valueProperty().addListener((observable, oldValue, newValue) -> calculateTotalAmount());

        // Create label for total amount
        totalAmountLabel = new Label("$0.00");

        // Create grid pane for layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        // Add components to grid pane
        gridPane.add(new Label("Bill Amount:"), 0, 0);
        gridPane.add(billAmountTextField, 1, 0);

        gridPane.add(taxSlider, 0, 1);
        gridPane.add(tipSlider, 1, 1);

        gridPane.add(totalAmountLabel, 0, 2, 2, 1);

        // Create scene and set content
        Scene scene = new Scene(gridPane, 400, 200);

        // Set stage properties and show
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateTotalAmount() {
        try {
            double billAmount = Double.parseDouble(billAmountTextField.getText());
            double taxPercentage = taxSlider.getValue() / 100; // Convert to percentage
            double tipPercentage = tipSlider.getValue() / 100; // Convert to percentage

            double taxAmount = billAmount * taxPercentage;
            double tipAmount = billAmount * tipPercentage;
            double totalAmount = billAmount + taxAmount + tipAmount;

            totalAmountLabel.setText(String.format("$%.2f", totalAmount));
        } catch (NumberFormatException e) {
            totalAmountLabel.setText("$0.00");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
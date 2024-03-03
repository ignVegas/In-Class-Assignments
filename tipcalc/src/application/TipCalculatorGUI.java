package application;

import javafx.*;

public
 
class TipCalculatorGUI extends Application {
    private TextField billAmountTextField;
    private Slider taxSlider;
    private Slider tipSlider;
    private Label totalAmountLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");
        billAmountTextField = new TextField();
        billAmountTextField.setPromptText("Enter bill amount");
        billAmountTextField.setOnAction(this::calculateTotalAmount);

        taxSlider = new Slider(40, 70, 46);
        taxSlider.setLabel("Tax Percentage:");
        taxSlider.valueProperty().addListener((observable, oldValue, newValue) -> calculateTotalAmount()); // update amounts

      
        tipSlider = new Slider(0, 30, 0);
        tipSlider.setLabel("Tip Percentage:");
        tipSlider.valueProperty().addListener((observable, oldValue, newValue) -> calculateTotalAmount()); // update amounts
        totalAmountLabel = new Label("$0.00");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(10);
        gridPane.add(new Label("Bill Amount:"), 0, 0);
        gridPane.add(billAmountTextField, 1, 0);
        gridPane.add(taxSlider, 0, 1);
        gridPane.add(tipSlider, 1, 1);
        gridPane.add(totalAmountLabel, 0, 2, 2, 1);
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateTotalAmount() 
    {
        try
        {
            double billAmount = Double.parseDouble(billAmountTextField.getText());
            double taxPercentage = taxSlider.getValue() / 100;
            double tipPercentage = tipSlider.getValue() / 100;
            double taxAmount = billAmount * taxPercentage;
            double tipAmount = billAmount * tipPercentage;
            double totalAmount = billAmount + taxAmount + tipAmount;
            totalAmountLabel.setText(String.format("$%.2f", totalAmount));
        } 
        catch (NumberFormatException e)
        {
            totalAmountLabel.setText("$0.00");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
package contactApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContactsApp extends Application {
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        contacts.addAll(
                new Contact("Vegas", "Mantsch", "mantv26@uwgb.edu", "123-456-7890", "12/26/2003", new Image("/image/image.jpg")),
                new Contact("Gabe", "Ortega", "ortega@google.com", "123-456-7890", "01/01/1000", new Image("/image/image.jpg"))
        );

        FXCollections.sort(contacts);

        ListView<Contact> listView = new ListView<>(contacts);
        listView.setCellFactory(param -> new ContactListCell());
        GridPane contactDetailsGrid = new GridPane();
        contactDetailsGrid.setHgap(10);
        contactDetailsGrid.setVgap(5);
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextField dobField = new TextField();
        ImageView imageView = new ImageView();
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                firstNameField.setText(newValue.getFirstName());
                lastNameField.setText(newValue.getLastName());
                emailField.setText(newValue.getEmail());
                phoneField.setText(newValue.getPhoneNumber());
                dobField.setText(newValue.getDateOfBirth());
                imageView.setImage(newValue.getImage());
            }
        });
        contactDetailsGrid.addRow(0, firstNameField, lastNameField, emailField);
        contactDetailsGrid.addRow(1, phoneField, dobField, imageView);
        Scene scene = new Scene(new javafx.scene.layout.HBox(listView, contactDetailsGrid), 800, 600);
        primaryStage.setTitle("Contacts App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class ContactListCell extends javafx.scene.control.ListCell<Contact> {
        @Override
        protected void updateItem(Contact contact, boolean empty) {
            super.updateItem(contact, empty);

            if (empty || contact == null) {
                setText(null);
            } else {
                setText(contact.getFirstName() + " " + contact.getLastName());
            }
        }
    }
}

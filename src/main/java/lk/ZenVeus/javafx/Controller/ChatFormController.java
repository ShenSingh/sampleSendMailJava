package lk.ZenVeus.javafx.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ZenVeus.javafx.smtp.Mail;

public class ChatFormController {
    public TextField subject;
    public TextField to;
    public TextArea massage;




    public void subjectFieldOnAction(ActionEvent actionEvent) {
        massage.requestFocus(); // This is focus the massage field if subject is valid
    }

    public void toFieldOnAction(ActionEvent actionEvent) {
        boolean isValid = checkValidEmail(); // This method is check the email is valid or not

        if (isValid) {
            to.setStyle("-fx-border-color: #3BC688"); // This is change the border color to black if email is valid

            subject.requestFocus(); // This is focus the subject field if email is valid
        }
    }

    public void sendBtn(ActionEvent actionEvent) {
        boolean isEmpty = checkEmpty(); // This is check the fields are empty or not

        if (isEmpty) {
            new Alert(Alert.AlertType.CONFIRMATION, "Mail Send Successfully").show(); // This is show the confirmation message if mail send successfully

            String newTo = to.getText();
            String newSubject = subject.getText();
            String newMassage = massage.getText();

            Mail mail = new Mail();

            mail.setTo(newTo); // This is set the new email
            mail.setSubject(newSubject); // This is set the new subject
            mail.setMsg(newMassage); // This is set the new massage

            mail.run(); // This is run the mail
        }
    }

    private boolean checkEmpty() {
        if (!to.getText().isEmpty() && !subject.getText().isEmpty() && !massage.getText().isEmpty()) { // This is check the fields are empty or not
            boolean isValid = checkValidEmail(); // This method is check the email is valid or not

            if (isValid) {
                to.setStyle("-fx-border-color: #3BC688"); // This is change the border color to black if email is valid

                return true; // This is return true if fields are not empty
            }
        } else {

            new Alert(Alert.AlertType.ERROR, "Fields are Empty").show(); // This is show the error message if fields are empty
            if (to.getText().isEmpty()) {
                to.setStyle("-fx-border-color: red"); // This is change the border color to red if email is empty
            }
            if (subject.getText().isEmpty()) {
                subject.setStyle("-fx-border-color: red"); // This is change the border color to red if subject is empty
            }
            if (massage.getText().isEmpty()) {
                massage.setStyle("-fx-border-color: red"); // This is change the border color to red if massage is empty
            }

        }
        return false; // This is return false if fields are empty
    }

    private boolean checkValidEmail() {

        if (!to.getText().isEmpty()) { // This is check the email is empty or not
            String email = to.getText();
            if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) { // This is check the email is valid or not.
                // regex is ""^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$""

                return true; // This is return true if email is valid

            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Email").show(); // This is show the error message if email is invalid
                to.setStyle("-fx-border-color: red"); // This is change the border color to red if email is invalid
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Email is Empty").show(); // This is show the error message if emai// l is empty
            to.setStyle("-fx-border-color: red"); // This is change the border color to red if email is empty
        }
        return false; // This is return false if email is invalid
    }
}

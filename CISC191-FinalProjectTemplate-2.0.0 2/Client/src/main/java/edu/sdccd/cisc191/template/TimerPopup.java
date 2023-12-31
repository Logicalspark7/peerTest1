package edu.sdccd.cisc191.template;

import javafx.animation.KeyFrame;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.util.Duration;

public class TimerPopup extends Popup {

    private TextField inputTimerMinutes = new TextField();
    private AppLabel minutesAdd = new AppLabel();
    private AppButton timerSubmit = new AppButton();
    private Time time = new Time();
    private int secondsTotal;

    /** Converts user input in minutes to seconds. If there is no input, return 1 second.
     * @param inputTimerMinutes textfield that holds how many minutes user wants timer to run
     * @return seconds in total for timer to run
     */
    public int getSecondsTotal(TextField inputTimerMinutes) {
        try {
            if (inputTimerMinutes.getText().equals("")) {
                secondsTotal = 1;
            } else {
                time.setSecondsTotal(Integer.parseInt(inputTimerMinutes.getText()));
                secondsTotal = time.getSecondsTotal();
            }
        }catch (NumberFormatException e) {
            // Handle non-numeric input gracefully, show an alert, for example
            showErrorAlert("Invalid Input", "Please enter a valid numeric value for minutes.");
            secondsTotal = 1;
        }
        return secondsTotal;

    }

    /**
     * Sets contents and style of timer popup
     * @param inputTimerMinutes for user to input minutes to set timer
     * @return HBox that contains popup contents
     */
    public VBox getTimerAdding(TextField inputTimerMinutes, AppButton timerSubmit) {
        minutesAdd.setText("Minutes: ");
        timerSubmit.setText("Start Timer");
        HBox timerHBox = new HBox(5, minutesAdd, inputTimerMinutes);
        VBox timerAdding = new VBox(5, timerHBox, timerSubmit);
        timerAdding.setStyle("-fx-background-color: #F5F2E3; -fx-border-color: #E6C8EC;-fx-border-width:5");
        timerAdding.setPadding(new Insets(10));
        return timerAdding;
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

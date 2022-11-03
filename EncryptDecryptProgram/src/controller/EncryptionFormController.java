package controller;

import algorithms.EncryptionMethods;
import dialog.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class EncryptionFormController implements Initializable {
    @FXML private TextArea textAreaBox1;
    @FXML private TextArea textAreaBox2;
    @FXML private ChoiceBox algorithmsChoiceBox;
    @FXML private Button encryptButton;
    @FXML private Button decryptButton;
    @FXML private Button clearButton;
    List<String> encryptionAlgorithms = new ArrayList<String>();

    public void encryptButtonClicked(ActionEvent actionEvent) {
        String messageToEncrypt = textAreaBox1.getText();

        if(messageToEncrypt.isEmpty()){
            Dialogs.informationAlert("Information", "Information Alert", "Please enter text in the encrypt text area.");
        }else{
            try{
                if(algorithmsChoiceBox.getValue().equals("ROT1")){
                    textAreaBox2.setText(EncryptionMethods.rot1Encrypt(messageToEncrypt));
                }
                else if(algorithmsChoiceBox.getValue().equals("ROT13")){
                    textAreaBox2.setText(EncryptionMethods.rot13(messageToEncrypt));
                }
                else if(algorithmsChoiceBox.getValue().equals("Caesar Cipher")){
                    textAreaBox2.setText(EncryptionMethods.caesarCipherEncryptMethod(messageToEncrypt));
                }

            }catch(Exception exception){
                System.out.println(exception.fillInStackTrace());
            }
        }
    }

    public void decryptButtonClicked(ActionEvent actionEvent) {
        String messageToDecrypt = textAreaBox1.getText();

        if(messageToDecrypt.isEmpty()){
            Dialogs.informationAlert("Information", "Information Alert","You should write text in the above field.");
        }else{
            try{
                if(algorithmsChoiceBox.getValue().equals("ROT1")){
                    textAreaBox2.setText(EncryptionMethods.rot1Decrypt(messageToDecrypt));
                }
                else if(algorithmsChoiceBox.getValue().equals("ROT13")){
                    textAreaBox2.setText(EncryptionMethods.rot13(messageToDecrypt));
                }
                else if(algorithmsChoiceBox.getValue().equals("Caesar Cipher")){
                    textAreaBox2.setText(EncryptionMethods.caesarCipherDecryptMethod(messageToDecrypt));
                }
            }catch(Exception ex){
                System.out.println(ex.fillInStackTrace());
            }
        }
    }

    public void clearButtonClicked(ActionEvent actionEvent) {
        textAreaBox1.clear();
        textAreaBox2.clear();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        encryptionAlgorithms.add("ROT1");
        encryptionAlgorithms.add("ROT13");
        encryptionAlgorithms.add("Caesar Cipher");
        algorithmsChoiceBox.getItems().addAll(encryptionAlgorithms);
        algorithmsChoiceBox.getSelectionModel().selectFirst();
    }

    public void aboutButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AboutPage.fxml")));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}

package com.mdg.cryptoconverter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import static com.mdg.cryptoconverter.util.CryptoUtils.decrypt;
import static com.mdg.cryptoconverter.util.CryptoUtils.encrypt;

public class ConverterController {
    @FXML
    private Label copiedAlertLabel;

    @FXML
    private TextArea textFieldToEncrypt;

    @FXML
    private TextArea encryptedTextField;

    @FXML
    private TextArea textFieldToDecrypt;

    @FXML
    private TextArea decryptedTextField;

    @FXML
    protected void onEncryptionButtonClick() {
        String encryptedText = encrypt(textFieldToEncrypt.getText());
        encryptedTextField.setText(encryptedText);
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onDecryptionButtonClick() {
        String decryptedText = decrypt(textFieldToDecrypt.getText());
        decryptedTextField.setText(decryptedText);
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onResetEncryptionButtonClick() {
        encryptedTextField.setText("");
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onResetDecryptionButtonClick() {
        decryptedTextField.setText("");
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onTextToBeEncryptedFieldFocused() {
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onTextToBeDecryptedFieldFocused() {
        copiedAlertLabel.setText("");
    }

    @FXML
    protected void onEncryptedTextFieldFocused() {
        copiedAlertLabel.setText("copied");
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(encryptedTextField.getText());
        clipboard.setContent(clipboardContent);
        encryptedTextField.selectAll();
    }

    @FXML
    protected void onDecryptedTextFieldFocused() {
        copiedAlertLabel.setText("copied");
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(decryptedTextField.getText());
        clipboard.setContent(clipboardContent);
        decryptedTextField.selectAll();
    }
}
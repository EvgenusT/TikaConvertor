import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {

    ObservableList<String> localizationList = FXCollections.observableArrayList("Windows-1251", "UTF-8", "UTF-16");

    @FXML
    public TextField TextForEncoding;
    @FXML
    public TextField TextResultEncoding;

    @FXML
    public TextField Id_encoding;

    @FXML
    public ChoiceBox listEncoding;

    @FXML
    public void initialize() {
        listEncoding.setValue("UTF-8");
        listEncoding.setItems(localizationList);
    }

    String forEncoding = "null";

    public Controller() throws UnsupportedEncodingException {
    }

    public void pressEncoding(ActionEvent actionEvent) throws IOException {
        if (!forEncoding.isEmpty()) {
            forEncoding = TextForEncoding.getText();
            String adresRes = listEncoding.getValue().toString();
            TextResultEncoding.setText(TikaMain.encodingText(forEncoding, adresRes));

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Поле тексту не заповнено!");
            alert.showAndWait();
        }
    }

    public void getEncoding(ActionEvent actionEvent) throws IOException {

        forEncoding = TextForEncoding.getText();
        String word = TikaMain.checkEncoding(forEncoding);
//        cutOff(word);
        Id_encoding.setText(cutOff(word));

    }

    public void clearText(ActionEvent actionEvent) {
        TextForEncoding.clear();
        TextResultEncoding.clear();
        Id_encoding.clear();
    }

    private String cutOff(String word) {
        String regs = "\\s\\d+$";
        String res = word.replace("Match of ", "");
        res = res.replace(" with confidence", "");

        Pattern ptrn = Pattern.compile(regs);
        Matcher matcher = ptrn.matcher(res);
        matcher.replaceAll("");


        return matcher.replaceAll("");
    }
}

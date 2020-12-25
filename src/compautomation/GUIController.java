package compautomation;

import Utility.DBConnection;
import controller.*;
import entity.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class GUIController implements Initializable {

    private ProductController pc;
    private IngredientController ingC;
    private ProductionController pnc;
    private NonArgeController naC;
    private ArgeController aC;
    private DBConnection db = new DBConnection() {
    };
    ;
    private int ind = 0;
    private List<Product> pList;
    private List<Ingredient> ingList;
    private List<NonArge> nonArList;
    private List<Arge> arList;
    String[] ingsList = new String[15];
    double[] amountList = new double[15];
    ObservableList ids = FXCollections.observableArrayList();
    ObservableList<String> unqCodes = FXCollections.observableArrayList();
    ObservableList names = FXCollections.observableArrayList();

    @FXML
    private Button btnIngToMenu;
    @FXML
    private Button btnProductToMenu;
    @FXML
    private Button btnProductionToMenu;
    @FXML
    private Button btnAccountingToMenu;
    @FXML
    private Button btnPnProductEntry;
    @FXML
    private Button btnPnIngredientEntry;
    @FXML
    private Button btnPnProductionEntry;
    @FXML
    private Button btnPnAccountingEntry;

    @FXML
    private Pane paneMain;
    @FXML
    private Pane paneProductEntry;
    @FXML
    private Pane paneIngredientEntry;
    @FXML
    private Pane paneProductionEntry;
    @FXML
    private Pane paneAccountingEntry;

    @FXML
    private TextField tfPName;
    @FXML
    private TextField tfPCategory;
    @FXML
    private TextField tfPBrand;
    @FXML
    private TextField tfPPiece;
    @FXML
    private TextField tfPPrice;
    @FXML
    private TextField tfPBarcode;
    @FXML
    private TextArea taPDescr;
    @FXML
    private Button btnPAdd;
    @FXML
    private ComboBox cboxPid;
    @FXML
    private TextArea taPUList;
    @FXML
    private Button btnPUYenile;
    @FXML
    private TextField tfPUpname;
    @FXML
    private TextField tfPUcategory;
    @FXML
    private TextField tfPUbarcode;
    @FXML
    private TextField tfPUprice;
    @FXML
    private Button btnPUpdate;
    @FXML
    private TextArea taIngUList;
    @FXML
    private Button btnIngUYenile;
    @FXML
    private TextField tfIngUnqCode;
    @FXML
    private TextField tfIngPieces;
    @FXML
    private TextField tfIngAmount;
    @FXML
    private Button btnIngAdd;
    @FXML
    private ComboBox cboxIngUnqcodes;
    @FXML
    private TextField tfIngUPieces;
    @FXML
    private TextField tfIngUAmount;
    @FXML
    private Button btnIngUDone;
    @FXML
    private TextArea taProPList;
    @FXML
    private TextArea taProIngList;
    @FXML
    private Button btnProYenile;
    @FXML
    private Button btnProDone;
    @FXML
    private Button btnProductionAdd;
    @FXML
    private ComboBox cboxProPnames;
    @FXML
    private ComboBox cboxProIngCodes;
    @FXML
    private TextField tfProPpieces;
    @FXML
    private TextField tfProIngAmoutn;
    @FXML
    private TextArea taNonArgeList;
    @FXML
    private TextArea taArgeList;
    @FXML
    private Button btnAccYenile;
    @FXML
    private Button btnNonArgeEnter;
    @FXML
    private Button btnArgeEnter;
    @FXML
    private ComboBox cboxNonArgeCat;
    @FXML
    private ComboBox cboxNonArgeMon;
    @FXML
    private TextField tfNonArgeInc;
    @FXML
    private TextField tfNonArgeExp;
    @FXML
    private ComboBox cboxArgeCat;
    @FXML
    private ComboBox cboxArgeMon;
    @FXML
    private TextField tfArgeInc;
    @FXML
    private TextField tfArgeExp;
    @FXML
    private TextField tfArgePN;
    @FXML
    private ComboBox cboxAccCatChc;
    @FXML
    private ComboBox cboxAccMonChc;
    @FXML
    private Button btnAccCatGet;
    @FXML
    private Button btnAccMonGet;

    public GUIController() {
        cboxPid = new ComboBox();
        cboxIngUnqcodes = new ComboBox();
        cboxProPnames = new ComboBox();
        cboxProIngCodes = new ComboBox();
        cboxNonArgeMon = new ComboBox();
        cboxArgeMon = new ComboBox();
        cboxAccCatChc = new ComboBox();
        cboxAccMonChc = new ComboBox();
        cboxNonArgeCat = new ComboBox();
        cboxArgeCat = new ComboBox();
        taPUList = new TextArea();
        taIngUList = new TextArea();
        taProPList = new TextArea();
        taProIngList = new TextArea();
        taArgeList = new TextArea();
        taNonArgeList = new TextArea();
    }

    @FXML
    private void toMain() {
        paneMain.toFront();
    }

    @FXML
    private void productEntrytoFront() {
        paneProductEntry.toFront();
    }

    @FXML
    private void ingredientEntrytoFront() {
        paneIngredientEntry.toFront();
    }

    @FXML
    private void productionEntrytoFront() {
        paneProductionEntry.toFront();
    }

    @FXML
    private void accountingEntrytoFront() {
        paneAccountingEntry.toFront();
    }

    private void populateCboxProduction() {
        cboxProPnames.setItems(names);
        cboxProIngCodes.setItems(unqCodes);
    }

    @FXML
    private void populateTextAreaUProduct() {
        taPUList.setText("");
        pList = new ArrayList<>();
        pc = new ProductController();
        pList = pc.read();
        int i = 0;
        while (i < pList.size()) {
            taPUList.appendText(pList.get(i).toString() + "\n");
            i++;
        }
        pList = null;
        pc = null;
    }

    @FXML
    private void populateTextAreaUIngredient() {
        taIngUList.setText("");
        ingList = new ArrayList<>();
        ingC = new IngredientController();
        ingList = ingC.read();
        int i = 0;
        while (i < ingList.size()) {
            taIngUList.appendText(ingList.get(i).toString() + "\n");
            i++;
        }
        ingList = null;
        ingC = null;
    }

    private void populateCboxIngredient() {
        String query = "select * from ingredient";
        try {
            PreparedStatement pst = db.connect().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                unqCodes.add(rs.getString("unqcode"));
            }
            cboxIngUnqcodes.setItems(unqCodes);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    private void populateCboxProProduct() {
        String query = "select * from product";
        try {
            PreparedStatement pst = db.connect().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("pname"));
            }
            cboxProPnames.setItems(names);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void populateProductionAreas() {
        taProPList.setText("");
        pList = new ArrayList<>();
        pc = new ProductController();
        pList = pc.read();
        int i = 0;
        while (i < pList.size()) {
            taProPList.appendText(pList.get(i).toString() + "\n");
            i++;
        }
        pList = null;
        pc = null;

        taProIngList.setText("");
        ingList = new ArrayList<>();
        ingC = new IngredientController();
        ingList = ingC.read();
        i = 0;
        while (i < ingList.size()) {
            taProIngList.appendText(ingList.get(i).toString() + "\n");
            i++;
        }
        ingList = null;
        ingC = null;
    }

    @FXML
    private void populateCboxProduct() {
        String query = "select * from product";
        try {
            PreparedStatement pst = db.connect().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ids.add(Integer.toString(rs.getInt("pid")));
            }
            cboxPid.setItems(ids);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void populateTextAreaAccounting() {
        taNonArgeList.setText("");
        taArgeList.setText("");
        aC = new ArgeController();
        naC = new NonArgeController();
        arList = new ArrayList<>();
        nonArList = new ArrayList<>();

        arList = aC.read();
        nonArList = naC.read();

        int i = 0;
        while (i < nonArList.size()) {
            taNonArgeList.appendText(nonArList.get(i).toString() + "\n");
            i++;
        }
        i = 0;
        while (i < arList.size()) {
            taArgeList.appendText(arList.get(i).toString() + "\n");
            i++;
        }

        aC = null;
        naC = null;
        arList = null;
        nonArList = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateCboxProduct();
        populateCboxIngredient();
        populateTextAreaUProduct();
        populateTextAreaUIngredient();
        populateProductionAreas();
        populateCboxProduction();
        populateCboxProProduct();
        populateTextAreaAccounting();
    }

    // ÜRÜN İŞLEMLERİ
    @FXML
    private void productAdd(ActionEvent event) {
        pc = new ProductController();
        pc.create(tfPName.getText(), tfPCategory.getText(), Double.parseDouble(tfPPrice.getText()),
                tfPBrand.getText(), tfPBarcode.getText(), Integer.parseInt(tfPPiece.getText()),
                taPDescr.getText());
        pc = null;
    }

    @FXML
    private void productUpdate(ActionEvent event) {
        pc = new ProductController();
        pc.update(Integer.parseInt(cboxPid.getSelectionModel().getSelectedItem().toString()),
                tfPUpname.getText(), tfPUcategory.getText(), tfPUbarcode.getText(),
                Double.parseDouble(tfPUprice.getText()));
        pc = null;
    }

    //HAMMADDE İŞLEMLERİ
    @FXML
    private void ingredientAdd() {
        ingC = new IngredientController();
        ingC.create(tfIngUnqCode.getText(), Integer.parseInt(tfIngPieces.getText()),
                Double.parseDouble(tfIngAmount.getText()));
        ingC = null;
    }

    @FXML
    private void ingredientUpdate() {
        ingC = new IngredientController();
        ingC.update(cboxIngUnqcodes.getSelectionModel().getSelectedItem().toString(),
                Integer.parseInt(tfIngUPieces.getText()), Double.parseDouble(tfIngUAmount.getText()));
    }

    //ÜRETİM İŞLEMLERİ
    @FXML
    private void production() {
        pnc = new ProductionController();

        pnc.create(ingsList, amountList, cboxProPnames.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(tfProPpieces.getText()));

        ind = 0;
        for (int i = 0; i < ingsList.length; i++) {
            ingsList[i] = "";
            amountList[i] = 0;
        }
    }

    @FXML
    private void productionAdd() {
        ingsList[ind] = cboxProIngCodes.getSelectionModel().getSelectedItem().toString();
        amountList[ind] = Double.parseDouble(tfProIngAmoutn.getText());
        ind++;
    }

    //MUHASEBE İŞLEMLERİ
    @FXML
    private void accountingNonArge() {
        naC = new NonArgeController();
        naC.create(cboxNonArgeCat.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(tfNonArgeInc.getText()),
                Double.parseDouble(tfNonArgeExp.getText()), cboxNonArgeMon.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    private void accountingArge() {
        aC = new ArgeController();
        aC.create(tfArgePN.getText(), cboxArgeCat.getSelectionModel().getSelectedItem().toString(),
                Double.parseDouble(tfArgeInc.getText()), Double.parseDouble(tfArgeExp.getText()),
                cboxArgeMon.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    private void accountingGetByCategory() {
        taNonArgeList.setText("");
        taArgeList.setText("");
        aC = new ArgeController();
        naC = new NonArgeController();
        arList = new ArrayList<>();
        nonArList = new ArrayList<>();

        arList = aC.readByCat(cboxAccCatChc.getSelectionModel().getSelectedItem().toString());
        nonArList = naC.readByCat(cboxAccCatChc.getSelectionModel().getSelectedItem().toString());

        int i = 0;
        while (i < nonArList.size()) {
            taNonArgeList.appendText(nonArList.get(i).toString() + "\n");
            i++;
        }
        i = 0;
        while (i < arList.size()) {
            taArgeList.appendText(arList.get(i).toString() + "\n");
            i++;
        }

        aC = null;
        naC = null;
        arList = null;
        nonArList = null;

    }

    @FXML
    private void accountingGetByMonth() {
        taNonArgeList.setText("");
        taArgeList.setText("");
        aC = new ArgeController();
        naC = new NonArgeController();
        arList = new ArrayList<>();
        nonArList = new ArrayList<>();

        arList = aC.readByMonth(cboxAccMonChc.getSelectionModel().getSelectedItem().toString());
        nonArList = naC.readByMonth(cboxAccMonChc.getSelectionModel().getSelectedItem().toString());

        int i = 0;
        while (i < nonArList.size()) {
            taNonArgeList.appendText(nonArList.get(i).toString() + "\n");
            i++;
        }
        i = 0;
        while (i < arList.size()) {
            taArgeList.appendText(arList.get(i).toString() + "\n");
            i++;
        }

        aC = null;
        naC = null;
        arList = null;
        nonArList = null;
    }
}

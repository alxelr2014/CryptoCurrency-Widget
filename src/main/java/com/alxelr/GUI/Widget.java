package com.alxelr.GUI;

import com.alxelr.Data.DataProviderService;
import com.alxelr.Database.DatabaseCoin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Widget implements Initializable {
    @FXML
    private TableView<CryptoView> cryptoTable;
    @FXML
    private TextField crypto;

    @FXML
    private TextField value;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            initializeTable();
    }

    private ArrayList<CryptoView> getTableData() {
        ArrayList<CryptoView> result = new ArrayList<>();
        for (DatabaseCoin databaseCoin: DatabaseCoin.getAllCoins())
        {
            result.add(new CryptoView(databaseCoin.getCoinName(),databaseCoin.getValueCoin(),
                    new DataProviderService().getData(databaseCoin.getCoinName()+databaseCoin.getValueCoin())));
        }
        return result;
    }


    @FXML
    void add(ActionEvent event) {
        DatabaseCoin.add(new DatabaseCoin(crypto.getText(),value.getText()));
        crypto.clear();
        value.clear();
        initializeTable();
    }

    @FXML
    void refresh(ActionEvent event) {
        initializeTable();
    }
    private void initializeTable()
    {
        cryptoTable.getColumns().clear();
        cryptoTable.getItems().clear();
        TableColumn<CryptoView,String> coinName = new TableColumn<>("Coin");
        coinName.setCellValueFactory(new PropertyValueFactory<>("coinName"));
        TableColumn<CryptoView,String> lastPrice = new TableColumn<>("Last Price");
        lastPrice.setCellValueFactory(new PropertyValueFactory<>("lastPrice"));
        TableColumn<CryptoView,String> valueCoin = new TableColumn<>("Value");
        valueCoin.setCellValueFactory(new PropertyValueFactory<>("valueCoin"));
        TableColumn<CryptoView,String> high24 = new TableColumn<>("24H High");
        high24.setCellValueFactory(new PropertyValueFactory<>("high24"));
        TableColumn<CryptoView,String> low24 = new TableColumn<>("24H Low");
        low24.setCellValueFactory(new PropertyValueFactory<>("low24"));

        cryptoTable.setPlaceholder(new Label("No crypto added"));
        cryptoTable.getItems().addAll(getTableData());
        cryptoTable.getColumns().addAll(coinName,lastPrice,valueCoin,high24,low24);
    }

}

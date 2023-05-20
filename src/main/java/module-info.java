module me.filming.wordlefx {
    requires javafx.controls;
    requires javafx.fxml;


    exports me.filming.wordlefx.model;
    opens me.filming.wordlefx.model to javafx.fxml;
    exports me.filming.wordlefx.view;
    opens me.filming.wordlefx.view to javafx.fxml;
    exports me.filming.wordlefx.controller;
    opens me.filming.wordlefx.controller to javafx.fxml;
}
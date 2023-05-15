module me.filming.wordlefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.filming.wordlefx to javafx.fxml;
    exports me.filming.wordlefx;
}
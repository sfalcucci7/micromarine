module micromarine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires mysql.connector.java;
    

    opens micromarine to javafx.fxml;
    exports micromarine;
}

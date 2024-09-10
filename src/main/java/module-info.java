module micromarine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens micromarine to javafx.fxml;
    exports micromarine;
}

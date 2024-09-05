module micromarine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens micromarine to javafx.fxml;
    exports micromarine;
}

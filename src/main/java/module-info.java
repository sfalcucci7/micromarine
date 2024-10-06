module micromarine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;
    //requires mysql.connector.java;
    requires javafx.base;
    requires javafx.swing;

    opens micromarine to javafx.fxml;
    //opens sample.Datamodel;
    exports micromarine;
}

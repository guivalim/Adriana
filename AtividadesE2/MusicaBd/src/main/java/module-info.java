module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Controller;
    opens org.example.Controller to javafx.fxml;
}

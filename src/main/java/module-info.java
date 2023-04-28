module edu.guilford {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.guilford to javafx.fxml;
    exports edu.guilford;
}

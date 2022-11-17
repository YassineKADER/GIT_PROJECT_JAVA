module com.example.ygit {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.jgit;


    opens com.example.ygit to javafx.fxml;
    exports com.example.ygit;
}
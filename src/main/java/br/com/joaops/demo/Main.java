package br.com.joaops.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
    
    private ConfigurableApplicationContext context;
    private Parent root;
    
    @Override
    public void init() throws Exception {
        this.context = SpringApplication.run(Main.class);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CRUD Pessoa");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/favicon.png")));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PessoaLayout.fxml"));
        loader.setControllerFactory(context::getBean);
        root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop() throws Exception {
        context.stop();
    }
    
    public static void main(String[] args) {
        launch(Main.class, args);
    }
    
}
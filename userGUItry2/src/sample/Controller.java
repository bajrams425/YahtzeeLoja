package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Controller{

    public AnchorPane root;
    public VBox scene;
    public Button swapButton;
    public Pane Loja;
    public Pane Msg;

    //me dit ne cilen anë jena
    private boolean left = true;

    public void swap(){

        swapButton.setDisable(true);

        if(left==true){
            //bone Msg visible ama e tejdukshme
            Msg.setOpacity(0);
            Msg.setVisible(true);

            //tranzit prej majt ne te djatht te panet-it perpara
            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.3), scene);
            translate.setToX(scene.getLayoutX() + (root.getPrefWidth() - scene.getPrefWidth()));
            translate.play();
            translate.setOnFinished(e -> swapButton.setDisable(false));

            //le me shtyp prap butonin per mu ndrru skena
            left=false;
            swapButton.setText("Play!");

            //largo skenen e lojes kur ndrrohet pozita e butonave
            //bonja fade away
            FadeTransition fo = new FadeTransition(Duration.millis(650), Loja);
            fo.setFromValue(1);
            fo.setToValue(0);
            fo.play();

            //levize djathtas majtas gjate kohes qe ja bon fade
            TranslateTransition fadeleft = new TranslateTransition(Duration.seconds(0.65), Loja);
            fadeleft.setToX(Loja.getLayoutX() - (root.getPrefWidth()/2));
            fadeleft.play();

            //fute ne sken msgs edhe prit gjysen e kohes para se mu shfaq
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{
                            TranslateTransition faderight = new TranslateTransition(Duration.seconds(0.65), Msg);
                            faderight.setFromX(root.getPrefWidth() / 2);
                            faderight.setToX(scene.getLayoutX());
                            faderight.play();
                            FadeTransition fi = new FadeTransition(Duration.millis(650), Msg);
                            fi.setFromValue(0);
                            fi.setToValue(1);
                            fi.play();

                            //Hjeke Game node qe me mujt me kliku mi Msg node
                            Loja.setVisible(false);
                            Loja.managedProperty().bind(Loja.visibleProperty());
                    }
            ));
            timeline.play();

        }
        else if(left==false){
            //tranzit prej djatht ne te majt te panet-it perpara
            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.3), scene);
            translate.setToX(scene.getLayoutX());
            translate.play();
            translate.setOnFinished(e -> swapButton.setDisable(false));

            //le me shtyp prap butonin per mu ndrru skena
            left=true;
            swapButton.setText("Chat...");

            //largo skenen e Msg kur ndrrohet pozita e butonave
            //bonja fade away
            FadeTransition fo = new FadeTransition(Duration.millis(650), Msg);
            fo.setFromValue(1);
            fo.setToValue(0);
            fo.play();

            //levize djathtas majtas gjate kohes qe ja bon fade
            TranslateTransition fadeleft = new TranslateTransition(Duration.seconds(0.65), Msg);
            fadeleft.setToX(Msg.getLayoutX() + (root.getPrefWidth()/2));
            fadeleft.play();

            //fute ne sken e lojes edhe prit gjysen e kohes para se mu shfaq
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{
                        TranslateTransition faderight = new TranslateTransition(Duration.seconds(0.65), Loja);
                        faderight.setFromX(Loja.getLayoutX() - (root.getPrefWidth()/2));
                        faderight.setToX(Loja.getPrefWidth());
                        faderight.play();
                        FadeTransition fi = new FadeTransition(Duration.millis(650), Loja);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        //Kthe Game node per me mujt me interaktu
                        Loja.setVisible(true);
                        Loja.managedProperty().bind(Loja.visibleProperty());
                    }
            ));
            timeline.play();
        }
    }
    public void ReDoGame(){
    }

    public void Call(ActionEvent actionEvent) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("/VoiceCall/voice.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    public void Video(ActionEvent actionEvent) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("/VoiceCall/voice.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
}

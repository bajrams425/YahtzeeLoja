package VideoCall;

import javafx.scene.control.Button;

public class videoController {

    public Button CallButton;

    public void beginCall() {
        CallButton.getStyleClass().removeAll("call");
        CallButton.getStyleClass().add("endCall");
    }
}

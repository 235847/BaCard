//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import javafx.scene.Node;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;

    public DraggableMaker() {
    }

    public void makeDraggable(Node node) {
        node.setOnMousePressed((mouseEvent) -> {
            this.mouseAnchorX = mouseEvent.getX();
            this.mouseAnchorY = mouseEvent.getY();
        });
        node.setOnMouseDragged((mouseEvent) -> {
            node.setLayoutX(mouseEvent.getSceneX() - this.mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - this.mouseAnchorY);
        });
    }
}

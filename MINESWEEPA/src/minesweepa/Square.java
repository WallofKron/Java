package minesweepa;

import java.awt.Button;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Square extends Button {

    public static enum State{
        Normal, Pressed, Marked
    }
}

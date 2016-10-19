package object_programming_2.lab4.s_lammouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MousePressListener extends MouseListener {

    default void mousePressed(MouseEvent e){}

    default void mouseReleased(MouseEvent e){}

    default void mouseEntered(MouseEvent e){}

    default void mouseExited(MouseEvent e){}
}

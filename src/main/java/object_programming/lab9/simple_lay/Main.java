package object_programming.lab9.simple_lay;

import object_programming.lab9.simple_lay.ui.controller.LayoutController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Choose layout:\n" +
                "A) BorderLayou \n" +
                "B) FlowLayout \n" +
                "C) FlowLayout with left alignment \n" +
                "D) FlowLayout with right alignment \n" +
                "E) GridLayout with one row \n" +
                "F) GridLayout with one column \n" +
                "G) GridLayout as array (3, 2) ";
        String letter = JOptionPane.showInputDialog(null, text);

        LayoutManager layout = betterSolution(letter);
//        LayoutManager layout = badSolution(letter);

        LayoutController controller = new LayoutController(layout);
        controller.showFrame();
    }

    private static LayoutManager badSolution(String letter) {
        LayoutManager layout = null;
        switch (letter) {
            case "A":
                layout = new BorderLayout();
                break;
            case "B":
                layout = new FlowLayout();
                break;
            case "C":
                layout = new FlowLayout(FlowLayout.LEFT);
                break;
            case "D":
                layout = new FlowLayout(FlowLayout.RIGHT);
                break;
            case "E":
                layout = new GridLayout(1, 5);
                break;
            case "F":
                layout = new GridLayout(5, 1);
                break;
            case "G":
                layout = new GridLayout(3, 2);
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Wrong choice. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return layout;
    }

    private static LayoutManager betterSolution(String letter) {
        Map<String, LayoutManager> layoutStrategy = new HashMap<String, LayoutManager>() {
            {
                put("A", new BorderLayout());
                put("B", new FlowLayout());
                put("C", new FlowLayout(FlowLayout.LEFT));
                put("D", new FlowLayout(FlowLayout.RIGHT));
                put("E", new GridLayout(1, 5));
                put("F", new GridLayout(5, 1));
                put("G", new GridLayout(3, 3));
            }
        };

        return layoutStrategy.entrySet().stream()
                .filter(entry -> entry.getKey().equals(letter))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new RuntimeException("Wrong choise"));
    }
}

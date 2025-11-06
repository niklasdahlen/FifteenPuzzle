import javax.swing.*;
import java.awt.*;

public class PuzzleBoard extends JPanel {
    private final int SIZE = 4;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private int emptyRow = SIZE -1;
    private int emptyCol = SIZE -1;

    public PuzzleBoard() {
        setLayout(new GridLayout(SIZE,SIZE,5,5));
        setBackground(Color.ORANGE);
        createButtons();
    }

    private void createButtons() {
        int num = 1;
        for (int r = 0; r <SIZE; r++) {
            for (int c = 0; c <SIZE; c++) {
                JButton b = new JButton();
                if (r == SIZE - 1 && c == SIZE -1) {
                    b.setText("");
                } else {
                    b.setText(String.valueOf(num++));
                }
                b.setFont(new Font("Arial", Font.BOLD,20));
                b.setBackground(Color.BLACK);
                b.addActionListener(e->moveTile(b));
                buttons[r][c] = b;
                add(b);
            }
        }
    }

}

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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

    public void shuffle() {
        List<String> values = new ArrayList<>();
        for (int i = 1; i < SIZE * SIZE; i++) {
            values.add(String.valueOf(i));
        }
        values.add("");

        do{
            Collections.shuffle(values);
        } while(!isSolveable(values));

        int index = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                buttons[r][c].setText(values.get(index));
                if (values.get(index).equals("")) {
                    emptyRow = r;
                    emptyCol = c;
                }
                index++;
            }
        }
    }

    private void moveTile(JButton b) {
        int row = -1, col = -1;
        for(int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if(buttons[r][c] == b) {
                    row = r;
                    col = c;
                }
            }
        }

        if ((Math.abs(row-emptyRow) == 1 && col == emptyCol) ||
            (Math.abs(col -emptyCol) == 1 && row == emptyRow)) {
            buttons[emptyRow][emptyCol].setText(b.getText());
            b.setText("");
            emptyRow = row;
            emptyCol = col;

            if(isSolved()) {
                JOptionPane.showMessageDialog(this,"You won!");
            }
        }
    }
    private boolean isSolved() {
        int num = 1;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                String text = buttons[r][c].getText();
                if (r == SIZE -1 && c == SIZE -1)
                    return text.equals("");
                if (!text.equals(String.valueOf(num++)))
                    return false;
            }
        }
        return true;
    }

}

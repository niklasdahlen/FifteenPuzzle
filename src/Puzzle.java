import javax.swing.*;
import java.awt.*;

public class Puzzle extends JFrame {
    public Puzzle() {
        setTitle("15-puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PuzzleBoard board = new PuzzleBoard();
        add(board, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> board.shuffle());
        buttonPanel.add(newGameButton);

        JButton solveButton = new JButton("Solve Game");
        solveButton.addActionListener(e-> board.solveInstantly());
        buttonPanel.add(solveButton);

        add(buttonPanel,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Puzzle::new);
    }

}

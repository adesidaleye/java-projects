import javax.swing.*;

public class FlappyBird {
    public static void main(String[] args) {
        int boardHeight = 360;
        int boardWidth = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
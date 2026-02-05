import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lab2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Bar chart ");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GraphPanel panel = new GraphPanel();
        frame.add(panel);
        JButton redrawButton = new JButton("Redraw");
        frame.add(redrawButton, BorderLayout.SOUTH);
        redrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }

        });
        frame.setVisible(true);

    }

    static class GraphPanel extends JPanel {
        int startX = 50;
        int startY = 50;
        int size = 25;
        int gridSize = 10;
        int barSpacing = 5;
        Random rand = new Random();

        // Grid
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    g.drawRect(
                            startX + x * size,
                            startY + y * size,
                            size,
                            size

                    );
                }
            }

            for (int x = 0; x < gridSize; x++) {
                int barHeight = rand.nextInt(gridSize + 1);

                int barX = startX + x * size + barSpacing;
                int barY = startY + (gridSize - barHeight) * size;

                g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                g.fillRect(
                        barX,
                        barY,
                        size - barSpacing,
                        barHeight * size);
            }
        }

    }
}

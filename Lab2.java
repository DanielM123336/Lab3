import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lab2 extends JFrame {
    final BasicStroke stroke = new BasicStroke(10f);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Bar chart ");
        frame.setSize(500, 500);
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

        // draws Cartesian plane
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
            // randomly generates bar and colors
            Graphics2D g2 = (Graphics2D) g;
            float strokeWidth = 8f;
            g2.setStroke(new BasicStroke(strokeWidth));

            for (int x = 0; x < gridSize; x++) {

                int barHeight = rand.nextInt(gridSize + 1);
                int halfStroke = (int) (strokeWidth / 2);

                int barX = startX + x * size + size / 2;
                int barTopY = startY + (gridSize - barHeight) * size + halfStroke;
                int barBottomY = startY + gridSize * size - halfStroke;
                if (barHeight == 0) {
                    g2.drawLine(barX, barBottomY, barX, barBottomY);
                    continue;
                }

                g2.setColor(new Color(
                        rand.nextInt(256),
                        rand.nextInt(256),
                        rand.nextInt(256)

                ));

                g2.drawLine(barX, barTopY, barX, barBottomY);
            }
        }

    }
}

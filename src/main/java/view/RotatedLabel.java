package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;

public class RotatedLabel extends JLabel {
    private double angle;

    public RotatedLabel(String text, double angle) {
        super(text);
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Ativa suavização (opcional, melhora a qualidade)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rotaciona ao redor do centro do componente
        AffineTransform oldTransform = g2.getTransform();
        g2.rotate(Math.toRadians(angle), getWidth() / 2.0, getHeight() / 2.0);

        super.paintComponent(g2);
        g2.setTransform(oldTransform);
        g2.dispose();
    }
}
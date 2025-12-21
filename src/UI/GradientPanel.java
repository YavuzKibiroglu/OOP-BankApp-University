package UI;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    // Varsayılan Renkler (Mavi Tonları - Üst Panel İçin İdeal)
    private Color color1 = new Color(0, 102, 204); // Koyu Mavi
    private Color color2 = new Color(102, 204, 255); // Açık Mavi

    // Geçiş Yönü (0: Yatay, 1: Dikey)
    private int direction = 0;

    // Boş Constructor (Mavi tonlarını kullanır)
    public GradientPanel() {
        super();
        setOpaque(false); // Arka planın boyanmasına izin ver
    }

    // Özel Renk Constructor'ı (İstediğin renkleri vererek oluşturabilirsin)
    public GradientPanel(Color c1, Color c2) {
        super();
        this.color1 = c1;
        this.color2 = c2;
        setOpaque(false);
    }

    // Yön Ayarlı Constructor
    public GradientPanel(Color c1, Color c2, int direction) {
        super();
        this.color1 = c1;
        this.color2 = c2;
        this.direction = direction;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Daha kaliteli render (Pürüzsüz geçiş)
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth();
        int h = getHeight();

        GradientPaint gp;

        if (direction == 0) {
            // YATAY GEÇİŞ (Soldan Sağa)
            gp = new GradientPaint(0, 0, color1, w, 0, color2);
        } else {
            // DİKEY GEÇİŞ (Yukarıdan Aşağıya)
            gp = new GradientPaint(0, 0, color1, 0, h, color2);
        }

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
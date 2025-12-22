package UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IconHelper {

    /**
     * Belirtilen yoldaki resmi alır, istenen genişlik ve yüksekliğe (px)
     * pürüzsüz bir şekilde küçültür ve ImageIcon olarak döndürür.
     */
    public static ImageIcon createIcon(String path, int width, int height) {
        try {
            // 1. Resmi resources klasöründen bul
            URL imgURL = IconHelper.class.getResource(path);

            if (imgURL != null) {
                // 2. Resmi belleğe yükle
                ImageIcon originalIcon = new ImageIcon(imgURL);
                Image img = originalIcon.getImage();

                // 3. Resmi yeniden boyutlandır (SCALE_SMOOTH = kaliteli küçültme)
                Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // 4. Yeni boyuttaki resmi ImageIcon'a çevirip döndür
                return new ImageIcon(resizedImg);
            } else {
                System.err.println("HATA: Resim dosyası bulunamadı -> " + path);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
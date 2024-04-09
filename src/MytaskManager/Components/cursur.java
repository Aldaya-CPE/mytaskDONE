
package MytaskManager.Components;
import MytaskManager.Main.Main;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class cursur {
 public static void setHandCursor(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
 
 public static void setHandCursors(JButton... buttons) {
        for (JButton button : buttons) {
            setHandCursor(button);
        }
    }
public static void main(String[] args) {
        JButton jButton1 = new JButton();
        JButton jButton5 = new JButton();
        JButton jButton9 = new JButton();
        JButton jButton8 = new JButton();
        JButton jButton10 = new JButton();

        setHandCursors(jButton1, jButton5, jButton9, jButton8, jButton10);
    }

}
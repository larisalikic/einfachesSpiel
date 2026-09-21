import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnView extends JFrame {

    private static final String HINWEIS = "Tippe eine Zahl von 1 bis 9";
    private JLabel rundenErgebnis;
    private JLabel gesamtPunkte;
    private JTextField spielerZahl;
    private JTextField computerZahl;
    private JButton nochEinmal;

    private JLabel erstelleUeberschrift(String text) {
        return new JLabel(text, SwingConstants.CENTER);
    }

    private JLabel erstelleAnzeigeLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        return label;
    }

    private JTextField erstelleZahlenFeld() {
        JTextField feld = new JTextField();
        feld.setFont(new Font("Arial", Font.BOLD, 28));
        feld.setHorizontalAlignment(SwingConstants.CENTER);
        return feld;
    }

    public void setController(GewinnController controller) {
        spielerZahl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.spielen();
            }
        });
        nochEinmal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.neueRunde();
            }
        });
    }

    public String getSpielerZahl() {
        return spielerZahl.getText();
    }

    public void zeigeComputerZahl(int zahl) {
        computerZahl.setText(String.valueOf(zahl));
    }

    public void zeigeRundenErgebnis(String text) {
        rundenErgebnis.setText(text);
    }

    public void zeigeGesamtPunkte(int punkte) {
        gesamtPunkte.setText(String.valueOf(punkte));
    }

    public void zeigeStartPunkte(int punkte) {
        gesamtPunkte.setText("Gesamtpunkte: " + punkte);
    }

    public void loescheRunde() {
        spielerZahl.setText("");
        computerZahl.setText("");
        rundenErgebnis.setText(HINWEIS);
    }

    public void zeigeFehler(String text) {
        JOptionPane.showMessageDialog(this, text);
    }
}
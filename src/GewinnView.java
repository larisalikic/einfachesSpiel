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

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(530, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rundenErgebnis = erstelleAnzeigeLabel();
        gesamtPunkte = erstelleAnzeigeLabel();

        spielerZahl = erstelleZahlenFeld();
        computerZahl = erstelleZahlenFeld();
        computerZahl.setEditable(false);
        computerZahl.setBackground(Color.WHITE);

        nochEinmal = new JButton("Noch einmal!");
        nochEinmal.setEnabled(false);

        JPanel oben = new JPanel(new GridLayout(2, 2, 12, 2));
        oben.add(erstelleUeberschrift("Rundenergebnis:"));
        oben.add(erstelleUeberschrift("Gesamtpunkte:"));
        oben.add(rundenErgebnis);
        oben.add(gesamtPunkte);

        JPanel ueberschriften = new JPanel(new GridLayout(1, 2, 12, 0));
        ueberschriften.add(erstelleUeberschrift("Deine Zahl:"));
        ueberschriften.add(erstelleUeberschrift("Computer:"));

        JPanel textfelder = new JPanel(new GridLayout(1, 2, 12, 0));
        textfelder.add(spielerZahl);
        textfelder.add(computerZahl);

        JPanel mitte = new JPanel(new BorderLayout(5, 5));
        mitte.add(ueberschriften, BorderLayout.NORTH);
        mitte.add(textfelder, BorderLayout.CENTER);

        JPanel unten = new JPanel();
        unten.add(nochEinmal);

        JPanel hauptPanel = new JPanel(new BorderLayout(5, 5));
        hauptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hauptPanel.add(oben, BorderLayout.NORTH);
        hauptPanel.add(mitte, BorderLayout.CENTER);
        hauptPanel.add(unten, BorderLayout.SOUTH);

        add(hauptPanel);
    }

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

    public void setSpielerEingabeAktiv(boolean aktiv){
        spielerZahl.setEnabled(aktiv);
    }

    public void setNochEinmal(boolean aktiv){
        nochEinmal.setEnabled(aktiv);
    }
}
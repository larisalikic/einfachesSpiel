/**
 * Mainklasse des Zahlen-Gewinnspiels.
 * Erzeugt Model, View und Controller, verbindet sie und zeigt das Fenster an.
 *
 * @author Larisa Likic
 * @version 21.9.2026
 */

public class GewinnMain {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}

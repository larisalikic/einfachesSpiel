public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.setController(this);

        view.loescheRunde();
        view.zeigeStartPunkte(model.getGesamtPunkte());
    }

    public void spielen() {
        Integer zahl = liesSpielerZahl();
        if (zahl == null) {
            view.zeigeFehler("Bitte eine ganze Zahl von 1 bis 9 eingeben!");
            return;
        }

        model.berechneComputerZahl();
        model.berechneRunde(zahl);

        view.zeigeComputerZahl(model.getComputerZahl());
        view.zeigeRundenErgebnis(erstelleRundenText());
        view.zeigeGesamtPunkte(model.getGesamtPunkte());
    }

    public void neueRunde() {
        view.loescheRunde();
    }

    private Integer liesSpielerZahl() {
        String text = view.getSpielerZahl();
        if (text == null) {
            return null;
        }
        try {
            int zahl = Integer.parseInt(text.trim());
            if (zahl >= 1 && zahl <= 9) {
                return zahl;
            }
        } catch (NumberFormatException e) {
            // wenn keine Zahl da ist, wird null zurückgegeben
        }
        return null;
    }

    private String erstelleRundenText() {
        if (model.hatGewonnen()) {
            return "Gewonnen";
        }
        if (model.hatVerloren()) {
            return "Verloren";
        }
        int ergebnis = model.getRundenErgebnis();
        if (ergebnis > 0) {
            return "+" + ergebnis;
        }
        return String.valueOf(ergebnis);
    }
}



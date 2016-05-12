
public class Taikaneliotehdas {

    public Taikanelio luoTaikanelio(int koko) {

        Taikanelio nelio = new Taikanelio(koko);
        /*
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                nelio.asetaArvo(j, i, 0);
            }
        }
        */
        // toteuta taikaneliön luominen Siamese method -algoritmilla tänne
        int maxSteps = koko * koko;
        int currentStep = 1;
        int X = nelio.getLeveys() / 2;
        int Y = 0;
        int vanhaX = 0;
        int vanhaY = 0;

        while (currentStep < maxSteps + 1) {
            
            vanhaX = X;
            vanhaY = Y;
            nelio.asetaArvo(X, Y, currentStep);
            if (X == koko - 1) {
                X = 0;
            } else {
                X++;
            }
            if (Y == 0) {
                Y = koko - 1;
            } else {
                Y--;
            }
            if (nelio.annaArvo(X, Y) != 0) {
                X = vanhaX;
                Y = vanhaY;
                Y++;
            }

            currentStep++;
        }

        return nelio;
    }

}

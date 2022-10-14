//Natacha Rivière 28706745

public class Salade extends Entree{
  private static String[] noms={"Tomate-mozza", "Salade césar", "Salade de lentilles", "Bettrave", "Salade d'endives",
  "Verrine avocat, fromage a la creme et saumon fume", "Salade de chèvre chaud", "Salade de riz"};
  private static double[] valeurs={3, 4.5, 3, 2, 1, 2, 8, 5};

  public Salade(String nom, double num){
    super(nom, num);
  }

  public Salade(int num){
      this(noms[num], valeurs[num]);
  }

  public Salade(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String toString(){
    return super.toString();
  }
}

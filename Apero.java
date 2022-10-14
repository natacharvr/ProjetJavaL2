//Natacha Rivière 28706745

public class Apero extends Entree{
  private static String[] noms={"Charcuterie", "Tarama & blinis", "Pringles gout barbecue", "Terrine de sanglier", "Natchos",
  "Biscuits", "saumon fume", "veloute de petits poids"};
  private static double[] valeurs={8, 5.5,4.5, 6.5, 1, 2, 8, 2.85};

  public Apero(String nom, double num){
    super(nom, num);
  }

  public Apero(int num){
      this(noms[num], valeurs[num]);
  }

  public Apero(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String toString(){
    return super.toString();
  }
}

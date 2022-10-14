public abstract class Aliment{
  protected double prix;
  protected String nom;

  public Aliment(String nom, double prix){
      this.nom=nom;
      this.prix=prix;
  }

  public Aliment(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String getNom(){
    return nom;
  }

  public double getPrix(){
    return prix;
  }
  public abstract String toString();
}

//Natacha Rivière 28706745

public class Entree extends Aliment{

  public static final int nb = 8;

  public Entree(String nom, double num){
    super(nom, num);
  }


  public Entree(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String toString(){
    return "Entree : "+nom+"\n";
  }
}

//Natacha Rivière 28706745

import java.util.ArrayList;

public class Panier{
  private ArrayList<Aliment> contenu;
  private static Panier panier = new Panier();

  private Panier(){
    contenu = new ArrayList<Aliment>();
  }

  public static Panier getPanier(){
    return panier;
  }

  public void ajouter(Aliment a) throws Exception{
    if (a instanceof Entree){
      if (a instanceof Apero){
        Aliment b = new Apero(a);
        contenu.add(b);
      }
      if (a instanceof Salade){
        Aliment b = new Salade(a);
        contenu.add(b);
      }

    }
    else {
      if (a instanceof Plat){
        Perissable al = (Perissable) a;
        Plat b = new Plat(a);
        b.cloneDate(al.getJour(), al.getMois(), al.getAnnee());
        Aliment y = (Aliment) b;
        contenu.add(y);
      }
      else {
        if (a instanceof Dessert){
          Perissable al = (Perissable) a;
          Dessert b = new Dessert(a);
          b.cloneDate(al.getJour(), al.getMois(), al.getAnnee());
          Aliment c = (Aliment) b;
          contenu.add(c);
        }
        else {
          throw new Exception();
        }
      }
    }
  }

  public String toString(){
    String s = "Votre panier contient :\n";
    for (int i=0; i<contenu.size(); i++){
      s+=contenu.get(i).toString();
    }
    return s;
  }

  public boolean malade(int annee, int mois, int jour){
    for (int i=0; i<contenu.size(); i++){
      if (contenu.get(i) instanceof Perissable){
        Perissable c=(Perissable)(contenu.get(i));
        if (c.getAnnee()==annee){
          if (c.getMois()<mois){
          return true;
        }
        else {
          if((c.getJour()<jour)&&(c.getMois()==mois)){
            return true;
          }
        }
      }
    }
  }
    return false;
  }
}

//Natacha Rivière 28706745

public class Magasin{
  private Aliment [][] consommables;

  public Magasin(){
    consommables = new Aliment[3][];
    int aous;
    consommables[0] = new Aliment[6];
    int e;
    consommables[1] = new Aliment[6];
    int p;
    consommables[2] = new Aliment[6];
    int d;
    for (int i=0; i<6; i++){
      aous =(int) (Math.random()*2+1);
      if (aous==1){
        e = (int) (Math.random()*Entree.nb);
        consommables[0][i]=new Apero(e);
      } else {
        e = (int) (Math.random()*Entree.nb);
        consommables[0][i]=new Salade(e);
      }
      p = (int) (Math.random()*Plat.nb);
      consommables[1][i]=new Plat(p);
      d = (int) (Math.random()*Dessert.nb);
      consommables[2][i]=new Dessert(d);
    }
  }

  public void choixEntree(){
    System.out.println("Vous pouvez choisir entre ces six entrees :");
    for (int i=0; i<6; i++){
      System.out.println(i+1 + ": "+consommables[0][i]);
    }
    int choix = Joueur.choix();
    System.out.println("Vous avez choisi d'acheter l'item suivant : \n"+ consommables[0][choix].toString());
    Joueur.achat(consommables[0][choix]);
  }

  public void choixPlat(){
    System.out.println("Vous pouvez choisir entre ces six plats :");
    for (int i=0; i<6; i++){
      System.out.println(i+1 + ": "+consommables[1][i]);
    }
    int choix = Joueur.choix();
    System.out.println("Vous avez choisi d'acheter l'item suivant : \n"+ consommables[1][choix].toString());
    Joueur.achat(consommables[1][choix]);
  }

  public void choixDessert(){
    System.out.println("Vous pouvez choisir entre ces six desserts :");
    for (int i=0; i<6; i++){
      System.out.println(i+1 + ": "+consommables[2][i]);
    }
    int choix = Joueur.choix();
    System.out.println("Vous avez choisi d'acheter l'item suivant : \n"+ consommables[2][choix].toString());
    Joueur.achat(consommables[2][choix]);
  }

  public String toString(){
    String s="Je suis un magasin contenant :\n";
    for (int j=0; j<3; j++){
      for (int i=0; i<6; i++){
        s+=consommables[j][i].getNom()+ " coutant :\t "+ consommables[j][i].getPrix()+"\n";
      }
    }
    return s;
  }
}

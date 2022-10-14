//Natacha Rivière 28706745

public class Jeu{

  public static void main(String[] args) {

    String consigne = "Vous allez devoir choisir une entree, un plat et un dessert dans les items proposes par la suite.\n";
    consigne+="Vous allez avoir un budget alloue, essayez de choisir des aliments pour vous constituer un repas sans depasser ce budget.\n";
    consigne+="ATTENTION, certains aliments ont une date de peremption, vous perdez si vous achetez un produit perime.\n";
    consigne+="Cette date est inscrite sous le nom de l'article.\n Puisse le sort vous etre favorable.\n";

    Joueur.setNom();
    Joueur.setDate();
    System.out.println("Nous sommes donc le " +Joueur.getDate()[0]+"."+Joueur.getDate()[1]);
    System.out.println(consigne);
    Joueur.setBudget(20);
    Magasin m = new Magasin();

    m.choixEntree();
    m.choixPlat();
    m.choixDessert();

    System.out.println(Joueur.monPanier());

    System.out.println(Joueur.resultat());
  }
}

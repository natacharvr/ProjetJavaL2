//Natacha Rivière 28706745

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Joueur{
  private static double budgetInit;
  private static double budgetFinal;
  private static Panier panier= Panier.getPanier();
  private static String nom;
  private static Scanner scanner = new Scanner(System.in);
  private static int[] date;

  public static int[] getDate(){
    return date;
  }

  public static void setDate(){
    date = new int[3];
    date[2] = 2021;
    int jour = -1;
    while ((jour<1) || (jour>31)){
      if (jour > 31){
        System.out.println("Veuillez entrer un chiffre compris entre 1 et 31.");
      }
      jour =-1;
      try {
        System.out.println("Quel la date du jour? (Entrez un chiffre entre 1 et 31)");
        if (scanner.hasNextInt()){
          jour = scanner.nextInt();
        }
        else throw new PasUnChiffreException();
        System.out.println("Vous avez entre le numero "+ jour);
      }
      catch(PasUnChiffreException e) {
        System.out.println(e.getMessage()+" Entrez un nombre entier.");
        scanner.nextLine();
      }
    }
    date[0]=jour;


    int mois = -1;
    while ((mois<1) || (mois>12)){
      if (mois > 12){
        System.out.println("Veuillez entrer un chiffre compris entre 1 et 12.");
      }
      mois =-1;
      try {
        System.out.println("Quel est le mois? (Entrez un chiffre entre 1 et 12)");
        if (scanner.hasNextInt()){
          mois = scanner.nextInt();
        }
        else throw new PasUnChiffreException();
        System.out.println("Vous avez entre le numero "+ mois);
      }
      catch(PasUnChiffreException e) {
        System.out.println(e.getMessage()+" Entrez un nombre entier.");
        scanner.nextLine();
      }
    }
    date[1]=mois;
  }

  public static void setBudget(double max){
    budgetInit=Math.random()*(max-5)+5;
    budgetFinal=budgetInit;
    String s = NumberFormat.getInstance().format(budgetInit);
    System.out.println("Votre budget est : "+s);
  }

  public static void achat(Aliment a){
    budgetFinal -= a.getPrix();
    try {
      panier.ajouter(a);
    }
    catch (Exception e){
      System.out.println("Erreur d'ajout au panier, a n'est pas un aliment");
    }
  }

  public static void setNom(){
    while ((nom==null)||(nom=="")){
      try{
        System.out.println("Comment vous appelez vous?");
        nom= scanner.nextLine();
        entrerNom(nom);
        System.out.println("Bienvenue "+ nom);
      }
      catch(NomInvalideException e){
        System.out.println(e.getMessage() + " Je doute que ce soit reelement votre nom");
      }
    }
  }

  public static String getNom(){
    return nom;
  }

  public static String entrerNom(String nom) throws NomInvalideException{
    if (nom==""){
      throw new NomInvalideException();
    }
    else {
      return nom;
    }
  }

  public static int choix(){
    int choix = -1;
    while ((choix<1) || (choix>6)){
      if (choix > 6){
        System.out.println("Veuillez entrer un chiffre compris entre 1 et 6.");
      }
      choix =-1;
      try {
        System.out.println("Quel est votre choix ? (Entrez un chiffre entre 1 et 6)");
        if (scanner.hasNextInt()){
          choix = scanner.nextInt();
        }
        else throw new PasUnChiffreException();
        System.out.println("Vous avez choisi le numero "+ choix);
      }
      catch(PasUnChiffreException e) {
        System.out.println(e.getMessage()+" Entrez un nombre entier.");
        scanner.nextLine();
      }
    }
    return choix-1;
  }

  public static String monPanier(){
    return panier.toString();
  }

  public static String resultat(){
    boolean malade = panier.malade(date[2], date[1], date[0]);
    if ((budgetFinal > 0)&&(!malade)){
      String s = NumberFormat.getInstance().format(budgetInit);
      String s1 = NumberFormat.getInstance().format(budgetFinal);
      return "Felicitation "+nom+",\nVous avez gagne, vous aviez "+s+" euros et avec vos achats vous repartez avec un repas complet et "+s1+" euros.";
    }
    else {
      if (malade){
        return nom + " ici, le probleme n'est pas tant de gerer votre budget mais plutot de regarder les dates de peremption des produits. Vous etes bon pour une intoxication alimentaire a ce rythme.";
      }
      else {
        String s1 = NumberFormat.getInstance().format(budgetFinal);
        return "Je suis navre "+nom+",\nVous ne pouvez pas passer la caisse, vous avez vu trop grand. Votre budget etait trop restreint. \nVous avez PERDU, vous avez "+s1+ "euros.";
      }
    }
  }
}

//Natacha Rivière 28706745

public class Dessert extends Aliment implements Perissable{
  private static String[] noms={"Mousse au chocolat", "Eclair au chocolat","Salade de fruits", "Crepes sucrees", "Yaourt nature", "Yaourt sucre",
"Tarte aux pommes", "Crumble banane chocolat", "glace a la vanille", "mousse a la maracudja", "Charlotte aux fraises", "Brownie", "Pomme", "banane", "Glaces Ben and jerry's"};
  private static double[] valeurs={5, 2, 1.5, 2, 0.8, 0.85, 4, 5, 3.5, 7, 8, 1.5, 0.2, 0.25, 4.5};
  public static final int nb = 15;
  private int[] dateDePeremption;

  public void setDate(int[] dateDePeremption){
    dateDePeremption[2]=(int)(Math.random()*2+2021);
    int mois=(int)(Math.random()*12+1);
    dateDePeremption[1]=mois;

    if (mois==2){
      dateDePeremption[0]=(int)(Math.random()*28+1);
    } else {
      if (((mois<8)&&(mois%2==1))||((mois>7)&&(mois%2==0))){
        dateDePeremption[0]=(int)(Math.random()*31+1);
      } else {
        dateDePeremption[0]=(int)(Math.random()*30+1);
      }
    }
  }

  public void cloneDate(int jour, int mois, int annee){
    dateDePeremption[0]=jour;
    dateDePeremption[1]=mois;
    dateDePeremption[2]=annee;
  }

  public Dessert(String nom, double num){
    super(nom, num);
    dateDePeremption= new int[3];
    setDate(dateDePeremption);
  }

  public Dessert(int num){
    this(noms[num], valeurs[num]);
  }

  public Dessert(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String getDate(){
    return dateDePeremption[0]+"."+dateDePeremption[1]+"."+dateDePeremption[2];
  }

  public String toString(){
    return "Dessert : "+nom+"\n\t"+getDate()+"\n";
  }
  public int getMois(){
    return dateDePeremption[1];
  }
  public int getJour(){
    return dateDePeremption[0];
  }
  public int getAnnee(){
    return dateDePeremption[2];
  }
}

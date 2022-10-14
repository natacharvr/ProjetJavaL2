//Natacha Rivière 28706745

public class Plat extends Aliment implements Perissable{
  private static String[] noms={"Pizza 4 fromages", "Boeuf Bourgignon", "Poulet au curry", "Quiche lorraine", "Crepe complete",
  "Grattin de pomme de terres", "Patates douces au four", "Poulet roti", "Oeuf, bacon", "Pates au thon", "Homard", "Tartare de boeuf", "Risotto de poulet",
  "Risotto de cepes", "Salade de poivrons marines","Sandwich poulet-crudites", "Croque monsieur"};
  private static double[] valeurs={4.5, 11.5, 7, 4, 5, 4.5, 1.5, 9.20, 2.5, 1.2, 35, 8.2, 6, 8, 2.6, 1.1, 0.9};
  public static final int nb = 17;
  private int[] dateDePeremption;

  public void setDate(int[] dateDePeremption){
    dateDePeremption[2]=(int)(Math.random()*2+2021);
    int mois=(int)(Math.random()*12);
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

  public Plat(String nom, double num){
    super(nom, num);
    dateDePeremption= new int[3];
    setDate(dateDePeremption);
  }

  public Plat(int num){
    this(noms[num], valeurs[num]);
  }

  public Plat(Aliment a){
    this(a.getNom(), a.getPrix());
  }

  public String getDate(){
    return dateDePeremption[0]+"."+dateDePeremption[1]+"."+dateDePeremption[2];
  }

  public String toString(){
    return "Plat : "+nom+"\n\t"+getDate()+"\n";
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

package studentInfo;
import java.io.Serializable;

public class Student implements Serializable {
   
   private String id;
   private String name;
   private String gender;
   private double score;
   
   public Student() {
      id=""; name="";gender="";score=0.0;
   }
   public Student(String i,String na,String g,double s){
      id=i;name=na;gender=g;score=s;
   }
   public  void setId(String i){id=i;}
   public String getId(){ return id;}
   public void setName(String na){name=na;}
   public String getName(){return name;}
   public void setGender(String g){ gender=g;}
   public String getGender(){return gender;}
   public void setScore(double s){ score=s;}
   public double getScore(){return score;}
   
   public String toString(){
      return getId()+"\t"+getName()+"\t"+getGender()+"\t"+getScore();
   }
}


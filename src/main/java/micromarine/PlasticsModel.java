package micromarine;

//This model class references and generates the setters and getters for each data input field that is populated in the View Page table
public class PlasticsModel {
   String fullname;
   String email;
   Integer counttotal;
   String usastate;
   Double size;
   String season;
   Integer experimentID;

//Getters and Setters established here which are then called in ViewController
public PlasticsModel (String fullname, String email, Integer counttotal, String usastate, Double size, String season, Integer experimentID){
this.fullname = fullname;
this.email = email;
this.counttotal = counttotal;
this.usastate = usastate;
this.size = size;
this.season = season;
this.experimentID = experimentID;

}
//get and set experimentID
public Integer getExperimentID(){
   return experimentID;
}

public void setExperimentID(Integer experimentID){
   this.experimentID = experimentID;
}
//get and set full name
public String getFullname(){
return fullname;
}

public void setFullname(String fullname){
   this.fullname = fullname;
}
//get and set email
public String getEmail(){
   return email;
   }

   public void setEmail(String email){
      this.email = email;
   }
//get and set count total
   public Integer getCounttotal(){
      return counttotal;
      }
      
      public void setCounttotal(Integer counttotal){
         this.counttotal = counttotal;
      }
//get and set state
public String getUsastate(){
         return usastate;
         }

 public void setUsastate(String usastate){
    this.usastate = usastate;
 }
//get and set max size
 public Double getSize(){
   return size;
   }

   public void setSize(Double size){
      this.size = size;
   }

//get and set season
public String getSeason(){
   return season;
   }

public void setSeason(String season){
   this.season = season;
}

}
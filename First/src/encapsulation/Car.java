package encapsulation;


public class Car {
 
 private String company_name;
 private String model_name;
 private int year;
 private double mileage;

 // Constructor to initialize all values
 public Car(String company_name, String model_name, int year, double mileage) {
     this.company_name = company_name;
     this.model_name = model_name;
     this.year = year;
     this.mileage = mileage;
 }

 // Getter and Setter for company_name
 public String getCompany_name() {
     return company_name;
 }

 public void setCompany_name(String company_name) {
     this.company_name = company_name;
 }

 // Getter and Setter for model_name
 public String getModel_name() {
     return model_name;
 }

 public void setModel_name(String model_name) {
     this.model_name = model_name;
 }

 // Getter and Setter for year
 public int getYear() {
     return year;
 }

 public void setYear(int year) {
     this.year = year;
 }

 // Getter only for mileage (read-only)
 public double getMileage() {
     return mileage;
 }
}



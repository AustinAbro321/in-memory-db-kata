import java.sql.*;
import java.util.*;

public class CarDb {

    public static void setup() {     
        String createCountries="create table if not exists countries(\n" + 
            "    ID int PRIMARY KEY,\n" + 
            "    abbreviation varchar(5),\n" + 
            "    name varchar(100)\n" + 
            ")"; 
         String createPeople =  "create table if not exists people(\n" + 
            "    ID int PRIMARY KEY,\n" + 
            "    full_name varchar(100) not NULL,\n" + 
            "    email varchar(100),\n" + 
            "    country_id int,\n" + 
            "    foreign key (country_id) references countries(id)\n" + 
            "    on delete CASCADE\n" + 
            ")";
         String createCars =  "create table if not exists stellantis_cars(\n" + 
            "    ID int primary KEY,\n" + 
            "    car_name varchar (100) not NULL,\n" + 
            "    year INT not null\n" + 
            ")"; 
         String createSales = "create table if not exists sales(\n" + 
            "    VIN INT primary KEY,\n" + 
            "    person_id int not null,\n" + 
            "    car_id int not null,\n" + 
            "    sale_date DATE not null,\n" + 
            "    foreign key (person_id) references people(id) \n" + 
            "    on delete CASCADE,\n" + 
            "    foreign key (car_id) REFERENCES stellantis_cars(id)\n" + 
            "    on delete CASCADE\n" + 
            ")";
        String insertCountries = "insert into countries (id,abbreviation,name) \n" + 
            "values(1,'USA','United States of America'),\n" + 
            "(2,'NOR','Norway'),\n" + 
            "(3,'SWE','Sweden')";
        String insertCars = 
            "insert into stellantis_cars(id,car_name,year) values\n" + 
            "(1,'Jeep Cherokee',2018),\n" + 
            "(2,'Jeep Cherokee',2017),\n" + 
            "(3,'Jeep Cherokee',2000),\n" + 
            "(4,'Dodge Challenger',1985),\n" + 
            "(5,'FIAT 124 Spider',2100),\n" + 
            "(6,'Chrysler 300',2003),\n" + 
            "(7,'Alfa Romeo Giulia',2021);\n";
        String insertPeople = 
            "insert into people(ID,full_name,email,country_id) values\n" + 
            "(1,'Austin Abro','Austin.Abro@stellantis.com',1),\n" + 
            "(2,'Chris Galivan','Chris.Gallivan@stellantis.com',1),\n" + 
            "(3,'Jackie Chan',null,1),\n" + 
            "(4,'Barry Bonds',null,2),\n" + 
            "(5,'Bjarne Stroustrup',null,3)," +
            "(6,'Linus Torvalds','linus.torvalds@linux.org',1);\n";
        String insertSales = 
            "insert into sales(VIN,person_id,car_id,sale_date) VALUES\n" + 
            "(1,3,1,'2001-09-28'),\n" + 
            "(2,1,1,'2001-09-28'),\n" + 
            "(5,5,4,'2001-09-28'),\n" + 
            "(3,1,1,'2010-11-28'),\n" + 
            "(100,4,1,'2020-03-26'),\n" + 
            "(101,4,2,'2020-03-26'),\n" + 
            "(102,4,7,'2020-03-26'),\n" + 
            "(103,4,5,'2020-03-26'),\n" + 
            "(4,3,4,'2020-10-15');";
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement()) {
            statement.execute(createCountries);
            statement.execute(createPeople);
            statement.execute(createCars);
            statement.execute(createSales);   
            statement.execute(insertCountries);
            statement.execute(insertCars);
            statement.execute(insertPeople);
            statement.execute(insertSales);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        
    }
    
    public static void tearDown(){
        String deleteCountries = "delete from countries;";
        String deleteSales = "delete from sales;";
        String deletePeople = "delete from people;";
        String deleteCars = "delete from stellantis_cars";
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement()) {
            statement.execute(deleteSales);
            statement.execute(deletePeople);
            statement.execute(deleteCars);
            statement.execute(deleteCountries);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPersonName() {
        String querySql = "select full_name from people where id = 1;";
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(querySql);
            return resultSet.getString("full_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getPersonName(int id) {
        String querySql = "select full_name from people where id = ?;";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement statement = connection.prepareStatement(querySql);) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getString("full_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    


    private static String connectionString =
        "jdbc:sqlite:/sandbox/hiker.db";
}

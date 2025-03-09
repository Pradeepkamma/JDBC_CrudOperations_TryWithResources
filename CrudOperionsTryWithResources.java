import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurdOperationsTryWithResources {
	
	private static final String DB_URL ="jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String USER ="root";
	private static final String PASSWORD ="admin";
	
	// CREATE operation (INSERT)
	public static void insertData(int id, String name, String designation, double salary) {
		String insertSQL ="INSERT INTO employees3(id,name,designation,salary) values (" + id + ", '" + name + "', '" + designation + "', " + salary + ")";
		try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
				Statement statement = connection.createStatement()){
			    int rowsAffected = statement.executeUpdate(insertSQL);
			    System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			System.err.println("Error inserting data: " + e.getMessage());
		}
	}
	
	//READ operation (Select)
	public static void retrieveData() {
		String selectSQL ="select * from employees3";
		try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
				Statement statement = connection.createStatement();
			    ResultSet resultSet = statement.executeQuery(selectSQL)){
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
	                String designation = resultSet.getString("designation");
	                double salary = resultSet.getDouble("salary");
	                System.out.println("ID: " + id + " Name: " + name + " Designation: " + designation + " Salary: " + salary);
				}
		} catch (SQLException e) {
			System.err.println("Error retrieving data: " + e.getMessage());
		}
	}
	
	//UPDATE operation
	public static void updateData(int id, String newName, String newDesignation, double newSalary) {
		String updateSQL = "UPDATE employees3 SET name = '" + newName + "', designation = '" 
                + newDesignation + "', salary = " + newSalary + " WHERE id = " + id;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	             Statement statement = connection.createStatement()) {
	            int rowsAffected = statement.executeUpdate(updateSQL);
	            System.out.println("Rows affected: " + rowsAffected);
	        } catch (SQLException e) {
	            System.err.println("Error updating data: " + e.getMessage());
	        }
	    }
	
	//DELETE operation
	public static void deleteData(int id) {
		String deleteSQL = "delete from employees3 where id = "+  id;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	             Statement statement = connection.createStatement()) {
	            int rowsAffected = statement.executeUpdate(deleteSQL);
	            System.out.println("Rows affected: " + rowsAffected);
	        } catch (SQLException e) {
	            System.err.println("Error deleting data: " + e.getMessage());
	        }
	    }
	
	// Main method to demonstrate CRUD operations
	public static void main(String[] args) {
		
		
		// Insert data
        System.out.println("Inserting data...");
        insertData(101, "Pradeep", "Software Engineer", 60000.0);
        insertData(102, "Dharani", "System IO Engineer", 65300.0);
        insertData(103, "Aishu", "Data Science", 54600.0);
        insertData(104, "Chandu", "Electraical Engineer", 35900.0);
        insertData(105, "Ramu", "Mechainacal Engineer", 25400.0);
        insertData(106, "Vamsi", "Hardware", 15430.0);
        insertData(107, "Srujun", "Software Engineer", 56000.0);
       
        // Retrieve data
        System.out.println("\nRetrieving data...");
        retrieveData();

        // Update data
        System.out.println("\nUpdating data...");
        updateData(102, "Dharanii", "Senior Software Engineer", 80000.0);

        // Retrieve data again to see the update
        System.out.println("\nRetrieving data after update...");
        retrieveData();

        // Delete data
        System.out.println("\nDeleting data...");
        deleteData(106);

        // Retrieve data again to see the deletion
        System.out.println("\nRetrieving data after deletion...");
        retrieveData();

	}

}


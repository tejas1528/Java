import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/ myjdbc";
    private static final String userName = "root";
    private static final String password = "FORTNITEbatt1e";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement statement = connection.createStatement();
//            String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            Scanner sc = new Scanner(System.in);
            String debit_query = "UPDATE acc SET balance = balance - ? WHERE acc_no = ?";
            String credit_query = "UPDATE acc SET balance = balance + ? WHERE acc_no = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
            debitPreparedStatement.setDouble(1, 500);
            debitPreparedStatement.setInt(2, 101);
            creditPreparedStatement.setDouble(1, 500);
            creditPreparedStatement.setInt(2, 102);
            int affectedRows1 = debitPreparedStatement.executeUpdate();
            int affectedRows2 = creditPreparedStatement.executeUpdate();


























//                                      (-!____________________Statement_Batching____________________!-)
//            while (true){
//                System.out.print("Enter name: ");
//                String name = sc.next();
//                System.out.print("Enter age: ");
//                int age = sc.nextInt();
//                System.out.print("Enter marks: ");
//                double marks = sc.nextDouble();
//                System.out.print("Enter more data(Y/N): ");
//                String choice = sc.next();
//                String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
//                statement.addBatch(query);
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = statement.executeBatch();
//            for(int i = 0; i < arr.length; i++){
//                if(arr[i] == 0){
//                    System.out.println("Query: " + i + " not executed Successfully");
//                }
//            }


//                                      (-!____________________PreparedStatement_Batching____________________!-)
//            while (true){
//                System.out.print("Enter name: ");
//                String name = sc.next();
//                System.out.print("Enter age: ");
//                int age = sc.nextInt();
//                System.out.print("Enter marks: ");
//                double marks = sc.nextDouble();
//                System.out.print("Enter more data(Y/N): ");
//                String choice = sc.next();
//                preparedStatement.setString(1, name);
//                preparedStatement.setInt(2, age);
//                preparedStatement.setDouble(3, marks);
//                preparedStatement.addBatch();
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = preparedStatement.executeBatch();
//            for(int i = 0; i < arr.length; i++){
//                if(arr[i] == 0){
//                    System.out.println("Query: " + i + " not executed Successfully");
//                }
//            }

//                                      (-!____________________PreparedStatement____________________!-)
//          !----------For Insert----------!
//            String query = "DELETE FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,2);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected > 0) {
//                System.out.println("Data updated");
//            }else{
//                System.out.println("Data not updated");
//            }

//          !----------For Insert----------!
//            String query = "UPDATE students SET id = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,2);
//            preparedStatement.setInt(2,3);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected > 0) {
//                System.out.println("Data updated");
//            }else{
//                System.out.println("Data not updated");
//            }

//          !----------For Retrive----------!
//            String query = "SELECT marks FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks: " + resultSet.getDouble("marks"));
//            }else{
//                System.out.println("Marks not found");
//            }

//          !----------For Insert----------!
//            String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,"Tejjas");
//            preparedStatement.setInt(2,25);
//            preparedStatement.setDouble(3,92.7);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected > 0) {
//                System.out.println("Data inserted");
//            }else{
//                System.out.println("Data not inserted");
//            }


//                                      (-!____________________Statement____________________!-)
//            !----------For Retrive----------!
//            String query = "SELECT * FROM students";
//            ResultSet resulSet = statement.executeQuery(query);
//            while (resulSet.next()){
//                int id = resulSet.getInt("id");
//                String name = resulSet.getString("name");
//                int age = resulSet.getInt("age");
//                double marks = resulSet.getDouble("marks");
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("AGE: " + age);
//                System.out.println("MARKS: " + marks);
//            }

//            !----------For Insert----------!
//            String query2 = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)","Tejjas", 23, 98.0);
//            int rowsAffected = statement.executeUpdate(query2);
//            if(rowsAffected > 0) {
//                System.out.println("Data inserted");
//            }else{
//                System.out.println("Data not inserted");
//            }


//            !----------For Update----------!
//            String query3 = String.format("UPDATE students SET marks = %f WHERE id = %d", 88.5, 2);
//            int rowsAffected = statement.executeUpdate(query3);
//            if(rowsAffected > 0) {
//                System.out.println("Data updated");
//            }else{
//                System.out.println("Data not updated");
//            }

//            !----------For Delete----------!
//            String query4 = "DELETE FROM students WHERE id = 2";
//            int rowsAffected = statement.executeUpdate(query4);
//            if(rowsAffected > 0) {
//                System.out.println("Data deleted");
//            }else{
//                System.out.println("Data not deleted");
//            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    static boolean isSufficient(Connection connection, int acc_no){
        PreparedStatement preparedStatement = 
    }
}
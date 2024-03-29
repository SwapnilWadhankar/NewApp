import java.sql.*;
class NewApp {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //It contains all the appropriate methods to register and deregister the database driver class and to create a connection between a Java application and the database.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.....");
            //dbprotocolName:dbenginename://ipaddress:portnumber/dbname
            String url = "jdbc:mysql://localhost:3306/newapp";
            String userName = "root";
            String passWord = System.getenv("DATABASE_USER_PASSOWRD");

            //A Connection is a session between a Java application and a database. It helps to establish a connection with the database.
            connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println("Connection established successfully...");
            System.out.println("Classname details " + connection.getClass().getName());

            //SQL query to return ID, name, address and age from the IPLteam table
            String sqlSelectQuery = ("select sid,sname,sage,saddress from IPLteam");

            //create statement object which can be used to execute the SQL queries
            statement = connection.createStatement();
            System.out.println("Classname of class implemented : "+ statement.getClass().getName());

            //create a resultset object which can store the output generated by the sql query
            resultSet = statement.executeQuery(sqlSelectQuery);
            System.out.println("Classname of class implemented : "+ resultSet.getClass().getName());
            System.out.println();
            System.out.println("Id\t Name\tAge\tTeam\t");

            //move the cursor to the next row to see if there is value, if yes then return the value
            while(resultSet.next()){
                Integer sid = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                String team = resultSet.getString(4);

                System.out.println(sid +"\t"+name+"\t"+age+"\t"+team+"\t");
            }
        }catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //if connection is still present, close it else throw an error
            if(connection!=null){
                try{
                    connection.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }
    }
}

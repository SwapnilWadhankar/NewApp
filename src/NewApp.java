import java.sql.*;
class NewApp {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.....");
            String url = "jdbc:mysql://localhost:3306/newapp";
            String userName = "root";
            String passWord = "Li0nelMe$$i@_719449";
            connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println("Connection established successfully...");
            String sqlSelectQuery = ("select sid,sname,sage,saddress from IPLteam");
            System.out.println("Classname details " + connection.getClass().getName());
            statement = connection.createStatement();
            System.out.println("Classname of class implemented : "+ statement.getClass().getName());
            resultSet = statement.executeQuery(sqlSelectQuery);
            System.out.println("Classname of class implemented : "+ resultSet.getClass().getName());
            System.out.println();
            System.out.println("Id\t Name\tAge\tTeam\t");
            while(resultSet.next()){
                Integer sid = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                String team = resultSet.getString(4);

                System.out.println(sid +"\t"+name+"\t"+age+"\t"+team+"\t");
            }
        }catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
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


package pkg18bcb0140_java_jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        //kanak agarwal 
        //MAPS
        //roll number - 47
    
        System.out.println("\n\t\tESTABLISHING CONNECTION");
        String url="jdbc:mysql://localhost:3306/JAVA_TH_STUDENTS?SSL=true";
        String user="root";
        String pass="";
        FileOutputStream fO=null;
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,user,pass);
             Statement stmt = conn.createStatement();
             System.out.println("\t\tCONNECTED SUCCESSFULLY");
             System.out.println("\t_______________________________________________________________________________");
             
             System.out.println("\n\t\tCREATING A TABLE NAMED STUDENT_DETAILS IN THE DATABASE JAVA_TH_STUDENTS");
             //CREATING TABLE STUDENT_DETAILS
             String sql = "CREATE TABLE STUDENT_DETAILS " + "(name VARCHAR(100) , " + "PHOTO LONGBLOB, "+"register_number VARCHAR(100), " + 
                   "city VARCHAR(100), " + "company_placed VARCHAR(100), " + "salary INTEGER, "+"cgpa FLOAT)"; 
             stmt.executeUpdate(sql);
            System.out.println("\t\tSTUDENT_DETAILS TABLE SUCCESSFULLY CREATED");
            System.out.println("\t_______________________________________________________________________________");
             
            
            //INSERTING STUDENT RECORDS
            
            //STUDENT1 RECORD
            System.out.println("\n\t\tINSERTING RECORDS INTO THE TABLE");  
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT1', ? , '1', 'Prachi Pal', 'CHENNAI' , 2060000 ,9.5)");
            InputStream pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT1.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT2 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT2', ? , '2', 'Vipasha', 'WORK_INDIA' , 4000000 ,9.3)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT2.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT3 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT3', ? , '3', 'Ansh', 'Delhi' , 3400000 ,8.5)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT3.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT4 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT4', ? , '4', 'Riya Kumari', 'Noida' , 3000000 ,9.2)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT4.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT5 5
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT5', ? , '5', 'Dev Kumar Verma', 'Delhi' , 2917000 ,9.0)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT5.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT6 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT6', ? , '6', 'Anshika ', 'Delhi' , 2800000 ,8.5)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT6.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT7 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT7', ? , '7', 'Tarun Rawat', 'Dehradoon' , 2820000 ,9.5)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT7.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
            //STUDENT8 RECORD
            pstmt = conn.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES('STUDENT8', ? , '8', 'Nikita Adhikari', 'Ajmer' , 953300 ,8.2)");
            pic = new FileInputStream("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_PHOTOS\\STUDENT8.png");
            pstmt.setBlob(1, pic);
            pstmt.execute();
            
        
         System.out.println("\t\tSUCCESSFULLY INSERTED ALL THE RECORDS");
         
         System.out.println("\t_______________________________________________________________________________");
         System.out.println("\n\t\tDETAILS OF STUDENT WITH HIGHEST PACKAGE\n");
         
         //SELECTING HIGHEST PACKAGE STUDENT
         String QUERY = "SELECT name,PHOTO, register_number, city, company_placed, salary,cgpa FROM STUDENT_DETAILS WHERE salary = (SELECT salary from STUDENT_DETAILS as a ORDER BY salary DESC LIMIT 0,1)";
         ResultSet rs = stmt.executeQuery(QUERY);
         
          byte picture[];
          Blob blob;
          int i=1;
         while(rs.next())
         {
            //DISPLAYING HIGHEST SALARY RECORD 
            System.out.println("\t\tNAME: " + rs.getString("name"));
            System.out.println("\t\tREGISTERATION NUMBER : " + rs.getString("register_number"));
            System.out.println("\t\tCITY: " + rs.getString("city"));
            System.out.println("\t\tCOMPANY PLACED: " + rs.getString("company_placed"));
            System.out.println("\t\tSALARY: " + rs.getInt("salary"));
            System.out.println("\t\tCGPA: " + rs.getFloat("cgpa"));
            i++;
             System.out.println("\t_______________________________________________________________________________");
            //RETRIVING THE PHOTO OF STUDENT WITH HIGHEST RECORD TO FOLDER
            File f=new File("E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_WITH_HIGHEST_PACKAGE_PHOTOS\\" + rs.getString("name") + ".jpg");
            fO=new FileOutputStream(f);
            blob=rs.getBlob("PHOTO");
            picture=blob.getBytes(1,(int)blob.length());
            fO.write(picture);
            System.out.println("\n\t\t\tFILE SUCCESSFULLY SAVED IN THE LOCATION\n\t\t"+" E:\\3. JAVA LAB\\JAVA JDBC\\STUDENTS_WITH_HIGHEST_PACKAGE_PHOTOS\\");
            System.out.println();
         }
        }
        catch(Exception e)      
        {
                    
            System.out.println(e);
               
        }
    }
    
}

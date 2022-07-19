Import java.sql.Connection; 

Import java.sql.PreparedStatement; 

Import java.sql.ResultSet; 

Import java.sql.SQL Exception; 

Import java.sql.Statment; 

Import java.util.ArrayList; 

Import com.bean.Customer; 

Import com.util.dbUtil; 


Public class CustomerDAO { 

Connection con = null;      //establish connection 

Prepared Statement ps= null;      //Execute SQL Statments 

Prepared Statement id = null; 

ResultSet rs = null ; 


Public int registerCustomer(Customer c){ 

int result = 0; // rows 

con = dbUtil.getConnection();//connection 

try 

{ 
id = con.prepareStatement ("select round(dbms_random.value*1000) from dual"); //generates random id from 1-1000 for each customer 

ps= con. prepareStatement ("insert into Customer values(?,?,?,?,P,?,?) "); //queries for insertion of values 

rs = id.executeQuery(); //execute insert 


while(rs.next()){ 

ps.setString(1, c.getName()); //inserted based on format of table 

ps. setString(2, c.getAddress()); 

ps. setString (3, c.getEmailID()); 

ps. setInt (4, c.getContactNo()) ; 

ps.setInt (5,rs.getInt (1)); //generate random id , gets the random generated id from results set 

ps. setstring(6,"TCSQ21"); //default password 

ps.setInt (7,c.getPland()); //plan ID for the later part 

result = ps. executeUpdate(); 

System.out.println( "Your system generated ID is: "+ rs.getInt(1)); 

} catch (SQLException e1) { 

e1.printStackTrace(); 

} 

finally{ 
dbUtil.closeConnection(con); 
} 

return result u; 
} 

 

public int updatePassword (int custId, String password) //taking two variables custid and password 

{int result p= 0; 

con = dbUtil.getConnection(); 

try 

{ 
ps = con.prepareStatement ("update Customer set password=? where custId=?"); 

ps. setString(1, password); // inserted into the first ? 

ps.setInt (2, custId); //inserted into second ? 

result p = ps.executeUpdate(); //execute query and return p 

} catch (SOLException e) { 

e.printstackTrace(); 

} 

Finally { dbUtil.closeConnection(con); } 

return result p; 

} 

 

public int Login(int id, String pass){ 

int status = 0; 

con = dbUtil.getconnection(); 

try { 

Ps = con.prepareStatement ("select * from Customer where custId="" 

+ id + "' and password='" +pass + "'"); 

rs= ps.executeQuery(); //Select 

if (rs.next)){ 

system.out.println("\nWELCOME+ rs.getString(1) 

status= 1;} 

} catch (SQLException e) { 

e.printStackTrace(); 

} 

finally{dbUtil.closeConnection(con); 

} 

return status; 

} 

public ArrayList‹Customer› fetchCustomerDetails(int custId){ 

ArrayList<Customer> list = new ArrayList<Customer>): 

con = dbUtil.getConnection(); 

try { 

ps = con.prepareStatement ("select * from Customer where custId=?"); 

ps.setInt (1, custId); 

rs= ps. executeQuery(); //Select 

While(rs.next()){ 

String name =rs.getString(1); 

String address = rs.getString(2); 

String emailID = rs.getString(3); 

int contactNo = rs.getInt(4); 

int customerId = rs.getInt(5); 

String password = rs.getString(6); 

Int planId = rs.getInt(7); 

 

Customer c = new Customer(name,address,emailID,contactNo,customerId,password,planId); 

List.add(c); } 

} catch (SQL Exception e){  

e.printStackTrace(); } 

Finally { db.Util.closeConnection(con); 

} return list; } 
                   

public boolean checkIdInsert (int custId){ 

boolean check = false; 

con = dbUtil.getConnection(); 

try { 

ps= con.prepareStatement ("select * from Customer where custId=?"): 

ps.setInt (1, custId); 

rs= ps.executeQuery(); //Select 

if(rs.next ()){ 

check= true; 

} 

} catch (SOLException e) { 

e.printStackTrace};
} 


finally{ 

dbUtil.closeConnection(con); 

} 

return check; 

}   
                   
public ArrayList‹Customer> operatorFetchCustDetails(int custId){ 

ArrayList‹Customer> listCust = new ArrayList‹Customer>() : 

con = dbUtil.getConnection) 

try { 

// SQL command data stored in String datatype 


Statement stmt= con.createStatement(); 

ResultSet rs = stmt.executeQuery ("select * from Customer") 

// Printing of the SQL command above 

System.out.printf( "%-8s %12s %20s %20s %20s %n"', "Customer ID", "Name", "Address", 

"Email","Contact No"); 

// Condition check 

while (rs.next()) { 

int custId1= rs.getInt("custId"); 

String name= rs.getString("name"); 

String address = rs.getString("address"); 

String email = rs.getString("emailID"); 

int contactNo = rs.getInt ("contactNo"); 

System.out.printf( "%-8s %15s %28s %20s %20s %n", custId1, name, address, email, contactNo); 

} catch (SQLException e){ 

e.printStackTrace(); 

} 

finally{ 

dbUtil.closeConnection(con); 

} 

return listCust; 

} 
  
public int deleteCustomer(int custId) 

{ 

int rows=0; 

con=dbUtil.getconnection(); 

}

Try { 

ps = con.prepareStatement("delete from Customer where custId=?"); 

ps.setInt(1,custId); 

rows=ps.executeUpdate(); //dml insert,delete,update 

} catch( DQLException e) { 

 //TODO Auto-generated catch-block 

e.printStackTrace(); } 

finally { 

dbUtil.closeConnection(con);  

}
  return rows ; 

} 

} 

 

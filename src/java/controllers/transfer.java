
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/balance")
public class transfer {
    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Bean userForm = new Bean();    
        model.put("userForm", userForm);
         
        return "transfer";
    }    
    @RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Bean user, 
			Map<String, Object> model) {
            
            user.setResult(
                    transfer(
                            user.getAcc_no(),
                            user.getName(),
                            user.getPass(),
                            user.getAcc2(),
                            user.getAmount()
                            )
                    );
         return "transfer";
	}    
        
        public void myconnection()
    { 
        try
        {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance() ;
       String url="jdbc:sqlserver://localhost;instance=LallyInfosys;databaseName=online_banking;user=online_banking;password=123";
           cn=DriverManager.getConnection(url);    }
        catch(Exception e)
        { System.out.println(e);} }
        
        public String transfer(int acc_no,String user_name,String pass,int acc2,int amount)
        { 
            try
            {
                myconnection();
        sql="Select * from user_accounts where account_number='"+acc_no+"' and user_n='"+user_name+"' and pass='"+pass+"' ;";
            st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      
      if(rs.next())
      { 
          sql="Select * from user_accounts where account_number='"+acc2+"'";
         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery(sql); 
            if(!rs.next())
            { 
                return "Please make sure Receiver's Account Number is Correct !!!";
            
            }
         
             sql="Select * from user_accounts where account_number='"+acc_no+"' and user_n='"+user_name+"' and pass='"+pass+"' ;";
            st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      if(rs.next());
         int bal= rs.getInt("balance");
         if(bal<amount)
         { return "Insufficient Amount";}
         else
         {
         sql="Update user_accounts set balance='"+(bal-amount)+"' where account_number='"+acc_no+"' and user_n='"+user_name+"' ;";
         st=cn.createStatement();
         st.executeUpdate(sql);
         sql="Select * from user_accounts where account_number='"+acc_no+"'";
         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery(sql);
         
         sql="Select * from user_accounts where account_number='"+acc2+"' ;";
          st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
         if(rs.next())
         {  bal= rs.getInt("balance");
         
           sql="Update user_accounts set balance='"+(bal+amount)+"' where account_number='"+acc2+"' ;";
          st=cn.createStatement();
         st.executeUpdate(sql);
         sql="Select * from user_accounts where account_number='"+acc2+"'";
         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery(sql); 
         
         
         
         }
         return "Transfer Successfull.....";
         }
      }
      else 
      { return "Please Check your Details and Try Again....";}
        }
            catch(Exception e)
            { return e+"";}
            
        }
        
     
    
        
}

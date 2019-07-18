
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "/balance")
public class balance {
    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Bean userForm = new Bean();    
        model.put("userForm", userForm);
         
        return "balance";
    }    
    @RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Bean user, 
			Map<String, Object> model) {
            
            user.setResult(check_balance(user.getAcc_no(),user.getName(),user.getPass()));
         return "balance";
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
        
        public String check_balance(int acc_no,String user_name,String pass)
        { 
            try
            {
                myconnection();
        sql="Select * from user_accounts where account_number='"+acc_no+"' and user_n='"+user_name+"' and pass='"+pass+"' ;";
            st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      
      if(rs.next())
      { 
          
      return "Your Balance is : Rs "+rs.getInt("balance");
      }
      else 
      { return "Please Check your Details and Try Again....";}
            }
            catch(Exception e)
            { return e+"";}
            
        }
        
        
    
        
}

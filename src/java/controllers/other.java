
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
@RequestMapping (value = "/other")
public class other {
    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    @RequestMapping (method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Bean userForm = new Bean();    
        model.put("userForm", userForm);
         
    
            return "other";
    }    
    @RequestMapping (method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Bean user, 
			Map<String, Object> model) {
             if(user.getOther().equals("MAKE ACCOUNT"))
                 return "make_account";
              if(user.getOther().equals("DELETE ACCOUNT"))
            { return "delete_account";}
            if(user.getOther().equals("DEPOSIT"))
                return "deposit";
             if(user.getOther().equals("ADD MONEY"))
             {
                 user.setResult(deposit(user.getAcc_no(),user.getAmount()));
                 return "deposit";
             }
             if(user.getOther().equals("WITHDRAW"))
                return "withdraw";
             if(user.getOther().equals("WITHDRAW MONEY"))
             {
                 
                  user.setResult(withdraw(user.getAcc_no(),user.getAmount()));
                 return "withdraw";
             }
                 else 
               return "login";
	}    
        
         public void myconnection()
    { 
        try
        {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance() ;
       String url="jdbc:sqlserver://localhost;instance=LallyInfosys;databaseName=online_banking;user=online_banking;password=123";
           cn = DriverManager.getConnection(url);    }
        catch(Exception e)
        {
		System.out.println(e);}
	 }
    public String deposit(int accn , int amt)
    { 
        try
            
        {
            if(amt<=0)
            { return "Please Enter valid amount";}
            myconnection();
        sql="Select * from user_accounts where account_number ="+accn+" ;";
         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=st.executeQuery(sql);
        if(rs.next())
        { 
            int bal=rs.getInt("balance");
            
            sql="Update user_accounts set balance ='"+(bal+amt)+"' where account_number ='"+accn+"' ;";
            st=cn.createStatement();
            st.executeUpdate(sql);
           return "Money Added. "
                   + " Balance is : Rs "+(bal+amt);       
        }
        else
        { return "Please Enter valid Account Number";}
            }
        catch(Exception e)
        { return e+"";}
    }
        public String withdraw(int accn , int amt)
    { 
        try
            
        {
            if(amt<=0)
            { return "Please Enter valid amount";}
            
            myconnection();
        sql="Select * from user_accounts where account_number ="+accn+" ;";
         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=st.executeQuery(sql);
        if(rs.next())
        { 
            int bal=rs.getInt("balance");
            if(amt>bal)
            { return "Insufficient Balance";}
            
            sql="Update user_accounts set balance ='"+(bal-amt)+"' where account_number ='"+accn+"' ;";
            st=cn.createStatement();
            st.executeUpdate(sql);
           return "Money Withdrawn. "
                   + " Balance is : Rs "+(bal-amt);       
        }
        else
        { 
		return "Please Enter valid Account Number";
	}
            }
        catch(Exception e)
        { 
		return e+"";
	}
    }
}

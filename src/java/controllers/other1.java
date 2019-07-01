
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
@RequestMapping(value = "/other_1")
public class other1 {
    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Bean userForm = new Bean();    
        model.put("userForm", userForm);
         
    
            return "other_1";
    }    
    @RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Bean user, 
			Map<String, Object> model) {
           
           
             if(user.getOther().equals("MAKE USER ACCOUNT"))
             {
    user.setResult(     
            make(
                        user.getName(),
                        user.getAcc_no(),
                        user.getUname(),
                        user.getPass(),
                        user.getEmail(),
                       user.getAmount()
                    )  
    ); 
             return "make_account";
             }
                  
            
             if(user.getOther().equals("DELETE USER ACCOUNT"))
             {
    user.setResult(del(user.getAcc_no())  );
                 
                 
                 return "delete_account";
             }
             else 
                 return "static";
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
    public String make(String name,int acc_no,String uname,String pass,String email,int amount)
    { 
        try
            
        {
            myconnection();
            sql="Select * from user_accounts where account_number ='"+acc_no+"' ;";
            st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      if(rs.next())
      { return "Account Number Already Exists.Please Select new Account Number..";}
      
            sql="Insert into user_accounts values ("+"'"+correct(name)+"' ,"+
                    "'"+acc_no+"' ,"+
                    "'"+correct(uname)+"' ,"+
                    "'"+correct(pass)+"' ,"+
                    "'"+correct(email)+"' ,"+
                    "'"+amount+"' "+
                    ") ;";
                    st=cn.createStatement();
                    st.executeUpdate(sql);
                    return "Account created successfully....!!";
            
        }
        catch(Exception e)
        { return e+"";}
    }
    
    public String correct(String str)
    { 
    String str2="";
    
    for(int i=0;i<str.length();i++)
    { if((str.charAt(i)+"").equals(","))
        break;
    else
        str2=str2+str.charAt(i);
       
    }
    return str2;
    }
       public String del(int acc_no)
    { 
        try
            
        {
            myconnection();
            sql="Select * from user_accounts where account_number ='"+acc_no+"' ;";
            st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      if(!rs.next())
      { return "Account Number does not exists.";}
      
            sql="Delete from user_accounts where account_number='"+acc_no+"' ";
                    st=cn.createStatement();
                    st.executeUpdate(sql);
                    return "Account Deleted successfully....!!";
            
        }
        catch(Exception e)
        { return e+"";}
    }
}

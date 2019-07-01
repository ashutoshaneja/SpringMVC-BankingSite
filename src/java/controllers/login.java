
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/deposit")
public class login {
    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Bean userForm = new Bean();    
        model.put("userForm", userForm);
         
         
        return "admin";
    }    
    @RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Bean user, 
			Map<String, Object> model) {
            
		
		
            if(check(user.getBranch(),user.getPass()))
                return "static2";
            else
            { user.setResult("Incorrect Details");
                return "admin";
            }
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
         
         public String[] get()
         { try
         {
             sql="Select branch from admins";
             st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             rs=st.executeQuery(sql);
             rs.last();
             String br[]=new String[rs.getRow()+1];
             int i=0;
             while(rs.next())
             { 
                 br[i]=rs.getString("branch");
                 i++;
             }
             return br;
         }
         catch(Exception e)
         { 
         String ex[] = new String[1];
         ex[0]=e+"";
         return ex;
         }
         }
    public boolean check(String branch,String pass)
    { 
     try
         { myconnection();
             sql="Select * from admin where branch='"+branch+"' and pass='"+pass+"' ;";
             st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             rs=st.executeQuery(sql);
            
             if(rs.next())
             { 
                 return true;
             }
             else
             return false;
         }
         catch(Exception e)
         { 
        
         System.out.println(e+"");
          return false;
         }
    
    }
        
}

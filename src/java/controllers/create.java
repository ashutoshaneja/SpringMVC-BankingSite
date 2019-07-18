
package controllers;

 import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class create {

    @RequestMapping
     public String menu (ModelMap m)
            {
            return "static";
             }
    
}

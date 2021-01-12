<<<<<<< HEAD
package rocks.process.Studentstuff.Studentstuffweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @RequestMapping(path = "/")
    public class IndexController {


        @GetMapping
        public String getIndexView() {
            return "Home.html";
        }

        @GetMapping(path = "/Policy")
        public String getPolicyView() {
            return "PrivacyPolicy.html";
        }
    }

=======
@Controller
@RequestMapping (path = "/")
public class CustomerController {
    @getMapping
    public String getIndexView() {return "Home.html"}
}
>>>>>>> parent of 7d7e3dd... Merge pull request #20 from andreasmartin/main

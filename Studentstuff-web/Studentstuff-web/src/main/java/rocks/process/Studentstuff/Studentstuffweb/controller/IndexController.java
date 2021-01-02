@Controller
@RequestMapping (path = "/")
public class CustomerController {
    @getMapping
    public String getIndexView() {return "Home.html"}
}
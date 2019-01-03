import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "Filter1")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        String userN = req.getParameter("userN");
        String passU = req.getParameter("passU");
        ArrayList<User> myUser = new ArrayList<>();
        myUser.add(new User("Drew", "123", "asb75@txstate.edu"));
        myUser.add(new User("Ryan", "456", "mrm75@txstate.edu"));
        myUser.add(new User("Luke", "789", "lol75@txstate.edu"));
        User user = new User(userN, passU);

        for (User person : myUser) {
            if (userN.equals((person.getUserName())) && passU.equals(person.getUserPassword())) {
                chain.doFilter(req, resp);
            }
            else {
                HttpServletResponse rsp = (HttpServletResponse) resp;
                rsp.sendRedirect("/login.jsp");
                return;
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

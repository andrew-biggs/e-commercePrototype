import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/index.html";
        String action = request.getParameter("action");
        HttpSession mySession = request.getSession();
        UserArray userSession = (UserArray) mySession.getAttribute("myUser");
        Cart cartSession = (Cart) mySession.getAttribute("aCart");
        boolean verify = false;

        if(userSession == null){
            userSession = new UserArray();
        }
        userSession.AddToList((new User("Drew", "123", "asb75@txstate.edu")));
        userSession.AddToList((new User("Ryan", "456", "mrm75@txstate.edu")));
        userSession.AddToList((new User("Luke", "789", "lol75@txstate.edu")));
        /*for (User e : userSession.getMyUser()) {
            System.out.println(e.getUserName() + " " + e.getUserPassword() + " " + e.getEmail()); ----> loop that checks to see if preset is saved.
        }*/

        if(action.equals("create")){
            url = "/create.jsp";
        }
        else if(action.equals("login")){
            url = "/login.jsp";
        }
        else if(action.equals("addUser")){
            String un = request.getParameter("userN");
            String pw = request.getParameter("passU");
            String em = request.getParameter("email");

            User u1 = new User (un, pw, em);
            userSession.AddToList(u1);
            mySession.setAttribute("myUser", userSession);
            for (User e : userSession.getMyUser()) {
                System.out.println(e.getUserName() + " " + e.getUserPassword() + " " + e.getEmail()); // loop that checks to see if new account saved.
            }
            url = "/login.jsp";
        }
        else if(action.equals("enter")) {
            String un = request.getParameter("userN");
            String pw = request.getParameter("passU");
            String em = request.getParameter("email");

            for (User e : userSession.getMyUser()) {
                if (un.equals((e.getUserName())) && pw.equals(e.getUserPassword())) {
                    System.out.println("all good");
                    verify = true;
                }
            }
            if (verify) {
                pw = Encryption.AlgMD5(pw);

                User u1 = new User(un, pw, em);

                mySession.setAttribute("aUser", u1);
                request.setAttribute("aUser", u1);
                url = "/Welcome.jsp";
            }
            else {
                for(User e : userSession.getMyUser()) {
                    System.out.println(e.getUserName() + " " + e.getUserPassword() + " " + e.getEmail());
                }
                String error = "ERROR: username or password is incorrect. Try again.";
                request.setAttribute("error", error);
                url = "/login.jsp";
            }
        }
        if(action.equals("addService")){
            if(cartSession == null){
                cartSession = new Cart();
            }
            String id = request.getParameter("product_id");
            String desc = request.getParameter("itemDesc");
            Integer numOfItem = Integer.parseInt(request.getParameter("numOfItems"));
            Double itemPrice = Double.parseDouble(request.getParameter("price"));

            Service newService = new Service(id, desc, numOfItem, itemPrice);
            cartSession.AddToCart(newService);
            mySession.setAttribute("aCart", cartSession);
            url = "/appointment.jsp";
        }
        else if (action.equals("continue")){
            url = "/Welcome.jsp";
        }
        else if (action.equals("checkout")){
            url = "/Checkout.jsp";
        }
        else if (action.equals("logout")){
            url = "/login.jsp";
            mySession.removeAttribute("aCart");
            //mySession.invalidate();
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    // Note to self: I commented out the session invalidate above to be able to log back in with a created account
    // after logging out (array saves info). Unfortunately this enables users to access any page by typing in url, even when not logged in.
    // Possible solution: Create filter that checks for a boolean variable? maybe when logging in variable is switched
    // to "on" and after logging out variable switched to "off". Have a filter check for variable status, and send user back to login page if
    // variable is in "off" status. Appointment page needs working on; needs to utilize date and time functionality.

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

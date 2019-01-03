import java.util.ArrayList;
public class Cart {

    private ArrayList<Service> myCart;

    public Cart() {
        myCart = new ArrayList<>();
    }

    public ArrayList<Service> getMyCart() {
        return myCart;
    }

    public void setMyCart(ArrayList<Service> myCart) {

        this.myCart = myCart;
    }

    public void AddToCart(Service prod) {
        String prodId = prod.getItemId(); //assign hidden product id value to prodId string
        int prodNumb = prod.getNumOfItems(); // assign hidden number of items to number of items variable
        for (int i = 0; i < myCart.size(); i++) {
            Service itc = myCart.get(i);
            if (itc.getItemId().equals(prodId)) {
                itc.setNumOfItems(itc.getNumOfItems() + prodNumb);
                return;
            }
        }
        myCart.add(prod);
    }

    public void RemoveFromCart(Service prod) {
        myCart.remove(prod);
    }

}

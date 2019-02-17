package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import net.minidev.json.parser.JSONParser;
import stackjava.com.demojsf.form.CartToClientForm;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.ProductService;

@SuppressWarnings("serial")
@ManagedBean(name = "clientHomeController")
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "clientHome", pattern = "/client/home", viewId = "/client/home.xhtml"),
		@URLMapping(id = "clientCart", pattern = "/client/cart", viewId = "/client/cart.xhtml"),
		@URLMapping(id = "clientCheckout", pattern = "/client/checkout", viewId = "/client/checkout.xhtml"),
		@URLMapping(id = "clientCategory", pattern = "/client/categories", viewId = "/client/category.xhtml"),
		@URLMapping(id = "clientOrder", pattern = "/client/orders", viewId = "/client/order.xhtml"),
		@URLMapping(id = "clientConfirmation", pattern = "/client/confirmation", viewId = "/client/confirmation.xhtml"),
		@URLMapping(id = "clientProductDetail", pattern = "/client/productDetail", viewId = "/client/productDetail.xhtml"),
		@URLMapping(id = "clientContact", pattern = "/client/contact", viewId = "/client/contact.xhtml") })
public class ClientHomeController implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Product> list;

	private String cart;

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	@SuppressWarnings("deprecation")
	public HashMap<Integer, Integer> checkCart() {
		HashMap<Integer, Integer> hmCart = new HashMap<Integer, Integer>();
		ArrayList<CartToClientForm> lstCartToClientForm = new ArrayList<CartToClientForm>();
		// [[1,1],[2,1],[3,1],[6,1],[4,1]]
		// [1,1],[2,1],[3,1],[6,1],[4,1]
//		String cartT = "[[1,1]]";
		/*List<String> list = new ArrayList<String>(Arrays.asList(cart.split("\\]")));
		int i = 0;
		for (String string : list) {
			// System.out.println(string);

			if (i == 0) {
				List<String> listS = new ArrayList<String>(Arrays.asList(string.split("\\[")));
				for (String string2 : listS) {
					List<String> listSS = new ArrayList<String>(Arrays.asList(string2.split(",")));
					CartToClientForm cart = new CartToClientForm();
					for (int j = 0; j < listSS.size(); j++) {
						if (!listSS.get(j).equals("")) {
							System.out.println("a: " + listSS.get(j));
							if (j % 2 == 0) {
								if (Integer.parseInt(listSS.get(j)) != 0) {
									cart.setId(Integer.parseInt(listSS.get(j)));
								}
							} else {
								cart.setQuantity(Integer.parseInt(listSS.get(j)));
							}

						}
					}
					lstCartToClientForm.add(cart);
				}
			} else {
				List<String> listS = new ArrayList<String>(Arrays.asList(string.split(",\\[")));
				for (String string2 : listS) {
					List<String> listSS = new ArrayList<String>(Arrays.asList(string2.split(",")));
					CartToClientForm cart = new CartToClientForm();
					for (int j = 0; j < listSS.size(); j++) {
						if (!listSS.get(j).equals("")) {
							System.out.println("a: " + listSS.get(j));
							if (j % 2 == 0) {
								if (Integer.parseInt(listSS.get(j)) != 0) {
									cart.setId(Integer.parseInt(listSS.get(j)));
								}
							} else {
								cart.setQuantity(Integer.parseInt(listSS.get(j)));
							}

						}
					}
					lstCartToClientForm.add(cart);
				}
			}
			i++;

		}
		for (CartToClientForm string : lstCartToClientForm) {
			System.out.println("id" + string.getId()  + " quantity: "+ string.getQuantity());
		}*/
		
//		JSONArray mJsonArray = new JSONArray(cartT);
//		JSONObject mJsonObject = new JSONObject();
//		for (int i = 0; i < mJsonArray.length(); i++) {
//		    mJsonObject = mJsonArray.getJSONObject(i);
//		    System.out.println(mJsonObject.getString("1"));
//		}
		  String jsReturn =" [{1:1, 3:3}]";
		    JSONArray array = new JSONArray(jsReturn); 
		    for (Object object : array) {
				System.out.println(object.toString().split(",")[0]);
			}
		    int i = 0;
		    JSONObject myJsonObject = new JSONObject();
		    while(i < array.length()){
		        myJsonObject = array.getJSONObject(i); 
		       
		        i++;
		    }
		
		return hmCart;

	}

	public static void main(String[] args) {
		ClientHomeController cl = new ClientHomeController();
		cl.checkCart();
	}

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getList() {
		return this.list = productService.getAll();
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	List<Product> listFilter;

	public List<Product> getListFilter() {
		return this.listFilter = productService.getListFilter();
	}

	public void setListFilter(List<Product> listFilter) {
		this.listFilter = listFilter;
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.inventory;

/**
 * Servlet implementation class AddInventoryServlet
 */
@WebServlet("/addInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("product-name");
		String price = request.getParameter("price");
		String qty = request.getParameter("qty");
		
		int convertPrice = Integer.parseInt(qty);
		double convertQty = Double.parseDouble(price);
		
		inventory inv = new inventory(name, convertPrice, convertQty);
		inventoryHelper helper = new inventoryHelper();
		
		helper.insertItem(inv);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.inventory;

/**
 * Servlet implementation class EditInventoryServlet
 */
@WebServlet("/editInventoryServlet")
public class EditInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inventoryHelper helper = new inventoryHelper();
		
		String name = request.getParameter("productName");
		String price = request.getParameter("price");
		String qty = request.getParameter("qty");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		inventory itemToUpdate = helper.searchForItemById(tempId);
		
		itemToUpdate.setProductName(name);
		itemToUpdate.setPrice(Double.parseDouble(price));
		itemToUpdate.setQuantity(Integer.parseInt(qty));
		
		helper.editItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewFullInventoryServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

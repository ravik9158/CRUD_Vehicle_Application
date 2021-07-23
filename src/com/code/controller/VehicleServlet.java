package com.code.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.dao.VehicleDAO;
import com.code.model.Vehicle;

/**
 * Servlet implementation class VehicleServlet
 */
@WebServlet("/")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleDAO vehicleDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleServlet() {
		this.vehicleDAO = new VehicleDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/new": {
			showNewForm(request, response);
			break;
		}
		case "/insert": {
			try {
				insertVehicle(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		case "/delete": {
			try {
				deleteUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		case "/edit": {
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		case "/update": {
			try {
				updateVehicle(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		default:
			try {
				listVehicle(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}

	private void listVehicle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Vehicle> listVehicle = this.vehicleDAO.selectAllVehicles();
		request.setAttribute("listVehicle", listVehicle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-list.jsp");
		dispatcher.forward(request, response);
	}

	private void updateVehicle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");

		Vehicle vehicle = new Vehicle(id, brand, model, type, price, quantity);
		this.vehicleDAO.updateVehicle(vehicle);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Vehicle existingVehicle = this.vehicleDAO.selectVehicle(id);
		existingVehicle.setId(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-form.jsp");
		request.setAttribute("vehicle", existingVehicle);
		dispatcher.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.vehicleDAO.deleteVehicle(id);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertVehicle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		Vehicle newVehicle = new Vehicle(brand, model, type, price, quantity);
		this.vehicleDAO.insertVehicle(newVehicle);
		response.sendRedirect("list");
	}

}

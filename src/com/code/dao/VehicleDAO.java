package com.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.code.model.Vehicle;

public class VehicleDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vehicle_management_system?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_VEHICLE_SQL = "INSERT INTO vehicle  (brand, model, type, price, quantity) VALUES  (?, ?, ?, ?, ?);";
    private static final String SELECT_VEHICLE_BY_ID = "select id, brand, model, type, price, quantity from vehicle where id = ?";
    private static final String SELECT_ALL_VEHICLES = "select * from vehicle";
    private static final String DELETE_VEHICLE_SQL = "delete from vehicle where id = ?;";
    private static final String UPDATE_VEHICLE_SQL = "update vehicle set brand = ?, model= ?, type =?, price =?, quantity =? where id = ?;";
	
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return connection;
    }
    
    public void insertVehicle(final Vehicle vehicle) throws SQLException {
        try {
        	Connection connection = getConnection();
        	PreparedStatement prepareStatement = connection.prepareStatement(INSERT_VEHICLE_SQL);
        	prepareStatement.setString(1, vehicle.getBrand());
        	prepareStatement.setString(2, vehicle.getModel());
        	prepareStatement.setString(3, vehicle.getType());
        	prepareStatement.setString(4, vehicle.getPrice());
        	prepareStatement.setString(5, vehicle.getQuantity());
        	
        	prepareStatement.executeUpdate();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public boolean updateVehicle(Vehicle vehicle) throws SQLException {
    	boolean rowUpdated = false;
    	try {
    		Connection connection = getConnection();
        	PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_VEHICLE_SQL);
        	prepareStatement.setString(1, vehicle.getBrand());
        	prepareStatement.setString(2, vehicle.getModel());
        	prepareStatement.setString(3, vehicle.getType());
        	prepareStatement.setString(4, vehicle.getPrice());
        	prepareStatement.setString(5, vehicle.getQuantity());
        	prepareStatement.setInt(6, vehicle.getId());
        	
        	rowUpdated = prepareStatement.executeUpdate() > 0;
        	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return rowUpdated;
    }
    
    public Vehicle selectVehicle(int id) {
    	Vehicle vehicle = null;
    	
    	try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VEHICLE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	String brand = rs.getString("brand");
            	String model = rs.getString("model");
            	String type = rs.getString("type");
            	String price = rs.getString("price");
            	String quantity = rs.getString("quantity");
            	
            	vehicle = new Vehicle(brand, model, type, price, quantity);
            }
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return vehicle;
    }
    
    public List<Vehicle> selectAllVehicles() {
    	List<Vehicle> vehicles = new ArrayList<Vehicle>();
    	
    	try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VEHICLES);
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	int id = rs.getInt("id");
            	String brand = rs.getString("brand");
            	String model = rs.getString("model");
            	String type = rs.getString("type");
            	String price = rs.getString("price");
            	String quantity = rs.getString("quantity");
            	
            	vehicles.add(new Vehicle(id, brand, model, type, price, quantity));
            }
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return vehicles;
    }
    
    public boolean deleteVehicle(int id) {
    	boolean rowDeleted = false;
    	
    	try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VEHICLE_SQL);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            
            rowDeleted = preparedStatement.executeUpdate() > 0;
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return rowDeleted;
    }
}

package com.ty.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.car.dto.Car;
import com.ty.car.helper.ConnectorObject;

public class CarDao {

	public void addCar(Car car) {

		Connection connection = ConnectorObject.connect();
		String sql = "INSERT INTO car VALUES(?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, car.getId());
			statement.setString(2, car.getName());
			statement.setDouble(3, car.getPrice());
			statement.execute();
			
			System.out.println("data Saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		Connection connection = ConnectorObject.connect();
		String sql = "DELETE FROM car WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("data deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Car getById(int id) {
		Connection connection = ConnectorObject.connect();
		String sql = "SELECT * FROM car WHERE id =?";
		Car car = new Car();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setPrice(resultSet.getDouble(3));
			}
			return car;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	ArrayList<Car> cars = new ArrayList<Car>();

	public List<Car> getAllCar() {
		Connection connection = ConnectorObject.connect();
		String sql = "SELECT * FROM car";

		try {

			Statement setatment = connection.createStatement();
			ResultSet set = setatment.executeQuery(sql);
			while (set.next()) {
				Car car = new Car();
				car.setId(set.getInt(1));
				car.setName(set.getString(2));
				car.setPrice(set.getDouble(3));
				cars.add(car);
			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

}

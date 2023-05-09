package com.ty.car.controler;

import java.util.List;

import com.ty.car.dao.CarDao;
import com.ty.car.dto.Car;

public class CarDriver {
public static void main(String[] args) {
	Car car=new Car();
	
	car.setId(5);
	car.setName("toyato");
	car.setPrice(3000000);
	
	CarDao carDao=new CarDao();
	//method 1
	//carDao.addCar(car);
	
	//method 2
	//carDao.delete(1);
	
 List<Car> cars=   carDao.getAllCar();
 
 for(Car c : cars) {
	 System.out.println(c);
 }
}
}

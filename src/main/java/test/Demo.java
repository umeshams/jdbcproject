package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ty.car.helper.ConnectorObject;

public class Demo {
	public static void main(String[] args) throws Exception {

		Connection connection = ConnectorObject.connect();
        //statment inteface
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet set = statement.executeQuery("SELECT * FROM car");
		set.absolute(7);

		while (set.previous()) {
			System.out.println(set.getInt(1));
		}

		//preparedstatment interface
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car",
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet set2 = preparedStatement.executeQuery();
		System.out.println("prepard statment");
		set2.afterLast();
		//get all details from back to top
		while (set2.previous()) {
			System.out.println(set2.getInt(1));
		}

	}
}

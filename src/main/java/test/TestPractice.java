package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.ty.car.helper.ConnectorObject;

public class TestPractice {
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectorObject.connect();

		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM car";

		ResultSet set = statement.executeQuery(sql);
		while (set.next()) {
			System.out.println(set.getInt(1));
		}

		statement.execute("DELETE FROM car WHERE id=6");
		connection.commit();

		statement.execute("INSERT INTO car VALUES(6,'volvo',4000000)");

		connection.commit();
		// rollback is get all the row upto where you commit the data
		connection.rollback();
		System.out.println("rollback");
		set = statement.executeQuery("SELECT * FROM car");
		while (set.next()) {
			System.out.println(set.getInt(1));
		}

	}

}

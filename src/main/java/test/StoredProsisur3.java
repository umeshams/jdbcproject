package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Type;
import com.ty.car.helper.ConnectorObject;

public class StoredProsisur3 {
	public static void main(String[] args) {
		Connection connection = ConnectorObject.connect();

		try {
			CallableStatement cal = connection.prepareCall("{?=call getcall()}");
		
                
			ResultSet rs = cal.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(0)+"  "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

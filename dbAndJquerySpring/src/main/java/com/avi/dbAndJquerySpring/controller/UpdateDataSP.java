package com.avi.dbAndJquerySpring.controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.avi.dbAndJquerySpring.StoredProcedures;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;

@StoredProcedures("UpdateData")
public class UpdateDataSP extends StoredProcedure{

	
	private static final String spName = "updateData1";
	private Connection conn;
	
	public UpdateDataSP(DataSource ds) {
		super(ds, spName);
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		declareParameter(new SqlParameter("id",Types.STRUCT));
		declareParameter(new SqlOutParameter("message", Types.BIGINT));
		compile();
		
		//declareParameter(new SqlParameter(1,Types.REAL));
	}
	
	public Long getData() {
		
	    Long[] a = {1l,2l,3l,4l};
	    Array ab = null;
	    SQLServerDataTable st = null;
	    try {
	    	 st = new SQLServerDataTable();
			st.addColumnMetadata("id",java.sql.Types.BIGINT);
			
			//st.addRow(5);
			st.addRow(4);
			st.addRow(3);
			st.addRow(2);
			st.addRow(1);
			//ab = conn.createArrayOf("BIGINT", a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id",st);
		
		Map<String, Object> out = super.execute(param);
		Long result = (Long)out.get("message");
		return result;
	}
}

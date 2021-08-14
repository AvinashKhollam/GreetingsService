package com.avi.dbAndJquerySpring.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;

@Repository
@Transactional
public class TestDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UpdateDataSP updateDataSP;
	
	public Long getData () {
		Long data = 7l;
		Long s = 0l;
		String data1 = "";
		StoredProcedureQuery sq = null;
		try {
			SQLServerDataTable st = new SQLServerDataTable();
			st.addColumnMetadata("id",java.sql.Types.BIGINT);
			
			//st.addRow(5);
			st.addRow(4);
			st.addRow(3);
			st.addRow(2);
			st.addRow(1);
			//Parameter<SQLServerDataTable> tt = new SQLServerDataTable();
			/*sq = manager.createStoredProcedureQuery("dbo.updateData1")
					.registerStoredProcedureParameter("id", Object.class, ParameterMode.IN)
					.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
			sq.setParameter("id", (Object)st);
			sq.setParameter(arg0, arg1)
			
			sq.execute();*/
			
			
			
			
			
			
			//Connection connection = dataSource.getConnection();
			//  SQLServerCallableStatement pstmt = (SQLServerCallableStatement)connection.prepareCall("{call dbo.updateData1(?, ?)}")
					  
				//	  .unwrap(SQLServerCallableStatement.class);
					  
			//  pstmt.registerOutParameter("message", Types.VARCHAR);
			  
			//  pstmt.setStructured(1, "dbo.Dimension", st);
			//  pstmt.registerOutParameter(2, Types.BIGINT);
			//  pstmt.setString("message", "");
			  
			 // pstmt.execute();
			  s = updateDataSP.getData();
			
			/*jdbcTemplate.setResultsMapCaseInsensitive(true);
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
					.withProcedureName("updateData1").withCatalogName("dbo")
					.withoutProcedureColumnMetaDataAccess()
					.declareParameters(new SqlParameter("id",Types.class),
							new SqlOutParameter("message", Types.VARCHAR));
			Types.class
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", st);
			Map<String, Object> out = call.execute(params);*/
			 //data  =  pstmt.getLong(2);
			// pstmt.get
			//  data1 = "7";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}

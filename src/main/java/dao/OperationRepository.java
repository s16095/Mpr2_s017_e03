package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by L on 05.11.2016.
 */
public class OperationRepository extends RepositoryBase{

	public OperationRepository(Connection connection) {
		super(connection);
	}

	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE operations("
			+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
			+ "name varchar(5)," + ")";
	}
	@Override
	protected String tableName() {
		return "Operations";

	}
}
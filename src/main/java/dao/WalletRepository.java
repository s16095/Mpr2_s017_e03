package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IWalletRepository;
import dao.uow.IUnitOfWork;
import domain.model.Person;
import domain.model.Wallet;

public class WalletRepository extends RepositoryBase<Wallet>
implements IWalletRepository{

	public WalletRepository(Connection connection,
			IMapResultSetIntoEntity<Wallet> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
	}

		@Override
		protected String createTableSql() {
			return "CREATE TABLE wallet("
					+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
					+ "accountId int," + "asset DECIMAL," + "CURRENCY_ID int,"
					+ "PERSON_ID int,"
					+ "FOREIGN KEY (PERSON_ID) REFERENCES people(id),"
					+ "FOREIGN KEY (CURRENCY_ID) REFERENCES currency(id)" + ")";
		}

		@Override
		protected String tableName() {
			return "wallet";
		}
		
		protected String insertSql() {
			return "INSERT INTO wallet(AccountId, Asset) VALUES (?,?)";
		}
		
		protected String updateSql() {
			return "UPDATE wallet SET (AccountId, Asset)=(?,?) WHERE id=?";
		}
		
		@Override
		protected void setUpdate(Wallet entity) throws SQLException {
			update.setInt(1, entity.getAccountID());
			update.setBigDecimal(2, entity.getAsset());
			
		}

		@Override
		protected void setInsert(Wallet entity) throws SQLException {
			insert.setInt(1, entity.getAccountID());
			insert.setBigDecimal(2, entity.getAsset());
		}

		public List<Wallet> byPerson(Person person) {
			// TODO Auto-generated method stub
			return null;
		}	
	}


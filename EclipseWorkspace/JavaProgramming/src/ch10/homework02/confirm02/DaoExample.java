package ch10.homework02.confirm02;

public class DaoExample {

	public static void dbWork(DataAccessObject dao){
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
		
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

}

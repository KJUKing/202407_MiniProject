package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BookingVo;

public class BookingDao {
	private static BookingDao instance;

	private BookingDao() {

	}

	public static BookingDao getInstance() {
		if (instance == null) {
			instance = new BookingDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public void bookingUpdate(List<Object> paramBk) {
		String sql = "INSERT INTO BOOKING\r\n" +
				"VALUES ((SELECT NVL(MAX(BK_CODE),0)+1 FROM BOOKING), ? , ?, 'N')";

		jdbc.update(sql, paramBk);

	}

	public void bookingUpdate1(List<Object> paramBk) {
		String sql = "BEGIN\r\n" +
				"    INSERT INTO BOOKING (BK_CODE, FK_SCH_CODE, FK_SEAT_CODE)\r\n" +
				"    VALUES ((SELECT NVL(MAX(BK_CODE),0)+1 FROM BOOKING), ?, ?);\r\n" +
				"\r\n" +
				"    INSERT INTO BOOKING (BK_CODE, FK_SCH_CODE, FK_SEAT_CODE)\r\n" +
				"    VALUES ((SELECT NVL(MAX(BK_CODE),0)+1 FROM BOOKING), ?, ?);\r\n" +
				"\r\n" +
				"    COMMIT;\r\n" +
				"EXCEPTION\r\n" +
				"    WHEN OTHERS THEN\r\n" +
				"        ROLLBACK;\r\n" +
				"        RAISE;\r\n" +
				"END;";
		jdbc.update(sql, paramBk);

	}

	public BookingVo bookingSelectOne(List<Object> paramBk) {
		String sql = "";
		return jdbc.selectOne(sql, paramBk, BookingVo.class);
	}

	public BookingVo bookingSelect(List<Object> paramBk) {
		String sql = " SELECT BK_CODE\r\n" +
				" FROM BOOKING\r\n" +
				" WHERE FK_SCH_CODE = ?\r\n" +
				" AND FK_SEAT_CODE = ?";
		return jdbc.selectOne(sql, paramBk, BookingVo.class);
	}

	public List<BookingVo> bookingSelectList(List<Object> paramBk) {
		String sql = "SELECT BK_CODE\r\n" +
				"FROM BOOKING\r\n" +
				"WHERE ((FK_SCH_CODE = ? AND FK_SEAT_CODE = ?)\r\n" +
				"OR (FK_SCH_CODE = ? AND FK_SEAT_CODE = ?))";
		return jdbc.selectList(sql, paramBk, BookingVo.class);
	}

	public void bookingDelete(List<Object> paramBk) {
		String sql = "DELETE BOOKING\r\n" +
				"WHERE BK_CODE = ?";
		jdbc.update(sql, paramBk);
	}

	public void bookingDelete1(List<Object> paramBk) {
		String sql = "DELETE BOOKING\r\n" +
				"WHERE BK_CODE IN(?,?)";
		jdbc.update(sql, paramBk);

	}

	public void bkCheckUpdate(List<Object> paramBk) {
		String sql = "UPDATE BOOKING\r\n" +
				"SET BK_CHECK_NY = 'Y'\r\n" +
				"WHERE BK_CODE = ? ";
		jdbc.update(sql, paramBk);

	}

	public List<BookingVo> bkCheckSelect() {
		String sql = "SELECT FK_SEAT_CODE\r\n" +
				"FROM BOOKING\r\n" +
				"WHERE BK_CHECK_NY = 'N'";
		return jdbc.selectList(sql, BookingVo.class);
	}


	public void bkCheckDelete() {
		String sql = "DELETE FROM BOOKING\r\n" +
				"WHERE BK_CHECK_NY = 'N'";
		jdbc.update(sql);
	}

	public void bkCheckUpdate1(List<Object> paramBk) {
		String sql = "UPDATE BOOKING\r\n" +
				"SET BK_CHECK_NY = 'Y'\r\n" +
				"WHERE BK_CODE IN (?,?)";
		jdbc.update(sql, paramBk);

	}

	public BookingVo bookingDelBeforeSel(List<Object> param) {
		String sql = "SELECT FK_SEAT_CODE\r\n" +
				"FROM BOOKING\r\n" +
				"WHERE BK_CODE = ? ";

		return jdbc.selectOne(sql, param, BookingVo.class);
	}

	public void bookingTicketDelete(List<Object> param) {
		String sql = "DELETE BOOKING\r\n "
				+ "	WHERE BK_CODE = ?";
		jdbc.update(sql, param);

	}
}

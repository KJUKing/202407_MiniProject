package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class AdminDao {
	private static AdminDao instance;

	private AdminDao() {

	}

	public static AdminDao getInstance() {
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<MemberVo> memberAllList() {
		String sql = "SELECT *\r\n" + 
				"FROM MEMBER\r\n" + 
				"WHERE MEM_ID != 'admin'";
		return jdbc.selectList(sql, MemberVo.class);
	}

	public List<MemberVo> ticketAllList() {
		String sql = "SELECT J.HFDNIC AS MEM_NICK, I.MN AS MOVIE_NAME, I.EGN AS GENRE, I.KPT AS PART_TYPE, I.RUNNING_TIME AS RUNNING_TIME, J.HRN AS ROW_NUM, J.HSN AS SEAT_NUM, J.HFTP AS PRICE, I.FDTN AS THE_NAME, HFDTI AS TICKET, J.HFDMN AS MEM_NAME \r\n" + 
				"  FROM (SELECT G.FK_MOVIE_CODE AS FMC, H.RN AS HRN, H.SN AS HSN, H.FDMN AS HFDMN, H.FDNIC AS HFDNIC, H.FDTI AS HFDTI, H.FTP AS HFTP, G.FK_THE_CODE AS FTC  \r\n" + 
				"          FROM SCHEDULE G, (SELECT E.ROW_NUM AS RN, E.SEAT_NUM AS SN, FK_THE_CODE1 AS TC, F.DMN AS FDMN, F.DNIC AS FDNIC, F.DTI AS FDTI, F.TP AS FTP  \r\n" + 
				"                              FROM SEAT E, (SELECT FK_SEAT_CODE AS SC , D.MN AS DMN, D.NIC AS DNIC, D.TI AS DTI, D.TP  \r\n" + 
				"                                              FROM BOOKING C, (SELECT A.MEM_NAME AS MN, A.MEM_NICK AS NIC, B.TICKET AS TI, B.FK_BK_CODE AS BK, B.TOTAL_PRICE AS TP  \r\n" + 
				"                                                                 FROM MEMBER A, TICKET B  \r\n" + 
				"                                                                WHERE A.MEM_NO = B.FK_MEM_NO) D  \r\n" + 
				"                                             WHERE C.BK_CODE = D.BK)F  \r\n" + 
				"				            WHERE F.SC = E.SEAT_CODE  \r\n" + 
				"				              AND E.STATUS = 'Y') H  \r\n" + 
				"          WHERE G.FK_THE_CODE = H.TC)J,  \r\n" + 
				"		(SELECT (F.DPT||'-'||(TRUNC((TO_NUMBER(SUBSTR(F.DPT,1,2))*60+  \r\n" + 
				"		         E.MOVIE_TIME)/60)||':'||MOD((TO_NUMBER(SUBSTR(F.DPT,1,2))*60+  \r\n" + 
				"				 E.MOVIE_TIME),60))) AS RUNNING_TIME,  \r\n" + 
				"				 E.MOVIE_CODE AS MC,  \r\n" + 
				"				 E.MOVIE_NAME AS MN,  \r\n" + 
				"                 F.DTC AS FDTC,  \r\n" + 
				"				 E.GENRE AS EGN,  \r\n" + 
				"                 E.MOVIE_TIME AS EMT,  \r\n" + 
				"				 K.PART_TYPE AS KPT,  \r\n" + 
				"				 F.DTN AS FDTN                            \r\n" + 
				"		  FROM MOVIE E, (SELECT C.FK_MOVIE_CODE AS MC,  \r\n" + 
				"				                D.PT AS DPT,  \r\n" + 
				"				                D.TC AS DTC,  \r\n" + 
				"				                D.TN AS DTN  \r\n" + 
				"				           FROM SCHEDULE C, (SELECT B.THE_CODE AS TC,  \r\n" + 
				"				                                    A.PART_TIME AS PT,  \r\n" + 
				"				                                    B.THE_NAME AS TN \r\n" + 
				"				                               FROM TIME A, THEATER B \r\n" + 
				"                                              WHERE A.TIME_CODE = B.FK_TIME_CODE) D \r\n" + 
				"                          WHERE D.TC = C.FK_THE_CODE) F, RATE_CODE K \r\n" + 
				"          WHERE F.MC = E.MOVIE_CODE \r\n" + 
				"		    AND K.RATE_CODE = E.FK_RATE)I \r\n" + 
				"WHERE J.FMC = I.MC \r\n" + 
				"AND J.FTC = I.FDTC \r\n" + 
				"ORDER BY TICKET";
		return jdbc.selectList(sql, MemberVo.class);
	}
}

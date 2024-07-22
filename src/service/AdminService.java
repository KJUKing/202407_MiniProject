package service;

import java.util.List;

import dao.AdminDao;
import vo.MemberVo;

public class AdminService {
	private static AdminService instance;

	private AdminService() {

	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}
	AdminDao dao = AdminDao.getInstance();

	public List<MemberVo> memberAllList() {
		
		return dao.memberAllList();
	}

	public List<MemberVo> ticketAllList() {
		
		return dao.ticketAllList();
	}
}

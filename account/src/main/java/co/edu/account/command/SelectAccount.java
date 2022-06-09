package co.edu.account.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.account.common.Command;
import co.edu.account.service.AccountService;
import co.edu.account.serviceImpl.AccountServiceImpl;
import co.edu.account.vo.AccountVO;

public class SelectAccount implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		AccountService dao = new AccountServiceImpl();
		List<AccountVO> list = new ArrayList<AccountVO>();
		list = dao.selectList();
		req.setAttribute("list", list);
		System.out.println(req.getAttribute("list"));
		return "account/selectList";
		
	}

}

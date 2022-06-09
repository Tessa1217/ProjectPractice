package co.edu.account.service;

import java.util.List;

import co.edu.account.vo.AccountVO;

public interface AccountService {
	
	List<AccountVO> selectList();
	AccountVO selectAccount(AccountVO vo);
	int insertAccount(AccountVO vo);
	int updateAccount(AccountVO vo);
	int deleteAccount(AccountVO vo);
	

}

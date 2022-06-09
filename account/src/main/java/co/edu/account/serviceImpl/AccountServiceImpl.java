package co.edu.account.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.edu.account.common.DataSource;
import co.edu.account.service.AccountMapper;
import co.edu.account.service.AccountService;
import co.edu.account.vo.AccountVO;

public class AccountServiceImpl implements AccountService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private AccountMapper map = sqlSession.getMapper(AccountMapper.class);
	
	@Override
	public List<AccountVO> selectList() {
		return map.selectList();
	}

	@Override
	public AccountVO selectAccount(AccountVO vo) {
		return map.selectAccount(vo);
	}

	@Override
	public int insertAccount(AccountVO vo) {
		return map.insertAccount(vo);
	}

	@Override
	public int updateAccount(AccountVO vo) {
		return map.updateAccount(vo);
	}

	@Override
	public int deleteAccount(AccountVO vo) {
		return map.deleteAccount(vo);
	}

}

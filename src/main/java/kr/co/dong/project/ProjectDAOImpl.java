package kr.co.dong.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace="kr.co.dong.projectMapper";
	
	
	
	
	
	@Override
	public int product_totalRecord() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".product_totalRecord");
	}
	@Override
	public int mypage_totalRecord(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".mypage_totalRecord", user_id);
	}
	

	@Override
	public int boardsReadCnt(int boards_no) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+".boardsReadCnt", boards_no);
	}
	
	@Override
	public List<BoardsVO> reviewlist(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".reviewlist", product_id);
	}
	
	
	
	
	@Override
	public ProductVO productDetail(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".productDetail", product_id);
	}
	@Override
	public List<AddressVO> addresslist(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".addresslist", user_id);
	}
	
	
	
	
	
	@Override
	public List<ProductVO> listProduct(int start, int pageSIZE) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("pageSIZE", pageSIZE);
		return sqlSession.selectList(nameSpace + ".listProduct", map);
	}
	@Override
	public List<ProductVO> listMypage(int start, int pageSIZE, String user_id) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("pageSIZE", pageSIZE);
		map.put("user_id", user_id);
		return sqlSession.selectList(nameSpace + ".listMypage", map);
	}
	
	
	

	@Override
	public Map<String, Object> projectLogin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace +".projectLogin",map);
	}

	@Override
	public int join(UserVO userVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".join", userVO);
	}
	@Override
	public int pay(BuyVO buyVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".pay", buyVO);
	}
	@Override
	public int review(BoardsVO boardsVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".review", boardsVO);
	}

	

	

	

}

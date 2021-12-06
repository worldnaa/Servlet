package connectionPool.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectionPool.common.dao.AbstractDao;
import connectionPool.service.user.vo.UserVO;

// AbstarctDao 공유 회원관리 Service 담당 DAO

public class  UserDao extends AbstractDao{
	
	// Field 
	
	// Constructor
	public UserDao(){
	}

	// Method
	public void getUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try{		
			// 1단계 connection
			con = this.connect();
			
            // 2단계 statement 
			pStmt = con.prepareStatement("SELECT user_id , password FROM users WHERE user_id=? AND password=?");
			pStmt.setString(1,userVO.getId());
			pStmt.setString(2,userVO.getPwd());

			//3단계 resultset
			rs = pStmt.executeQuery();
			if(rs.next()){    
				System.out.println("db에서 확인 한 id,pwd ==>: "+userVO.getId()+" : " +userVO.getPwd());
				userVO.setActive(true);
			}else{               
            	System.out.println("db에 < "+userVO.getId()+" >에 해당하는 자료가 없습니다.");
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con, pStmt, rs);
		}
	}//end of getUser()
	
	public boolean addUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		boolean insertResult   = false;
		try{		
			//1단계 connection
			con = this.connect();
			
			//2단계 statement 
			pStmt = con.prepareStatement("INSERT INTO users ( user_no, user_id, password ) VALUES( ? , ? , ? )" );
			pStmt.setInt(1,userVO.getNo());
			pStmt.setString(2,userVO.getId());
			pStmt.setString(3,userVO.getPwd());

			//3단계 결과값 확인하기
			if( 1 == pStmt.executeUpdate()){    
				insertResult = true;
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con,pStmt);
		}
		return insertResult; 
	}//end of addUser()
	
	public List<UserVO> getUserList(){
		List<UserVO> arrayList = new ArrayList<UserVO>();
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try{		
			// 1단계 connection
			con = this.connect();
			
            // 2단계 statement 
			pStmt = con.prepareStatement("SELECT user_no, user_id, password FROM users ORDER BY user_no");

			//3단계 resultset
			rs = pStmt.executeQuery();
			while(rs.next()) {
				UserVO userVO = new UserVO();
				userVO.setNo(rs.getInt("user_no"));
				userVO.setPwd(rs.getString("password"));
				userVO.setId(rs.getString("user_id"));
				System.out.println(userVO);
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con, pStmt, rs);
		}
		return arrayList;
	}

}

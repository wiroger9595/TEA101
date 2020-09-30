package com.space.model;

import java.util.List;

public class SpaceService {
	
	private SpaceDAOInterface dao;
	
	public SpaceService(){
		dao = new SpaceDAO();
	}
	
	public SpaceVO addSpace(SpaceVO spaceVO) {
		dao.insert(spaceVO);
		return spaceVO;
	}
	
	
	public SpaceVO updateSapce(SpaceVO spaceVO) {
		dao.update(spaceVO);
		return spaceVO;
	}
	
	public void deleteSpace(String spaceId) {
		dao.delete(spaceId);
	}
	
	
	public SpaceVO selectOneSpace(String spaceId) {
		return dao.selectOne(spaceId);
	}
	
	public List<SpaceVO> selectAllSpace() {
		return dao.getAll();
	}
	
	
//	====================================================================
	
	

   

    public List<SpaceVO> queryByStartEnd(int start, int end) {
        return dao.queryByStartEnd(start, end);
    }

    
    

}


package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsJudge;

public interface GamesJudgeDao extends GenericDao{
	/**
	 * 根据比赛Id获取裁判员名单
	 * @param gamesId 比赛Id
	 * @return 裁判列表
	 */
	public List<YsmsJudge> getJudgesByGameId(int gamesId);
	
	/**
	 * 添加或修改比赛中的裁判员
	 * @param ysmsJudge 裁判员
	 */
	public void save(YsmsGamesJudge ysmsGamesJudge);
	
	/**
	 * 删除一名裁判员
	 * @param ysmsGamesJudge 裁判员
	 */
	public void delete(YsmsGamesJudge ysmsGamesJudge);
	


	/**
	 * 根据比赛和裁判查找比赛裁判关系
	 * @param gameId 比赛Id
	 * @param judgeId 裁判Id
	 * @return 关系对象
	 */
	public YsmsGamesJudge getJudgeRelationByIdAndGameId(int gameId, int judgeId);
	
	/**
	 * 根据比赛和裁判员位置查找
	 * @param gamesId
	 * @param positionIndex
	 * @return
	 */
	public YsmsGamesJudge getJudgeByGameAndPosition(int gamesId, int positionIndex);
	
	/**
	 * 根据裁判获取该裁判参加过的场次
	 * @param judgeId
	 * @return
	 */
	public List<YsmsGamesJudge> getJudgeRelationsByJudgeId(int judgeId);
	
}

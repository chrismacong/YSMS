package com.cwkj.ysms.dao.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.view.AssistRankView;
import com.cwkj.ysms.model.view.ShooterRankView;
import com.cwkj.ysms.util.Page;

@Repository
public class GamesDaoImpl extends GenericDaoImpl implements GamesDao {
	private static final Log log = LogFactory.getLog(GamesDaoImpl.class);

	@Override
	public List<YsmsGames> getGamesByTeamId(int teamId) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by teamId");
		try {
			String sql = " from YsmsGames g where g.ysmsTeamByHostTeamid.teamId = "+teamId 
					+ " or g.ysmsTeamByGuestTeamid.teamId = "+teamId;
			List<Object> objects= findByHQL(sql);
			List<YsmsGames> results = new ArrayList<YsmsGames>();
			for(int i=0;i<objects.size();i++){
				YsmsGames game = (YsmsGames)objects.get(i);
				results.add(game);
			}
			log.debug("find by teamId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by teamId failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByDate(Date date) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by date");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date oneDayAfterDate = cal.getTime();
			String sql = " from YsmsGames g where g.gamesTime between ? and ?";
			Query query = getSession().createQuery(sql);
			query.setDate(0,date);
			query.setDate(1,oneDayAfterDate);
			List<YsmsGames> results = query.list();
			log.debug("find by date successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByZoneId(int zoneId) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by zoneId");
		try {
			String sql = " from YsmsGames g where g.ysmsLeagueZone.zoneId = " + zoneId;
			List<Object> objects= findByHQL(sql);
			List<YsmsGames> results = new ArrayList<YsmsGames>();
			for(int i=0;i<objects.size();i++){
				YsmsGames game = (YsmsGames)objects.get(i);
				results.add(game);
			}
			log.debug("find by leagueId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by leagueId failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByZoneIdAndDate(int zoneId, Date date) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by zoneId and date");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date oneDayAfterDate = cal.getTime();
			String sql = " from YsmsGames g where g.ysmsLeagueZone.zoneId = " + zoneId 
					+ " and g.gamesTime between ? and ?";
			Query query = getSession().createQuery(sql);
			query.setDate(0, date);
			query.setDate(1,oneDayAfterDate);
			List<YsmsGames> results = query.list();
			log.debug("find by leagueId and date successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by leagueId and date failed", re);
			throw re;
		}
	}

	@Override
	public void save(YsmsGames ysmsGames) {
		log.debug("saving YsmsGames instance");
		try {
			getSession().saveOrUpdate(ysmsGames);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGames findById(int gamesId) {
		log.debug("getting YsmsGames instance with id: " + gamesId);
		try {
			YsmsGames result = (YsmsGames) getSession()
					.get("com.cwkj.ysms.model.YsmsGames", gamesId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsGames ysmsGames) {
		log.debug("deleting YsmsGames instance");
		try {
			getSession().delete(ysmsGames);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByZoneIdBetweenDate(int zoneId,
			Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by zoneId and period");
		try {
			String sql = " from YsmsGames g where g.ysmsLeagueZone.zoneId = " + zoneId 
					+ " and g.gamesTime between ? and ?";
			Query query = getSession().createQuery(sql);
			query.setDate(0, beginDate);
			query.setDate(1,endDate);
			List<YsmsGames> results = query.list();
			log.debug("find by leagueId and period successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by leagueId and period failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByTeamIdBetweenDate(int teamId,
			Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		log.debug("find YsmsGames instance by teamId and period");
		try {
			String sql = " from YsmsGames g where (g.ysmsTeamByHostTeamid.teamId = "+teamId 
					+ " or g.ysmsTeamByGuestTeamid = "+teamId +") and g.gamesTime between ? and ?";
			Query query = getSession().createQuery(sql);
			query.setDate(0,beginDate);
			query.setDate(1, endDate);
			List<YsmsGames> results = query.list();
			log.debug("find by teamId and period successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
	}
	
	@Override
	public List<YsmsGames> getGamesBySchoolIdBetweenDate(int schoolId,
			Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		log.debug("find YsmsGames instance by teamId and period");
		try {
			String sql = " from YsmsGames g where (g.ysmsTeamByHostTeamid.ysmsSchool.schoolId = "+schoolId 
					+ " or g.ysmsTeamByGuestTeamid.ysmsSchool.schoolId = "+schoolId +") and g.gamesTime between ? and ?";
			Query query = getSession().createQuery(sql);
			query.setDate(0,beginDate);
			query.setDate(1, endDate);
			List<YsmsGames> results = query.list();
			log.debug("find by teamId and period successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
	}
	
	@Override
	public List<YsmsGames> getGamesBetweenDate(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		log.debug("find YsmsGames instance by teamId and period");
		try {
			String sql = " from YsmsGames g where g.gamesTime between ? and ? order by g.gamesTime asc";
			Query query = getSession().createQuery(sql);
			query.setDate(0,beginDate);
			query.setDate(1, endDate);
			List<YsmsGames> results = query.list();
			log.debug("find by teamId and period successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
	}
	
	@Override
	public YsmsGames getNextGameByTeamId(int teamId) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String sql = " select g from YsmsGames g" + 
					" where g.ysmsTeamByHostTeamid.teamId = " + teamId + 
					" or g.ysmsTeamByGuestTeamid.teamId = " + teamId + 
					" and g.gamesTime > ? order by g.gamesTime asc";
			Query query = getSession().createQuery(sql);
			query.setDate(0,date);
			List<YsmsGames> objects = query.list();
			if (objects.size() < 1) {
				return null;
			}
			YsmsGames result = objects.get(0);
			log.debug("find by teamId after date successful, gamesId: " + result.getGamesId());
			return result;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGames getLastGameByTeamId(int teamId) {
		log.debug("finding YsmsGames instance by teamId before date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String sql = " select g from YsmsGames g" + 
					" where g.ysmsTeamByHostTeamid.teamId = " + teamId + 
					" or g.ysmsTeamByGuestTeamid.teamId = " + teamId + 
					" and g.gamesTime < ? order by g.gamesTime desc";
			Query query = getSession().createQuery(sql);
			query.setDate(0,date);
			List<YsmsGames> objects = query.list();
			if (objects.size() < 1) {
				return null;
			}
			YsmsGames result = objects.get(objects.size() - 1);
			log.debug("find by teamId before date successful, gamesId: " 
					+ result.getGamesId());
			return result;
		} catch (RuntimeException re) {
			log.error("find by teamId before date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> findByFuzzyQueryAndPage(Integer leagueId, Integer zoneId, Date date, Page page) {
		log.debug("finding  ByFuzzyQueryAndPage instances");
		try {
			String queryString = "from YsmsGames as yg where 0=0";
			if(leagueId != null){
				queryString += " and yg.ysmsLeagueZone.ysmsLeague.leagueId = " + leagueId;
			}
			if (zoneId != null) {
				queryString += " and yg.ysmsLeagueZone.zoneId = " + zoneId;
			}
			if (date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				queryString += " and yg.gamesTime like '%" + sdf.format(date)
						+ "%' ";
			}
			queryString += " order by yg.gamesTime asc, yg.gamesId asc";
			Query queryObject = getSession().createQuery(queryString);
			if (page != null) {
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}

	@Override
	public int getGamesCount(Integer leagueId, Integer zoneId, Date date) {
		log.debug("finding  ByFuzzyQueryAndPage instances");
		try {
			String queryString = "from YsmsGames as yg where 0=0";
			if(leagueId != null){
				queryString += " and yg.ysmsLeagueZone.ysmsLeague.leagueId = " + leagueId;
			}
			if (zoneId != null) {
				queryString += " and yg.ysmsLeagueZone.zoneId = " + zoneId;
			}
			if (date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				queryString += " and yg.gamesTime like '%" + sdf.format(date)
						+ "%' ";
			}
			queryString += " order by yg.gamesTime ";
			return this.getHqlRecordCount(queryString);
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGames getNextGameByAthleteId(int athleteId) {
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			String sql = " select g from YsmsGames g, YsmsTeam t, YsmsTeammember tm" + 
					" where (g.ysmsTeamByHostTeamid.teamId = t.teamId" + 
					" or g.ysmsTeamByGuestTeamid.teamId = t.teamId)" + 
					" and t.teamId = tm.ysmsTeam.teamId" + 
					" and tm.ysmsAthlete.athleteId = " + athleteId + 
					" and g.gamesTime > ? order by g.gamesTime asc";
			Query query = getSession().createQuery(sql);
			query.setString(0, dateStr);
			List<YsmsGames> objects = query.list();
			if (objects.size() < 1) {
				return null;
			}
			YsmsGames result = objects.get(0);
			log.debug("find by teamId after date successful, gamesId: " + result.getGamesId());
			return result;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGames getLastGameByAthleteId(int athleteId) {
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			String sql = " select g from YsmsGames g, YsmsTeam t, YsmsTeammember tm" + 
					" where (g.ysmsTeamByHostTeamid.teamId = t.teamId" + 
					" or g.ysmsTeamByGuestTeamid.teamId = t.teamId)" + 
					" and t.teamId = tm.ysmsTeam.teamId" + 
					" and tm.ysmsAthlete.athleteId = " + athleteId + 
					" and g.gamesTime < ? order by g.gamesTime desc";
			Query query = getSession().createQuery(sql);
			query.setString(0, dateStr);
			List<YsmsGames> objects = query.list();
			if (objects.size() < 1) {
				return null;
			}
			YsmsGames result = objects.get(0);
			log.debug("find by teamId after date successful, gamesId: " + result.getGamesId());
			return result;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> findAll() {
		log.debug("finding all YsmsGames instances");
		try {
			String queryString = "from YsmsGames where 0=0 order by gameTime asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getNextGamesByTeamId(int teamId) {
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String sql = " select g from YsmsGames g" + 
					" where g.ysmsTeamByHostTeamid.teamId = " + teamId + 
					" or g.ysmsTeamByGuestTeamid.teamId = " + teamId + 
					" and g.gamesTime > ? order by g.gamesTime asc";
			Query query = getSession().createQuery(sql);
			query.setDate(0,date);
			List<YsmsGames> objects = query.list();
			return objects;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getLastGamesByTeamId(int teamId) {
		log.debug("finding YsmsGames instance by teamId before date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String sql = " select g from YsmsGames g" + 
					" where g.ysmsTeamByHostTeamid.teamId = " + teamId + 
					" or g.ysmsTeamByGuestTeamid.teamId = " + teamId + 
					" and g.gamesTime < ? order by g.gamesTime desc";
			Query query = getSession().createQuery(sql);
			query.setDate(0,date);
			List<YsmsGames> objects = query.list();
			return objects;
		} catch (RuntimeException re) {
			log.error("find by teamId before date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getNextGamesByAthleteId(int athleteId) {
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			String sql = " select g from YsmsGames g, YsmsTeam t, YsmsTeammember tm" + 
					" where (g.ysmsTeamByHostTeamid.teamId = t.teamId" + 
					" or g.ysmsTeamByGuestTeamid.teamId = t.teamId)" + 
					" and t.teamId = tm.ysmsTeam.teamId" + 
					" and tm.ysmsAthlete.athleteId = " + athleteId + 
					" and g.gamesTime > ? order by g.gamesTime asc";
			Query query = getSession().createQuery(sql).setMaxResults(10);
			query.setString(0, dateStr);
			List<YsmsGames> objects = query.list();
			return objects;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getLastGamesByAthleteId(int athleteId) {
		log.debug("finding YsmsGames instance by teamId after date");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			String sql = " select g from YsmsGames g, YsmsTeam t, YsmsTeammember tm" + 
					" where (g.ysmsTeamByHostTeamid.teamId = t.teamId" + 
					" or g.ysmsTeamByGuestTeamid.teamId = t.teamId)" + 
					" and t.teamId = tm.ysmsTeam.teamId" + 
					" and tm.ysmsAthlete.athleteId = " + athleteId + 
					" and g.gamesTime < ? order by g.gamesTime desc";
			Query query = getSession().createQuery(sql).setMaxResults(10);
			query.setString(0, dateStr);
			List<YsmsGames> objects = query.list();
			return objects;
		} catch (RuntimeException re) {
			log.error("find by teamId after date failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGames> getGamesByTeamIdBeforeDate(int teamId, Date date) {
		log.debug("find YsmsGames instance by teamId and before date");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql = " from YsmsGames g where g.gamesTime < '" + sdf.format(date) + 
					"' and (g.ysmsTeamByHostTeamid.teamId = " + teamId + 
					" or g.ysmsTeamByGuestTeamid.teamId = " + teamId + ")";
			Query query = getSession().createQuery(sql);
			List<YsmsGames> results = query.list();
			log.debug("find by teamId and period successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
	}

	@Override
	public List<ShooterRankView> getShooterRank(int zoneId, int topHowMany) {
		List<ShooterRankView> views = new ArrayList<ShooterRankView>();
		log.debug("find Shooter Rank");
		try {
			String sql = "select sc.school_id, sc.school_name, ath.identified_name, ath.athlete_id, count(goal.goal_id), count(goalc.goal_id)"
					+ " from ysms_school sc, ysms_athlete ath, ysms_games game, ysms_goal goal"
					+ " left outer join ysms_goal goalc"
					+ " on goal.goal_id = goalc.goal_id"
					+ " and goalc.style = 2"
					+ " where goal.shooter = ath.athlete_id"	
					+ " and goal.games_id = game.games_id"
					+ " and game.zone_id = " + zoneId
					+ " and ath.school_id = sc.school_id"
					+ " and (goal.style = 1 or goal.style = 2)"
					+ " group by athlete_id"
					+ " order by count(goal.goal_id) desc";
			Query query = getSession().createSQLQuery(sql).setMaxResults(topHowMany);
			List<Object[]> results = query.list();
			log.debug("find Shooter Rank successful, result size: "
					+ results.size());
			if(results!=null){
				for(int i=0;i<results.size();i++){
					ShooterRankView srv = new ShooterRankView();
					Object[] objs = results.get(i);
					srv.setSchoolId((int) objs[0]);
					srv.setSchoolName(objs[1].toString());
					srv.setAthleteName(objs[2].toString());
					srv.setAthleteId((int)objs[3]);
					srv.setGoalCount(((BigInteger) objs[4]).intValue());
					srv.setPenaltyCount(((BigInteger) objs[5]).intValue());
					views.add(srv);
				}
			}
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
		return views;
	}

	@Override
	public List<AssistRankView> getAssistRank(int zoneId, int topHowMany) {
		List<AssistRankView> views = new ArrayList<AssistRankView>();
		log.debug("find Assist Rank");
		try {
			String sql = "select sc.school_id, sc.school_name, ath.identified_name, ath.athlete_id, count(goal.goal_id)"
					+ " from ysms_school sc, ysms_athlete ath, ysms_games game, ysms_goal goal"
					+ " where goal.assistant = ath.athlete_id"	
					+ " and goal.games_id = game.games_id"
					+ " and game.zone_id = " + zoneId
					+ " and ath.school_id = sc.school_id"
					+ " group by athlete_id"
					+ " order by count(goal.goal_id) desc";
			Query query = getSession().createSQLQuery(sql).setMaxResults(topHowMany);
			List<Object[]> results = query.list();
			log.debug("find Shooter Rank successful, result size: "
					+ results.size());
			if(results!=null){
				for(int i=0;i<results.size();i++){
					AssistRankView srv = new AssistRankView();
					Object[] objs = results.get(i);
					srv.setSchoolId((int) objs[0]);
					srv.setSchoolName(objs[1].toString());
					srv.setAthleteName(objs[2].toString());
					srv.setAthleteId((int)objs[3]);
					srv.setAssistCount(((BigInteger) objs[4]).intValue());
					views.add(srv);
				}
			}
		} catch (RuntimeException re) {
			log.error("find by teamId and period failed", re);
			throw re;
		}
		return views;
	}

	@Override
	public List<YsmsGames> findByFuzzyQueryAndPageForJudge(Integer leagueId,
			Integer zoneId, Date date, Page page, int judgeId) {
		log.debug("finding  ByFuzzyQueryAndPage instances");
		try {
			String queryString = "select distinct yg from YsmsGames as yg, YsmsGamesJudge gj where gj.ysmsJudge.judgeId = " 
					+ judgeId + " and gj.ysmsGames.gamesId = yg.gamesId";
			if(leagueId != null){
				queryString += " and yg.ysmsLeagueZone.ysmsLeague.leagueId = " + leagueId;
			}
			if (zoneId != null) {
				queryString += " and yg.ysmsLeagueZone.zoneId = " + zoneId;
			}
			if (date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				queryString += " and yg.gamesTime like '%" + sdf.format(date)
						+ "%' ";
			}
			queryString += " order by yg.gamesTime asc, yg.gamesId asc";
			Query queryObject = getSession().createQuery(queryString);
			if (page != null) {
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}

	@Override
	public int getMyGamesCount(Integer leagueId, Integer zoneId, Date date,
			int judgeId) {
		log.debug("finding  ByFuzzyQueryAndPage instances");
		try {
			String queryString = "select distinct yg from YsmsGames as yg, YsmsGamesJudge gj where gj.ysmsJudge.judgeId = " 
					+ judgeId + " and gj.ysmsGames.gamesId = yg.gamesId";
			if(leagueId != null){
				queryString += " and yg.ysmsLeagueZone.ysmsLeague.leagueId = " + leagueId;
			}
			if (zoneId != null) {
				queryString += " and yg.ysmsLeagueZone.zoneId = " + zoneId;
			}
			if (date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				queryString += " and yg.gamesTime like '%" + sdf.format(date)
						+ "%' ";
			}
			queryString += " order by yg.gamesTime ";
			return this.getHqlRecordCount(queryString);
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}
}

package org.study.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.study.dao.LinkmanDao;
import org.study.entity.Linkman;

import java.util.List;

public class LinkmanDaoImpl extends SqlSessionDaoSupport implements LinkmanDao {
    @Override
    public Linkman queryLinkmanById(int id) {
        SqlSession sqlSession = super.getSqlSession();
        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
        Linkman linkman = mapper.queryLinkmanById(1);
        return linkman;
    }

    @Override
    public void AddLinkman(Linkman Linkman) {
        SqlSession sqlSession = super.getSqlSession();
        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
        mapper.AddLinkman(Linkman);
    }

    @Override
    public List<Linkman> queryAllLinkman() {
        SqlSession sqlSession = super.getSqlSession();
        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
        List<Linkman> linkmanList = mapper.queryAllLinkman();
        return linkmanList;
    }

    @Override
    public void deleteLinkmanByid(int id) {
        SqlSession sqlSession = super.getSqlSession();
        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
        mapper.deleteLinkmanByid(id);
    }

    @Override
    public Linkman queryLinkmanbyname(String name) {
        SqlSession sqlSession = super.getSqlSession();
        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
        return mapper.queryLinkmanbyname(name);
    }

//    @Override
//    public Boolean queryLinkmanIsExit(int id) {
//        SqlSession sqlSession = super.getSqlSession();
//        LinkmanDao mapper = sqlSession.getMapper(LinkmanDao.class);
//        Boolean exit = mapper.queryLinkmanIsExit(id);
//        if (exit!=null){
//            return true;
//        }else
//            return false;
//    }

}

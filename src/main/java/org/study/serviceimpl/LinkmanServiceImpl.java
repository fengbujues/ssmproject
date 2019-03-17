package org.study.serviceimpl;

import org.study.dao.LinkmanDao;
import org.study.entity.Linkman;
import org.study.service.LinkmanService;

import java.util.List;

public class LinkmanServiceImpl implements LinkmanService {
    private LinkmanDao linkmanDao;

    public LinkmanDao getLinkmanDao() {
        return linkmanDao;
    }

    public void setLinkmanDao(LinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    @Override
    public Linkman queryLinkmanById(int id) {
        return linkmanDao.queryLinkmanById(id);
    }

    @Override
    public void AddLinkman(Linkman linkman) {
        linkmanDao.AddLinkman(linkman);
    }

    @Override
    public List<Linkman> queryAllLinkman() {
        return linkmanDao.queryAllLinkman();
    }

    @Override
    public Boolean deleteLinkmanByid(int id) {
//        if (linkmanDao.queryLinkmanIsExit(id)){
//            linkmanDao.deleteLinkmanByid(id);
//            return true;
//        }else
//            return false;
//    }
        linkmanDao.deleteLinkmanByid(id);
        return true;
    }

    @Override
    public boolean login(String username,String psw) {
        Linkman linkman = linkmanDao.queryLinkmanbyname(username);
        if(linkman==null){
            return false;
        }else{
            if(linkman.getTel().equals(psw)){
                return true;
            }
        }
        return false;
    }
    public Linkman queryLinkmanbyname(String name){
        Linkman linkman = linkmanDao.queryLinkmanbyname(name);
        return linkman;
    }

    //分页查询 这里的page应该是第几页 需要进行转换 默认3条数据为一页

    /**
     * 0 1
     * 3 2
     * 6 3
     * (当前页-1)*3
     * @param page
     * @return
     */
    @Override
    public List<Linkman> limitQueryByPage(int page) {
        page = (page-1)*3;
        List<Linkman> list = linkmanDao.limitQueryByPage(page);
        return list;
    }


}

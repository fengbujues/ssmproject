package org.study.dao;

import org.study.entity.Linkman;

import java.util.List;

public interface LinkmanDao {
    public Linkman queryLinkmanById(int id);
    public void AddLinkman(Linkman Linkman);
    public List<Linkman> queryAllLinkman();
    public void deleteLinkmanByid(int id);
//    public Boolean queryLinkmanIsExit(int id);
    //通过name查询联系人 然后在service里面判断name和tel是否正确
    public Linkman queryLinkmanbyname(String name);
}

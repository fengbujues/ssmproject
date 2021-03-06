package org.study.service;

import org.study.entity.Linkman;

import java.util.List;

public interface LinkmanService {
    public Linkman queryLinkmanById(int id);
    public void AddLinkman(Linkman linkman);
    public List<Linkman> queryAllLinkman();
    public Boolean deleteLinkmanByid(int id);
    public boolean login(String username,String psw);
    //根据name 查询 联系人
    public Linkman queryLinkmanbyname(String name);
    //分页查询
    public List<Linkman> limitQueryByPage(int page);
    //编辑
    public void updateLinkman(Linkman linkman);
}

package org.study.service;

import org.study.entity.Linkman;

import java.util.List;

public interface LinkmanService {
    public Linkman queryLinkmanById(int id);
    public void AddLinkman(Linkman linkman);
    public List<Linkman> queryAllLinkman();
    public Boolean deleteLinkmanByid(int id);
    public boolean login(String username,String psw);
}

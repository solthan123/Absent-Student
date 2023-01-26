/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import AbsentStudent.TblUser;
import AbsentStudent.AbsentStudentUtil;
import org.hibernate.SQLQuery;

/**
 *
 * @author MYuslamF
 */
public class Login {
    public List<TblUser> getBy(String uName, String uPass)
    {
        Transaction trans = null;
        TblUser us = new TblUser();
        List<TblUser> user = new ArrayList();
        
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select * from tbl_user where username = :uName and password = :uPass");
            query.addEntity(TblUser.class);
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (TblUser) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return user;
    }
    
    public void add_user(TblUser user)
    {
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

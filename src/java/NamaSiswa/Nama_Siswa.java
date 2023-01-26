/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NamaSiswa;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import AbsentStudent.TblSiswa;
import AbsentStudent.AbsentStudentUtil;

/**
 *
 * @author MYuslamF
 */
public class Nama_Siswa {
    public List<TblSiswa> retrieveTblSiswa()
    {
        List stud = new ArrayList();
        TblSiswa stud1 = new TblSiswa();
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblSiswa");
            stud = query.list();
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return stud;
    }
    
    public List<TblSiswa> getbyID(String IdSiswa)
    {
        TblSiswa stud = new TblSiswa();
        List<TblSiswa> iStud = new ArrayList();
        
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_siswa where id_siswa = id");
            query.setString("id", IdSiswa);
            stud = (TblSiswa) query.uniqueResult();
            iStud = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return iStud;
    }    
        
    public void deleteSiswa(Integer IdSiswa)
    {
        Transaction trans = null;
        Session session =AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            TblSiswa stud = (TblSiswa) session.load(TblSiswa.class, new Integer(IdSiswa));
            session.delete(stud);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void editSiswa(TblSiswa stud)
    {
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.update(stud);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void add_siswa(TblSiswa stud)
    {
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(stud);
            trans.commit();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

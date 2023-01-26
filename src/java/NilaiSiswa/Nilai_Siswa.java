/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NilaiSiswa;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import AbsentStudent.TblNilaisiswa;
import AbsentStudent.AbsentStudentUtil;
/**
 *
 * @author MYuslamF
 */
public class Nilai_Siswa {
    public List<TblNilaisiswa> retrieveTblNilaisiswa()
    {
        List stud = new ArrayList();
        TblNilaisiswa stud1 = new TblNilaisiswa();
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblNilaisiswa");
            stud = query.list();
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return stud;
    }
    
    public List<TblNilaisiswa> getbyID(String IdSiswa)
    {
        TblNilaisiswa stud = new TblNilaisiswa();
        List<TblNilaisiswa> iStud = new ArrayList();
        
        Transaction trans = null;
        Session session = AbsentStudentUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_nilaisiswa where id_siswa = id");
            query.setString("id", IdSiswa);
            stud = (TblNilaisiswa) query.uniqueResult();
            iStud = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return iStud;
    }    
        
    public void deletenilaiSiswa(Integer IdSiswa)
    {
        Transaction trans = null;
        Session session =AbsentStudentUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            TblNilaisiswa stud = (TblNilaisiswa) session.load(TblNilaisiswa.class, new Integer(IdSiswa));
            session.delete(stud);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void editnilaiSiswa(TblNilaisiswa stud)
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
    
    public void add_nilaisiswa(TblNilaisiswa stud)
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

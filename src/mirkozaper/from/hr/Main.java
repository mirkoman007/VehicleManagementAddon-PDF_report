/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr;

import java.io.FileOutputStream;
import java.util.stream.Stream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mirkozaper.from.hr.model.Driver;

/**
 *
 * @author mirko
 */
public class Main {

    public static void main(String[] args) {
        
        List<Driver> drivers=GetDrivers();
        
        try {
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Drivers.pdf"));

            document.open();

            PdfPTable table = new PdfPTable(5);
            addTableHeader(table);
            drivers.forEach(d->{
                addRows(table,d);
            
            });
            
            document.add(table);
            document.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


    private static void addTableHeader(PdfPTable table) {
        Stream.of("IDDriver", "First name", "Last name", "Mobile number","Driver license number")
        .forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

    private static void addRows(PdfPTable table,Driver driver) {
        table.addCell(driver.getIDDriver().toString());
        table.addCell(driver.getFirstName());
        table.addCell(driver.getLastName());
        table.addCell(driver.getMobileNumber());
        table.addCell(driver.getDriverLicenseNumber());
    }



    private static List<Driver> GetDrivers() {
        
        List<Driver> drivers=new ArrayList<>();
        
        EntityManagerFactory emf=null;
        try{
            emf=Persistence.createEntityManagerFactory("HibernatePU");
            drivers=getDriversDataFromDb(emf);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(emf!=null){
                emf.close();
            }
        }
        
        return drivers;
    }
    
    private static List<Driver> getDriversDataFromDb(EntityManagerFactory emf) {
        List<Driver> drivers=new ArrayList<>();
        
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Query query = em.createNativeQuery("select * from Driver", Driver.class);
            query.getResultList().forEach(d -> {
                drivers.add((Driver) d);
            });

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return drivers;
    }
    

}

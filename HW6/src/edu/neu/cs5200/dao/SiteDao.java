package edu.neu.cs5200.dao;

import java.io.File;
import java.util.List;
import edu.neu.cs5200.model.*;
import javax.persistence.*;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import edu.neu.cs5200.model.Site;

public class SiteDao {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Homework6");

    public Site findSite(int siteId) {
        EntityManager em = factory.createEntityManager();
        return em.find(Site.class, siteId);
    }

    @SuppressWarnings("unchecked")
    public List<Site> findAllSites() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("Site.findAllSites");
        return (List<Site>) query.getResultList();
    }

    public void exportSiteDatabaseToXmlFile(SiteList siteList, String xmlFileName) {
        File xmlFile = new File(xmlFileName);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(siteList, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void convertXmlFileToOutputFile(String inputXmlFileName, String outputXmlFileName, String xsltFileName) {
        File inputXmlFile = new File(inputXmlFileName);
        File xsltFile = new File(xsltFileName);
        File outputXmlFile = new File(outputXmlFileName);

        StreamSource source = new StreamSource(inputXmlFile);
        StreamSource xslt = new StreamSource(xsltFile);
        StreamResult output = new StreamResult(outputXmlFile);

        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(source, output);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SiteDao dao = new SiteDao();

        List<Site> sites = dao.findAllSites();
        // test
        for (Site site : sites){
        	System.out.println(site.getName());
        }
        SiteList SiteList = new SiteList(sites);
        dao.exportSiteDatabaseToXmlFile(SiteList, "xml/sites.xml");
        // for site2html
        dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
        // for site2equipment
        dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");
    }
}


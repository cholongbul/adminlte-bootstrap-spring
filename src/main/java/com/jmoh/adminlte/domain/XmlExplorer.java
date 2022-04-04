package com.jmoh.adminlte.domain;

import com.jmoh.adminlte.util.XmlChanger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.io.IOException;

@Component
public class XmlExplorer {

    @Value("classpath:static/data2/*")
    private Resource[] resources;

    public int getFilecnt(){

        int filecnt = resources.length;
        return filecnt;
    }

    public String getDataAPI(String chartname) throws IOException {
        String filepath = "";
        for (Resource res : resources){
            if (res.getFilename().toLowerCase().contains(chartname)){
                filepath = res.getURI().getPath();
                break;
            }
        }
        Document xmldom = XmlChanger.convertXMLFileToXMLDocument(filepath);
        String xmlstring = XmlChanger.convertXmlDocumentToString(xmldom);

        return xmlstring;

    }
}

package com.jmoh.adminlte.domain;

import com.jmoh.adminlte.util.XmlChanger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.io.*;
import java.net.URL;


@Component
public class XmlExplorer {

    @Value("classpath:static/data2/*")
    private Resource[] resources;

    public int getFilecnt() {
        int filecnt = resources.length;
        return filecnt;
    }

    public String getDataAPI(String chartname) throws IOException {
        String filename = "";
        for (Resource res : resources) {
            if (res.getFilename().toLowerCase().contains(chartname)) {
                filename = res.getFilename();
                System.out.println(filename);
                break;
            }
        }

        File file = getFile(filename);

        Document xmldom = XmlChanger.convertXMLFileToXMLDocument(file);
        String xmlstring = XmlChanger.convertXmlDocumentToString(xmldom);

        return xmlstring;

    }

    private File getFile(String filename) {
        File file = null;
        try {
            InputStream input = getClass().getResourceAsStream("/static/data2/" + filename);
            file = File.createTempFile("tempfile", ".tmp");
            OutputStream out = new FileOutputStream(file);
            int read;
            byte[] bytes = new byte[1024];

            while ((read = input.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.close();
            file.deleteOnExit();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;
    }
}

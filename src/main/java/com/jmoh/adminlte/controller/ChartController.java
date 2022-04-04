package com.jmoh.adminlte.controller;

import com.jmoh.adminlte.domain.XmlExplorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ChartController {

    @Autowired
    XmlExplorer xmlExplorer;


    @GetMapping("/")
    public String chart(Model model){
        return "index";
    }


    @GetMapping("getData.do")
    @ResponseBody
    public String getElectiondata(@RequestParam("chartname") String chartname, HttpServletResponse response) throws Exception {
        response.addIntHeader("xmlcnt", xmlExplorer.getFilecnt());

        return xmlExplorer.getDataAPI(chartname);
    }
}

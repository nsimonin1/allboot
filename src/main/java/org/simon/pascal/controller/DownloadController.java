package org.simon.pascal.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simon.pascal.report.ParseHtmlTable1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

@Controller
public class DownloadController {
    @Autowired
	private SpringTemplateEngine templateEngine;
	
	/*
     * Download a file from 
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere. 
     */
    @RequestMapping(value="/download/pdf", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException, DocumentException { 
     
        final String nameFile="hello";         
        String mimeType= "application/pdf";
        response.setContentType(mimeType);         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" +nameFile+"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        byte[] bytes=ParseHtmlTable1.createPdf(getContent(request));
        response.setContentLength(bytes.length);
        response.getOutputStream().write(bytes); 
    }
    
    public String getContent(HttpServletRequest request){ 
    	String z025="images/z025.png";
    	String z026="images/z026.png";
    	String z033="images/z033.png";
    	String baseUrl = request.getScheme() + // "http"
                "://" +                                // "://"
                request.getServerName() +              // "myhost"
                ":" +                                  // ":"
                request.getServerPort() +              // "80"
                request.getContextPath();              // "/myContextPath" or "" if deployed in root context
      
    	Locale locale = Locale.forLanguageTag("fr");
        Context context = new Context(locale);
        context.setVariable("z025", z025);
        context.setVariable("z026", z026);
        context.setVariable("z033", z033);
        context.setVariable("baseUrl", baseUrl);
        String content = templateEngine.process("book", context);
        return content;
        
    }
}

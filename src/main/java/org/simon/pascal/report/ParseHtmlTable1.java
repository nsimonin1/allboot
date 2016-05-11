package org.simon.pascal.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.servlet.resource.CssLinkResourceTransformer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import com.itextpdf.tool.xml.parser.XMLParser;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
public class ParseHtmlTable1 {
	//public static final String CSS = "tr { text-align: center; } th { background-color: lightgreen; padding: 3px; } td {background-color: lightblue;  padding: 3px; }";
	
	private static final String STYLE_FILE_NAME="static/css/pdf-styles.css";
	private static final String HTML_FILE_NAME="static/html/book.html";
	
	public static byte[] createPdf() throws DocumentException, IOException{
		
		try(ByteArrayOutputStream os=new ByteArrayOutputStream();){
		Document document=new Document();
		PdfWriter writer=PdfWriter.getInstance(document, os);
		
		document.open();
		ClassLoader classLoader = ParseHtmlTable1.class.getClassLoader();
        
        CSSResolver cssResolver=new StyleAttrCSSResolver();
        CssFile cssFile=XMLWorkerHelper.getCSS(classLoader.getResourceAsStream(STYLE_FILE_NAME));
        cssResolver.addCss(cssFile);
        
        HtmlPipelineContext htmlContext=new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        PdfWriterPipeline pdf=new PdfWriterPipeline(document,writer); 
        
        HtmlPipeline html=new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css=new CssResolverPipeline(cssResolver, html);
        
        XMLWorker worker=new XMLWorker(css, true);
        XMLParser p=new XMLParser(worker);
        InputStream is=classLoader.getResourceAsStream(HTML_FILE_NAME);
        p.parse(is);
        document.close();
        return os.toByteArray();
		}
	}
	
  public static byte[] createPdf(String content) throws DocumentException, IOException{
		
		try(ByteArrayOutputStream os=new ByteArrayOutputStream();){
		Document document=new Document();
		PdfWriter writer=PdfWriter.getInstance(document, os);
		
		document.open();
		ClassLoader classLoader = ParseHtmlTable1.class.getClassLoader();
        
        CSSResolver cssResolver=new StyleAttrCSSResolver();
        CssFile cssFile=XMLWorkerHelper.getCSS(classLoader.getResourceAsStream(STYLE_FILE_NAME));
        cssResolver.addCss(cssFile);
        
        HtmlPipelineContext htmlContext=new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        PdfWriterPipeline pdf=new PdfWriterPipeline(document,writer); 
        
        HtmlPipeline html=new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css=new CssResolverPipeline(cssResolver, html);
        
        XMLWorker worker=new XMLWorker(css, true);
        XMLParser p=new XMLParser(worker);
        InputStream is=new ByteArrayInputStream(content.getBytes());
        p.parse(is);
        document.close();
        return os.toByteArray();
		}
	}
}

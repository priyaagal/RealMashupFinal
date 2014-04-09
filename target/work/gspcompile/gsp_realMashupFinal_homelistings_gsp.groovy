import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_realMashupFinal_homelistings_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/home/listings.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'fancybox', file: 'jquery.fancybox-v=2.1.5.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'font-awesome.min.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css', file: 'style.css'))
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',29,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(flash.address)
printHtmlPart(9)
expressionOut.print(flash.city)
printHtmlPart(10)
expressionOut.print(flash.zip)
printHtmlPart(10)
expressionOut.print(flash.bathroom)
printHtmlPart(11)
expressionOut.print(flash.bedroom)
printHtmlPart(11)
expressionOut.print(flash.fArea)
printHtmlPart(11)
expressionOut.print(flash.lArea)
printHtmlPart(12)
expressionOut.print(flash.zestAmt)
printHtmlPart(13)
expressionOut.print(flash.address)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1396949038591L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}

package com.pchina.cms.common.utils;
//package com.springcms.pchina.common.utils;
//
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.mail.MessagingException;
//
//import cn.net.ibingo.common.mail.MailSenderInfo;
//import cn.net.ibingo.common.mail.SendMailHandler;
//
//public class MailTest {
//       public static void main( String [] args){
//				MailSenderInfo mailSenderInfo = new MailSenderInfo();
//				mailSenderInfo.setSubject("数据监控");
//				List<String> toAddress = new ArrayList<String>();
//				toAddress.add("wulin@ibingo.net.cn");
//				mailSenderInfo.setToAddress(toAddress);
//				List<String> ccAddress = new ArrayList<String>();
//				ccAddress.add("wulin@ibingo.net.cn");
//				List<String> bccAddress = new ArrayList<String>();
//				mailSenderInfo.setCcAddress(ccAddress);
//				mailSenderInfo.setBccAddress(bccAddress);
//				mailSenderInfo.setContent("Dear All ：<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;" + "数据发生改变");
//				SendMailHandler sendMailHandler = new SendMailHandler(false);
//				try {
//					sendMailHandler.sentHtmlEmail(mailSenderInfo);
//				} catch (UnsupportedEncodingException | MessagingException e) {
//					e.printStackTrace();
//				}
//       }
//       
//}

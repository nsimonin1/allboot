package org.simon.pascal.service.impl;

import org.simon.pascal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Service
public class MessageService {
	   // @Autowired
	   // private SimpMessagingTemplate template;

	   // @Scheduled(cron="*/59 * * * * MON-FRI")
	    public void trigger() {
	      //  this.template.convertAndSend("/topic/message", "" + DateUtil.getTime());
	    }
}

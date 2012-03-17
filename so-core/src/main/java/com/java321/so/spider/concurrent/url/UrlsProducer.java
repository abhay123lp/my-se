package com.java321.so.spider.concurrent.url;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UrlsProducer implements Runnable {

	Log log = LogFactory.getLog(UrlsProducer.class);
	private BlockingQueue<String> queue;
	private List<String> urls;

	@Override
	public void run() {
		for (String url : urls) {
			queue.add(url);
		}
		log.info("UrlsProducer Insert To Queue:" + urls.size());
	}

	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}

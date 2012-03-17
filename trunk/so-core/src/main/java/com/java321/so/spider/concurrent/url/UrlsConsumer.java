package com.java321.so.spider.concurrent.url;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.java321.so.service.AbstractUrlService;
import com.java321.so.spider.crawl.Crawl;

public class UrlsConsumer implements Runnable {

	Log log = LogFactory.getLog(UrlsConsumer.class);
	private BlockingQueue<String> queue;
	private Crawl crawl;
	private AbstractUrlService urlService;

	@Override
	public void run() {
		String url = null;
		try {
			url = queue.take();
		} catch (InterruptedException e) {
			log.error("Get BlockingQueue Error", e);
		}

		if (null == url)
			return;

		List<String> incrUrls = this.crawl.crawl(url);
		this.urlService.insertIncrementalUrl(incrUrls);
		log.info("UrlsConsumer Crawl Url:" + url + ",InsertIncrementalUrl:"
				+ incrUrls.size());
	}

	public void setCrawl(Crawl crawl) {
		this.crawl = crawl;
	}

	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}

}

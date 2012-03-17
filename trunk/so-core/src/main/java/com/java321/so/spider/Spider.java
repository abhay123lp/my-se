package com.java321.so.spider;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.java321.so.service.AbstractUrlService;
import com.java321.so.spider.concurrent.url.UrlsConsumer;
import com.java321.so.spider.concurrent.url.UrlsProducer;

public class Spider {

	private static final int SPIDE_POOL_SIZE = 10;
	private final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	private UrlsProducer urlsProducer;
	private UrlsConsumer urlsConsumer;
	private final ExecutorService exec = Executors
			.newFixedThreadPool(SPIDE_POOL_SIZE);
	private AbstractUrlService urlService;

	/**
	 * 全量抓取
	 */
	public void doWholeSpider() {
		List<String> urls = this.urlService.getSingleUrlsStr();
		doSpider(urls);
	}

	/**
	 * 增量抓取
	 * 
	 * @param urls
	 */
	public void doIncrementalSpider() {

		List<String> urls = this.urlService.getIncrementalSingleUrlsStr();
		doSpider(urls);
	}

	private void doSpider(List<String> urls) {
		urlsProducer.setUrls(urls);
		try {
			urlsProducer.setQueue(queue);
			new Thread(urlsProducer).start();

			urlsConsumer.setQueue(queue);
			exec.execute(urlsConsumer);
		} finally {
			exec.shutdown();
		}
	}

	public void setUrlsProducer(UrlsProducer urlsProducer) {
		this.urlsProducer = urlsProducer;
	}

	public void setUrlsConsumer(UrlsConsumer urlsConsumer) {
		this.urlsConsumer = urlsConsumer;
	}

	public void setUrlService(AbstractUrlService urlService) {
		this.urlService = urlService;
	}

}
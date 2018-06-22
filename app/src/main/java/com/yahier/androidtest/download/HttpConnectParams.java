package com.yahier.androidtest.download;

public enum HttpConnectParams {
	URLSTRING("https://apk.apk.hz155.com/down/lypcdibutj.apk"),
	/**
	 * 请求的方式
	 */
	POST("GET"),
	/**
	 * 请求的格式
	 */
	ACCECT(
			"Accept",
			"image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*"),
	/**
	 * 请求的语言
	 */
	ACCECT_LANGAGE("Accept-Language", "zh-CN"),
	/**
	 * 请求的字符集编码
	 */
	CHARSET("Charset", "UTF-8"),
	/**
	 * 链接的超时数
	 */
	CONNECTTIEMEDOUT("5000"),
	/**
	 * 保持链接
	 */
	KEEPCONNECT("Connection", "Keep-Alive");

	public String header; // 标题
	public String content; // 内容

	private HttpConnectParams(String header, String content) {
		this.header = header;
		this.content = content;
	}

	private HttpConnectParams(String content) {
		this.content = content;
	}
}

package com.yahier.androidtest.com.example.andriod_test;

public class ScreenCap {

	static {
		System.loadLibrary("scrcap");
	}

	static native void captureScreenToFile(String fileName);
}

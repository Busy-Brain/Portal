package com.mk.portal.framework;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		String pathname="/static";
		File staticFile = new File(
				pathname);
		System.out.println(staticFile.isDirectory());

	}

}

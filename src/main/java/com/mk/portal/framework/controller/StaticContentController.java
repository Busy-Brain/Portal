package com.mk.portal.framework.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.portal.framework.FrameworkConstants;

/**
 * This controller controls the behaviour for handling static content
 * 
 * @author mohit
 *
 */
@Controller
public class StaticContentController {
	//TODO Configurable
	private static final String STATIC_URL = "/static/";

	@RequestMapping(value = STATIC_URL + "/{"
			+ FrameworkConstants.StaticContentConstants.STATIC_CONTENT_TYPE
			+ "}" + "/{" + FrameworkConstants.StaticContentConstants.FOLDER_ID
			+ "}" + "/{" + FrameworkConstants.StaticContentConstants.FILE_NAME
			+ "}")
	public void requesForStaticContent(
			HttpServletResponse response,
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.StaticContentConstants.STATIC_CONTENT_TYPE) String staticContentType,
			@PathVariable(FrameworkConstants.StaticContentConstants.FOLDER_ID) String folderId,
			@PathVariable(FrameworkConstants.StaticContentConstants.FILE_NAME) String fileName)
			throws IOException {
		try {

			String pathname = FrameworkConstants.PageConstants.STATIC_FOLDER_PATH + "/"
					+ staticContentType + "/" + folderId + "/"
					+ fileName + getExtension(staticContentType);
			//TODO Log it.
			//TODO modify to pick files from resource folders instead
			System.out.println(pathname);
			File staticFile = new File(
					pathname);
			response.setContentType("text/css");
			ServletOutputStream out;
			FileInputStream fis = new FileInputStream(staticFile);
			byte[] data = new byte[(int) staticFile.length()];
			fis.read(data);
			fis.close();
			//
			out = response.getOutputStream();
			out.println(new String(data));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getExtension(String staticContentType) {
		if (staticContentType.equals("css")) {
			return ".css";
		}
		if (staticContentType.equals("script")
				|| staticContentType.equals("js")) {
			return ".js";
		}
		return null;
	}

}

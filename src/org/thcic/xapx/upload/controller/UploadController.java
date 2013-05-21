package org.thcic.xapx.upload.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/demo/upload")
public class UploadController {

	@RequestMapping(value = "/up5", method = RequestMethod.POST)
	public ModelAndView drawPie(HttpServletRequest request,
			HttpServletResponse response) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart)
			return null;
		try {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// Set factory constraints
			factory.setSizeThreshold(10485760);
			//factory.setRepository(new File("./TempFiles"));
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// Set overall request size constraint
			upload.setSizeMax(-1);
			// Parse the request
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			for(FileItem item : items) {
			    if (item.isFormField()) {
			        processFormField(item);
			    } else {
			        processUploadedFile(item);
			    }
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	private boolean processFormField(FileItem item) {
		System.out.println(item.getFieldName() + " = " + item.getString());
		return true;
	}

	private boolean processUploadedFile(FileItem item) throws Exception {
		System.out.println("FileName: " + item.getName());
		item.write(new File("uploadfiles/" + item.getName()));
		return true;
	}

}

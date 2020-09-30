package com.spacePhoto.controller;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.spacePhoto.model.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/spacephoto/spacephoto.do")
public class SpacePhotoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�SpaceDetail_Home.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("spacePhotoId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���a�Ϥ�ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/SpacePhoto_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/SpacePhoto_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				SpacePhotoService spacePhotoSvc = new SpacePhotoService();
				SpacePhotoVO spacePhotoVO = spacePhotoSvc.selectOneSpacePhoto(str);
				if (spacePhotoVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/SpacePhoto_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("spacePhotoVO", spacePhotoVO); 
				String url = "/spacephoto/listOneSpacePhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/SpacePhoto_Home.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllSpaceDetail.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String spacePhotoId = req.getParameter("spacePhotoId");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				SpacePhotoService spacePhotoSvc = new SpacePhotoService();
				SpacePhotoVO spacePhotoVO = spacePhotoSvc.selectOneSpacePhoto(spacePhotoId);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("spacePhotoVO", spacePhotoVO);
				String url = "/spacephoto/update_spacephoto_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/listAllSpacePhoto.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { 
			List<String> errorMessages = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMessages);
			
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

				String spacePhotoId = new String(req.getParameter("spacePhotoId").trim());
				if (spacePhotoId == null || spacePhotoId.trim().length() == 0) {
					errorMessages.add("���a�Ϥ�ID�ФŪť�");
				}

				String spaceId = req.getParameter("spaceId");
				if (spaceId == null || spaceId.trim().length() == 0) {
					errorMessages.add("���aID�ФŪť�");
				}

//				�s�W�Ϥ��A�Y�L�Ϥ��h�w�]��J�Ϥ�
				byte[] spacePhoto = null;
				Part part = req.getPart("spacePhoto");
				InputStream in = part.getInputStream();
				String filename = getFileNameFromPart(part);
				if(filename == null || filename.isEmpty()) {
					File file = new File(getServletContext().getRealPath("/") + "/spacephoto/images/tomcat.png");
					FileInputStream fis = new FileInputStream(file);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();  
					byte[] buffer = new byte[8192];
					int i;
					while ((i = fis.read(buffer)) != -1) {
						baos.write(buffer, 0, i);
					}
					spacePhoto = baos.toByteArray();
					baos.close();
					fis.close();
				}else {
					spacePhoto = new byte[in.available()];
					in.read(spacePhoto);
					in.close();
				}
				
				SpacePhotoVO spacePhotoVO = new SpacePhotoVO();
				spacePhotoVO.setSpacePhotoId(spacePhotoId);
				spacePhotoVO.setSpaceId(spaceId);
				spacePhotoVO.setSpacePhoto(spacePhoto);
				
				// Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spacePhotoVO", spacePhotoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/update_spacephoto_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				SpacePhotoService spacePhotoSvc = new SpacePhotoService();
				spacePhotoVO = spacePhotoSvc.updateSpacePhoto(spacePhotoId, spaceId, spacePhoto);
				System.out.println(spacePhotoVO);
				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("spacePhotoVO", spacePhotoVO); 
				String url = "/spacephoto/listOneSpacePhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneSpacePhoto.jsp
				successView.forward(req, res);
				
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMessages.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/update_spacephoto_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { 
			List<String> errorMessages = new LinkedList<String>();
			 //Store this set in the request scope, in case we need to
			 //send the ErrorPage view.
			req.setAttribute("errorMessages", errorMessages);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				System.out.println("Test1");
				String spacePhotoId = new String(req.getParameter("spacePhotoId").trim());
				if (spacePhotoId == null || spacePhotoId.trim().length() == 0) {
					errorMessages.add("���a�Ϥ�ID�ФŪť�");
				}
				System.out.println("Test2");
				String spaceId = req.getParameter("spaceId");
				if (spaceId == null || spaceId.trim().length() == 0) {
					errorMessages.add("���aID�ФŪť�");
				}
				System.out.println("Test3");
//				�s�W�@�ӧt���Ϥ���ƪ�spacePhoto
				byte[] spacePhoto = null;
				Part part = req.getPart("spacePhoto");
				InputStream in = part.getInputStream();
				String filename = getFileNameFromPart(part);
				if(filename == null || filename.isEmpty()) {
					File file = new File(getServletContext().getRealPath("/") + "/spacephoto/images/tomcat.png");
					FileInputStream fis = new FileInputStream(file);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();  
					byte[] buffer = new byte[8192];
					int i;
					while ((i = fis.read(buffer)) != -1) {
						baos.write(buffer, 0, i);
					}
					spacePhoto = baos.toByteArray();
					baos.close();
					fis.close();
				}else {
					spacePhoto = new byte[in.available()];
					in.read(spacePhoto);
					in.close();
				}
				System.out.println("Test4");
				
				SpacePhotoVO spacePhotoVO = new SpacePhotoVO();
				spacePhotoVO.setSpacePhotoId(spacePhotoId);
				spacePhotoVO.setSpaceId(spaceId);
				spacePhotoVO.setSpacePhoto(spacePhoto);

				
//				 Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spacePhotoVO", spacePhotoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/update_spacephoto_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
				/*************************** 2.�}�l�s�W��� ***************************************/
				SpacePhotoService spacePhotoSvc = new SpacePhotoService();
				spacePhotoVO = spacePhotoSvc.addSpacePhoto(spacePhotoId, spaceId, spacePhoto);
				System.out.println(spacePhotoVO);
				
				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
				String url = "/spacephoto/listAllSpacePhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/addSpacePhoto.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				String spacePhotoId = new String(req.getParameter("spacePhotoId"));

				/*************************** 2.�}�l�R����� ***************************************/
				SpacePhotoService spacePhotoSvc = new SpacePhotoService();
				spacePhotoSvc.deleteSpacePhoto(spacePhotoId);

				/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
				String url = "/spacephoto/listAllSpacePhoto.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacephoto/listAllSpacePhoto.jsp");
				failureView.forward(req, res);
			}
		}
	}
	
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
//		System.out.println(header);
		String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}

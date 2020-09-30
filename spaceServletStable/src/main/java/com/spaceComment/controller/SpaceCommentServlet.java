package com.spaceComment.controller;

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

import com.spaceComment.model.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/spacecomment/spacecomment.do")
public class SpaceCommentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("spaceCommentId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���a����ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/SpaceComment_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/SpaceComment_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				SpaceCommentService spaceCommentSvc = new SpaceCommentService();
				SpaceCommentVO spaceCommentVO = spaceCommentSvc.selectOneSpaceComment(str);
				if (spaceCommentVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/SpaceComment_Home.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceCommentVO", spaceCommentVO); // ��Ʈw���X��spaceCommentVO����,�s�Jreq
				String url = "/spacecomment/listOneSpaceComment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneSpaceComment.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/SpaceComment_Home.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllSpaceComment.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String spaceCommentId = req.getParameter("spaceCommentId");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				SpaceCommentService spaceCommentSvc = new SpaceCommentService();
				SpaceCommentVO spaceCommentVO = spaceCommentSvc.selectOneSpaceComment(spaceCommentId);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("spaceCommentVO", spaceCommentVO); // ��Ʈw���X��spaceCommentVO����,�s�Jreq
				String url = "/spacecomment/update_spacecomment_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_spacecomment_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/listAllSpaceComment.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // �Ӧ�update_spacecomment_input.jsp���ШD
			List<String> errorMessages = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMessages);
			
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

				String spaceCommentId = new String(req.getParameter("spaceCommentId").trim());
				if (spaceCommentId == null || spaceCommentId.trim().length() == 0) {
					errorMessages.add("���a����ID�ФŪť�");
				}

				String spaceId = req.getParameter("spaceId");
				if (spaceId == null || spaceId.trim().length() == 0) {
					errorMessages.add("���aID�ФŪť�");
				}
				
				String memId = req.getParameter("memId");
				if (memId == null || memId.trim().length() == 0) {
					errorMessages.add("�|��ID�ФŪť�");
				}
				
				String spaceCommentContent = req.getParameter("spaceCommentContent");
				if (spaceCommentContent == null || spaceCommentContent.trim().length() == 0) {
					errorMessages.add("�������e�ФŪť�");
				}
				
				Double spaceCommentLevel = null;
				try {
					spaceCommentLevel = Double.parseDouble(req.getParameter("spaceCommentLevel").trim());
					if(spaceCommentLevel <= 0 || spaceCommentLevel > 5) errorMessages.add("���a�����P��: �нT�{");
				} catch (NumberFormatException e) {
					spaceCommentLevel = 0.0;
					errorMessages.add("���a�����P�����~");
				}

				java.sql.Date spaceCommentDate = null;
				try {
					spaceCommentDate = java.sql.Date.valueOf(req.getParameter("spaceCommentDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("���a����������~");
				}
				
				
				SpaceCommentVO spaceCommentVO = new SpaceCommentVO();
				spaceCommentVO.setSpaceCommentId(spaceCommentId);
				spaceCommentVO.setSpaceId(spaceId);
				spaceCommentVO.setMemId(memId);
				spaceCommentVO.setSpaceCommentContent(spaceCommentContent);
				spaceCommentVO.setSpaceCommentLevel(spaceCommentLevel);
				spaceCommentVO.setSpaceCommentDate(spaceCommentDate);
				
				// Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceCommentVO", spaceCommentVO); // �t����J�榡���~��spaceCommentVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/update_spacecomment_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				SpaceCommentService spaceCommentSvc = new SpaceCommentService();
				spaceCommentVO = spaceCommentSvc.updateSpaceComment(spaceCommentVO);
				System.out.println(spaceCommentVO);
				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceCommentVO", spaceCommentVO);
				String url = "/spacecomment/listOneSpaceComment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMessages.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/update_spacecomment_input.jsp");
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
				
				String spaceCommentId = new String(req.getParameter("spaceCommentId").trim());
				if (spaceCommentId == null || spaceCommentId.trim().length() == 0) {
					errorMessages.add("���a����ID�ФŪť�");
				}

				String spaceId = req.getParameter("spaceId");
				if (spaceId == null || spaceId.trim().length() == 0) {
					errorMessages.add("���aID�ФŪť�");
				}
				
				String memId = req.getParameter("memId");
				if (memId == null || memId.trim().length() == 0) {
					errorMessages.add("�|��ID�ФŪť�");
				}
				
				String spaceCommentContent = req.getParameter("spaceCommentContent");
				if (spaceCommentContent == null || spaceCommentContent.trim().length() == 0) {
					errorMessages.add("���a�������e�ФŪť�");
				}
				
				Double spaceCommentLevel = null;
				try {
					spaceCommentLevel = Double.parseDouble(req.getParameter("spaceCommentLevel").trim());
					if(spaceCommentLevel <= 0 || spaceCommentLevel > 5) errorMessages.add("���a�����P��: �нT�{");
				} catch (NumberFormatException e) {
					spaceCommentLevel = 0.0;
					errorMessages.add("���a�����P�����~");
				}

				java.sql.Date spaceCommentDate = null;
				try {
					spaceCommentDate = java.sql.Date.valueOf(req.getParameter("spaceCommentDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("���a����������~");
				}

				
				SpaceCommentVO spaceCommentVO = new SpaceCommentVO();
				spaceCommentVO.setSpaceCommentId(spaceCommentId);
				spaceCommentVO.setSpaceId(spaceId);
				spaceCommentVO.setMemId(memId);
				spaceCommentVO.setSpaceCommentContent(spaceCommentContent);
				spaceCommentVO.setSpaceCommentLevel(spaceCommentLevel);
				spaceCommentVO.setSpaceCommentDate(spaceCommentDate);
				
				// Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceCommentVO", spaceCommentVO); // �t����J�榡���~��spaceCommentVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/update_spacecomment_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
				/*************************** 2.�}�l�s�W��� ***************************************/
				SpaceCommentService spaceCommentSvc = new SpaceCommentService();
				spaceCommentVO = spaceCommentSvc.addSpaceComment(spaceCommentVO);
				System.out.println(spaceCommentVO);
				
				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
				String url = "/spacecomment/listAllSpaceComment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/addSpaceComment.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // �Ӧ�listAllSpace.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				String spaceCommentId = new String(req.getParameter("spaceCommentId"));

				/*************************** 2.�}�l�R����� ***************************************/
				SpaceCommentService spaceCommentSvc = new SpaceCommentService();
				spaceCommentSvc.deleteSpaceComment(spaceCommentId);

				/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
				String url = "/spacecomment/listAllSpaceComment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/spacecomment/listAllspaceComment.jsp");
				failureView.forward(req, res);
			}
		}
	}
}

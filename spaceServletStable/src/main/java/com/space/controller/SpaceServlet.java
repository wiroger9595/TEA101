package com.space.controller;

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

import com.space.model.*;
import com.spaceDetail.model.SpaceDetailService;
import com.spaceDetail.model.SpaceDetailVO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/space/space.do")
public class SpaceServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		/**此為後端
		 * 
		 */
		// ================================  ======================================================= //

		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�spaceHome.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("spaceId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("wrong space ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

//				Integer spaceId = null;
//				try {
//					spaceId = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("���aID�榡�����T");
//				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				SpaceService spaceSvc = new SpaceService();
				SpaceVO spaceVO = spaceSvc.selectOneSpace(str);
				if (spaceVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈw���X��spaceVO����,�s�Jreq
				String url = "/space/listOneSpace.jsp";
				//String url = "/frontendPage/spaceDetail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneSpace.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllSpace.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String spaceId = req.getParameter("spaceId");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				SpaceService spaceSvc = new SpaceService();
				SpaceVO spaceVO = spaceSvc.selectOneSpace(spaceId);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈw���X��spaceVO����,�s�Jreq
				String url = "/space/updateSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� updateSpace.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/listAllSpace.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // �Ӧ�updateSpace.jsp���ШD
			List<String> errorMessages = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMessages);
			
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String spaceId = new String(req.getParameter("spaceId").trim());
				
				String memId = req.getParameter("memId");
				
				String empId = req.getParameter("empId");

				String spaceAddress = req.getParameter("spaceAddress").trim();
				if (spaceAddress == null || spaceAddress.trim().length() == 0) {
					errorMessages.add("���a�a�}�ФŪť�");
				}
				
				Double spaceLng = null;
				try {
					spaceLng = Double.parseDouble(req.getParameter("spaceLng").trim());
					if(spaceLng < 0) errorMessages.add("�нT�{�g��");
				} catch (NumberFormatException e) {
					errorMessages.add("�g�׿��~");
				}
				
				Double spaceLat = null;
				try {
					spaceLat = Double.parseDouble(req.getParameter("spaceLat").trim());
					if(spaceLat > 90 || spaceLat < -90) errorMessages.add("�нT�{�n��");
				} catch (NumberFormatException e) {
					errorMessages.add("�n�׿��~");
				}
				
				String spaceName = req.getParameter("spaceName");
				//spaceName���~�B�z
				String spaceNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (spaceName == null || spaceName.trim().length() == 0) {
					errorMessages.add("���a�W��: �ФŪť�");
				} else if (!spaceName.trim().matches(spaceNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMessages.add("���a�W��: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
				}

				String spaceType = req.getParameter("spaceType");
				
				String spaceEquipment = req.getParameter("spaceEquipment");
				
				String spaceContain = req.getParameter("spaceContain");

				String spaceRule = req.getParameter("spaceRule");

				String spaceRefund = req.getParameter("spaceRefund");
				
				String spaceStatus = req.getParameter("spaceStatus");

				java.sql.Date spaceSignupDate = null;
				
				try {
					spaceSignupDate = java.sql.Date.valueOf(req.getParameter("spaceSignupDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				
				java.sql.Date spaceOnsaleDate = null;
				try {
					spaceOnsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOnsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�W�[������~");
				}
				
				java.sql.Date spaceOffsaleDate = null;
				try {
					spaceOffsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOffsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�U�[������~");
				}
				
				SpaceVO spaceVO = new SpaceVO();
				spaceVO.setSpaceId(spaceId);
				spaceVO.setMemId(memId);
				spaceVO.setEmpId(empId);
				spaceVO.setSpaceAddress(spaceAddress);
				spaceVO.setSpaceLng(spaceLng);
				spaceVO.setSpaceLat(spaceLat);
				spaceVO.setSpaceName(spaceName);
				spaceVO.setSpaceType(spaceType);
				spaceVO.setSpaceEquipment(spaceEquipment);
				spaceVO.setSpaceContain(spaceContain);
				spaceVO.setSpaceRule(spaceRule);
				spaceVO.setSpaceRefund(spaceRefund);
				spaceVO.setSpaceStatus(spaceStatus);
				spaceVO.setSpaceSignupDate(spaceSignupDate);
				spaceVO.setSpaceOnsaleDate(spaceOnsaleDate);
				spaceVO.setSpaceOffsaleDate(spaceOffsaleDate);
				
				// Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceVO", spaceVO); // �t����J�榡���~��spaceVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/space/updateSpace.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceVO = spaceSvc.updateSapce(spaceVO);
				System.out.println(spaceVO);
				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈwupdate���\��,���T����spaceVO����,�s�Jreq
				String url = "/space/listOneSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneSpace.jsp
				successView.forward(req, res);
				
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMessages.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/updateSpace.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // �Ӧ�addSpace.jsp���ШD
			List<String> errorMessages = new LinkedList<String>();
//			 Store this set in the request scope, in case we need to
//			 send the ErrorPage view.
			req.setAttribute("errorMessages", errorMessages);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				
				String spaceId = new String(req.getParameter("spaceId").trim());
				
				String memId = req.getParameter("memId");
				
				String empId = req.getParameter("empId");

				String spaceAddress = req.getParameter("spaceAddress").trim();
				if (spaceAddress == null || spaceAddress.trim().length() == 0) {
					errorMessages.add("���a�a�}�ФŪť�");
				}
				
				Double spaceLng = null;
				try {
					spaceLng = Double.parseDouble(req.getParameter("spaceLng").trim());
					if(spaceLng < 0) errorMessages.add("�нT�{�g��");
				} catch (NumberFormatException e) {
					errorMessages.add("�g�׿��~");
				}
				
				Double spaceLat = null;
				try {
					spaceLat = Double.parseDouble(req.getParameter("spaceLat").trim());
					if(spaceLat > 90 || spaceLat < -90) errorMessages.add("�нT�{�n��");
				} catch (NumberFormatException e) {
					errorMessages.add("�n�׿��~");
				}
				
				String spaceName = req.getParameter("spaceName");
				//spaceName���~�B�z
				String spaceNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,50}$";
				if (spaceName == null || spaceName.trim().length() == 0) {
					errorMessages.add("���a�W��: �ФŪť�");
				} else if (!spaceName.trim().matches(spaceNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMessages.add("���a�W��: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��50����");
				}

				String spaceType = req.getParameter("spaceType");
				
				String spaceEquipment = req.getParameter("spaceEquipment");
				
				String spaceContain = req.getParameter("spaceContain");

				String spaceRule = req.getParameter("spaceRule");

				String spaceRefund = req.getParameter("spaceRefund");
				
				String spaceStatus = req.getParameter("spaceStatus");

				java.sql.Date spaceSignupDate = null;
				try {
					spaceSignupDate = java.sql.Date.valueOf(req.getParameter("spaceSignupDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

				java.sql.Date spaceOnsaleDate = null;
				try {
					spaceOnsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOnsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�W�[������~");
				}

				java.sql.Date spaceOffsaleDate = null;
				try {
					spaceOffsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOffsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�U�[������~");
				}

				
				SpaceVO spaceVO = new SpaceVO();
				spaceVO.setSpaceId(spaceId);
				spaceVO.setMemId(memId);
				spaceVO.setEmpId(empId);
				spaceVO.setSpaceAddress(spaceAddress);
				spaceVO.setSpaceLng(spaceLng);
				spaceVO.setSpaceLat(spaceLat);
				spaceVO.setSpaceName(spaceName);
				spaceVO.setSpaceType(spaceType);
				spaceVO.setSpaceEquipment(spaceEquipment);
				spaceVO.setSpaceContain(spaceContain);
				spaceVO.setSpaceRule(spaceRule);
				spaceVO.setSpaceRefund(spaceRefund);
				spaceVO.setSpaceStatus(spaceStatus);
				spaceVO.setSpaceSignupDate(spaceSignupDate);
				spaceVO.setSpaceOnsaleDate(spaceOnsaleDate);
				spaceVO.setSpaceOffsaleDate(spaceOffsaleDate);
				
//				 Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceVO", spaceVO); // �t����J�榡���~��spaceVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/space/addSpace.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
				/*************************** 2.�}�l�s�W��� ***************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceVO = spaceSvc.addSpace(spaceVO);
				System.out.println(spaceVO);
				
				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
				String url = "/space/listAllSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllSpace.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/addSpace.jsp");
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
				String spaceId = new String(req.getParameter("spaceId"));

				/*************************** 2.�}�l�R����� ***************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceSvc.deleteSpace(spaceId);

				/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
				String url = "/space/listAllSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/listAllSpace.jsp");
				failureView.forward(req, res);
			}
		}
	



/**此為前端
 * 
 */
// ================================ 此為前端 ======================================================= //








		if ("frontend_getOne_For_Display".equals(action)) { // �Ӧ�spaceHome.jsp���ШD
		
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("spaceId");
				System.out.println("testtttttt"+str);
				
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("wrong space ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}
		
		//		Integer spaceId = null;
		//		try {
		//			spaceId = new Integer(str);
		//		} catch (Exception e) {
		//			errorMsgs.add("���aID�榡�����T");
		//		}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}
		
				/*************************** 2.�}�l�d�߸�� *****************************************/
				SpaceService spaceSvc = new SpaceService();
				SpaceVO spaceVO = spaceSvc.selectOneSpace(str);
				if (spaceVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}
		
				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈw���X��spaceVO����,�s�Jreq
				System.out.println(spaceVO.getSpaceId());
				
				SpaceDetailService detailSvc = new SpaceDetailService();
				SpaceDetailVO sDetailVO = detailSvc.selectOneSpaceDetail(spaceVO.getSpaceId());
			
				req.setAttribute("sDetailVO", sDetailVO);
				
				String url = "/frontendPage/spaceDetail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneSpace.jsp
				successView.forward(req, res);
		
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/spaceHome.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("frontend_getOne_For_Update".equals(action)) { // �Ӧ�listAllSpace.jsp���ШD
		
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String spaceId = req.getParameter("spaceId");
		
				/*************************** 2.�}�l�d�߸�� ****************************************/
				SpaceService spaceSvc = new SpaceService();
				SpaceVO spaceVO = spaceSvc.selectOneSpace(spaceId);
		
				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈw���X��spaceVO����,�s�Jreq
				String url = "/space/updateSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� updateSpace.jsp
				successView.forward(req, res);
		
				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/listAllSpace.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("frontend_update".equals(action)) { // �Ӧ�updateSpace.jsp���ШD
			List<String> errorMessages = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMessages);
			
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String spaceId = new String(req.getParameter("spaceId").trim());
				
				String memId = req.getParameter("memId");
				
				String empId = req.getParameter("empId");
		
				String spaceAddress = req.getParameter("spaceAddress").trim();
				if (spaceAddress == null || spaceAddress.trim().length() == 0) {
					errorMessages.add("���a�a�}�ФŪť�");
				}
				
				Double spaceLng = null;
				try {
					spaceLng = Double.parseDouble(req.getParameter("spaceLng").trim());
					if(spaceLng < 0) errorMessages.add("�нT�{�g��");
				} catch (NumberFormatException e) {
					errorMessages.add("�g�׿��~");
				}
				
				Double spaceLat = null;
				try {
					spaceLat = Double.parseDouble(req.getParameter("spaceLat").trim());
					if(spaceLat > 90 || spaceLat < -90) errorMessages.add("�нT�{�n��");
				} catch (NumberFormatException e) {
					errorMessages.add("�n�׿��~");
				}
				
				String spaceName = req.getParameter("spaceName");
				//spaceName���~�B�z
				String spaceNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (spaceName == null || spaceName.trim().length() == 0) {
					errorMessages.add("���a�W��: �ФŪť�");
				} else if (!spaceName.trim().matches(spaceNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMessages.add("���a�W��: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
				}
		
				String spaceType = req.getParameter("spaceType");
				
				String spaceEquipment = req.getParameter("spaceEquipment");
				
				String spaceContain = req.getParameter("spaceContain");
		
				String spaceRule = req.getParameter("spaceRule");
		
				String spaceRefund = req.getParameter("spaceRefund");
				
				String spaceStatus = req.getParameter("spaceStatus");
		
				java.sql.Date spaceSignupDate = null;
				
				try {
					spaceSignupDate = java.sql.Date.valueOf(req.getParameter("spaceSignupDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				
				java.sql.Date spaceOnsaleDate = null;
				try {
					spaceOnsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOnsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�W�[������~");
				}
				
				java.sql.Date spaceOffsaleDate = null;
				try {
					spaceOffsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOffsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�U�[������~");
				}
				
				SpaceVO spaceVO = new SpaceVO();
				spaceVO.setSpaceId(spaceId);
				spaceVO.setMemId(memId);
				spaceVO.setEmpId(empId);
				spaceVO.setSpaceAddress(spaceAddress);
				spaceVO.setSpaceLng(spaceLng);
				spaceVO.setSpaceLat(spaceLat);
				spaceVO.setSpaceName(spaceName);
				spaceVO.setSpaceType(spaceType);
				spaceVO.setSpaceEquipment(spaceEquipment);
				spaceVO.setSpaceContain(spaceContain);
				spaceVO.setSpaceRule(spaceRule);
				spaceVO.setSpaceRefund(spaceRefund);
				spaceVO.setSpaceStatus(spaceStatus);
				spaceVO.setSpaceSignupDate(spaceSignupDate);
				spaceVO.setSpaceOnsaleDate(spaceOnsaleDate);
				spaceVO.setSpaceOffsaleDate(spaceOffsaleDate);
				
				// Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceVO", spaceVO); // �t����J�榡���~��spaceVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/space/updateSpace.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
		
				/*************************** 2.�}�l�ק��� *****************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceVO = spaceSvc.updateSapce(spaceVO);
				System.out.println(spaceVO);
				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("spaceVO", spaceVO); // ��Ʈwupdate���\��,���T����spaceVO����,�s�Jreq
				String url = "/space/listOneSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneSpace.jsp
				successView.forward(req, res);
				
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMessages.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/updateSpace.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("frontend_insert".equals(action)) { // �Ӧ�addSpace.jsp���ШD
			List<String> errorMessages = new LinkedList<String>();
		//	 Store this set in the request scope, in case we need to
		//	 send the ErrorPage view.
			req.setAttribute("errorMessages", errorMessages);
		
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				
				String spaceId = new String(req.getParameter("spaceId").trim());
				
				String memId = req.getParameter("memId");
				
				String empId = req.getParameter("empId");
		
				String spaceAddress = req.getParameter("spaceAddress").trim();
				if (spaceAddress == null || spaceAddress.trim().length() == 0) {
					errorMessages.add("���a�a�}�ФŪť�");
				}
				
				Double spaceLng = null;
				try {
					spaceLng = Double.parseDouble(req.getParameter("spaceLng").trim());
					if(spaceLng < 0) errorMessages.add("�нT�{�g��");
				} catch (NumberFormatException e) {
					errorMessages.add("�g�׿��~");
				}
				
				Double spaceLat = null;
				try {
					spaceLat = Double.parseDouble(req.getParameter("spaceLat").trim());
					if(spaceLat > 90 || spaceLat < -90) errorMessages.add("�нT�{�n��");
				} catch (NumberFormatException e) {
					errorMessages.add("�n�׿��~");
				}
				
				String spaceName = req.getParameter("spaceName");
				//spaceName���~�B�z
				String spaceNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,50}$";
				if (spaceName == null || spaceName.trim().length() == 0) {
					errorMessages.add("���a�W��: �ФŪť�");
				} else if (!spaceName.trim().matches(spaceNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMessages.add("���a�W��: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��50����");
				}
		
				String spaceType = req.getParameter("spaceType");
				
				String spaceEquipment = req.getParameter("spaceEquipment");
				
				String spaceContain = req.getParameter("spaceContain");
		
				String spaceRule = req.getParameter("spaceRule");
		
				String spaceRefund = req.getParameter("spaceRefund");
				
				String spaceStatus = req.getParameter("spaceStatus");
		
				java.sql.Date spaceSignupDate = null;
				try {
					spaceSignupDate = java.sql.Date.valueOf(req.getParameter("spaceSignupDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
		
				java.sql.Date spaceOnsaleDate = null;
				try {
					spaceOnsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOnsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�W�[������~");
				}
		
				java.sql.Date spaceOffsaleDate = null;
				try {
					spaceOffsaleDate = java.sql.Date.valueOf(req.getParameter("spaceOffsaleDate").trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					errorMessages.add("�ӫ~�U�[������~");
				}
		
				
				SpaceVO spaceVO = new SpaceVO();
				spaceVO.setSpaceId(spaceId);
				spaceVO.setMemId(memId);
				spaceVO.setEmpId(empId);
				spaceVO.setSpaceAddress(spaceAddress);
				spaceVO.setSpaceLng(spaceLng);
				spaceVO.setSpaceLat(spaceLat);
				spaceVO.setSpaceName(spaceName);
				spaceVO.setSpaceType(spaceType);
				spaceVO.setSpaceEquipment(spaceEquipment);
				spaceVO.setSpaceContain(spaceContain);
				spaceVO.setSpaceRule(spaceRule);
				spaceVO.setSpaceRefund(spaceRefund);
				spaceVO.setSpaceStatus(spaceStatus);
				spaceVO.setSpaceSignupDate(spaceSignupDate);
				spaceVO.setSpaceOnsaleDate(spaceOnsaleDate);
				spaceVO.setSpaceOffsaleDate(spaceOffsaleDate);
				
		//		 Send the use back to the form, if there were errors
				if (!errorMessages.isEmpty()) {
					req.setAttribute("spaceVO", spaceVO); // �t����J�榡���~��spaceVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/space/addSpace.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}
				/*************************** 2.�}�l�s�W��� ***************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceVO = spaceSvc.addSpace(spaceVO);
				System.out.println(spaceVO);
				
				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
				String url = "/space/listAllSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllSpace.jsp
				successView.forward(req, res);
		
				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/addSpace.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("frontend_delete".equals(action)) { // �Ӧ�listAllSpace.jsp
		
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				String spaceId = new String(req.getParameter("spaceId"));
		
				/*************************** 2.�}�l�R����� ***************************************/
				SpaceService spaceSvc = new SpaceService();
				spaceSvc.deleteSpace(spaceId);
		
				/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
				String url = "/space/listAllSpace.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
		
				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/space/listAllSpace.jsp");
				failureView.forward(req, res);
			}
		}	
	}
}

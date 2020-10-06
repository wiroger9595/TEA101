<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@include file="/frontendPage/template/header.jsp"%> 
<%@ page import="java.util.*"%>
     
<%@ page import="com.spaceDetail.model.*"%>
<%@ page import="com.spaceComment.model.*"%>
<%@ page import="com.space.model.*"%>

<%@ page import="com.spacePhoto.model.*"%>
<%@ page import="com.orderDetail.model.*"%>
<%@ page import="com.orderMaster.model.*"%>



<%
	String spaceId = request.getParameter("spaceId");
	String spaceDetailId = request.getParameter("spaceDetailId");
	
	SpaceDetailService spaceDetailSvc = new SpaceDetailService();
	SpaceDetailVO listOneSpaceDetail = spaceDetailSvc.selectOneSpaceDetail(spaceId);
	pageContext.setAttribute("listOneSpaceDetail",listOneSpaceDetail);
	//String spaceCommentId = request.getParameter("spaceCommentId");
	
	System.out.print(spaceId + "asasaasaasa");
	System.out.print(spaceDetailId + "m,,m,.,.,.,.");
	
/* 	SpacePhotoService sps = new SpacePhotoService();
	SpaceDetailService spaceDetailSvc = new SpaceDetailService();
    MemberService memberService = new MemberService();
	SpaceService spaceSvc = new SpaceService();
	
	List<SpaceVO> listSpace = spaceSvc.selectAllSpace();
	pageContext.setAttribute("listSpace",listSpace);  
	
	 */

    
        
	
	
	
	OrderDetailService orderDetailService = new OrderDetailService();
	List<OrderDetailVO> listAllOrderDetail = orderDetailService.selectAllOrderDetail();
	
	SpaceDetailService spaceDetailService = new SpaceDetailService();
	
	//String oneSpaceDetail = spaceDetailService.
	
	
	pageContext.setAttribute("listAllSpaceComment",listAllOrderDetail); 

	
    OrderDetailVO orderDetailId = listAllOrderDetail.get(0);

	
	
	//OrderDetailVO orderDetailVO = new OrderDetailVO();
	
	
/* 	OrderDetailVO insertOrderDetailVO = orderDetailService.addOrderDetail(orderDetailId);
	pageContext.setAttribute("insertOrderDetailVO", insertOrderDetailVO);
	
	System.out.print(insertOrderDetailVO + " 1248y1249812 ");
	
	
	
	
	
	
	
 	OrderMasterVO orderMasterVO = new OrderMasterVO();
	
	OrderMasterService orderMasterService = new OrderMasterService();
	OrderMasterVO insertOrderMasterVO = orderMasterService.addOrderMaster(orderMasterVO);
	pageContext.setAttribute("insertOrderMasterVO", insertOrderMasterVO);
	
	
	System.out.print(insertOrderMasterVO + " 8787623r09 "); 
 */
	
	
 	OrderMasterVO orderMasterVO = (OrderMasterVO) request.getAttribute("OrderMasterVO");
	
 	OrderDetailVO orderDetailVO = (OrderDetailVO) request.getAttribute("OrderDetailVO");
 	
 	
 	
 	
%>
    

	<!-- /header -->
	
	<main>
		<div class="hero_in cart_section">
			<div class="wrapper">
				<div class="container">
					<div class="bs-wizard clearfix">
						<div class="bs-wizard-step">
							<div class="text-center bs-wizard-stepnum">Your cart</div>
							<div class="progress">
								<div class="progress-bar"></div>
							</div>
							<a href="cart-1.html" class="bs-wizard-dot"></a>
						</div>

						<div class="bs-wizard-step active">
							<div class="text-center bs-wizard-stepnum">Payment</div>
							<div class="progress">
								<div class="progress-bar"></div>
							</div>
							<a href="#0" class="bs-wizard-dot"></a>
						</div>

						<div class="bs-wizard-step disabled">
							<div class="text-center bs-wizard-stepnum">Finish!</div>
							<div class="progress">
								<div class="progress-bar"></div>
							</div>
							<a href="#0" class="bs-wizard-dot"></a>
						</div>
					</div>
					<!-- End bs-wizard -->
				</div>
			</div>
		</div>
		<!--/hero_in-->
		
		
		<!-- ============================================================= -->
		
		
		

		<div class="bg_color_1">
			<div class="container margin_60_35">
				<div class="row">
				
					<div class="col-lg-8">
						<div class="box_cart">
						<div class="message">
							<p>Exisitng Customer? <a href="#0">Click here to login</a></p>
						</div>
						<div class="form_title">
							<h3><strong>1</strong>Your Details</h3>
							<p>
								Mussum ipsum cacilds, vidis litro abertis.
							</p>
						</div>
						
						
					

						<div class="step">
						
						
							<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label>Full name</label>
									<input type="text" name="fullNameId" id="memberId" class="form-control" value="MEM00001">
								</div>
							</div>
							
							</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Email</label>
									<input type="email" id="email_booking" name="memberEmail" class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Confirm email</label>
									<input type="email" id="email_booking_2" name="email_booking_2" class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Telephone</label>
									<input type="text" id="telephone_booking" name="memberPhone" class="form-control">
								</div>
							</div>
						</div>
						</div>
						
						
						
						<hr>
						<!--End step -->

						<div class="form_title">
							<h3><strong>2</strong>Payment Information</h3>
							<p>
								Mussum ipsum cacilds, vidis litro abertis.
							</p>
						</div>
						
						
						<div class="step">
							<div class="form-group">
							<label>Name on card</label>
							<input type="text" class="form-control" id="name_card_bookign" name="name_card_bookign">
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-12">
								<div class="form-group">
									<label>Card number</label>
									<input type="text" id="card_number" name="card_number" class="form-control">
								</div>
							</div>
							<div class="col-md-6 col-sm-12">
								<img src="img/cards_all.svg" alt="Cards" class="cards-payment">
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Expiration date</label>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" id="expire_month" name="expire_month" class="form-control" placeholder="MM">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" id="expire_year" name="expire_year" class="form-control" placeholder="Year">
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Security code</label>
									<div class="row">
										<div class="col-4">
											<div class="form-group">
												<input type="text" id="ccv" name="ccv" class="form-control" placeholder="CCV">
											</div>
										</div>
										<div class="col-8">
											<img src="img/icon_ccv.gif" width="50" height="29" alt="ccv"><small>Last 3 digits</small>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--End row -->

						<hr>

						<h4>Or checkout with Paypal</h4>
						<p>
							Lorem ipsum dolor sit amet, vim id accusata sensibus, id ridens quaeque qui. Ne qui vocent ornatus molestie, reque fierent dissentiunt mel ea.
						</p>
						<p>
							<a href="#0"><img src="img/paypal_bt.png" alt="Image"></a>
						</p>
						</div>
						<hr>
						<!--End step -->

						<div class="form_title">
							<h3><strong>3</strong>Billing Address</h3>
							<p>
								Mussum ipsum cacilds, vidis litro abertis.
							</p>
						</div>
						<div class="step">
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label>Country</label>
										<div class="custom-select-form">
										<select class="wide add_bottom_15" name="country" id="country">
											<option value="" selected>Select your Area</option>
											<option value="Europe">Europe</option>
											<option value="United states">United states</option>
											<option value="South America">South America</option>
											<option value="Oceania">Oceania</option>
											<option value="Asia">Asia</option>
										</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label>Street line 1</label>
										<input type="text" id="street_1" name="street_1" class="form-control">
									</div>
								</div>
								
							</div>
							
							
							
							
							
							<!--End row -->
						</div>
						<hr>
						<!--End step -->
						<div id="policy">
							<h5>Cancellation policy</h5>
							<p class="nomargin">Lorem ipsum dolor sit amet, vix <a href="#0">cu justo blandit deleniti</a>, discere omittantur consectetuer per eu. Percipit repudiare similique ad sed, vix ad decore nullam ornatus.</p>
						</div>
						</div>
					</div>
					<!-- /col -->
					
					<aside class="col-lg-4" id="sidebar">
						<div class="box_detail">
							<div id="total_cart">
								Total <span class="float-right">69.00$</span>
							</div>
							<ul class="cart_details">
								<li>From <span>02-11-18</span></li>
								<li>To <span>04-11-18</span></li>
								<li>Adults <span>2</span></li>
								<li>Childs <span>1</span></li>
							</ul>
							
								
								
									<a href="cart-3.html" class="btn_1 full-width purchase">Purchase</a>
									<input type="hidden" name="action"	value="frontend_getOne_For_Display">
							     	<input type="hidden" name="spaceId"  value="${spaceVO.spaceId}">
							   	 	<input type="submit" value="前往場地介紹">
					
							
							<div class="text-center"><small>No money charged in this step</small></div>
						</div>
					</aside>
			
				</div>
				
				<!-- /row -->
			</div>
			
			<!-- /container -->
		</div>
		
		<!-- /bg_color_1 -->
	</main>
	<!--/main-->
	
	
	<%@include file="/frontendPage/template/footer.jsp" %>
	
	
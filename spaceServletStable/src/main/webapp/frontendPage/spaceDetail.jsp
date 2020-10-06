<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="java.util.*"%>

<%@include file="/frontendPage/template/header.jsp"%> 
     
<%@ page import="com.space.model.*"%>
<%@ page import="com.spaceDetail.model.*"%>
<%@ page import="com.spaceComment.model.*"%>
<%@ page import="com.spacePhoto.model.*"%>


	<% 	Base64.Encoder encoder = Base64.getEncoder(); %>

<%
	
/* ===================== space id =============================================== */
	


	String spaceId = request.getParameter("spaceId");
	

	SpaceService spaceSvc = new SpaceService();
	SpaceVO listOneSpace = spaceSvc.selectOneSpace(spaceId);
	pageContext.setAttribute("listOneSpace",listOneSpace);
	System.out.println(spaceId);

	/* ===================== space detail =============================================== */

/* 	SpaceDetailVO spaceDetailVO =(SpaceDetailVO) request.getAttribute("selectOneSpaceDetail");
 */	
	
	SpaceDetailVO spaceDeatilVO = (SpaceDetailVO) request.getAttribute("sDetailVO");
	//SpaceDetailService spaceDetailSvc = new SpaceDetailService();
	pageContext.setAttribute("spaceDeatilVO",spaceDeatilVO);
	System.out.println(spaceDeatilVO);
	
	/* ===================== space comment =============================================== */

	
	String spaceCommentId = request.getParameter("spaceCommentId");
	
	SpaceCommentService spaceCommentSvc = new SpaceCommentService();
	SpaceCommentVO listOneSpaceComment = spaceCommentSvc.selectOneSpaceComment(spaceCommentId);
	pageContext.setAttribute("listOneSpaceComment",listOneSpaceComment);

	List<SpaceCommentVO> listAllSpaceComment = spaceCommentSvc.getAll();
	pageContext.setAttribute("listAllSpaceComment",listAllSpaceComment);
	
	/* ===================== space photo =============================================== */
	
	
	SpacePhotoVO spacePhotoVO = (SpacePhotoVO) request.getAttribute("sPhotoVO");
	//SpaceDetailService spaceDetailSvc = new SpaceDetailService();
	pageContext.setAttribute("spacePhotoVO",spacePhotoVO);
	
	//System.out.print(spacePhotoVO + " ooooooo  ");
	
	/* String spacePhotoId = request.getParameter("spacePhotoId");
	
	SpacePhotoService spacePhotoSvc = new SpacePhotoService();
	SpacePhotoVO listOneSpacePhoto = spacePhotoSvc.selectOneSpacePhoto(spacePhotoId);
	pageContext.setAttribute("listOneSpacePhoto",listOneSpacePhoto);
	
	List<SpacePhotoVO> listAllSpacePhoto = spacePhotoSvc.getAll();
	pageContext.setAttribute("listAllSpacePhoto",listAllSpacePhoto); */
	
	
	
	/* ===================== select all comment from all one spaceId =============================================== */
	
	
%>


	<main>
		<section class="hero_in hotels_detail">
			<div class="wrapper">
				<div class="container">
					<h1 class="fadeInUp"><span></span>${spaceVO.spaceName}</h1>
				</div>
				
					<span class="magnific-gallery">
						<a href="<%=request.getContextPath()%>/space/showonepicture?spaceId=${spaceVO.spaceId}" class="btn_photos" title="Photo title" data-effect="mfp-zoom-in">View photos</a>
	
								<a href="data:image/png;base64,<%=encoder.encodeToString(((SpacePhotoVO)pageContext.getAttribute("spacePhotoVO")).getSpacePhoto())%>" title="Photo title" data-effect="mfp-zoom-in"></a>
								
					</span>
				
			</div>
		</section>
		<!--/hero_in-->
		
		<div class="container ">
						<div class="hidden-md">
								<img src="img/avatar1.jpg" alt="" class="rounded-circle thumb_visit">
				
							</div>
				</div>
		<!--  -->

		<div class="bg_color_1">
			<nav class="secondary_nav sticky_horizontal">
				<div class="container">
					<ul class="clearfix">
						<li><a href="#description" class="active">Description</a></li>
						<li><a href="#reviews">Reviews</a></li>
						<li><a href="#sidebar">Booking</a></li>
					</ul>
				</div>
			</nav>
			<div class="container margin_60_35">
				<div class="row">
					<div class="col-lg-8">
						<section id="description">
							<h2>Description</h2>
							<p>Per consequat adolescens ex, cu nibh commune <strong>temporibus vim</strong>, ad sumo viris eloquentiam sed. Mea appareat omittantur eloquentiam ad, nam ei quas oportere democritum. Prima causae admodum id est, ei timeam inimicus sed. Sit an meis aliquam, cetero inermis vel ut. An sit illum euismod facilisis, tamquam vulputate pertinacia eum at.</p>
							<p>Cum et probo menandri. Officiis consulatu pro et, ne sea sale invidunt, sed ut sint <strong>blandit</strong> efficiendi. Atomorum explicari eu qui, est enim quaerendum te. Quo harum viris id. Per ne quando dolore evertitur, pro ad cibo commune.</p>
							<div class="row">
								<div class="col-lg-6">
									<ul class="bullets">
										<li>Dolorem mediocritatem</li>
										<li>Mea appareat</li>
										<li>Prima causae</li>
										<li>Singulis indoctum</li>
									</ul>
								</div>
								<div class="col-lg-6">
									<ul class="bullets">
										<li>Timeam inimicus</li>
										<li>Oportere democritum</li>
										<li>Cetero inermis</li>
										<li>Pertinacia eum</li>
									</ul>
								</div>
							</div>
							<!-- /row -->
							
							
							
							<!--  row  -->
							<hr>
							
							<h3>Location</h3>
							<div id="map" class="map map_single add_bottom_30"></div>
							<!-- End Map -->
						</section>
						<!-- /section -->
					
						<section id="reviews">
							<h2>Reviews</h2>
							<div class="reviews-container">
								<div class="row">
									<div class="col-lg-3">
										<div id="review_summary">
											<strong>8.5</strong>
											<em>Superb</em>
											<small>Based on 4 reviews</small>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="row">
											<div class="col-lg-10 col-9">
												<div class="progress">
													<div class="progress-bar" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col-lg-2 col-3"><small><strong>5 stars</strong></small></div>
										</div>
										<!-- /row -->
										<div class="row">
											<div class="col-lg-10 col-9">
												<div class="progress">
													<div class="progress-bar" role="progressbar" style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col-lg-2 col-3"><small><strong>4 stars</strong></small></div>
										</div>
										<!-- /row -->
										<div class="row">
											<div class="col-lg-10 col-9">
												<div class="progress">
													<div class="progress-bar" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col-lg-2 col-3"><small><strong>3 stars</strong></small></div>
										</div>
										<!-- /row -->
										<div class="row">
											<div class="col-lg-10 col-9">
												<div class="progress">
													<div class="progress-bar" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col-lg-2 col-3"><small><strong>2 stars</strong></small></div>
										</div>
										<!-- /row -->
										<div class="row">
											<div class="col-lg-10 col-9">
												<div class="progress">
													<div class="progress-bar" role="progressbar" style="width: 10%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col-lg-2 col-3"><small><strong>1 stars</strong></small></div>
										</div>
										<!-- /row -->
									</div>
								</div>
								<!-- /row -->
							</div>

							<hr>





							<div class="reviews-container">
								
									<c:forEach var="spaceCommentVO" items="${listAllSpaceComment}">
										<c:if test="${spaceCommentVO.spaceId == spaceVO.spaceId}">
											<div class="review-box clearfix">
												<figure class="rev-thumb"><img src="img/avatar1.jpg" alt="">
												</figure>
												<div class="rev-content">
													<div class="rating">
														<c:if test="${spaceCommentVO.spaceCommentLevel == 1}">
															<i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i><i class="icon_star"></i><i class="icon_star"></i>
														</c:if>
														<c:if test="${spaceCommentVO.spaceCommentLevel == 2}">
															<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star "></i><i class="icon_star"></i>
														</c:if>
														<c:if test="${spaceCommentVO.spaceCommentLevel == 3}">
															<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star "></i><i class="icon_star"></i>
														</c:if>
														<c:if test="${spaceCommentVO.spaceCommentLevel == 4}">
															<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
														</c:if>
														<c:if test="${spaceCommentVO.spaceCommentLevel == 5}">
															<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i>
														</c:if>
													</div>
													<div class="rev-info">
														Admin – April 03, 2016:
													</div>
													<div class="rev-text">
														<p>
															${spaceCommentVO.spaceCommentContent}
														</p>
													</div>
												</div>
											</div>
											<!-- /review-box -->
										</c:if>
									</c:forEach>
								
								
							</div>
							<!-- /review-container -->
							
							
							
							
							
							
							
							
						</section>
						<!-- /section -->
						<hr>

							<div class="add-review">
								<h5>Leave a Review</h5>
								<form>
									<div class="row">
										<div class="form-group col-md-6">
											<label>Name and Lastname *</label>
											<input type="text" name="name_review" id="name_review" placeholder="" class="form-control">
										</div>
										<div class="form-group col-md-6">
											<label>Email *</label>
											<input type="email" name="email_review" id="email_review" class="form-control">
										</div>
										<div class="form-group col-md-6">
											<label>Rating </label>
											<div class="custom-select-form">
											<select name="rating_review" id="rating_review" class="wide">
												<option value="1">1 (lowest)</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5" selected>5 (medium)</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10 (highest)</option>
											</select>
											</div>
										</div>
										<div class="form-group col-md-12">
											<label>Your Review</label>
											<textarea name="review_text" id="review_text" class="form-control" style="height:130px;"></textarea>
										</div>
										<div class="form-group col-md-12 add_top_20">
											<input type="submit" value="Submit" class="btn_1" id="submit-review">
										</div>
									</div>
								</form>
							</div>
					</div>
					<!-- /col -->
					
					<aside class="col-lg-4" id="sidebar">
						<div class="box_detail booking">
							<div class="price">
		
										<span id="price">${spaceDeatilVO.spaceDetailCharge}</span><small>per hour</small>
										
								
								<div class="score">
									<span>
									
									<c:forEach var="spaceCommentVO" items="${listAllSpaceComment}">
										<c:if test="${commentFromSpecificId <= 3}">
											<h5>Good</h5>
										</c:if>
										<c:if test="${commentFromSpecificId <= 7 || commentFromSpecificId > 3}">
											<h5>Average</h5>
										</c:if>
										<c:if test="${spaceCommentVO.spaceCommentLevel == 3}">
											<h5>Bad</h5>
										</c:if>
									</c:forEach>
										<em>350 Reviews</em></span><strong>7.0</strong>
								
								
								
								
								
								
								
								
								</div>
								
								
								
								
								
							</div>

							
							
							
							<div class="form-group input-dates">
								<input class="form-control" type="text" name="dates" id="calcDate_${spaceVO.spaceId}" placeholder="When.." >
								<i class="icon_calendar"></i>
								
							</div>

							
							
								<div class="panel-dropdown">
										<a href="#">Guests <span class="qtyTotal">1</span></a>
										<div class="panel-dropdown-content right">
											<div class="qtyButtons">
												<label>Adults</label>
												<input type="text" name="qtyInput" value="1">
											</div>
											<div class="qtyButtons">
												<label>Childrens</label>
												<input type="text" name="qtyInput" value="0">
											</div>
										</div>
									</div>

								

							
							<a href="<%=request.getContextPath()%>/frontendPage/orderSingle.jsp" class=" add_top_30 btn_1 full-width purchase" name="totalChargePerHour" >Purchase</a>
							<a href="wishlist.html" class="btn_1 full-width outline wishlist"><i class="icon_heart" name="totalChargePerPerson" onclick="total-date()"></i> Add to wishlist</a>
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













	<%@include file="/frontendPage/template/footer.jsp"%>   

	
	
	<!-- DATEPICKER  -->
	<script>
		$(function () {

			$('input[name="dates"]').daterangepicker({
				timePicker: true,
				"timePicker24Hour": true,
				startDate: moment().startOf('hour'),
				endDate: moment().startOf('hour').add(32, 'hour'),
				opens: 'left',
				locale: {
					cancelLabel: 'Clear',
					format: 'YY/MM/DD HH:mm',
				},
				minDate: new Date(),
			});

			/*
			$('input[name="dates"]').daterangepicker({
				autoUpdateInput: false,
				timePicker: true,
				parentEl:'.scroll-fix',
				minDate:new Date(),
				opens: 'left',
				locale: {
					cancelLabel: 'Clear'
				}
			});
			  */
			
			$('input[name="dates"]').on('apply.daterangepicker', function (ev, picker) {
				$(this).val(picker.startDate.format('MM-DD-YY') + ' > ' + picker.endDate.format('MM-DD-YY'));
				var start_date = picker.startDate;
				var end_date = picker.endDate;
				
				var price = parseInt("50");

				var diff_hours = end_date.diff(start_date, "hours");
				var total_price = price * diff_hours;
				

				$("#price").html(total_price);
			});
			$('input[name="dates"]').on('cancel.daterangepicker', function (ev, picker) {
				$(this).val('');
			});
		});
	</script>
	
	
	
	<!-- Ajax here   -->
	<script type="text/javascript">
		function calc(amountMoney, totalHourGet){
			
			//take time to hour
			var timeSpent = '1:25:58',
		    amountPerHour = 100,
		    time = timeSpent
		        .split(':')
		        .reduce((r, a, i) => r + a * Math.pow(60, -i), 0),
		    result = time * amountPerHour;
		    
			console.log('time', time);
			console.log('amount', result.toFixed(2));
			
			
			
			
			totalHours = totalHourGet.value
			if((totalHourGet)){
				alert("not right value");
				totalHourGet.value = 0;
				totalHours = totalHourGet.value;
				totalHourGet.focus();
			}
			var totalCharge = 'calcDate_' + amountMoney; 
			
			var charge = parseFloat(document.getElementById(calcDataId).innerText);
		}
	</script>
	
	
	<!-- INPUT QUANTITY  -->
	<script src="${pageContext.request.contextPath}/resources/js/input_qty.js"></script>
	
	
	

  	
  	
	
	<!--   =============================================== 觸發 Ajax ================================================ 
	-->
	
  	
</body>
</html>

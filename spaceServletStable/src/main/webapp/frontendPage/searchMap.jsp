<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@include file="/frontendPage/template/header.jsp"%>  
<%@ page import="java.util.*"%>
<%@ page import="com.space.model.*"%>
<%@ page import="com.space.controller.*"%>

<%@ page import="com.spaceDetail.model.*"%>
<%@ page import="com.spaceComment.model.*"%>
<%@ page import="com.spacePhoto.model.*"%>



<%
	
/* 	String spaceId = request.getParameter("spaceId");
 */	
 /*  ====================================================================  */ 
    SpaceService spaceSvc = new SpaceService();
    List<SpaceVO> listSpace = spaceSvc.selectAllSpace();
    pageContext.setAttribute("listSpace",listSpace);  
    
    /*  ====================================================================  */ 
    SpaceDetailService spaceDetailSvc = new SpaceDetailService();
    List<SpaceDetailVO> listSpaceDetail = spaceDetailSvc.selectAllSpaceDetail();
    pageContext.setAttribute("listSpaceDetail",listSpaceDetail);  
    
    /*  ====================================================================  */ 
    SpaceCommentService spaceCommentSvc = new SpaceCommentService();
    List<SpaceCommentVO> listSpaceComment = spaceCommentSvc.getAll();
    pageContext.setAttribute("listSpaceComment",listSpaceComment);
    
    
/*  ====================================================================  */   	
	String spacePhotoId = request.getParameter("spacePhotoId");
	
	SpacePhotoService spacePhotoSvc = new SpacePhotoService();
	SpacePhotoVO listOneSpacePhoto = spacePhotoSvc.selectOneSpacePhoto(spacePhotoId);
	pageContext.setAttribute("listOneSpacePhoto",listOneSpacePhoto);
    
    Map<String, Object> combineSpaceId = new HashMap<String, Object>();
    
    
%>

	


	<main>
	<div class="container-fluid full-height">
		<div class="row row-height">
			<div class="col-lg-5 content-left order-md-last order-sm-last order-last">
			<div id="results_map_view">
		   <div class="container-fluid">
			   <div class="row">
				   <div class="col-10">
					   <h4><strong>145</strong> results</h4>
				   </div>
				   <div class="col-2">
					   <a href="#0" class="search_map btn_search_map_view"></a> <!-- /open search panel -->
				   </div>
			   </div>
			   <!-- /row -->
				<div class="search_map_wp">
					<div class="custom-search-input-2 map_view">
						<div class="form-group">
							<input class="form-control" type="text" placeholder="What are you looking for...">
							<i class="icon_search"></i>
						</div>
						<div class="form-group">
							<input class="form-control" type="text" placeholder="Where">
							<i class="icon_pin_alt"></i>
						</div>
						<select class="wide">
							<option>All Categories</option>	
							<option>Shops</option>
							<option>Hotels</option>
							<option>Restaurants</option>
							<option>Bars</option>
							<option>Events</option>
							<option>Fitness</option>
						</select>
						<input type="submit" value="Search">
					</div>
				</div>
				<!-- /search_map_wp -->
		   </div>
		   <!-- /container -->
	   </div>
	   <!-- /results -->
		
		<div class="filters_listing version_3">
			<div class="container-fluid">
				<ul class="clearfix">
					<li>
						<div class="switch-field">
							<input type="radio" id="all" name="listing_filter" value="all" checked>
							<label for="all">All</label>
							<input type="radio" id="popular" name="listing_filter" value="popular">
							<label for="popular">Popular</label>
							<input type="radio" id="latest" name="listing_filter" value="latest">
							<label for="latest">Latest</label>
						</div>
					</li>
					<li><a class="btn_filt_map" data-toggle="collapse" href="#filters" aria-expanded="false" aria-controls="filters" data-text-swap="Less filters" data-text-original="More filters">More filters</a></li>
				</ul>
			</div>
			<!-- /container -->
		</div>
		<!-- /filters -->
				
		<div class="collapse map_view" id="filters">
			<div class="container-fluid margin_30_5">
				<h6>Category</h6>
				<div class="row">
				    <div class="col-md-6">
				    	<div class="filter_type">
							<ul>
							    <li>
							        <label class="container_check">All <small>(945)</small>
							            <input type="checkbox">
							            <span class="checkmark"></span>
							        </label>
							    </li>
							    <li>
							        <label class="container_check">Museums <small>(45)</small>
							            <input type="checkbox">
							            <span class="checkmark"></span>
							        </label>
							    </li>
							    <li>
							        <label class="container_check">Churches <small>(30)</small>
							            <input type="checkbox">
							            <span class="checkmark"></span>
							        </label>
							    </li>
							</ul>
				    	</div>
				    </div>
				    <div class="col-md-6">
				    	<div class="filter_type">
					       	<ul>
							    <li>
							        <label class="container_check">Historic <small>(25)</small>
							            <input type="checkbox">
							            <span class="checkmark"></span>
							        </label>
							    </li>
							    <li>
							        <label class="container_check">Walking <small>(56)</small>
							            <input type="checkbox">
							            <span class="checkmark"></span>
							        </label>
							    </li>
							</ul>
				    	</div>
				    </div>
				</div>
					<div class="row">
						<div class="col-md-12">
							<div class="add_bottom_30">
								<h6>Distance</h6>
								<div class="distance"> Radius around selected destination <span></span> km</div>
								<input type="range" min="10" max="100" step="10" value="30" data-orientation="horizontal">
							</div>
						</div>
					</div>
				<!-- /row -->
			</div>
		</div>
		<!-- /Filters -->
		
		
		
		<%-- <c:if test="${empty page.list }">
			<div class="row" style="width:1210px;margin:0 auto;">
				<ol class="breadcrumb">
					<li><a href="#">main page</a>
				</ol>
			</div>
			
			<c:forEach items="${page.list }" var="">
				<div class="col-md-2">
					<a href="${pageContent.request.contextPath}/frontendPage/homePage.jsp">
						<img src="${pageContext.request.contextPath}/frontendPage/homePage.jsp" style='color:grey'>
					</a>
					<p><a href="${pageContext.request.contextPath}/frontendPage/homePage.jsp" style='color:grey'></a>
					<p><font color="#FF0000">price </font></p>
				</div>
			</c:forEach>
		</c:if> --%>
		
		
		
		<c:forEach var="spaceVO" items="${listSpace}" varStatus="status">
			
		
				
					<div class="box_list map_view">
					    <div class="row no-gutters add_top_20">
					        <div class="col-4">

						            <figure>
						            	
						                <small>Museum</small>
						                <a href="<%=request.getContextPath()%>/space/space.do?action=frontend_getOne_For_Display&spaceId=${spaceVO.spaceId}"><img src="${spacePhotoVO.spacePhoto}" class="img-fluid" alt="" width="800" height="533"></a>
						            </figure>
						            
						         
						            
					        </div>
					        <div class="col-8" id="clickSpaceDetail">
					            <div class="wrapper">
					                <a href="#0" class="wish_bt"></a>
					                	<h3><a href="<%=request.getContextPath()%>/space/space.do?action=frontend_getOne_For_Display&spaceId=${spaceVO.spaceId}">${spaceVO.spaceName}</a></h3>
					                		
					                		
						              		<c:forEach var="spaceDetailVO" items="${listSpaceDetail}"> 
						              			<c:if test="${spaceDetailVO.spaceId == spaceVO.spaceId}" >
						                			<span class="price">From <strong>${spaceDetailVO.spaceDetailCharge}</strong> /per person</span>
						                		</c:if>
						                	</c:forEach>
						                	
					            </div>
					            <ul>
					               <li>
					                	<a href="#0" onclick="onHtmlClick('Marker',2)" class="address">On Map</a>
					                </li>
					                <li>
					                    <div class="score"><span>Superb<em>350 Reviews</em></span>
					                    
					                    	
												
											
					                    
					                    </div>
					                </li>
					            </ul>
					        </div>
					    </div>
					</div>
					<!-- /box_list -->
		
	</c:forEach>
			
			
			
			
			
						<ul class="pagination pagination-sm add_bottom_30">
							<li class="page-item disabled">
														<a class="page-link" href="#" tabindex="-1">Previous</a>
													</li>
													<li class="page-item"><a class="page-link" href="#">1</a></li>
													<li class="page-item"><a class="page-link" href="#">2</a></li>
													<li class="page-item"><a class="page-link" href="#">3</a></li>
													<li class="page-item">
														<a class="page-link" href="#">Next</a>
													</li>
												</ul>
	
	
	
	
	
			
			
			
			
<!-- 		<p class="text-center add_top_30"><a href="#0" class="btn_1 rounded"><strong>Load more</strong></a></p>
 -->		
			
			
			
		</div>
		<!-- /content-left-->

		<div class="col-lg-7 map-right">
			<div id="map"></div>
			<!-- map-->
		</div>
		<!-- /map-right-->

		</div>
		<!-- /row-->
	</div>
	<!-- /container-fluid -->	
		
	</main>











	





	<!-- Sign In Popup -->
	<div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">
		<div class="small-dialog-header">
			<h3>Sign In</h3>
		</div>
		<form>
			<div class="sign-in-wrapper">
				<a href="#0" class="social_bt facebook">Login with Facebook</a>
				<a href="#0" class="social_bt google">Login with Google</a>
				<div class="divider"><span>Or</span></div>
				<div class="form-group">
					<label>Email</label>
					<input type="email" class="form-control" name="email" id="email">
					<i class="icon_mail_alt"></i>
				</div>
				<div class="form-group">
					<label>Password</label>
					<input type="password" class="form-control" name="password" id="password" value="">
					<i class="icon_lock_alt"></i>
				</div>
				<div class="clearfix add_bottom_15">
					<div class="checkboxes float-left">
						<label class="container_check">Remember me
						  <input type="checkbox">
						  <span class="checkmark"></span>
						</label>
					</div>
					<div class="float-right mt-1"><a id="forgot" href="javascript:void(0);">Forgot Password?</a></div>
				</div>
				<div class="text-center"><input type="submit" value="Log In" class="btn_1 full-width"></div>
				<div class="text-center">
					Don’t have an account? <a href="register.html">Sign up</a>
				</div>
				<div id="forgot_pw">
					<div class="form-group">
						<label>Please confirm login email below</label>
						<input type="email" class="form-control" name="email_forgot" id="email_forgot">
						<i class="icon_mail_alt"></i>
					</div>
					<p>You will receive an email containing a link allowing you to reset your password to a new preferred one.</p>
					<div class="text-center"><input type="submit" value="Reset Password" class="btn_1"></div>
				</div>
			</div>
		</form>
		<!--form -->
	</div>
	<!-- /Sign In Popup -->
		
	<!-- COMMON SCRIPTS -->
    <script src="${pageContext.request.contextPath}/resources/js/common_scripts.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/validate.js"></script>
	
	<!-- Map -->
	 <<!-- script 
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDPp1h-YGB5zYOzELLXZcLCcuPsfNNrX-8">
    </script> -->
	
	<script src="${pageContext.request.contextPath}/resources/js/markerclusterer.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/map_tours_half_screen.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/infobox.js"></script>
  
  
  	
</body>



<script>

	$(function(){
		var url="${pageContext.request.contextPath}/frontendPage/searchMap.jsp";
		var obj = {"method":"selectAllSpace"};
		
		$.post(url,obj,function(data){
			//alert(data);
			
			$.each(data,function(i,obj){
				//var li = "<li><a href='/spaceServletStable/frontendPage/spaceDetail.jsp'>"+ obj.spaceContain + "</a></li>";
				var li = "<li><a href='/SpaceServlet?method=selectOne&num=1&'>";
				$("#clickSpaceDetail").append(li);
			})
			
		},"json");
		
		
	});


</script>


</html>

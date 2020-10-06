<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.spaceDetail.model.*"%>


<%@include file="/frontendPage/template/header.jsp"%>  
	
	
	
	
	
	
	
	
	<main>
		<div class="hero_in cart_section">
			<div class="wrapper">
				<div class="container">
					<div class="bs-wizard clearfix">
						<div class="bs-wizard-step active">
							<div class="text-center bs-wizard-stepnum">Your cart</div>
							<div class="progress">
								<div class="progress-bar"></div>
							</div>
							<a href="#0" class="bs-wizard-dot"></a>
						</div>

						<div class="bs-wizard-step disabled">
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

		<div class="bg_color_1">
			<div class="container margin_60_35">

				<div class="row">
					<div class="col-lg-8">
						<div class="box_cart">
						<table class="table table-striped cart-list">
							<div class="col-lg-8">
								<h3>訂單明細</h3>
								<br>

								<h5>日期</h5>
								<p>
									Mussum ipsum cacilds, vidis litro abertis.
								</p>

								<!-- <a href="#sign-in-dialog"  data-content="toggle-text" id="sign-in" onclick="showAlert()"><strong>編輯</strong></a> -->

								<div class="form-group input-dates">
									<input class="form-control" type="text" name="dates" placeholder="When..">
								</div>

								
								<!-- Bootstap Modal -->
									<div class="menu_fixed modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered" role="document">
											<div class="modal-content">
												<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												</div>
												<div class="modal-body">
													<div class="form-control" name="datetimes"  placeholder="When.."></div>
													<i class="icon_calendar"></i>												
												</div>
											</div>
										</div>
									</div>
									<!-- /Bootstap Modal -->



								<br>
								<br>
								<br>

								<h5>人數</h5>
								<p>
									Mussum ipsum cacilds, vidis litro abertis.
								</p>

								<a href="#0" class="show_hide" data-content="toggle-text"><strong>編輯</strong></a>
								
								<hr>

								<h5>服務項目</h5>
								<br>
								<div>
									是否需要清潔服務float-right
								</div>
										
								<br>


								<label class="togit" for="switch" ><input type="checkbox" id="switch" class="togit" onclick="myFunction()" /><span class="slider round"></span></label>

								<br>
								<br>


									<!--  hidden div -->
									<div id="myDIV">
										
										清潔費加五％
									</div>

								
							</div>
						</table>
						<div class="cart-options clearfix">
							<div class="float-left">
								<div class="apply-coupon">
									<div class="form-group">
										<input type="text" name="coupon-code" value="" placeholder="Your Coupon Code" class="form-control">
									</div>
									<div class="form-group">
										<button type="button" class="btn_1 outline">Apply Coupon</button>
									</div>
								</div>
							</div>
							<div class="float-right fix_mobile">
								<button type="button" class="btn_1 outline">Update Cart</button>
							</div>
						</div>
						<!-- /cart-options -->
					</div>
					</div>
					<!-- /col -->
					
					
					
					<aside class="col-lg-4" id="sidebar">
						<div class="box_detail">
							<div id="total_cart">
								Total <span class="float-right" id="price">69.00$</span>
							</div>
							<ul class="cart_details">
								<li>From <span>02-11-18</span></li>
								<li>To <span>04-11-18</span></li>
								<li>Adults <span>2</span></li>
								<li>Childs <span>1</span></li>
							</ul>
								<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/frontendPage/orderReadToPay.jsp" enctype="multipart/form-data">

									<a href="" class="btn_1 full-width purchase">Checkout</a>
									<input type="hidden" name="action"	value="frontend_getOne_For_Display">
							     	<input type="hidden" name="spaceId"  value="${spaceVO.spaceId}">
							   	 	<input type="submit" value="Checkout" class="btn_1 full-width purchase">
							
							
								</FORM>
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
		

		$("#adult").on('click')



	});
</script>
	
	<!-- INPUT QUANTITY  -->
	<script src="js/input_qty.js"></script>
	
	<!-- INSTAGRAM FEED  -->
	<script>
	$(window).on('load', function(){
			"use strict";
			$.instagramFeed({
				'username': 'hotelwailea',
				'container': "#instagram-feed-hotel",
				'display_profile': false,
				'display_biography': false,
				'display_gallery': true,
				'get_raw_json': false,
				'callback': null,
				'styling': true,
				'items': 12,
				'items_per_row': 6,
				'margin': 1 
			});
		});
	</script>



</body>
</html>
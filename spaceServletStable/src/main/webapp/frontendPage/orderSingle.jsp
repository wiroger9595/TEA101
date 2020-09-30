<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
						
							<thead>
								<tr>
									<th>
										Item
									</th>
									<th>
										Discount
									</th>
									<th>
										Price
									</th>
									<th>
										Actions
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<div class="thumb_cart">
											<img src="http://via.placeholder.com/150x150/ccc/fff/thumb_cart_1.jpg" alt="Image">
										</div>
										<span class="item_cart">Persius delenit has cu</span>
									</td>
									<td>
										0%
									</td>
									<td>
										<strong>24,71$</strong>
									</td>
									<td class="options" style="width:5%; text-align:center;">
										<a href="#"><i class="icon-trash"></i></a>
									</td>
								</tr>
								<tr>
									<td>
										<div class="thumb_cart">
											<img src="http://via.placeholder.com/150x150/ccc/fff/thumb_cart_2.jpg" alt="Image">
										</div>
										<span class="item_cart">At deseruisse scriptorem</span>
									</td>
									<td>
										0%
									</td>
									<td>
										<strong>15,50$</strong>
									</td>
									<td class="options" style="width:5%; text-align:center;">
										<a href="#"><i class="icon-trash"></i></a>
									</td>
								</tr>
								<tr>
									<td>
										<div class="thumb_cart">
											<img src="http://via.placeholder.com/150x150/ccc/fff/thumb_cart_3.jpg" alt="Image">
										</div>
										<span class="item_cart">Ea vel semper quaerendum</span>
									</td>
									<td>
										0%
									</td>
									<td>
										<strong>24,71$</strong>
									</td>
									<td class="options" style="width:5%; text-align:center;">
										<a href="#"><i class="icon-trash"></i></a>
									</td>
								</tr>
								<tr>
									<td>
										<div class="thumb_cart">
											<img src="http://via.placeholder.com/150x150/ccc/fff/thumb_cart_4.jpg" alt="Image">
										</div>
										<span class="item_cart">Ei has exerci graecis</span>
									</td>
									<td>
										0%
									</td>
									<td>
										<strong>24,71$</strong>
									</td>
									<td class="options" style="width:5%; text-align:center;">
										<a href="#"><i class="icon-trash"></i></a>
									</td>
								</tr>
							</tbody>
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
								Total <span class="float-right">69.00$</span>
							</div>
							<ul class="cart_details">
								<li>From <span>02-11-18</span></li>
								<li>To <span>04-11-18</span></li>
								<li>Adults <span>2</span></li>
								<li>Childs <span>1</span></li>
							</ul>
							<a href="orderReadToPay" class="btn_1 full-width purchase">Checkout</a>
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

</body>
</html>
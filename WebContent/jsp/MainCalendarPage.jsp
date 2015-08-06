<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/calendar.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/custom_2.css">
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.calendario.js"></script>
<script
	src="${pageContext.request.contextPath}/js/modernizr.custom.63321.js"></script>
<script type="text/javascript">
	var mydate = new Date();
	var month = mydate.getMonth();
	var year = mydate.getFullYear();
	$(function() {
		getEvents(year, month)
		
		function getEvents(year, month){
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/management/getevents.html",
				data : {
					year : year,
					month : month
				},
				dataType : "json",
				success : function(data) {
					if (data != null) {
						var transEndEventNames = {
								'WebkitTransition' : 'webkitTransitionEnd',
								'MozTransition' : 'transitionend',
								'OTransition' : 'oTransitionEnd',
								'msTransition' : 'MSTransitionEnd',
								'transition' : 'transitionend'
							}, transEndEventName = transEndEventNames[Modernizr
									.prefixed('transition')], $wrapper = $('#custom-inner'), $calendar = $('#calendar'), cal = $calendar
									.calendario({
										onDayClick : function($el, $contentEl, dateProperties) {

											if ($contentEl.length > 0) {
												showEvents($contentEl, dateProperties);
											}

										},
										caldata : data,
										displayWeekAbbr : true
									}), $month = $('#custom-month').html(cal.getMonthName()), $year = $(
									'#custom-year').html(cal.getYear());

						$('#custom-next').on('click', function() {
							cal.gotoNextMonth(updateMonthYear);
							month++;
							if(month==12){
								month=0;
								year++;
							}
							$.ajax({
								type : 'POST',
								url : "${pageContext.request.contextPath}/management/getevents.html",
								data : {
									year : year,
									month : month
								},
								dataType : "json",
								success : function(data) {
										cal.setData(data);
								},
								error : function() {}
							});
						});
						$('#custom-prev').on('click', function() {
							cal.gotoPreviousMonth(updateMonthYear);
							month--;
							if(month==-1){
								month=11;
								year--;
							}
							$.ajax({
								type : 'POST',
								url : "${pageContext.request.contextPath}/management/getevents.html",
								data : {
									year : year,
									month : month
								},
								dataType : "json",
								success : function(data) {
										cal.setData(data);
								},
								error : function() {}
							});
						});

						function updateMonthYear() {
							$month.html(cal.getMonthName());
							$year.html(cal.getYear());
						}

						// just an example..
						function showEvents($contentEl, dateProperties) {

							hideEvents();

							var $events = $('<div id="custom-content-reveal" class="custom-content-reveal"><h4>Events for '
									+ dateProperties.monthname
									+ ' '
									+ dateProperties.day
									+ ', ' + dateProperties.year + '</h4></div>'), $close = $(
									'<span class="custom-content-close"></span>').on('click',
									hideEvents);

							$events.append($contentEl.html(), $close).insertAfter($wrapper);

							setTimeout(function() {
								$events.css('top', '0%');
							}, 25);

						}
						function hideEvents() {

							var $events = $('#custom-content-reveal');
							if ($events.length > 0) {

								$events.css('top', '100%');
								Modernizr.csstransitions ? $events.on(transEndEventName,
										function() {
											$(this).remove();
										}) : $events.remove();

							}

						}

					}
				},
				error : function() {}
			});
		}
	});
</script>
<title>日历</title>
</head>
<body>
	<div class="container">
		<section class="main">
			<div class="custom-calendar-wrap">
				<div id="custom-inner" class="custom-inner">
					<div class="custom-header clearfix">
						<nav>
							<span id="custom-prev" class="custom-prev"></span> <span
								id="custom-next" class="custom-next"></span>
						</nav>
						<h2 id="custom-month" class="custom-month"></h2>
						<h3 id="custom-year" class="custom-year"></h3>
					</div>
					<div id="calendar" class="fc-calendar-container"></div>
				</div>
			</div>
		</section>
	</div>
	<!-- /container -->
</body>
</html>
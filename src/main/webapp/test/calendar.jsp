<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui-calendar/latest/tui-calendar.css" />
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css" />
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.time-picker/latest/tui-time-picker.css" />

<script src="https://uicdn.toast.com/tui.code-snippet/v1.5.2/tui-code-snippet.min.js"></script>
<script src="https://uicdn.toast.com/tui.time-picker/latest/tui-time-picker.min.js"></script>
<script src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.min.js"></script>
<script src="https://uicdn.toast.com/tui-calendar/latest/tui-calendar.js"></script>
<title>캘린더 테스트</title>
</head>
<body>
	<h1>캘린더 테스트 페이지</h1>

	<div id="menu">
		<span id="menu-navi">
			<button type="button" class="btn btn-default btn-sm move-today" data-action="move-today">Today</button>
			<button type="button" class="btn btn-default btn-sm move-day" data-action="move-prev">
				<i class="calendar-icon ic-arrow-line-left" data-action="move-prev"></i>
			</button>
			<button type="button" class="btn btn-default btn-sm move-day" data-action="move-next">
				<i class="calendar-icon ic-arrow-line-right" data-action="move-next"></i>
			</button>
		</span> <span id="renderRange" class="render-range"></span>
	</div>
	<div id="calendar" style="height: 800px;"></div>
	
	<script type="text/javascript">
		var Calendar = tui.Calendar;
	
		var calendar = new Calendar('#calendar', {
			defaultView: 'month'
		});
	</script>
</body>
</html>
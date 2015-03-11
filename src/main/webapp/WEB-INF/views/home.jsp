<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/statics" var="staticResourcesBaseUrl"></spring:url>
<!doctype html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>Home</title>
		
		<link href="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			body {
				padding-top: 50px;
			}
		</style>
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Personalia Bareng</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>
		<div class="container">
			<h1>Welcome Home, Buddy!</h1>
			<p>This is home page</p>
		</div>
		<script type="text/javascript" src="${staticResourcesBaseUrl}/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript" src="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			// Custom css here.
		</script>
	</body>
</html>
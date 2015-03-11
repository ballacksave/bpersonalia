<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/statics" var="staticResourcesBaseUrl" />
<spring:url value="/login" var="loginPageUrl" />
<spring:url value="/authenticate" var="authenticationTargetUrl" />
<!doctype html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
		<title>Login</title>
		
		<link href="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			body {
				padding-top: 20px;
			}
		</style>
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" method="POST">
					<div class=" panel panel-default">
					<div class="panel-heading">Forgot Password</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="email" name="email" placeholder="Email Address" autofocus="autofocus" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9 col-md-offset-3">
								<button type="submit" class="btn btn-primary">Reset</button>
								<a href="${loginPageUrl}" class="btn btn-link">Back to Login</a>
							</div>
						</div>
					</div>
					</div>
				</form>
			</div>			
		</div>
		<script type="text/javascript" src="${staticResourcesBaseUrl}/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript" src="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			// Custom css here.
		</script>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/statics" var="staticResourcesBaseUrl"></spring:url>
<spring:url value="/authenticate" var="authenticationTargetUrl" />
<spring:url value="/forgot-password" var="forgotPasswordRequestUrl"/>
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
				<form class="form-horizontal" action="${authenticationTargetUrl}" method="POST">
					<div class=" panel panel-default">
					<div class="panel-heading">Login</div>
					<div class="panel-body">
                        <c:choose>
                            <c:when test="${not empty param.failed}">
                                <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-info" role="alert">
                                    <p><b>username</b> : administrator</p>
                                    <p><b>password</b> : password
                                </div>
                            </c:otherwise>
                        </c:choose>
						<div class="form-group">
							<label for="username" class="col-md-3 control-label">Username</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="username" name="username" placeholder="Username" autofocus="autofocus" autocomplete="off" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9 col-md-offset-3">
								<label>
									<input type="checkbox" id="remember-me" name="remember-me"> Remember me
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9 col-md-offset-3">
								<button type="submit" class="btn btn-primary">Login</button>
								<a href="${forgotPasswordRequestUrl}" class="btn btn-link">Forgot Password</a>
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
			// Custom javascript here.
		</script>
	</body>
</html>
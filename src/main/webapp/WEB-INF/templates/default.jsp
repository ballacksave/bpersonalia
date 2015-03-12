<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:url value="/statics" var="staticResourcesBaseUrl" />
<spring:url value="/" var="homePageUrl" />
<spring:url value="/employee" var="employeePageUrl" />
<spring:url value="/logout" var="logoutTargetUrl" />
<!doctype html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title><tiles:insertAttribute name="pageTitle" defaultValue="Belajar Bareng Java" /></title>
        
        <link href="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/css/bootstrap.min.css" rel="stylesheet">
        <link href="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/css/bootstrap-theme.min.css" rel="stylesheet">
        <tiles:insertAttribute name="customStylesheets" ignore="true" />
        <style type="text/css">
            body {
                padding-top: 75px;
            }
        </style>
        <tiles:insertAttribute name="customStyles" ignore="true" />
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${homePageUrl}">Personalia</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="${employeePageUrl}">Employee</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><p class="navbar-text"><sec:authentication property="principal.username" /></p></li>
                        <li><a href="${logoutTargetUrl}">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container">
            <tiles:insertAttribute name="content" ignore="true">
                <h1>Default Content</h1>
                <p>This string is from template, you have to insert content attributes to remove this!</p>
            </tiles:insertAttribute>
        </div>
        <script type="text/javascript" src="${staticResourcesBaseUrl}/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="${staticResourcesBaseUrl}/bootstrap/3.3.2-1/js/bootstrap.min.js"></script>
        <tiles:insertAttribute name="customJavascripts" ignore="true" />
    </body>
</html>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
        <title><tiles:insertAttribute name="pageTitle" defaultValue="Belajar Bareng Java" /></title>
        
        <link href="${staticResourcesBaseUrl}/bootswatch-paper/3.3.1+2/css/bootstrap.min.css" rel="stylesheet">
        <tiles:insertAttribute name="customStylesheets" ignore="true" />
        <style type="text/css">
            body {
                padding-top: 20px;
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
        <div class="container">
            <tiles:insertAttribute name="content" ignore="true" />
        </div>
        <script type="text/javascript" src="${staticResourcesBaseUrl}/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="${staticResourcesBaseUrl}/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <tiles:insertAttribute name="customJavascripts" ignore="true" />
    </body>
</html>
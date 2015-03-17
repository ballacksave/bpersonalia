<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<spring:url value="/statics" var="staticResourcesBaseUrl"></spring:url>
<spring:url value="/login" var="loginPageUrl" />

<tiles:insertDefinition name="blank">
    <tiles:putAttribute name="pageTitle" value="Forgot Password" />
    <tiles:putAttribute name="content">
        <div class="col-md-4 col-md-offset-4">
            <form class="form-horizontal" method="POST">
                <div class=" panel panel-default">
                    <div class="panel-heading">Forgot Password</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="email"
                                class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control"
                                    id="email" name="email"
                                    placeholder="Email Address"
                                    autofocus="autofocus"
                                    autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-9 col-md-offset-3">
                                <button type="submit"
                                    class="btn btn-primary">Reset</button>
                                <a href="${loginPageUrl}"
                                    class="btn btn-link">Back to
                                    Login</a>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
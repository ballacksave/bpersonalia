<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/employee" var="employeeListEndpointUrl" />
<tiles:insertDefinition name="default">
    <tiles:putAttribute name="pageTitle" value="Employee Detail" />
    <tiles:putAttribute name="content">
        <h3 class="page-header"><c:out value="${employee.fullName}" /></h3>
        <form class="form-horizontal">
            <div class="row">
                <div class="form-group col-md-6">
                    <label class="col-sm-4 control-label">
                        <spring:message code="label.entity.employee.regNumber" />
                    </label>
                    <div class="col-sm-4">
                        <p class="form-control-static">
                            <c:out value="${employee.regNumber}" />
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label class="col-sm-4 control-label">
                        <spring:message code="label.entity.employee.fullName" />
                    </label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:out value="${employee.fullName}" />
                        </p>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label class="col-sm-4 control-label">
                        <spring:message code="label.entity.employee.emailAddress" />
                    </label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:out value="${employee.emailAddress}" />
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label class="col-sm-4 control-label">
                        <spring:message code="label.entity.employee.birthDate" />
                    </label>
                    <div class="col-sm-4">
                        <spring:message code="pattern.general.java.date" var="javaDatePattern" />
                        <p class="form-control-static">
                            <fmt:formatDate value="${employee.birthDate}" pattern="${javaDatePattern}" />
                        </p>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label class="col-sm-4 control-label">
                        <spring:message code="label.entity.employee.gender" />
                    </label>
                    <div class="col-sm-4">
                        <spring:message code="${employee.gender.labelCode}" var="employeeGenderLabel" />
                        <p class="form-control-static">
                            <c:out value="${employeeGenderLabel}" />
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                <spring:url value="/employee" var="employeeListUrl" />
                <a href="${employeeListUrl}" class="btn btn-primary btn-sm">List</a>
                </div>
            </div>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>
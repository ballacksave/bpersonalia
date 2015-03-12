<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/employee" var="employeeListEndpointUrl" />
<tiles:insertDefinition name="default">
    <tiles:putAttribute name="pageTitle" value="Register Employee" />
    <tiles:putAttribute name="content">
        <form:form modelAttribute="command" class="form-horizontal">
            <div class="row">
                <spring:bind path="regNumber">
                    <c:if test="${not empty status.errorMessages}" var="hasError" />
                    <div class="form-group col-md-6 ${hasError ? 'has-error' : ''}">
                        <label for="regNumber" class="col-sm-4 control-label">
                            <spring:message code="label.entity.employee.regNumber" />
                        </label>
                        <div class="col-sm-4">
                            <form:input path="regNumber" type="text" class="form-control" autofocus="autofocus" autocomplete="off" />
                            <form:errors path="regNumber" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <div class="row">
                <spring:bind path="fullName">
                    <c:if test="${not empty status.errorMessages}" var="hasError" />
                    <div class="form-group col-md-6 ${hasError ? 'has-error' : ''}">
                        <label for="fullName" class="col-sm-4 control-label">
                            <spring:message code="label.entity.employee.fullName" />
                        </label>
                        <div class="col-sm-8">
                            <form:input path="fullName" type="text" class="form-control"/>
                            <form:errors path="fullName" />
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="emailAddress">
                    <c:if test="${not empty status.errorMessages}" var="hasError" />
                    <div class="form-group col-md-6 ${hasError ? 'has-error' : ''}">
                        <label for="emailAddress" class="col-sm-4 control-label">
                            <spring:message code="label.entity.employee.emailAddress" />
                        </label>
                        <div class="col-sm-8">
                            <form:input path="emailAddress" type="email" class="form-control"/>
                            <form:errors path="emailAddress" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <div class="row">
                <spring:bind path="birthDate">
                    <c:if test="${not empty status.errorMessages}" var="hasError" />
                    <div class="form-group col-md-6 ${hasError ? 'has-error' : ''}">
                        <label for="birthDate" class="col-sm-4 control-label">
                            <spring:message code="label.entity.employee.birthDate" />
                        </label>
                        <div class="col-sm-4">
                            <form:input path="birthDate" type="text" class="form-control" placeholder="dd/mm/yyyy" />
                            <form:errors path="birthDate" />
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="gender">
                    <div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
                        <label for="gender" class="col-sm-4 control-label">
                            <spring:message code="label.entity.employee.gender" />
                        </label>
                        <div class="col-sm-4">
                            <form:select path="gender" class="form-control">
                                <form:option value=""></form:option>
                                <form:option value="MALE"><spring:message code="label.entity.genderType.male" /></form:option>
                                <form:option value="FEMALE"><spring:message code="label.entity.genderType.female" /></form:option>
                            </form:select>
                            <form:errors path="gender" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">
                        <spring:message code="label.general.button.save" />
                    </button>
                    <a href="${employeeListEndpointUrl}" class="btn btn-warning">
                        <spring:message code="label.general.button.cancel" />
                    </a>
                </div>
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
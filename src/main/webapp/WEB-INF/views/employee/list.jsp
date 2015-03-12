<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="paging" uri="http://bareng.org/hr/spring-data-paging" %>

<spring:url value="/employee/register" var="registerEmployeeEndpointUrl" />
<spring:url value="/employee/detail" var="employeeDetailPageUrl" />
<tiles:insertDefinition name="default">
    <tiles:putAttribute name="pageTitle" value="Employee List" />
    <tiles:putAttribute name="content">
        <div>
            <a href="${registerEmployeeEndpointUrl}" class="btn btn-primary btn-sm">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> <spring:message code="label.employee.button.new" />
            </a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th><spring:message code="label.entity.employee.regNumber" /></th>
                        <th><spring:message code="label.entity.employee.fullName" /></th>
                        <th><spring:message code="label.entity.employee.birthDate" /></th>
                        <th><spring:message code="label.entity.employee.gender" /></th>
                        <th><spring:message code="label.entity.employee.emailAddress" /></th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty pagedList.content}">
                            <tr>
                                <td colspan="6" align="center">
                                    <i><spring:message code="message.general.list.nodata" /></i>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <spring:message code="pattern.general.java.date" var="javaDatePattern" />
                            <c:forEach items="${pagedList.content}" var="employee" varStatus="index">
                                <tr>
                                    <td>#</td>
                                    <td><c:out value="${employee.regNumber}" /></td>
                                    <td>
                                        <a href="${employeeDetailPageUrl}/${employee.id}"><c:out value="${employee.fullName}" /></a>
                                    </td>
                                    <td><fmt:formatDate value="${employee.birthDate}" pattern="${javaDatePattern}" /></td>
                                    <td><spring:message code="${employee.gender.labelCode}" /></td>
                                    <td><c:out value="${employee.emailAddress}" /></td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
        <paging:paging pagedListModelName="pagedList" />
    </tiles:putAttribute>
</tiles:insertDefinition>
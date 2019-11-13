<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page = "header.jsp"/>

<h1>Device List Page</h1>

<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-primary" href = "${pageContext.request.contextPath}/addDevice" role ="button">Add New Device</button></a>
</sec:authorize>


<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Device ID</th>
      <th scope="col">Device Name</th>
      <th scope="col">Device IP Address</th>
      <th scope="col">Device Location</th>
      <th scope="col">Device Time</th>
      <th scope="col">Device Value</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="device" items="${devices}">
    <tr>
      <th scope="row">${device.id}</th>
      <td><a href="${pageContext.request.contextPath}/device/item/${device.id}">${device.name}</a></td>
      <td>${device.value}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<jsp:include page = "chart.jsp"/>
<jsp:include page = "footer.jsp"/>
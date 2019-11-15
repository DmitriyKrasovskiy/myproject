<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page = "header.jsp"/>




<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">SpeedCam ID</th>
      <th scope="col">SpeedCam Name</th>
      <th scope="col">IP Address</th>
      <th scope="col">SpeedCam Location</th>
      <th scope="col">Speed Time</th>
      <th scope="col">Speed Value</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="device" items="${device}">
    <tr>
      <th scope="row">${device.id}</th>
      <td><a href="${pageContext.request.contextPath}/device/device/${device.id}">${device.name}</a></td>
      <td>${device.ipAddress}</td>
      <td>${device.location}</td>
      <td>${device.date}</td>
      <td>${device.value}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-primary" href = "${pageContext.request.contextPath}/addDevice" role ="button">Add New Device</button></a>
</sec:authorize>

<jsp:include page = "chart.jsp"/>
<jsp:include page = "footer.jsp"/>
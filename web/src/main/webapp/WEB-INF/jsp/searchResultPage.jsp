<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="header.jsp"/>

<h1>Search Result</h1>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Device ID</th>
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



<jsp:include page="footer.jsp"/>
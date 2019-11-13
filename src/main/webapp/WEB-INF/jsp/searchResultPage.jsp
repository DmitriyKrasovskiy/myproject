<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="header.jsp"/>

<h1>Search Result</h1>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">S/N</th>
      <th scope="col">Device IP Address</th>
      <th scope="col">Device Location</th>
      <th scope="col">Number of sensors</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="device" items="${devices}">
    <tr>
      <th scope="row">${device.id}</th>
      <td>${device.name}</td>
      <td>${device.location}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>



<jsp:include page="footer.jsp"/>
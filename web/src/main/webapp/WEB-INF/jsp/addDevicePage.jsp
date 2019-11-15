<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "header.jsp"/>

<h1>Add Device Page</h1>

<form action = "${pageContext.request.contextPath}/addDevice/device" method = "POST" enctype="multipart/form-data">
  <div class="form-group">
      <label for="exampleInputEmail1">Device Name</label>
      <input type="text" name ="name" class="form-control" id="exampleInputPassword1" placeholder="Enter name of device">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Device IP Address</label>
    <input type="text" name="ipAddress" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter IP address">
  </div>
  <div class="form-group">
      <label for="exampleInputEmail1">Device Location</label>
      <input type="text" name="location" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter location">
  </div>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<c:forEach var="error" items="${errors}">
<h2 color="red">${error.defaultMessage}</h2>
</c:forEach>


<jsp:include page = "footer.jsp"/>
<jsp:include page = "header.jsp"/>

<h1>${device.ip_address}</h1>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${device.ipAddress}</h5>
    <p class="card-text">${device.name}</p>
    <p class="card-text">${device.location}</p>
  </div>
</div>

<jsp:include page = "footer.jsp"/>
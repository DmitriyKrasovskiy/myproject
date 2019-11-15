<jsp:include page = "header.jsp"/>

<h1>${device.name}</h1>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${device.location}</h5>
    <p class="card-text">${device.date}</p>
    <p class="card-text">${device.value}</p>
  </div>
</div>

<jsp:include page = "footer.jsp"/>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-sharp fa-regular fa-hospital"></i> MEDI HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"> HOME </a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="patient.jsp"><i
						class="fa-sharp fa-regular fa-calendar-check"></i> PATIENT</a></li>

			</ul>



			<form class="d-flex" >

				<div class="dropdown">
					<button class="btn btn-outline-light dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${doctObj.fullName }
					</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="edit_profile.jsp">Edit</a></li>
						
						<li><a class="dropdown-item" href="../doctorLogout">Logout</a></li>

					</ul>
				</div>

			</form>





		</div>
	</div>
</nav>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav navbar-left">
			<li><img alt="icona" src="img/ico_nav.png" width="50"
				height="50"></li>
		</ul>
		<%
		String admin = (String) session.getAttribute("nomeadmin");
		if (admin == null) {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.jsp"><span
					class="glyphicon glyphicon-user"></span>&nbsp;Login</a></li>
		</ul>
		<%
		} else {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="home.jsp"><span
					class="glyphicon glyphicon-user"></span>&nbsp;<%= admin %></a></li>
			<li><a href="logout.jsp"><span
					class="glyphicon glyphicon-off"></span>&nbsp;Logout</a></li>
		</ul>
		<%
		}
		%>
	</div>
</nav>
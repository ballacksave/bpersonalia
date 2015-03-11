<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
	<head>
		<title>Registrasi</title>
	</head>
	<body>
		<h1>Registrasi</h1>
		<form:form commandName="command" method="POST">
			<form:label path="regNumber">Nomor Registrasi</form:label><br>
			<form:input path="regNumber" /><form:errors path="regNumber" /><br>
			<form:label path="fullName">Nama Legkap</form:label><br>
			<form:input path="fullName" /><form:errors path="fullName" /><br>
			<form:label path="birthDate">Tanggal Lahir</form:label><br>
			<form:input path="birthDate" /><form:errors path="birthDate" /><br>
			<form:label path="emailAddress">Alamat Email</form:label><br>
			<form:input path="emailAddress" /><form:errors path="emailAddress" /><br>
			<button type="submit">Register</button>
		</form:form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Lead</title>
</head>
<body>
	<!-- <h2>New Lead</h2> -->
	<form action = "savelead" method = "post">
		<table border="1">
			<tr>
				<th colspan="2" bgcolor="lightgrey"><font size = "4">New Leads</font></th>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type = "text" name = "firstName"/></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input type = "text" name = "lastName"/></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type = "text" name = "email"/></td>
			</tr>
			
			<tr>
				<td>Mobile</td>
				<td><input type = "text" name = "mobile"/></td>
			</tr>
			<tr>
				<!-- save button in middle -->
				<td style="text-align: center" colspan="2"><input type = "submit" value = "Save"/></td>
			</tr>
		</table>
	</form>
	${msg}
</body>
</html>
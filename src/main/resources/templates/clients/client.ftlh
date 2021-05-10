<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Client</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Client</a></H3>
  <br><br>
    UUID:
  <br>
     ${client.uuid}
  <br><br>
    Name:
  <br>
     ${client.fullName}
  <br><br>
    Phone number:
  <br>
     ${client.phoneNumber}
  <br><br>
      Email:
  <br>
     ${client.email}
  <br><br>
      Passport number:
  <br>
     ${client.passportNumber}
  <br><br>
  <form method="get" action="/client/${client.uuid}/newoffer">
     <input type="submit" value="Create loan offer">
  </form>
  </body>
</html>

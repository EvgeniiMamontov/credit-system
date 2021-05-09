<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit client</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Edit Client</a></H3>
    <br>
    <form method="post">
      <label for="name">ID:</label><br>
      <input type="text" id="uuid" name="uuid" required disabled value="${client.uuid}"><br>
      <label for="name">Full name:</label><br>
      <input type="text" id="name" name="name" required minlength="5" maxlength="50" value="${client.fullName}"><br>
      <label for="phone">Phone number:</label><br>
      <input type="tel" id="phone" name="phone" required title="Enter 5 to 15 digits" pattern="[0-9]{5,15}" value="${client.phoneNumber}"><br>
      <label for="email">Email:</label><br>
      <input type="email" id="email" name="email" required maxlength="50" value="${client.email}"><br>
      <label for="passport">Passport number:</label><br>
      <input type="text" id="passport" name="passport" required minlength="5" maxlength="20" value="${client.passportNumber}"><br>
      <input type="submit" value="Update">
    </form>
  </body>
</html>
